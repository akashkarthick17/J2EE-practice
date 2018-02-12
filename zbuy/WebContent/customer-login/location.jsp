<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>

function getCity() {
	var lattitude = <%= request.getParameter("lat") %>
	var longitude = <%= request.getParameter("long") %>
	
	var xhttp = new XMLHttpRequest();

	var response;
	var obj= null;
	xhttp.onreadystatechange = function() {
		if(this.readyState==4 && this.status==200) {
			response = this.response;
			console.log(JSON.parse(response));
		 obj = JSON.parse(response);
		 
		 return obj;
		 
		 document.getElementById("p").innerHTML = obj;
		 
		
		}
	}
	
	xhttp.open("GET","https://maps.googleapis.com/maps/api/geocode/json?latlng=22.5726,88.3639&key=AIzaSyBMJmMd7fELIjpBg3NzonCuz-ww-S8NW0A",true);
	xhttp.send();
	
}


</script>


</head>
<body onload="getCity()">

<%

response.setContentType("application/json");
response.setCharacterEncoding("UTF-8");
response.getWriter().write("hello");

%>

   

</body>
</html>