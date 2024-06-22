<h1> Employee Management System</h1>
<p>This is a simple Employee Management System built using Java, JSP, and MySQL. The project allows for the management of employees, including adding new employees, updating existing employee details, and viewing employee information. This project highlights the integration of database operations and web interface.</p>
<h3>Features</h3>
<ul>
  <li>Add new employees</li>
  <li>Update employee details</li>
  <li> Delete employee details</li>
  <li>View employee details</li>
  <li>Search for employees</li>
</ul>
<h3>Architecture</h3>
<ul>
  <li>Backend: Java (Servlets, JSP)</li>
  <li>Frontend: HTML, CSS</li>
  <li>Database: MySQL</li>
</ul>
<h2>Getting Started</h2>
<h3>Prerequisites</h3>
<ul>
  <li>Eclipse IDE [Enterprise Java] 2024-03</li>
  <li>JDK 8 or higher</li>
  <li>Apache Tomcat 9.0</li>
  <li>MySQL 8.0
</ul>
<h3>Installation</h3>
<ol>
  <li>Clone the repository:</li>
  <code>git clone https://github.com/TharunA777/Employee-Management-System-using-ChatGPT.git</code>
  <h4></h4>
  <li>Import the project <code>WAR</code> file into your IDE (Eclipse).</li>
  <li>Import the <code>mysql-connector.jar</code> file into your project (External Library) to enable MySQL database connectivity.</li>
   <h4></h4>
  <li>Configure the MySQL database:
  <ul>
    <li>Create a database named <code>empms</code></li>
    <li>Execute the SQL script <code>schema.sql</code> to create the necessary table.</li>
  </ul>
  </li>
   <h4></h4>
  <li>Update the database connection details in <code>Logindao.java</code>:</li>
<code>String url = "jdbc:mysql://localhost:3306/empms";
    String username = "root";
    String password = "password";</code>
  <h4></h4>
  <li>Deploy the project to your Apache Tomcat server:</li>
  <ul>
    <li>Right Click on the <code>index.jsp</code> file</li>
    <li>Click on Run on Server</li>
    <li>Select Tomcat Server 9.0</li>
  </ul>
</ol>

<h3>Screenshots</h3>

![screenshot gif](https://github.com/TharunA777/Employee-Management-System-using-ChatGPT/assets/132211534/202e9980-f5ec-4246-8bef-baf392f97a23)


<h3>Contributing</h3>
<p>Contributions are welcome! Please fork the repository and submit pull requests.</p>

<h3>Contact</h3>
<p>For any inquiries or feedback, please contact me at tarun.agasr@gmail.com.</p>

<h4>By acknowledging the significant role ChatGPT played in generating this code, I demonstrate the potential of AI tools in software development and my ability to effectively leverage these tools.</h4>


