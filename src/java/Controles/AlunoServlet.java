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
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jaque
 */
@WebServlet(name = "AlunoServlet", urlPatterns = {"/tabelaAluno"})
public class AlunoServlet extends HttpServlet {

    Locale ptBr = new Locale("pt", "BR");
    NumberFormat formatoDinheiro = NumberFormat.getCurrencyInstance(ptBr);
    DAOAluno controle2 = new DAOAluno();
    List<Aluno> dados = new ArrayList<>();

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
        String nomeAluno = "";
        nomeAluno = request.getParameter("nomeAluno");
        try (PrintWriter out = response.getWriter()) {

          //  String resultado = listaAlunosCadastrados();

            DAOAluno aluno = new DAOAluno();
            String tabela = "";
            List<Aluno> lista = aluno.listInOrderNome();
            for (Aluno l : lista) {
                tabela += "<tr>"
                        + "<td>" + l.getCpf()+ "</td>"
                        + "<td>" + l.getNome()+ "</td>"
                        + "<td>" + l.getSenha()+ "</td>"
                        + "<td>" + l.getFoto()+ "</td>"
                                    
                        
                    
                        + "<td>" + l.getEstado()+ "</td>"
                        + "</tr>";
            }
            System.out.println(tabela);
            request.getSession().setAttribute("resultado4", tabela);
            response.sendRedirect(request.getContextPath() + "/paginas/tabelaAluno.jsp");

            /*
            String resultado = "";
            if (nomeAluno == null || nomeAluno.equals("")) {
            resultado = listaAlunosCadastrados();
            } else {
            resultado = listaAlunoNome(nomeAluno);
            }
            request.getSession().setAttribute("resultado", resultado);
            response.sendRedirect(request.getContextPath() + "/paginas/tabelaAluno.jsp");
            }*/
        }
    }

    /* 
    protected String listaAlunoNome(String nomeAluno) {
        DAOAluno aluno = new DAOAluno();
        String tabela = "";
        List<Aluno> lista = aluno.listByNome(nomeAluno);
        for (Aluno l : lista) {
            tabela += "<tr>"
                    + "<td>" + l.getSiglaAluno()+ "</td>"
                    + "<td>" + l.getNomeAluno()+ "</td>"
                    + "</tr>";
        }
        System.out.println(tabela);
        
        return tabela;
    }
     */

    protected String listaAlunosCadastrados() {
        DAOAluno aluno = new DAOAluno();
        String tabela = "";
        /*
        List<Aluno> lista = aluno.listInOrderNome();
        for (Aluno l : lista) {
            tabela += "<tr>"
                    + "<td>" + l.getSiglaAluno()+ "</td>"
                    + "<td>" + l.getNomeAluno()+ "</td>"
                    + "</tr>";
        }
         */
        String text = new String();
        String[] aux;
        text = "";
        dados = controle2.listInOrderNome();
        for (Aluno linha : dados) {
            aux = String.valueOf(linha).split("-");
            text
                    += "<tr>"
                    + "<td>" + aux[0] + "</td>"
                    + "<td>" + aux[1] + "</td>"
                    + "<td>" + aux[2] + "</td>"
                    + "<td>" + aux[3] + "</td>"
                    + "<td>" + aux[4] + "</td>"
                   
                    + "<tr>";
        }
        return text;
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
        System.out.println("teste doget");
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
