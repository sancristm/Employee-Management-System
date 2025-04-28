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

The dashboard after the data has be pupulated in an initial state "no records" massaege should be displayed with an empty table

![image](https://github.com/user-attachments/assets/e4bf239c-c97f-4e44-9f21-8c478390fb49)



Add Employee | 
Add employee form: 
- Adds a an employee to the database and redirects to the index page
- The form has input validations when the user does not enter the require fields
- the form needs a revamp in the near future when it come to styling, validations messages output(kinda messy right now) etc 

![image](https://github.com/user-attachments/assets/57efe202-aabd-43d3-a171-c71fdbc99425)

![image](https://github.com/user-attachments/assets/c33bd064-b88a-4583-8de6-2523e0cd6c48)



***Edit Employee 
- onclick event redirects to the edit form
- the form pops up populated with the fields to edit
- Before Editing

  ![image](https://github.com/user-attachments/assets/59649e26-3145-49f7-850f-777aca0b697f)
  
  
- After (on save) redirects to the index/dashboard

  
  ![image](https://github.com/user-attachments/assets/1fdc9e7d-5ded-4cda-b6b2-ddd35e6d7e6a)


  

Delete Employee( deleates a record)
- deletes the record from the table as well as in the database
  ### after deletion
  ![image](https://github.com/user-attachments/assets/a40923bf-3387-4ff8-b066-8cc7cc89ae0a)

  
  ![image](https://github.com/user-attachments/assets/065ef69b-11f7-47f0-9be2-fbb849cef986)





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
