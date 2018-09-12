FROM seawenzhu/java_nginx
VOLUME /tmp
ADD www/ usr/share/nginx/html/
ADD *.jar app.jar
COPY startup.sh /startup.sh
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN bash -c 'touch /app.jar'
CMD ["sh", "/startup.sh"]