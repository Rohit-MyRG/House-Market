# **House Market**

## **Overview**
This project is a backend application for managing property listings and user authentication using Spring Boot and JWT authentication.

## **Features**
* **User Authentication**: Secure user authentication using JWT tokens.
* **Property Management**: CRUD operations for managing property details.
* **Error Handling**: Centralized exception handling with standardized error responses.
* **Validation**: Handled validation for API payload data.

## **Installation and Setup**
### **Prerequisites**
* Java Development Kit (JDK) version 11 or higher
* Maven (for building the project)
* MySQL database

## **Clone and Build**
 1. **Clone the repository**:
    ```
    git clone https://github.com/Rohit-MyRG/House-Market.git 
    cd house-market
    ```


 2. **Build the project**:
    ```
    mvn -U clean install
    ```

## **Configuration**
 1. Set up your MySQL database configuration in `src/main/resources/application.properties`.

 2. Run the application:
 `java -jar target/house-market-0.0.1-SNAPSHOT.jar`
 The application will start on http://localhost:8080.

# **API Endpoints**
## **Authentication**
* **POST** `/api/authenticate`: Authenticate user and generate JWT token.
    * **Request Payload**:
        ```
        {
            "email": "user@example.com",
            "password": "password"
        }
        ```
    
    * **Response Payload**:
        ```
        {
            "accessToken": "eyJhbGciOiJIUzI1NiIsIn...",
            "refreshToken": "eyJhbGciOiJIUzI1NiIsIn..."
        }
        ```

## **Property Details Controller**

- **Endpoints**:
    - **`GET /api/properties`**: Retrieve all properties.
    - **`POST /api/properties/{ownerId}`**: Add a new property associated with a specific owner.
    - **`GET /api/properties/owner/{ownerId}`**: Get all properties for a specific owner.
    - **`PUT /api/properties/{propertyId}`**: Update an existing property by ID.
    - **`DELETE /api/properties/{propertyId}`**: Delete a property by ID.

## **User Details Controller**

- **Endpoints**:
    - **`GET /api/users`**: Retrieve all users.
    - **`POST /api/users`**: Add a new user.