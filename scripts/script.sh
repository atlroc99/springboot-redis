#/bin/bash

VERSION=$(docker -v)
echo "Version : ${VERSION}"

docker images

docker rmi -f $(docker images --filter "dangling=true")

echo "AFTER DOCKER DANGLING IMAGE CLEAN UP"
docker images