<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome to My Bank</title>
<style>
    body {
        font-family: Arial, sans-serif;
        text-align: center;
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
        background-color: #0056b3;
    }
</style>
</head>
<body>

<div align="center">
    <h1>Successful!!!</h1>
    
    <span>Full Name:</span><span>${dto.name}</span>
    <br>
    <br>
    <br>
    <br>
    <a href="/all">See all accounts</a>
    <br>
    <br>
    <a href="/">Home</a>
</div>
</body>
</html>
