# Docker


# Running docker in Jenkins docker container
Since we wnat to automate building our artefacts, it's also necessary to automate building
docker images. 

When you remember this idea of linking docker exe and socket into docker container:
don't do that (see Jerome Petazzo's blog post below). The socket can be linked in. But the binary 
has to be installed separately.

This is done with the script [root_apt_get.sh](../src/main/script/root_apt_get.sh). It also
adds some user rights to start docker even as non-root user.

# Links
* http://jpetazzo.github.io/2015/09/03/do-not-use-docker-in-docker-for-ci/
* https://getintodevops.com/blog/the-simple-way-to-run-docker-in-docker-for-ci
* https://docs.docker.com/install/linux/docker-ce/debian/#install-docker-ce-1