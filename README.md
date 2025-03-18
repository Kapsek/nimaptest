# Nimap Test Project

## Overview
This project is a Spring Boot application for managing **Categories** and **Products** using a REST API. It includes CRUD operations for both entities with a one-to-many relationship (One Category can have multiple Products).

---

## Prerequisites
- Java 17 or later
- Spring Boot 3.x
- Maven
- PostgreSQL or MySQL Database

---

## Setup Instructions

1. **Clone the Repository:**
```bash
git clone https://github.com/your-repo/nimap-test.git
cd nimap-test
```

2. **Configure Database:**
- Update `application.properties` with your database configurations.
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nimap_test
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. **Build the Project:**
```bash
mvn clean install
```

4. **Run the Application:**
```bash
mvn spring-boot:run
```

---

## API Endpoints

### ✅ **Category APIs**
| Method | Endpoint                     | Description                    |
|---------|------------------------------|--------------------------------|
| GET     | `/api/categories?page=3`     | Get all categories with pagination |
| POST    | `/api/categories`            | Create a new category          |
| GET     | `/api/categories/{id}`       | Get category by ID             |
| PUT     | `/api/categories/{id}`       | Update category by ID          |
| DELETE  | `/api/categories/{id}`       | Delete category by ID          |

### ✅ **Product APIs**
| Method | Endpoint                     | Description                    |
|---------|------------------------------|--------------------------------|
| GET     | `/api/products?page=2`       | Get all products with pagination |
| POST    | `/api/products`              | Create a new product           |
| GET     | `/api/products/{id}`         | Get product by ID              |
| PUT     | `/api/products/{id}`         | Update product by ID           |
| DELETE  | `/api/products/{id}`         | Delete product by ID           |

---

## Sample Data for Testing

### **Create Category**
```json
{
  "name": "Electronics",
  "decscription": "All kinds of electronic devices"
}
```

### **Create Product**
```json
{
  "name": "Smartphone",
  "description": "Latest Android smartphone",
  "price": 499.99,
  "categoryId": 1
}
```

---

## Troubleshooting
- Ensure the database is running and accessible.
- Verify environment variables and database credentials.
- Check application logs for detailed error messages using:
```bash
mvn spring-boot:run -Dspring-boot.run.arguments=--debug
```

---

## Author
- Krishna Kapse 
- Contact: 7620888356 Email :krishnakapse10@gmail.com

