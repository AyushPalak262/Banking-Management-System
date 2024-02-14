 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Account Details</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8f9fa;
        padding: 20px;
    }
    .container {
        max-width: 800px;
        margin: 0 auto;
    }
    .table-container {
        margin-top: 20px;
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
    nav a:hover {
        background-color: white;
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
    <h2>All Accounts</h2>
    <div class="table-container">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Account ID</th>
                    <th>Name</th>
                    <th>Amount</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${dto}" var="dtos">
					<tr>
						
						<td>${dtos.id}</td>
						<td>${dtos.name}</td>
						<td>${dtos.amount}</td>
						<td><a href="deposit?id=${dtos.id}" class="btn btn-warning">Deposit </a></td>
						<td><a href="withdrawal?id=${dtos.id}" class="btn btn-warning">Withdrawal </a></td>
						<td><a href="delete?id=${dtos.id}" class="btn btn-danger">Delete </a></td>
					</tr>
				
				</c:forEach>
            </tbody>
        </table>
    </div>
</div>



</body>
</html>
