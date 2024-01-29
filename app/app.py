from flask import Flask, request
from kafka import KafkaProducer
from datetime import datetime
import json
from faker import Faker

app = Flask(__name__)
producer = KafkaProducer(
    bootstrap_servers=['localhost:9093'],
    value_serializer=lambda v: json.dumps(v).encode('utf-8')
)

@app.route('/posts', methods=['POST'])
def create_post():
    fake = Faker()
    post = request.get_json()
    # clickhouse can only parse strings without milliseconds
    post['created_at'] = datetime.now().strftime("%Y-%m-%dT%H:%M:%S")
    post['author'] = fake.user_name()
    post['content'] = fake.paragraph(nb_sentences=5)
    x= producer.send('users', post)
    print(x.get(timeout=60))
    return 'ok'