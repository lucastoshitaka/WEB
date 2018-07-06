<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="${pageContext.request.contextPath}/CadastroEstadoServlet">
            <div>    
            <label for="sigla do Estado">Sigla do Estado:</label>
            <input type="text" name="siglaEstado"/>
            </div>
            <div>
                <label for="nome do Estado">nome do Estado:</label>
            <input type="text" name="nomeEstado"/>
            <input type="submit" name="ok"/>
            </div>
        </form>
    </body>
</html>
