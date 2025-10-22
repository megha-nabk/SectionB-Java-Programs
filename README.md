# Section B – Java Programs

This folder contains Java solutions for **Section B (Coding Problems)** — designed for Java 17 or above.  
Each file is organized under the package `sectionb`.

---

## 📁 Contents

| File | Description |
|------|--------------|
| Problem1_FileWordCounter.java | Counts words, characters, and lines in a text file. Uses BufferedReader and handles missing files gracefully. |
| Problem2_StudentRecordManager.java | Uses Generics and Collection Framework to store students, sort by marks, and display top 3. |
| Problem3_StringFilterLambda.java | Demonstrates Lambda Expressions + Stream API to filter and transform strings. |
| Problem4_LogExecutionDemo.java | Implements a custom annotation `@LogExecutionTime` and uses Reflection API to log execution time. |
| Problem5_StudentCRUD.java | Performs CRUD operations on a MySQL table using JDBC and PreparedStatement. |
| student.sql | SQL script to create the `student` table in a MySQL database. |

---

## 🛠 Requirements
- **Java 17 or above**
- **MySQL Database**
- MySQL JDBC Driver (add to classpath)

---

## ⚙️ Compilation and Execution

### Compile
```bash
javac sectionb/*.java
```

### Run Examples
```bash
# Problem 1: Word Counter
java sectionb.FileWordCounter sample.txt

# Problem 2: Student Records
java sectionb.StudentRecordManager

# Problem 3: Lambda Filter
java sectionb.StringFilterLambda

# Problem 4: Log Execution
java sectionb.LogExecutionDemo

# Problem 5: JDBC CRUD
java sectionb.StudentCRUD
```

---

## 💾 Database Setup
Run the following commands in your MySQL console:

```sql
SOURCE student.sql;
```

Update the DB credentials inside `Problem5_StudentCRUD.java`:
```java
private static final String URL = "jdbc:mysql://localhost:3306/testdb";
private static final String USER = "root";
private static final String PASSWORD = "password";
```

---

## 📘 Notes
- All programs include exception handling and follow Java coding standards.
- Modify or extend as needed for academic or practice use.
