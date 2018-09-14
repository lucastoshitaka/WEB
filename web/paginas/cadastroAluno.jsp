
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="Entidades.Estado"%>
<%@page import="java.util.List"%>
<%@page import="DAOs.DAOEstado"%>

<%
    DAOEstado daoEstado = new DAOEstado();
    List<Estado> estado = daoEstado.listInOrderNome();

%>
<html>
    <jsp:useBean id="dao" class="DAOs.DAOEstado"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="${pageContext.request.contextPath}/CadastroAlunoServlet">
            <div>    
                <label for="cpf do Aluno">cpf do Aluno:</label>
                <input type="text" name="cpfAluno"/>
            </div>
            <div>
                <label for="nome do Aluno">nome do Aluno:</label>
                <input type="text" name="nomeAluno"/>
                <label for="senha do Aluno">senha do Aluno:</label>
                <input type="text" name="senhaAluno"/>
            </div>
            <div>
                <label for="foto do Aluno">foto do Aluno:</label>
                <input type="text" name="fotoAluno"/>
                <input type="submit" name="ok"/>
            </div>
            
        </form>
            
                    
            <select class="form-control" id="idioma" name="idioma_id_idioma">
                            <option value="">SELECIONE</option>
                            <%                       
                                for (Estado i : estado) {
                            %>
                            <option value="<%=i.getSiglaEstado()%>"><%=i.getNomeEstado()%></option>
                            <%}%>

                        </select>
          
        </form>
    </body>
</html>
