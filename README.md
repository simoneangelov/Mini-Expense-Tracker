# Mini Expense Tracker

This Mini Expense Tracker is a simple Spring Boot application designed to manage personal expenses.

## Features

- **CRUD Operations**: Create, Read, Update, and Delete expenses.
- **In-memory Database**: Uses H2 for easy setup and testing.
- **Exception Handling**: Custom exception handling for resource not found scenarios.
- **Spring Boot**: Built with Spring Boot for rapid development and deployment.

## Technologies Used

- Java 21
- Spring Boot 3.2.11
- Spring Data JPA
- H2 Database
- Maven

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/mini-expense-tracker.git
   cd mini-expense-tracker
   ```

2. **Build the project**:
   ```bash
   ./mvnw clean install
   ```

3. **Run the application**:
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the application**:
   - The application will be running at `http://localhost:8080`.
   - H2 console is available at `http://localhost:8080/h2-console`.


## API Endpoints

- **Create Expense**: `POST /api/expenses`
- **Get All Expenses**: `GET /api/expenses`
- **Get Expense by ID**: `GET /api/expenses/{id}`
- **Update Expense**: `PUT /api/expenses/{id}`
- **Delete Expense**: `DELETE /api/expenses/{id}`

## Database

The application uses an in-memory H2 database. The database schema is automatically created at startup, and sample data is loaded from `src/main/resources/data.sql`.

## Exception Handling

Custom exception handling is implemented using `ResourceNotFoundException` and `GlobalExceptionHandler` to provide meaningful error messages.

## License

This project is licensed under the Apache License 2.0. See the [LICENSE](LICENSE) file for details.
