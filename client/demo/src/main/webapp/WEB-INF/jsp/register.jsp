<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="style/register.css">
</head>
<body>
   <div class="register-box">
    <form method="post" action="/submit-register">
        <center><h1>Register</h1>
        <span class="error">${errMsg}</span></center>
        <label>Firstname :</label>
        <input type="text" name="firstname" id="" placeholder="Enter your firstname">
        <label>Lastname :</label>
        <input type="text" name="lastname" id="" placeholder="Enter your lastname">
        <label>Email :</label>
        <input type="text" name="email" id="" placeholder="Enter your email">
        <label>Password :</label>
        <input type="password" name="password" id="" placeholder="Choose your password">
        <label>Repeat password</label>
        <input type="password" name="confirm_password" id="">
        <div class="submit-container"><input type="submit" value="Register"></div>
    </form>
   </div>
</body>
</html>