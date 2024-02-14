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
    nav {
        background-color: #007bff;
        padding: 10px;
        color: #fff;
    }
    nav a {
        color: #fff;
        text-decoration: none;
        padding: 10px;
    }
   
</style>
</head>
<body>
<nav>
    <a href="/create">Create Account</a>
    <a href="/">Home</a>
    <a href="#">Logout</a>
</nav>
<div class="container">
    <h2>Enter Your Details</h2>
    <form:form action="create" method="post" modelAttribute="dto">
    <form:label path="name">Full Name:</form:label>
    <form:input path="name"/><br>
    <form:label path="amount">Amount:</form:label>
    <form:input path="amount"/><br>
    <form:button>Submit</form:button>
    </form:form>

</div>
</body>
</html>
