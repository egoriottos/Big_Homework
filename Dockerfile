FROM openjdk:11
WORKDIR /app
ADD BigHomeworkApplication myDir
RUN javac BigHomeworkApplication.java
CMD ["java", "BigHomeworkApplication"]


