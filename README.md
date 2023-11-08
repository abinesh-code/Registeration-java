# Registeration-java

This is a simple Spring Boot application that allows users to register and log in. Registered user details are stored in a MySQL database. An admin can log in to view registered user details via email.

## Getting Started

These instructions will help you set up and run the project on your local machine.

### Prerequisites

To run this project, you need to have the following software installed on your machine:

- Java Development Kit (JDK)
- MySQL Database
- Integrated Development Environment (IDE) (e.g., IntelliJ IDEA, Eclipse, Vscode)
- Apache Maven
- Google app password
- Default username and password for admin => username ->`admin` , password -> `admin123` you can modify on `register/src/main/java/com/example/register/admin/AdminController.java`
- Default generating .war file name is `training.war` you can modify at line 94 on `register/pom.xml` `<finalName> enter-custom-war-file-name</finalName>`

### Installation

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/abinesh-code/Rejisteration-java.git
   ```
2. Configure your database credentials on ```register/src/main/resource/application.yml```
3. Create a Google-app password by https://myaccount.google.com -> Security -> Two factor authentication (turn on) -> (scroll down) App passwords. Generate new app password and copy
4. Configure google account -> Go to line 15 on ```register/src/main/java/com/example/register/mail/EmailService.java``` enter you google account gmail and generated app password
5. Configure you email reciver -> Go to line 53 on ```register/src/main/java/com/example/register/user/UserController.java``` enter reciver email
6. Go to ```regiter/``` and run the command `mvn clean install` on terminal
7. Go to ```register/target/``` you can see generated war file
8. You can either deploy that .war file on external tomacat server on run with the following command ```java -jar training.war``` the server will start on `localhost:8080`
9. Open browser and type `localhost:8080/register` for registeration page and `localhost:8080/admin` for admin page

## Contact
abinesh.coder01@gmail.com
