/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOAluno;
import DAOs.DAOEstado;
import Entidades.Aluno;
import Entidades.Estado;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucastoshitaka
 */
@WebServlet(name = "CadastroAlunoServlet", urlPatterns = {"/CadastroAlunoServlet"})
public class CadastroAlunoServlet extends HttpServlet {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastroAlunoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastroAlunoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

                 DAOEstado daoEstado = new DAOEstado();
            Estado estado = new Estado();
            
            DAOAluno controle = new DAOAluno();
            Aluno entidade = new Aluno();      

            
            String cpfAluno = request.getParameter("cpfAluno");
            String nomeAluno = request.getParameter("nomeAluno");
            String senhaAluno = request.getParameter("senhaAluno");
            String fotoAluno = request.getParameter("fotoAluno");

            String est = String.valueOf(request.getParameter("estado"));
            estado=daoEstado.obter(est);
            
            
            System.out.println("0");
            
            System.out.println("3");
         

            entidade.setCpf(cpfAluno);
            entidade.setNome(nomeAluno);
            entidade.setSenha(senhaAluno);
            entidade.setFoto(fotoAluno);
                            entidade.setEstado(estado);

            System.out.println("1");
            
                   
            
            controle.inserir(entidade);
            System.out.println("4");
            

            response.sendRedirect(request.getContextPath() + "/paginas/cadastroAluno.jsp");
      
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            processRequest(request, response);
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
