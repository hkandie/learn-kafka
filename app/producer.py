from kafka import KafkaProducer
from datetime import datetime
from faker import Faker
import json
producer = KafkaProducer(
    bootstrap_servers=['localhost:9093'],
    value_serializer=lambda v: json.dumps(v).encode('utf-8')
)
fake = Faker()
rs=producer.send('users', {'author': fake.user_name(), 'content': fake.paragraph(nb_sentences=5), 'created_at': datetime.now().isoformat()})
print(rs.get(timeout=60))
print(producer.to_string())
