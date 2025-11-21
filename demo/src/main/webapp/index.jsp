<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Form</title></head>
<body>
<h2>Enter Details</h2>
<form action="submitForm" method="post">
    Name: <input type="text" name="name" required /><br><br>
    Email: <input type="email" name="email" required /><br><br>
    Age: <input type="number" name="age" /><br><br>
    <input type="submit" value="Submit" />
</form>
</body>
</html>