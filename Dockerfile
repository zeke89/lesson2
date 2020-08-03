FROM selenium/standalone-chrome

MAINTAINER egolubcov

RUN sudo apt-get update \
 && sudo apt-get -y install git

RUN sudo git clone https://github.com/zeke89/lesson2.git

RUN sudo apt-get install --assume-yes maven
CMD mvn --version