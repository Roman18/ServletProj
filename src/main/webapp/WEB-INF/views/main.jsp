<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Main</title>

</head>
<body>
<h1>Main page</h1>
<h3>Add note</h3>
<form action="<c:url value="/adduser"/>" method="post">
    name: <input  type="text" name="name"/><br/>
    description: <input type="text" name="description"/><br/>
    <input type="submit" value="Submit"/>
</form>

<table border="3">
    <c:forEach var="note" items="${notes}">
        <tr>
            <td>${note.id}</td>
            <td><a href="<c:url value="/notes/${note.id}"/>">${note.name}</a></td>
            <td>
                <form action="/webapp/delete" method="post">
                    <input type="hidden" value="${note.id}" name="id" />
                    <input type="submit" value="delete">
                </form>

            </td>
        </tr>

    </c:forEach>

</table>
</body>
</html>
