<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Logged In</h1>
    <script>
        const queryString = window.location.search;
        const urlParams = new URLSearchParams(queryString);

        const idClient = urlParams.get('idClient');
        const firstname = urlParams.get('firstname');
        localStorage.setItem("loggedIn",true);
        window.location.href = "/books?name="+firstname+"&idClient="+idClient; 
    </script>
</body>
</html>