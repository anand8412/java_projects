<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>



<table border="1">
<thead>
<tr>
<td>userId</td>
<td>firstname</td>
<td>lastname</td>
<td>age</td>
<td>gender</td>
<td>isMarried</td>
<td>Edit</td>
</tr>
</thead>

<tbody>
<c:forEach items="${users}" var="user">
<tr>
<td>${user.userId}</td>
<td>${user.firstname}</td>
<td>${user.lastname}</td>
<td>${user.age}</td>
<td>${user.gender}</td>
<td>${user.isMarried}</td>
<td><a href="UserServlet?action=edit&userId=${user.userId}">Edit</a></td>
<td><a href="UserServlet?action=delete&userId=${user.userId}">Delete</a></td>
</tr>
</c:forEach>
</tbody>
</table>


<br><br><br>
Create User:

<br>
<form action="UserServlet" >
firstName: <input type="text" name ="firstname" /> <br>
lastname: <input type="text" name ="lastname" /><br>
age: <input type="text" name ="age" /><br>
gender: <input type="text" name ="gender" /><br>
isMarried: <input type="text" name ="isMarried" /><br>
<input type="hidden" name ="action"  value="create"/>
 <input type="submit" value ="create user" /><br>

</form>



</html>