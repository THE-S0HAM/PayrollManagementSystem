<div align="center">

# 💼 Payroll Management System

[![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![JDBC](https://img.shields.io/badge/JDBC-Driver-007396?style=for-the-badge&logo=java&logoColor=white)](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html)
[![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)](LICENSE)

**A comprehensive console-based Employee Payroll Management System built with Core Java and MySQL Database**

*Streamline your organization's payroll operations with automated salary calculations, employee management, and real-time data persistence.*

[Features](#-features) •
[Architecture](#-architecture) •
[Installation](#-installation) •
[Usage](#-usage) •
[Screenshots](#-screenshots)

</div>

---

## 📋 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Technology Stack](#-technology-stack)
- [Architecture](#-architecture)
- [Project Structure](#-project-structure)
- [Database Design](#-database-design)
- [Installation](#-installation)
- [Configuration](#-configuration)
- [Usage](#-usage)
- [Screenshots](#-screenshots)
- [Salary Calculation Logic](#-salary-calculation-logic)
- [API Reference](#-api-reference)
- [Contributing](#-contributing)
- [License](#-license)

---

## 🎯 Overview

The **Payroll Management System** is a robust, console-based Java application designed to simplify and automate the complex process of managing employee payroll in organizations. This system provides a complete solution for:

- **Employee Lifecycle Management** - From onboarding to offboarding
- **Automated Salary Calculations** - Including HRA, DA, and PF components
- **Salary Increment Processing** - Percentage-based increments
- **Data Persistence** - MySQL database integration for reliable storage
- **Soft Delete Mechanism** - Safe employee deactivation without data loss

### Why Choose This System?

| Benefit | Description |
|---------|-------------|
| 🚀 **Efficiency** | Automates complex salary calculations instantly |
| 🔒 **Data Safety** | Soft delete ensures no accidental data loss |
| 📊 **Comprehensive** | Manages all aspects of employee payroll |
| 🔧 **Maintainable** | Clean DAO pattern for easy maintenance |
| 💾 **Persistent** | MySQL backend for reliable data storage |

---

## ✨ Features

### 👤 Employee Management

| Feature | Description |
|---------|-------------|
| ➕ **Add Employee** | Register new employees with name, department, and basic salary |
| 👁️ **View All Employees** | Display all active employees with complete details |
| 🔍 **Search by ID** | Find specific employee using their unique ID |
| ✏️ **Update Details** | Modify employee information (name, department, salary) |
| 🚪 **Employee Offboarding** | Safely deactivate employees (soft delete) |

### 💰 Payroll Features

| Feature | Description |
|---------|-------------|
| 🧮 **Auto Salary Calculation** | Automatically computes HRA, DA, PF, and Net Salary |
| 📈 **Salary Increment** | Apply percentage-based salary increments |
| 📋 **Salary Breakdown** | View detailed breakdown of salary components |

### 🛡️ Data Management

| Feature | Description |
|---------|-------------|
| 💾 **Persistent Storage** | All data stored in MySQL database |
| 🔄 **CRUD Operations** | Full Create, Read, Update, Delete functionality |
| 🗃️ **Soft Delete** | Employees are deactivated, not permanently deleted |
| 🔗 **Connection Pooling** | Efficient database connection management |

---

## 🛠️ Technology Stack

<table>
<tr>
<td align="center" width="150">
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="50" height="50"/>
<br><b>Java 17+</b>
<br><sub>Core Language</sub>
</td>
<td align="center" width="150">
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" width="50" height="50"/>
<br><b>MySQL 8.0+</b>
<br><sub>Database</sub>
</td>
<td align="center" width="150">
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" width="50" height="50"/>
<br><b>JDBC</b>
<br><sub>Database Connectivity</sub>
</td>
</tr>
</table>

### Detailed Technology Breakdown

| Technology | Version | Purpose |
|------------|---------|---------|
| **Java** | 17+ | Primary programming language with modern features like text blocks and switch expressions |
| **MySQL** | 8.0+ | Relational database for persistent data storage |
| **JDBC** | 4.2+ | Java Database Connectivity for MySQL integration |
| **MySQL Connector/J** | 8.0+ | Official MySQL JDBC driver |

---

## 🏗️ Architecture

The application follows a **layered architecture pattern** with clear separation of concerns:

```
┌─────────────────────────────────────────────────────────────────┐
│                    PRESENTATION LAYER                           │
│                      (PayrollApp.java)                          │
│              Console-based User Interface                       │
│         Menu Display | User Input | Output Display              │
└─────────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────────┐
│                     SERVICE LAYER                                │
│                   (PayrollService.java)                          │
│              Business Logic & Calculations                       │
│         HRA Calculation | DA Calculation | PF Deduction         │
└─────────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────────┐
│                  DATA ACCESS LAYER (DAO)                        │
│    ┌──────────────────┐    ┌──────────────────────────┐        │
│    │  EmployeeDAO.java│───▶│ EmployeeDAOImpl.java     │        │
│    │   (Interface)    │    │   (Implementation)       │        │
│    └──────────────────┘    └──────────────────────────┘        │
│              CRUD Operations | Database Queries                 │
└─────────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────────┐
│                   DATABASE LAYER                                 │
│                  (DBConnection.java)                             │
│         Connection Management | JDBC Configuration              │
└─────────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────────┐
│                      MySQL DATABASE                              │
│                      (payroll_db)                                │
│                   Employee Table Storage                         │
└─────────────────────────────────────────────────────────────────┘
```

### Design Patterns Used

| Pattern | Implementation | Benefit |
|---------|----------------|---------|
| **DAO Pattern** | `EmployeeDAO` interface + `EmployeeDAOImpl` | Separates data access from business logic |
| **Singleton (Connection)** | `DBConnection` class | Centralized database configuration |
| **Model Pattern** | `Employee` class | Encapsulates employee data structure |

---

## 📁 Project Structure

```
PayrollManagementSystem/
│
├── 📂 src/                          # Source code directory
│   ├── 📄 PayrollApp.java           # Main application entry point
│   ├── 📄 Employee.java             # Employee model/entity class
│   ├── 📄 EmployeeDAO.java          # DAO interface definition
│   ├── 📄 EmployeeDAOImpl.java      # DAO implementation
│   ├── 📄 PayrollService.java       # Business logic service
│   └── 📄 DBConnection.java         # Database connection utility
│
├── 📂 bin/                          # Compiled class files
│   ├── 📄 PayrollApp.class
│   ├── 📄 Employee.class
│   ├── 📄 EmployeeDAO.class
│   ├── 📄 EmployeeDAOImpl.class
│   ├── 📄 PayrollService.class
│   └── 📄 DBConnection.class
│
├── 📂 output/                       # Application screenshots
│   ├── 🖼️ add_employee_operation.png
│   ├── 🖼️ view_all_operation.png
│   ├── 🖼️ search_employee_by_id_operation.png
│   ├── 🖼️ employee_update_operation.png
│   ├── 🖼️ salary_increment_operation.png
│   ├── 🖼️ employee_deactivate_opration.png
│   └── 🖼️ exit_operation.png
│
├── 📂 .settings/                    # Eclipse IDE settings
├── 📄 .classpath                    # Eclipse classpath configuration
├── 📄 .project                      # Eclipse project file
├── 📄 .gitignore                    # Git ignore rules
└── 📄 README.md                     # This documentation file
```

### File Descriptions

| File | Lines | Description |
|------|-------|-------------|
| `PayrollApp.java` | 92 | Main entry point with console menu and user interaction logic |
| `Employee.java` | 60 | Model class with employee attributes and getter/setter methods |
| `EmployeeDAO.java` | 18 | Interface defining CRUD operations for employee data access |
| `EmployeeDAOImpl.java` | 155 | Implementation of DAO with MySQL JDBC operations |
| `PayrollService.java` | 19 | Service class for salary component calculations |
| `DBConnection.java` | 14 | Database connection utility with JDBC configuration |

---

## 🗄️ Database Design

### Entity Relationship Diagram

```
┌────────────────────────────────────────────────────────────┐
│                        EMPLOYEE                            │
├────────────────────────────────────────────────────────────┤
│  PK  │ emp_id        │ INT          │ AUTO_INCREMENT       │
├──────┼───────────────┼──────────────┼──────────────────────┤
│      │ name          │ VARCHAR(100) │ NOT NULL             │
│      │ department    │ VARCHAR(50)  │ NOT NULL             │
│      │ basic_salary  │ DOUBLE       │ NOT NULL             │
│      │ hra           │ DOUBLE       │ House Rent Allowance │
│      │ da            │ DOUBLE       │ Dearness Allowance   │
│      │ pf            │ DOUBLE       │ Provident Fund       │
│      │ net_salary    │ DOUBLE       │ Calculated Net Salary│
│      │ status        │ VARCHAR(20)  │ ACTIVE/INACTIVE      │
└────────────────────────────────────────────────────────────┘
```

### Create Database Script

```sql
-- Create the database
CREATE DATABASE IF NOT EXISTS payroll_db;

-- Use the database
USE payroll_db;

-- Create employee table
CREATE TABLE IF NOT EXISTS employee (
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(50) NOT NULL,
    basic_salary DOUBLE NOT NULL,
    hra DOUBLE DEFAULT 0,
    da DOUBLE DEFAULT 0,
    pf DOUBLE DEFAULT 0,
    net_salary DOUBLE DEFAULT 0,
    status VARCHAR(20) DEFAULT 'ACTIVE',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create index for faster lookups
CREATE INDEX idx_employee_status ON employee(status);
CREATE INDEX idx_employee_department ON employee(department);
```

### Sample Data

```sql
-- Insert sample employees
INSERT INTO employee (name, department, basic_salary, hra, da, pf, net_salary, status)
VALUES 
    ('John Doe', 'Engineering', 50000, 10000, 5000, 6000, 59000, 'ACTIVE'),
    ('Jane Smith', 'Marketing', 45000, 9000, 4500, 5400, 53100, 'ACTIVE'),
    ('Bob Johnson', 'Finance', 55000, 11000, 5500, 6600, 64900, 'ACTIVE');
```

---

## 🚀 Installation

### Prerequisites

Before you begin, ensure you have the following installed:

| Requirement | Version | Download Link |
|-------------|---------|---------------|
| Java JDK | 17 or higher | [Download](https://www.oracle.com/java/technologies/downloads/) |
| MySQL Server | 8.0 or higher | [Download](https://dev.mysql.com/downloads/mysql/) |
| MySQL Connector/J | 8.0+ | [Download](https://dev.mysql.com/downloads/connector/j/) |
| IDE (Optional) | Eclipse/IntelliJ | [Eclipse](https://www.eclipse.org/downloads/) |

### Step-by-Step Installation

#### 1️⃣ Clone the Repository

```bash
# Clone using HTTPS
git clone https://github.com/ByteNinjaSmit/PayrollManagementSystem.git

# Navigate to project directory
cd PayrollManagementSystem
```

#### 2️⃣ Set Up MySQL Database

```bash
# Login to MySQL
mysql -u root -p

# Run the database setup script
source path/to/database_setup.sql
```

Or manually execute:

```sql
-- Create database
CREATE DATABASE payroll_db;

-- Switch to database
USE payroll_db;

-- Create employee table
CREATE TABLE employee (
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(50) NOT NULL,
    basic_salary DOUBLE NOT NULL,
    hra DOUBLE DEFAULT 0,
    da DOUBLE DEFAULT 0,
    pf DOUBLE DEFAULT 0,
    net_salary DOUBLE DEFAULT 0,
    status VARCHAR(20) DEFAULT 'ACTIVE'
);
```

#### 3️⃣ Configure Database Connection

Edit `src/DBConnection.java` with your MySQL credentials:

```java
class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/payroll_db";
    private static final String USER = "your_username";  // Change this
    private static final String PASS = "your_password";  // Change this
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
```

#### 4️⃣ Add MySQL Connector JAR

**For Eclipse IDE:**
1. Right-click on project → **Build Path** → **Configure Build Path**
2. Go to **Libraries** tab → **Add External JARs**
3. Select the `mysql-connector-j-8.x.x.jar` file
4. Click **Apply and Close**

**For Command Line:**
```bash
# Download MySQL Connector
# Place in project lib folder

# Compile with classpath
javac -cp ".;lib/mysql-connector-j-8.x.x.jar" src/*.java -d bin/
```

#### 5️⃣ Compile and Run

**Using Eclipse:**
1. Open project in Eclipse
2. Right-click `PayrollApp.java`
3. Select **Run As** → **Java Application**

**Using Command Line:**
```bash
# Navigate to project directory
cd PayrollManagementSystem

# Compile all Java files
javac -cp ".;lib/mysql-connector-j-8.x.x.jar" -d bin src/*.java

# Run the application
java -cp "bin;lib/mysql-connector-j-8.x.x.jar" PayrollApp
```

---

## ⚙️ Configuration

### Database Configuration

| Property | Default Value | Description |
|----------|---------------|-------------|
| `URL` | `jdbc:mysql://localhost:3306/payroll_db` | MySQL database URL |
| `USER` | `root` | Database username |
| `PASS` | `********` | Database password |

### Salary Configuration (in PayrollService.java)

| Component | Calculation | Percentage |
|-----------|-------------|------------|
| **HRA** | Basic Salary × 0.20 | 20% of Basic |
| **DA** | Basic Salary × 0.10 | 10% of Basic |
| **PF** | Basic Salary × 0.12 | 12% of Basic |

### Modifying Salary Components

To change salary calculation percentages, edit `PayrollService.java`:

```java
public void calculateSalary(Employee emp) {
    double basic = emp.getBasicSalary();
    
    // Modify these percentages as needed
    double hra = basic * 0.20;  // 20% HRA
    double da = basic * 0.10;   // 10% DA  
    double pf = basic * 0.12;   // 12% PF (deduction)
    
    double netSalary = basic + hra + da - pf;
    
    emp.setHra(hra);
    emp.setDa(da);
    emp.setPf(pf);
    emp.setNetSalary(netSalary);
}
```

---

## 📖 Usage

### Main Menu Options

When you run the application, you'll see the following menu:

```
-------------------- Payroll Management System --------------------
1. Add Employee
2. View All Employees
3. View Employee By ID
4. Update Employee details
5. Apply Salary Increment
6. Remove Employee (Employee offboarding)
7. Exit
------------------------------------------------------------
Choose option: 
```

### Detailed Usage Guide

#### 1️⃣ Add Employee

```
Choose option: 1
Name: John Doe
Department: Engineering
Basic Salary: 50000
Employee Added Successfully
```

**What happens behind the scenes:**
- Salary components are automatically calculated
- Employee is saved to database with status "ACTIVE"

#### 2️⃣ View All Employees

```
Choose option: 2
1 | John Doe | Engineering | Basic: 50000.0 | Net: 59000.0 | Status: ACTIVE
2 | Jane Smith | Marketing | Basic: 45000.0 | Net: 53100.0 | Status: ACTIVE
```

**Note:** Only ACTIVE employees are displayed.

#### 3️⃣ View Employee By ID

```
Choose option: 3
Employee ID: 1
1 | John Doe | Engineering | Basic: 50000.0 | Net: 59000.0 | Status: ACTIVE
```

#### 4️⃣ Update Employee Details

```
Choose option: 4
Employee ID: 1
New Name: John D. Doe
New Department: Senior Engineering
New Basic Salary: 60000
Employee Updated Successfully
```

**Note:** Salary components are automatically recalculated.

#### 5️⃣ Apply Salary Increment

```
Choose option: 5
Employee ID: 1
Increment %: 10
Increment Applied Successfully
```

**Note:** Only basic salary is incremented. Recalculation of net salary requires updating the employee.

#### 6️⃣ Remove Employee (Offboarding)

```
Choose option: 6
Employee ID: 1
Employee Deactivated
```

**Note:** This is a soft delete. The employee record is preserved but marked as INACTIVE.

#### 7️⃣ Exit

```
Choose option: 7
Exited......
```

---

## 📸 Screenshots

### Application Operations Gallery

<details>
<summary>📷 Click to view all screenshots</summary>

#### 1. Add Employee Operation
![Add Employee](output/add_employee_operation.png)
*Adding a new employee with name, department, and basic salary*

---

#### 2. View All Employees Operation
![View All Employees](output/view_all_operation.png)
*Displaying all active employees in the system*

---

#### 3. Search Employee by ID Operation
![Search Employee](output/search_employee_by_id_operation.png)
*Finding a specific employee using their unique ID*

---

#### 4. Update Employee Operation
![Update Employee](output/employee_update_operation.png)
*Modifying employee details like name, department, and salary*

---

#### 5. Salary Increment Operation
![Salary Increment](output/salary_increment_operation.png)
*Applying percentage-based salary increment*

---

#### 6. Employee Deactivation Operation
![Employee Deactivation](output/employee_deactivate_opration.png)
*Soft deleting an employee (offboarding)*

---

#### 7. Exit Operation
![Exit](output/exit_operation.png)
*Gracefully exiting the application*

</details>

---

## 💰 Salary Calculation Logic

### Formula

```
┌─────────────────────────────────────────────────────────────────┐
│                    SALARY CALCULATION                           │
├─────────────────────────────────────────────────────────────────┤
│                                                                 │
│   HRA (House Rent Allowance)  =  Basic Salary × 20%            │
│   DA  (Dearness Allowance)    =  Basic Salary × 10%            │
│   PF  (Provident Fund)        =  Basic Salary × 12%            │
│                                                                 │
│   ─────────────────────────────────────────────────────────     │
│                                                                 │
│   NET SALARY = Basic Salary + HRA + DA - PF                     │
│                                                                 │
│   ─────────────────────────────────────────────────────────     │
│                                                                 │
│   Example:                                                      │
│   Basic Salary = ₹50,000                                        │
│   HRA          = ₹50,000 × 0.20 = ₹10,000                       │
│   DA           = ₹50,000 × 0.10 = ₹5,000                        │
│   PF           = ₹50,000 × 0.12 = ₹6,000                        │
│   ─────────────────────────────────────────────────────────     │
│   NET SALARY   = ₹50,000 + ₹10,000 + ₹5,000 - ₹6,000            │
│                = ₹59,000                                        │
│                                                                 │
└─────────────────────────────────────────────────────────────────┘
```

### Salary Components Breakdown

| Component | Full Form | Type | Percentage | Description |
|-----------|-----------|------|------------|-------------|
| **Basic** | Basic Salary | Base | N/A | Foundation of salary structure |
| **HRA** | House Rent Allowance | Allowance | +20% | Housing expense coverage |
| **DA** | Dearness Allowance | Allowance | +10% | Cost of living adjustment |
| **PF** | Provident Fund | Deduction | -12% | Retirement savings (deducted) |

### Visual Salary Distribution

```
                    SALARY BREAKDOWN
    ┌────────────────────────────────────────────┐
    │                                            │
    │   Basic Salary                      ████████████████  100%
    │                                            │
    │   + HRA (House Rent Allowance)      ███░░░░░░░░░░░░░  +20%
    │                                            │
    │   + DA (Dearness Allowance)         ██░░░░░░░░░░░░░░  +10%
    │                                            │
    │   - PF (Provident Fund)             ██░░░░░░░░░░░░░░  -12%
    │                                            │
    │   ════════════════════════════════════════════════    │
    │                                            │
    │   = NET SALARY                      ███████████████████ 118%
    │                                            │
    └────────────────────────────────────────────┘
```

---

## 📚 API Reference

### Employee Model

```java
public class Employee {
    // Fields
    private int empId;           // Unique identifier (auto-generated)
    private String name;         // Employee name
    private String department;   // Department name
    private double basicSalary;  // Base salary
    private double hra;          // House Rent Allowance
    private double da;           // Dearness Allowance
    private double pf;           // Provident Fund
    private double netSalary;    // Calculated net salary
    private String status;       // ACTIVE or INACTIVE
    
    // Constructors, Getters, Setters, toString()
}
```

### EmployeeDAO Interface

| Method | Parameters | Return Type | Description |
|--------|------------|-------------|-------------|
| `addEmployee` | `Employee emp` | `void` | Adds new employee to database |
| `getAllEmployees` | None | `List<Employee>` | Returns all active employees |
| `getEmployeeById` | `int id` | `Employee` | Finds employee by ID |
| `updateEmployee` | `Employee emp` | `void` | Updates employee details |
| `applyIncrement` | `int empId, double percent` | `void` | Applies salary increment |
| `deactivateEmployee` | `int id` | `void` | Soft deletes employee |

### PayrollService Class

| Method | Parameters | Return Type | Description |
|--------|------------|-------------|-------------|
| `calculateSalary` | `Employee emp` | `void` | Calculates HRA, DA, PF, Net Salary |

### DBConnection Class

| Method | Parameters | Return Type | Description |
|--------|------------|-------------|-------------|
| `getConnection` | None | `Connection` | Returns MySQL database connection |

---

## 🤝 Contributing

We welcome contributions to improve the Payroll Management System!

### How to Contribute

1. **Fork the Repository**
   ```bash
   git fork https://github.com/ByteNinjaSmit/PayrollManagementSystem.git
   ```

2. **Create Feature Branch**
   ```bash
   git checkout -b feature/AmazingFeature
   ```

3. **Commit Changes**
   ```bash
   git commit -m 'Add: AmazingFeature'
   ```

4. **Push to Branch**
   ```bash
   git push origin feature/AmazingFeature
   ```

5. **Open Pull Request**

### Contribution Ideas

| Area | Ideas |
|------|-------|
| 🎨 **UI/UX** | Add GUI using JavaFX or Swing |
| 🔐 **Security** | Implement user authentication |
| 📊 **Reports** | Generate PDF salary slips |
| 📧 **Notifications** | Email salary notifications |
| 🧪 **Testing** | Add JUnit test cases |
| 📝 **Logging** | Implement log4j logging |

---

## 📜 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

```
MIT License

Copyright (c) 2024 PayrollManagementSystem

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

---

## 👨‍💻 Author

<div align="center">

**Developed with ❤️ by ByteNinjaSmit**

[![GitHub](https://img.shields.io/badge/GitHub-ByteNinjaSmit-181717?style=for-the-badge&logo=github)](https://github.com/ByteNinjaSmit)

</div>

---

## 🙏 Acknowledgments

- Java Documentation & Tutorials
- MySQL Documentation
- JDBC API Reference
- Open Source Community

---

<div align="center">

### ⭐ Star this repository if you find it helpful!

**[⬆ Back to Top](#-payroll-management-system)**

</div>
