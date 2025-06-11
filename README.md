# 📱 Social Media Platform

A full-stack social media web application built with **React**, **Tailwind CSS**, **Spring Boot**, and **MySQL**. This platform allows users to register, create profiles, post content, like, comment, and connect with other users — mimicking core features of popular social networking platforms.

---

## 🚀 Tech Stack

**Frontend:**
- React
- Tailwind CSS
- Axios (for API calls)

**Backend:**
- Spring Boot
- Spring Security *(if applicable)*
- JPA / Hibernate

**Database:**
- MySQL

---

## 🔑 Features

- 🔐 User authentication and authorization (Login / Register)
- 🧑 Create and edit user profiles
- 📝 Create posts with text (optionally images/videos)
- ❤️ Like and comment on posts
- 👥 View other users' profiles and posts
- 📱 Responsive design for mobile and desktop

---

## 📁 Project Structure


---

## 🛠️ Getting Started

### Prerequisites

Make sure you have the following installed:

- [Node.js](https://nodejs.org/)
- [MySQL](https://www.mysql.com/)
- [Java 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/)

---

### 🚦 Running the Application

#### 1. Clone the repository


git clone https://github.com/yourusername/social-media-platform.git
cd social-media-platform


 Frontend (React)
cd client
npm install
npm start


⚙️ Configuration
In application.properties (Spring Boot backend), set your MySQL credentials and database name:

spring.datasource.url=jdbc:mysql://localhost:3306/social_media_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
