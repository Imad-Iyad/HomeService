# HOMESERVICE

Transforming Home Care, Seamlessly and Securely

![Last Commit](https://img.shields.io/badge/last%20commit-july-blue) 
![Java](https://img.shields.io/badge/java-99.3%25-blue) 
![Languages](https://img.shields.io/badge/languages-2-blue)

Built with the tools and technologies:

![Markdown](https://img.shields.io/badge/Markdown-black?logo=markdown) 
![Spring](https://img.shields.io/badge/Spring-green?logo=spring) 
![Docker](https://img.shields.io/badge/Docker-blue?logo=docker) 
![XML](https://img.shields.io/badge/XML-lightblue) 
![YAML](https://img.shields.io/badge/YAML-red)

---

## Table of Contents
- [Overview](#overview)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Usage](#usage)
  - [Testing](#testing)

---

## Overview
HomeService is a comprehensive backend framework tailored for building scalable, secure home service platforms.  
It leverages Spring Boot to deliver core functionalities such as web services, security, data persistence, JWT authentication, and API documentation, all within a modular architecture.

### Why HomeService?
This project simplifies the development of reliable, microservice-based home service applications.  
The core features include:

- 🔐 **Security & Authentication**: Implements JWT-based security with role-based access control to safeguard your APIs.
- 🚀 **RESTful API Endpoints**: Provides structured endpoints for managing users, services, appointments, reviews, and provider availability.
- 📦 **Containerized Deployment**: Uses Docker for consistent, portable deployment across environments.
- 📑 **Auto-Generated API Docs**: Integrates Swagger/OpenAPI for seamless API documentation and testing.
- ⚙️ **Robust Error Handling**: Centralized exception management ensures clear, consistent responses.
- 🔄 **Modular Data Flow**: Utilizes DTOs and mappers for clean, maintainable data exchange.

---

## Getting Started

### Prerequisites
This project requires the following dependencies:

- **Programming Language:** Java  
- **Package Manager:** Maven  
- **Container Runtime:** Docker  

---

### Installation
Build HomeService from the source and install dependencies:

1. Clone the repository:
   ```bash
   git clone https://github.com/Imad-Iyad/HomeService
   ```

2. Navigate to the project directory:
   ```bash
   cd HomeService
   ```

3. Install the dependencies:

   **Using docker:**
   ```bash
   docker build -t Imad-Iyad/HomeService .
   ```

   **Using maven:**
   ```bash
   mvn install
   ```

---

### Usage
Run the project with:

**Using docker:**
```bash
docker run -it {image_name}
```

**Using maven:**
```bash
mvn exec:java
```

---

### Testing
Work in progress 🚧
