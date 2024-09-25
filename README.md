# **House Market**

## **Overview**
<!-- This project is a full-stack application for managing property listings and user authentication using Spring Boot (backend) and a JavaScript-based frontend. It features secure JWT authentication, CRUD operations for property management, and robust error handling. -->

House Market is a comprehensive platform designed to simplify property renting. It provides a secure and efficient way for landlords to list properties and for users to find and manage rental properties.

### **Scalability & Future Plans**

We aim to enhance the project by introducing more advanced features and improvements:

- **Property Search & Filtration**: Users will be able to filter properties based on various criteria like price, location, and size, making the search process more efficient.
- **Shift to React.js**: The frontend will transition to React.js for a more dynamic and responsive user experience.
- **Messaging System with Kafka**: Implementing a real-time messaging system using Kafka to facilitate communication between property owners and potential buyers/renters.
- **Deployment on AWS Elastic Beanstalk**: For scalability, we plan to deploy the project on AWS Elastic Beanstalk, ensuring high availability and performance.
- **CI/CD Pipelines**: Continuous integration and deployment pipelines will be set up to streamline the development process, ensuring smooth updates and releases.
- **Media Management**: Efficient handling of property photos and videos for a more comprehensive property listing experience.

## **Technologies Used**
- Java 17
- Spring Boot 3.3.4
- MySQL
- JWT for security
- Maven
- Frontend: HTML, CSS, JavaScript

## **Features**
### **Backend**
* **User Authentication**: Secure user authentication using JWT tokens.
* **Property Management**: CRUD operations for managing property details.
* **Error Handling**: Centralized exception handling with standardized error responses.
* **Validation**: Handled validation for API payload data.

### **Frontend**
* **Login Page**: User login with JWT authentication.
* **Dashboard**: Display of property listings after successful authentication.
* **Token Management**: Handling of access and refresh tokens.

<!-- ## **Challenges & Learning**
While developing the House Market project, I faced and overcame several challenges:

* **CORS & JWT Authentication**: I resolved issues related to CORS while securing APIs with JWT, improving my understanding of API security and cross-origin communication.

* **Frontend Development**: I expanded my skills by learning HTML, CSS, and JavaScript, successfully building a functional UI and handling token-based authentication in the frontend. -->


## **Installation and Setup**
### **Prerequisites**
* Java Development Kit (JDK) version 17 or higher
* Maven (for building the project)
* MySQL database
* A code editor (e.g., Visual Studio Code) for both frontend and backend


## **Backend Setup**
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
 The backend will start on http://localhost:8080.

## **Frontend Setup**
1. Navigate to the `src/frontend/` folder.
2. Run the frontend using a local server (e.g., Live Server extension in VS Code).
The frontend will be accessible on http://localhost:5500.

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