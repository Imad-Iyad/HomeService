<div align="center">

# **HOMESERVICE**

### **Transforming Home Care, Seamlessly and Securely**

<br>

<p>
    <img src="https://img.shields.io/badge/last%20commit-july-blue?style=for-the-badge" alt="last commit">
    <img src="https://img.shields.io/badge/java-99.3%25-blue?style=for-the-badge" alt="language">
    <img src="https://img.shields.io/badge/languages-2-blue?style=for-the-badge" alt="languages">
</p>

<p>
  <strong>Built with the tools and technologies:</strong><br>
    <img src="https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=json-web-tokens&logoColor=white" alt="JWT">
    <img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" alt="Spring Boot">
    <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white" alt="Docker">
    <img src="https://img.shields.io/badge/XML-gray?style=for-the-badge" alt="XML">
    <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL">
</p>

</div>

---

### **Table of Contents**
* [Overview](#overview)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
  * [Usage](#usage)
  * [Testing](#testing)

---

## **Overview**

HomeService is a comprehensive backend framework tailored for building scalable, secure home service platforms. It leverages Spring Boot to deliver core functionalities such as web services, security, data persistence, JWT authentication, and API documentation, all within a modular architecture.

### **Why HomeService?**

This project simplifies the development of reliable, microservice-based home service applications. The core features include:

-   **🛡️ Security & Authentication**: Implements JWT-based security with role-based access control to safeguard your APIs.
-   **🚀 RESTful API Endpoints**: Provides structured endpoints for managing users, services, appointments, reviews, and provider availability.
-   **📦 Containerized Deployment**: Uses Docker for consistent, portable deployment across environments.
-   **📄 Auto-Generated API Docs**: Integrates Swagger/OpenAPI for seamless API documentation and testing.
-   **⚙️ Robust Error Handling**: Centralized exception management ensures clear, consistent responses.
-   **🧩 Modular Data Flow**: Utilizes DTOs and mappers for clean, maintainable data exchange.

---

## **Getting Started**

### **Prerequisites**

This project requires the following dependencies:

* Programming Language: Java
* Package Manager: Maven
* Container Runtime: Docker

### **Installation**

Build HomeService from the source and install dependencies:

1.  **Clone the repository:**
    ```sh
    git clone [https://github.com/Imad-Iyad/HomeService](https://github.com/Imad-Iyad/HomeService)
    ```

2.  **Navigate to the project directory:**
    ```sh
    cd HomeService
    ```

3.  **Install the dependencies:**

    **Using `docker`:**
    ```sh
    docker build -t Imad-Iyad/HomeService .
    ```

    **Using `maven`:**
    ```sh
    mvn install
    ```

### **Usage**

Run the project with:

**Using `docker`:**
```sh
docker run -it {image_name}
```

**Using `maven`:**
```sh
mvn exec:java
```
