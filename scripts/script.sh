#/bin/bash

VERSION=$(docker -v)
echo "Version : ${VERSION}"

docker images

strLength=$(docker images --filter="dangling=true")

echo "CHECKING IF DANGLING IMAGES EXISTS"

if [ ${#strLength} -gt 100 ]; then
  echo "REMOVING DANGLING IMAGE"
  docker rmi -f $(docker images --filter "dangling=true")
  else
    echo "NO DANGLING IMAGES FOUND"
fi
