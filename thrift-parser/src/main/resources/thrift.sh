#!/usr/bin/env bash

yum -y update
yum install -y wget

# Upgrade autoconf
wget http://ftp.gnu.org/gnu/autoconf/autoconf-2.69.tar.gz
tar xvf autoconf-2.69.tar.gz
cd autoconf-2.69
./configure --prefix=/usr
make
make install
cd ..

# Upgrade automake
wget http://ftp.gnu.org/gnu/automake/automake-1.14.tar.gz
tar xvf automake-1.14.tar.gz
cd automake-1.14
./configure --prefix=/usr
make
make install
cd ..

# Upgrade bison
wget http://ftp.gnu.org/gnu/bison/bison-2.5.1.tar.gz
tar xvf bison-2.5.1.tar.gz
cd bison-2.5.1
./configure --prefix=/usr
make
make install
cd ..

# Install C++ Lib Dependencie
yum -y install libevent-devel zlib-devel openssl-devel

# Upgrade Boost >= 1.53
wget http://sourceforge.net/projects/boost/files/boost/1.53.0/boost_1_53_0.tar.gz
tar xvf boost_1_53_0.tar.gz
cd boost_1_53_0
./bootstrap.sh
./b2 install