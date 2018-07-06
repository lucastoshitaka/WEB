<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="${pageContext.request.contextPath}/tabelaDisciplinas">
            <input type="text" name="nomeDisciplinas"/>
            <input type="submit" name="ok"/>
        </form>
    </body>
</html>