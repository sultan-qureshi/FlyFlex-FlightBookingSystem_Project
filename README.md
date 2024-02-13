# FlyFlex

FlyFlex is a full stack web application developed for flight booking.

## Features

- **Full Stack Application**: Developed as a full stack web application, FlyFlex covers both the frontend and backend aspects of flight booking.
  
- **Backend API Development**: Robust backend APIs were created using Spring Boot microservices, providing efficient and reliable data management.

- **Frontend Design**: The frontend of FlyFlex was designed and implemented using the Angular framework, offering a sleek and intuitive user interface.

- **Version Control with GitHub**: GitHub was utilized for version control, allowing for collaborative development and easy tracking of changes.

- **Service Discovery and API Gateway**: Netflix Eureka server was incorporated for service discovery, while an API Gateway was implemented for efficient routing of requests.

- **Security with Spring Security**: FlyFlex ensures secure authentication using Spring Security, with JWT token authentication for user validation.

## Technologies Used

- Java
- Spring Boot
- Angular
- MongoDB
- GitHub
- Netflix Eureka Server
- Spring Security

## Installation

To run FlyFlex locally, follow these steps:

1. Clone the repository: `git clone https://github.com/your-username/FlyFlex-FlightBookingSystem_Project.git`
2. Navigate to the project directory
3. Install dependencies: 
   - For frontend (Angular), navigate to the `booking` directory and run `npm install`
   - For backend (Spring Boot), run `mvn clean install`
4. Start the Eureka server: 
   - Navigate to the `EurekaServer` directory and Build and run `java -jar target/EurekaServer-0.0.1-SNAPSHOT.jar`
5. Start the microservices:
   - For each microservice, navigate to its respective directory Build and run `java -jar target/microservice-name-0.0.1-SNAPSHOT.jar`
6. Start the Angular application: 
   - Navigate to the `booking` directory and run `ng serve`
7. Access the application: 
   - Visit `http://localhost:4200` in your web browser to access the FlyFlex application
8. Explore endpoints:
   - Check the Eureka server home page (`http://localhost:8761`) to view and explore available endpoints for each microservice


## Contributing

Contributions are welcome! Feel free to submit pull requests or open issues for any improvements or features you'd like to see in FlyFlex.
