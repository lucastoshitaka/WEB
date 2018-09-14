/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOAluno;
import Entidades.Aluno;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JTextArea;

/**
 *
 * @author lucastoshitaka
 */
@WebServlet(name = "ServletListaAlunos", urlPatterns = {"/tabelaAlunos"})
public class AlunosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private JTextArea text = new JTextArea();
    private SimpleDateFormat dateDataInscricao = new SimpleDateFormat("");

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        String listaAlunos = "";

        try (PrintWriter out = response.getWriter()) {
            listaAlunos = request.getParameter("Alunos");

            String resultado = "";
            if (listaAlunos == null || listaAlunos.equals("")) {
                resultado = listaAlunossCadastrados();
            } else {
                resultado = listaAlunosNome(listaAlunos);
            }
            request.getSession().setAttribute("resultado4", resultado);
            response.sendRedirect(request.getContextPath() + "/paginas/tabelaAlunos.jsp");
        }
    }

    protected String listaAlunosNome(String listaAlunos) {
        DAOAluno aluno = new DAOAluno();
        String tabela = "";
        List<Aluno> lista = aluno.listByNome(listaAlunos);
        for (Aluno l : lista) {
            tabela += "<tr>"
                    + "<td>" + l.getCpf()+ "</td>"
                    + "<td>" + l.getNome()+ "</td>"
                    + "<td>" + l.getSenha()+ "</td>"
                    + "<td>" + l.getFoto()+ "</td>"
                    + "<td>" + l.getEstado().getNomeEstado()+ "</td>"
                    
                    + "</tr>";
        }
        return tabela;
    }

    protected String listaAlunossCadastrados() {
        DAOAluno aluno = new DAOAluno();
        String tabela = "";
        List<Aluno> lista = aluno.listInOrderNome();
        for (Aluno l : lista) {
            tabela += "<tr>"
                    + "<td>" + l.getCpf()+ "</td>"
                    + "<td>" + l.getNome()+ "</td>"
                    + "<td>" + l.getSenha()+ "</td>"
                    + "<td>" + l.getFoto()+ "</td>"
                    + "<td>" + l.getEstado().getNomeEstado()+ "</td>"
                    + "</tr>";
        }
        return tabela;
    }

            /* TODO output your page here. You may use following sample code. */
            
        


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
        
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AlunosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
      
           
        
    }

     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AlunosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("teste dopost");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
