# kubectl label pod/app-3-backend pod/app-3-frontend visibility=internal --namespace=app-3

mvn compile jib:dockerBuild
kubectl apply -f demo/kafka.yml 