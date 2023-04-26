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
   <center><h1>Hello ${name}</h1></center>
   <div class="books-container">
 
    <c:forEach items="${books}" var="book">
        <div class="card">
            <img src="book-cover.png" alt="">
            <h1 class="title">${book.title}</h1>
            <hr>
            <h2>${book.title}</h2>
            
           <a href="#popup1"> <button  class="button" onclick="openPopUp('${book.getIdBook()}')">Reserve</button></a>
        </div>
    </c:forEach>
    <script>

        body = document.getElementsByTagName('body')[0];

        const openPopUp = (idBook)=>{
            let currentUrl = window.location.href;
            let newUrl = currentUrl
            console.log(newUrl)
            newUrl = newUrl.replace(/&idBook=\d+/g, '');
            newUrl = newUrl.replace("#", '');

            console.log(idBook)
            const stateObj = { foo: "bar" };
            const title = "New Page Title";
            newUrl = newUrl+"&idBook="+idBook;

            history.replaceState(stateObj, title, newUrl);
        }

        const reserve = () =>{
            const startDate = document.getElementById("startDate")
            const queryString = window.location.search;
            const urlParams = new URLSearchParams(queryString);
            const idBook = urlParams.get('idBook');
            const idClient = urlParams.get('idClient');
            const name = urlParams.get('name');
            console.log(idBook);
            console.log(idClient);

            window.location.href = "/submit-reservation/?idClient="+idClient+"&idBook="+idBook+"&date="+startDate.value+"&name="+name;
        }

    </script>
    


<div id="popup1" class="overlay">
	<div class="popup">
		<h2>Choose reservation date :</h2>
		<a class="close" href="#">&times;</a>
        <center>Start Date : <input id="startDate" type="date" name="" id=""></center>
        <center><div class="submit-container"><input type="submit" value="Confirm" onclick="reserve()"></div></center>
        
	</div>
</div>
     
     
   </div>

</body>
</html>