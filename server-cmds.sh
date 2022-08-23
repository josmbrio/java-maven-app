export IMAGE=$1

echo "Starting the container..."
docker-compose -f docker-compose.yaml up --detach
