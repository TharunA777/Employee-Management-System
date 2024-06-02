<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
    <form action="addEmployee" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        
        <label for="role">Role:</label>
        <input type="text" id="role" name="role" required><br>
        
        <label for="designation">Designation:</label>
        <input type="text" id="designation" name="designation" required><br>
        
        <label for="city">City:</label>
        <input type="text" id="city" name="city" required><br>
        
        <label for="country">Country:</label>
        <input type="text" id="country" name="country" required><br>
        
        <label for="phone_number">Phone Number:</label>
        <input type="text" id="phone_number" name="phone_number" required><br>
        
        <input type="submit" value="Add Employee">
    </form>
</body>
</html>
