FROM ubuntu:latest
RUN apt -y update && apt-get -y install curl
RUN apt -y update && apt-get -y install netcat 
#RUN apt -y update && apt-get -y install rsync 
COPY . . 
#CMD mkfifo fifo 
#CMD nc -l -p 8080 <fifo | nc wiki.hse.cs.ru 80 | nc nginx-server:9000>fifo
ENV http_proxy=localhost:8080
#CMD ./tcp-proxy.sh 8080 tweakers.net 80
CMD nc -l -p 8080 | tee >(nc wiki.cs.hse.ru 80) >(nc nginx-server 9000)  