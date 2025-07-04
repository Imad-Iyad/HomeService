# استخدم Java 17
FROM eclipse-temurin:17-jdk-alpine

# أنشئ مجلد للتطبيق داخل الحاوية
WORKDIR /app

# انسخ ملف jar
COPY target/backend-0.0.1-SNAPSHOT.jar app.jar

# شغّل التطبيق
ENTRYPOINT ["java", "-jar", "app.jar"]
