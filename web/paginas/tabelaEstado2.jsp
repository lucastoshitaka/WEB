<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="${pageContext.request.contextPath}/tabelaEstado">
            <input type="text" name="nomeEstado"/>
            <input type="submit" name="ok"/>
        </form>
    </body>
</html>