Java Microservices Take-Home Test
Overview
This project demonstrates a simple event-driven microservices architecture built with Java 17 and Spring Boot 3.x.
The system consists of three independent microservices:
1.	Order Service – creates orders and publishes events
2.	Payment Service – processes payments based on order events
3.	Notification Service – sends notifications after successful payments
Communication between services is event-driven, implemented using Spring’s in-memory event mechanism to keep the solution simple and focused on architecture.

Architecture
┌───────────────┐
│ Order Service │
│ (REST API)    │
└───────┬───────┘
        │ OrderCreatedEvent
        ▼
┌───────────────┐
│ Payment       │
│ Service       │
└───────┬───────┘
        │ PaymentSucceededEvent
        ▼
┌───────────────┐
│ Notification  │
│ Service       │
└───────────────┘


Event Flow
•  Order Service
•	Accepts order creation requests
•	Publishes OrderCreatedEvent
•  Payment Service
•	Listens for OrderCreatedEvent
•	Simulates payment processing
•	Publishes PaymentSucceededEvent
•  Notification Service
•	Listens for PaymentSucceededEvent
•	Logs / stores notification messages

Technology Stack
•	Java 17
•	Spring Boot 3.x
•	Spring Web
•	Spring Events (in-memory)
•	SpringDoc OpenAPI (Swagger)
•	Maven
•	JUnit 5

Project Structure
java-microservices-takehome-sandunQ
 ├── order-service
 ├── payment-service
 ├── notification-service
 └── README.md

Each service follows a layered architecture:
•	Controller layer – REST APIs
•	Service layer – business logic
•	Domain layer – entities & events
•	Repository layer – in-memory data storage
•	Listener layer – event consumers

How to Run the Services
Prerequisites
Java 17+
Maven 3.8+

Order Service
cd order-service
mvn spring-boot:run

Runs on:
http://localhost:8080
Swagger:
http://localhost:8080/swagger-ui/index.html

Payment Service
cd payment-service
mvn spring-boot:run

Runs on:
http://localhost:8081
Swagger:
http://localhost:8081/swagger-ui/index.html

Notification Service
cd notification-service
mvn spring-boot:run

Runs on:
http://localhost:8082
Swagger:
http://localhost:8082/swagger-ui/index.html

Example API Flow
Create an Order
POST /api/orders
{
  "amount": 49.99,
  "customerEmail": "user@example.com"
}

Resulting Flow
•	Order is created
•	Payment is processed automatically
•	Notification is generated
Check:
•	GET /api/payments
•	GET /api/notifications

Data Storage
For simplicity and focus on architecture:
•	Data is stored using in-memory collections
•	No external database required
This approach:
•	Reduces setup time
•	Highlights event-driven design
•	Keeps services stateless and independent

Configuration
Each service uses application.properties:
server.port=808X

Ports:
•	Order Service → 8080
•	Payment Service → 8081
•	Notification Service → 8082
Testing
•  Unit tests are written using JUnit 5
•  Mockito can be used for service-level tests
•  Run tests using:
mvn test

Design Decisions
Why In-Memory Events?
•	Faster to implement for take-home test
•	Demonstrates event-driven principles
•	Keeps services loosely coupled
Production Consideration
The in-memory event mechanism can be replaced by RabbitMQ or Kafka without changing business logic.
Possible Improvements
•	Replace in-memory events with RabbitMQ
•	Add Docker Compose
•	Add Spring Security
•	Add Retry & Dead Letter Queues
•	Add Spring Boot Actuator
•	Persist data using PostgreSQL

Conclusion
This project demonstrates:
•	Clean microservice architecture
•	Event-driven communication
•	Proper separation of concerns
•	Modern Spring Boot practices
The focus is on clarity, maintainability, and correct event flow, rather than production completeness.

Author
Sandun Susantha
Java / Spring Boot Developer
