

```shell
cd spring-boot-guides\getting-started-guides\gs-spring-boot-docker

docker build -t gs-spring-boot-docker .
docker run -d -p 8080:8080 --name gs-spring-boot-docker gs-spring-boot-docker

docker tag gs-spring-boot-docker bert82503/gs-spring-boot-docker
docker push bert82503/gs-spring-boot-docker
```

