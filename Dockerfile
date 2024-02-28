FROM openjdk:11
WORKDIR /app
ADD BigHomeworkApplication
RUN javac BigHomeworkApplication.java
CMD ["java", "BigHomeworkApplication"]


