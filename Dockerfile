# Установите переменные окружения


# Используем официальный образ OpenJDK как базовый
FROM openjdk:23-slim
#VOLUME /tmp

#ENV MYSQL_HOST=localhost
#ENV MYSQL_PORT=3307
#ENV MYSQL_DB=gti_record_rey
#ENV MYSQL_USER=root
#ENV MYSQL_PASSWORD=root

# Указываем директорию для приложения внутри контейнера
WORKDIR /app

# Копируем jar файл из target в контейнер
# Предполагается, что приложение уже собрано (используйте команду mvn clean install перед этим)
COPY target/gti-record-rest-1.0.jar /app/gti-record-rest-1.0.jar

# Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "/app/gti-record-rest-1.0.jar"]

# Пробрасываем порт (если приложение работает на 8080 порту)
EXPOSE 8080
