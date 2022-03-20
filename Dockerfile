FROM ubuntu:latest 

RUN /bin/bash -c "apt -y update && apt-get -y install curl"
RUN /bin/bash -c "apt -y update && apt-get -y install netcat"
EXPOSE 8003
CMD /bin/bash -c "nc -l -p 8003 | tee >(nc wiki.cs.hse.ru 80) >(nc nginx-server 9000)"