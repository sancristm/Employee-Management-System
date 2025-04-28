# Employee Management App

A Java web application that performs full CRUD operations (Create, Read, Update, Delete) for managing employees. Built using **PrimeFaces**, **Payara Server**, **MySQL**, and **NetBeans**—without Spring Boot Framework

---

##  Technologies Used

- **Java Servlets** and **JSF Managed Beans** for backend logic
- **PrimeFaces** for responsive and component-rich UI
- **JDBC** for direct interaction with MySQL database
- **MySQL** as the relational database
- **NetBeans IDE** for development
- **Payara Server** as the deployment server

---

##  Project Structure

```
EmployeeApp/
├── src/
│   ├── java/
│   │   └── com/employee/
│   │       ├── Employee.java
│   │       ├── EmployeeDAO.java
│   │       └── EmployeeBean.java
│   ├── web/
│   │   ├── index.xhtml
│   │   ├── addEmployee.xhtml
│   │   ├── WEB-INF/
│   │   │   ├── web.xml
│   │   │   └── faces-config.xml
│   └── resources/
│       └── META-INF/
│           └── beans.xml
├── database/
│   └── employee_schema.sql
├── screenshots/
│   ├── main.png
│   ├── add.png
│   ├── edit.png
│   ├── delete.png
│   └── database.png
├── README.md
```

---

##  Setup Instructions

1. **Clone the Repository**

   ```bash
   git clone https://github.com/sancristm/Employee-Management-System.git 
   ```

2. **Open in NetBeans**

   - Launch NetBeans IDE.
   - Select *File* > *Open Project*.
   - Browse to the `EmployeeApp` directory and open it.

3. **Configure MySQL Database**

   - Create the `employeedb` database:
     ```sql
     CREATE DATABASE employeedb;
     ```
   - Execute the SQL script in `database/employee_schema.sql` to create the `employees` table.

4. **Deploy to Payara Server**

   - Add the Payara Server to NetBeans (if not already configured).
   - Right-click the project > *Run*
   - Access the app at: [http://localhost:8080/EmployeeApp](http://localhost:8080/EmployeeApp)

---

##  Run the App in a Clean/Fresh State

To run the application as new or reset it completely:

1. **Drop the Existing Database (if it exists)**
   ```sql
   DROP DATABASE IF EXISTS employeedb;
   ```
   you can an as well populate your database with data just incase or for testing purposes

   ![image](https://github.com/user-attachments/assets/c70e3f16-b26d-4f7d-8892-4efbd95a624e)


3. **Recreate the Database and Table**
   ```sql
   CREATE DATABASE employeedb;
   USE employeedb;
   -- Then run the contents of employee_schema.sql
   ```

4. **(Optional) Clear Server Deployment Cache**
   - In NetBeans, stop the Payara server.
   - Clean and build the project: `Right-click > Clean and Build`.
   - Redeploy the project to ensure all changes take effect.

---

##  Screenshots

| Main Table | 


Add Employee | 

Edit Employee | 

Delete Employee |

Database |


---

##  Features

- Display all employees in a dynamic table
- Add new employees using a form
- Edit employee details in-place
- Delete employee records with confirmation
- Form validation for required fields and proper email format
- Clear error messages via PrimeFaces `<p:messages>`
- Clean, structured, and maintainable code

---

##  License & Notes

This project is developed for evaluation purposes and adheres strictly to the given restrictions:

- No use of Spring Boot or similar frameworks
- Uses PrimeFaces for UI
- Uses JDBC for all database interactions
- Managed beans for backend logic
- Configured via `web.xml` and `faces-config.xml`

---

For any queries or contributions, feel free to fork the project or contact me at [sancristma@gmail.com].
