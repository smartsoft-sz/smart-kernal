#!/usr/bin/env bash

set -e

cd ../

#如果已经创建好镜像,这一步要注释掉,避免重复操作
mvn clean install -Dmaven.test.skip=true

#编译web代码
yarn install
rm -rf www
npm run build

# copy jar to docker/java
cp target/*.jar docker/webapp
cp -r www/ docker/webapp/www/

cd docker

# 停止原先运行的容器
docker-compose stop
# 删除停止的容器(如果想重启则不要执行此命令)
docker-compose rm -f

#删除停止的容器
docker ps -a | grep "Exited" | awk '{print $1 }'|xargs docker rm

#删除名称为none的镜像
docker images|grep none|awk '{print $3 }'|xargs docker rmi

# 使用docker-compose启动多容器应用
docker-compose up --build -d

# 日志
docker-compose logs -f --tail=200

# 重启命令
# docker-compose restart