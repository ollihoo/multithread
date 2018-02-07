# Docker


# First try

```
    docker run -p 9000:8080 -p 50000:50000 \
           -v ${ROOT_PATH}/jenkins_home:/var/jenkins_home \
           -v /var/run/docker.sock:/var/run/docker.sock \
           -v /usr/local/bin/docker:/usr/local/bin/docker \
           --name $CONTAINER_NAME \
           jenkins/jenkins:lts
```

Feedback:
```
jenkins@11cb25bcf6e7:/$ docker ps
Got permission denied while trying to connect to the Docker daemon socket at unix:///var/run/docker.sock: Get http://%2Fvar%2Frun%2Fdocker.sock/v1.35/containers/json: dial unix /var/run/docker.sock: connect: permission denied
```

So, this doesn't work. And, btw, it's also not recommended by Jerome Petazzo...

# Second try

Instead of linking docker, i install it on the jenkins container:


```
apt-get install apt-transport-https ca-certificates curl gnupg2 software-properties-common -y
curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -
add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/debian stretch stable"
apt-get update 
apt-get install docker-ce -y
```


# Links
* http://jpetazzo.github.io/2015/09/03/do-not-use-docker-in-docker-for-ci/
* https://getintodevops.com/blog/the-simple-way-to-run-docker-in-docker-for-ci