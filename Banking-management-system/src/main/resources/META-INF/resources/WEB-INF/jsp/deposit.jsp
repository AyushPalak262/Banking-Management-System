 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Details</title>
<style>
    body {
        font-family: Arial, sans-serif;
        text-align: center;
    }
    .container {
        margin-top: 50px;
    }
    input[type="text"], input[type="number"] {
        padding: 10px;
        margin: 10px;
        width: 300px;
        font-size: 16px;
        border-radius: 5px;
        border: 1px solid #ccc;
    }
    .btn {
        padding: 10px 20px;
        font-size: 16px;
        cursor: pointer;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
    }
    .btn:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
<div class="container">
    <h2>Enter Your Deposit amount</h2>
    <form action="/deposit" method="post">
    <input type="hidden" name="id" value="${id}">
    <label for="amount">Amount to Deposit:</label>
    <input type="number" id="amount" name="amount" required><br><br>
    <input type="submit" value="Deposit">
</form>
	
</div>
</body>
</html>
