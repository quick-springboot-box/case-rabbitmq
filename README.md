- download openssl, erlang, rabbitmq
> - tar zxf openssl.tar.gz ; 

> - elang install with openssl
./configure --prefix=/opt/erlang --without-javac --with-ssl=/opt/openssl
make
sudo make install

erl:
ssl:versions().

sbin/rabbitmq-server -detached