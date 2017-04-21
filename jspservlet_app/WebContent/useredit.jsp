<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>


Edit User:

<br>
<form action="UserServlet" >
firstName: <input type="text" name ="firstname"  value = "${user.firstname}"/> <br>
lastname: <input type="text" name ="lastname" value="${user.lastname}"/><br>
age: <input type="text" name ="age" value="${user.age}" /><br>
gender: <input type="text" name ="gender" value="${user.gender}" /><br>
isMarried: <input type="text" name ="isMarried" value="${user.isMarried}" /><br>
 <input type="hidden" name ="userId" value="${user.userId}" /><br>
<input type="hidden" name ="action"  value="updateuser"/>
 <input type="submit" value ="Edit user" /><br>

</form>

</html>

