# Order Management System - Spring Boot REST API

A simple and efficient Spring Boot REST API application for managing customer orders. This system allows users to create, view, update, and delete orders.

## Features

✅ Create new orders  
✅ View all orders  
✅ View order by ID  
✅ Filter orders by customer name  
✅ Filter orders by status  
✅ Update existing orders  
✅ Delete orders  
✅ In-memory H2 database for easy setup  
✅ CORS enabled for frontend integration  
✅ Sample data initialization on startup  

## Tech Stack

- **Backend**: Spring Boot 3.1.0
- **Language**: Java 17
- **Database**: H2 (In-memory) / MySQL (Optional)
- **Build Tool**: Maven
- **ORM**: Spring Data JPA / Hibernate
- **API Documentation**: REST API

## Project Structure

```
26/
├── pom.xml                                      # Maven configuration
├── README.md                                    # This file
└── src/
    ├── main/
    │   ├── java/com/orderms/
    │   │   ├── OrderManagementSystemApplication.java    # Main class
    │   │   ├── entity/
    │   │   │   └── Order.java                          # Order entity
    │   │   ├── repository/
    │   │   │   └── OrderRepository.java                # Data access layer
    │   │   ├── service/
    │   │   │   └── OrderService.java                   # Business logic
    │   │   ├── controller/
    │   │   │   └── OrderController.java                # REST API endpoints
    │   │   └── config/
    │   │       └── DataInitializer.java                # Sample data setup
    │   └── resources/
    │       └── application.properties          # Spring Boot configuration
    └── test/                                   # Test files
```

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- Postman (for API testing) - [Download](https://www.postman.com/downloads/)

## Installation & Setup

### Step 1: Clone the Repository
```bash
cd 26
```

### Step 2: Build the Project
```bash
mvn clean install
```

### Step 3: Run the Application
```bash
mvn spring-boot:run
```

Or run the JAR file:
```bash
mvn clean package
java -jar target/order-management-system-1.0.0.jar
```

### Step 4: Access the Application
The application will start on: **http://localhost:8080**

## Database Access (H2 Console)

Access the H2 console at: **http://localhost:8080/h2-console**

- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: (leave empty)

## REST API Endpoints

Base URL: `http://localhost:8080/api/orders`

### 1. Create a New Order
**POST** `/api/orders`

**Request Body**:
```json
{
  "customerName": "John Doe",
  "email": "john@example.com",
  "phone": "9876543210",
  "product": "Monitor",
  "quantity": 1,
  "unitPrice": 15000,
  "totalPrice": 15000,
  "shippingAddress": "123 Main St, City"
}
```

**Response (201 Created)**:
```json
{
  "id": 4,
  "customerName": "John Doe",
  "email": "john@example.com",
  "phone": "9876543210",
  "product": "Monitor",
  "quantity": 1,
  "unitPrice": 15000,
  "totalPrice": 15000,
  "status": "PENDING",
  "shippingAddress": "123 Main St, City",
  "createdAt": "2024-05-05T10:30:00",
  "updatedAt": "2024-05-05T10:30:00"
}
```

### 2. Get All Orders
**GET** `/api/orders`

**Response (200 OK)**:
```json
[
  {
    "id": 1,
    "customerName": "Rajesh Kumar",
    "email": "rajesh@example.com",
    "phone": "9876543210",
    "product": "Laptop",
    "quantity": 1,
    "unitPrice": 50000,
    "totalPrice": 50000,
    "status": "CONFIRMED",
    "shippingAddress": "123 Main St, Delhi",
    "createdAt": "2024-05-05T10:00:00",
    "updatedAt": "2024-05-05T10:00:00"
  }
]
```

### 3. Get Order by ID
**GET** `/api/orders/{id}`

Example: `GET /api/orders/1`

**Response (200 OK)**:
```json
{
  "id": 1,
  "customerName": "Rajesh Kumar",
  "email": "rajesh@example.com",
  "phone": "9876543210",
  "product": "Laptop",
  "quantity": 1,
  "unitPrice": 50000,
  "totalPrice": 50000,
  "status": "CONFIRMED",
  "shippingAddress": "123 Main St, Delhi",
  "createdAt": "2024-05-05T10:00:00",
  "updatedAt": "2024-05-05T10:00:00"
}
```

### 4. Get Orders by Customer Name
**GET** `/api/orders/customer/{customerName}`

Example: `GET /api/orders/customer/Rajesh Kumar`

### 5. Get Orders by Status
**GET** `/api/orders/status/{status}`

Example: `GET /api/orders/status/PENDING`

**Valid Status Values**: `PENDING`, `CONFIRMED`, `SHIPPED`, `DELIVERED`, `CANCELLED`

### 6. Update an Order
**PUT** `/api/orders/{id}`

Example: `PUT /api/orders/1`

**Request Body**:
```json
{
  "customerName": "Rajesh Kumar",
  "email": "rajesh.updated@example.com",
  "phone": "9876543210",
  "product": "Laptop Pro",
  "quantity": 1,
  "unitPrice": 60000,
  "totalPrice": 60000,
  "status": "SHIPPED",
  "shippingAddress": "New Address, Delhi"
}
```

### 7. Delete an Order
**DELETE** `/api/orders/{id}`

Example: `DELETE /api/orders/1`

**Response (200 OK)**:
```json
{
  "message": "Order deleted successfully"
}
```

### 8. Delete All Orders
**DELETE** `/api/orders`

## Testing with Postman

### Step 1: Import Postman Collection

Create a new Postman Collection with the following requests:

#### Request 1: Create Order
```
POST http://localhost:8080/api/orders
Content-Type: application/json

{
  "customerName": "Test User",
  "email": "test@example.com",
  "phone": "9999999999",
  "product": "Test Product",
  "quantity": 1,
  "unitPrice": 1000,
  "totalPrice": 1000,
  "shippingAddress": "Test Address"
}
```

#### Request 2: Get All Orders
```
GET http://localhost:8080/api/orders
```

#### Request 3: Get Order by ID
```
GET http://localhost:8080/api/orders/1
```

#### Request 4: Update Order
```
PUT http://localhost:8080/api/orders/1
Content-Type: application/json

{
  "customerName": "Updated Name",
  "email": "updated@example.com",
  "phone": "8888888888",
  "product": "Updated Product",
  "quantity": 2,
  "unitPrice": 2000,
  "totalPrice": 4000,
  "status": "CONFIRMED",
  "shippingAddress": "Updated Address"
}
```

#### Request 5: Delete Order
```
DELETE http://localhost:8080/api/orders/1
```

### Quick Postman Testing Steps:

1. Open Postman
2. Click "+ New" → "Request"
3. Enter request method (POST, GET, PUT, DELETE)
4. Enter URL: `http://localhost:8080/api/orders`
5. Add headers: `Content-Type: application/json` (for POST/PUT)
6. Add request body (for POST/PUT)
7. Click "Send"

## Sample Data

The application comes with 3 sample orders:

| ID | Customer Name | Product | Quantity | Status | Price |
|----|---------------|---------|----------|--------|-------|
| 1  | Rajesh Kumar  | Laptop  | 1        | CONFIRMED | 50000 |
| 2  | Priya Singh   | Mouse   | 5        | SHIPPED | 2500  |
| 3  | Amit Patel    | Keyboard| 2        | PENDING | 4000  |

## Order Statuses

- **PENDING** - Order received, awaiting confirmation
- **CONFIRMED** - Order confirmed by management
- **SHIPPED** - Order shipped to customer
- **DELIVERED** - Order delivered to customer
- **CANCELLED** - Order cancelled

## Switching to MySQL Database

If you want to use MySQL instead of H2:

1. **Install MySQL** and create a database:
   ```sql
   CREATE DATABASE order_db;
   ```

2. **Update `application.properties`**:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/order_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Restart the application**

## Error Handling

All API endpoints return appropriate HTTP status codes:

- **200 OK** - Request successful
- **201 Created** - Resource created successfully
- **400 Bad Request** - Invalid request data
- **404 Not Found** - Resource not found
- **500 Internal Server Error** - Server error

## Example Error Response

```json
{
  "message": "Order not found with id: 999"
}
```

## Troubleshooting

**Issue**: Port 8080 already in use
- **Solution**: Change port in `application.properties`: `server.port=8081`

**Issue**: MySQL connection failed
- **Solution**: Verify MySQL is running and credentials are correct

**Issue**: Application won't start
- **Solution**: Run `mvn clean install` and check Java version (requires Java 17+)

## Future Enhancements

- Add authentication and authorization
- Add payment integration
- Add email notifications
- Add order tracking
- Add customer reviews
- Add inventory management
- Add analytics dashboard

## License

This project is open source and available for educational purposes.

---

**Created for Web Technology Lab Exam**
