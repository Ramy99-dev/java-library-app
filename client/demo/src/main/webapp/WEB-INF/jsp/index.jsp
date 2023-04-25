<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="style/index.css">

</head>
<body>
   <div class="books-container">
    <c:forEach items="${books}" var="book">
        <div class="card">
            <img src="book-cover.png" alt="">
            <h1 class="title">${book.title}</h1>
            <hr>
            <h2>${book.title}</h2>
        </div>
    </c:forEach>
     
     
   </div>

</body>
</html>