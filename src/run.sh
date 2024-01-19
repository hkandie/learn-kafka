kubectl label pod/app-3-backend pod/app-3-frontend visibility=internal --namespace=app-3
kubectl config set-context --current --namespace confluent