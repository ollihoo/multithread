#
# This script installs docker for usage in a Jenkins docker container
# it's assumed here that /var/run/docker.sock is injected from outside
# by docker -v parameter (see docker_jenkins.sh)
#

apt-get update
apt-get install apt-transport-https ca-certificates curl gnupg2 software-properties-common -y
curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -
add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/debian stretch stable"
apt-get update
apt-get install docker-ce -y
gpasswd -a jenkins docker
chmod go+rw /var/run/docker.sock
