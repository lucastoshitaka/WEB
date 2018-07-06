/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAODisciplinas;
import Entidades.Disciplinas;
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
@WebServlet(name = "DisciplinasServlet", urlPatterns = {"/tabelaDisciplinas"})
public class DisciplinasServlet extends HttpServlet {

    Locale ptBr = new Locale("pt", "BR");
    NumberFormat formatoDinheiro = NumberFormat.getCurrencyInstance(ptBr);
    DAODisciplinas controle2 = new DAODisciplinas();
    List<Disciplinas> dados = new ArrayList<>();

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
        String nomeDisciplinas = "";
        nomeDisciplinas = request.getParameter("nomeDisciplinas");
        try (PrintWriter out = response.getWriter()) {

          //  String resultado = listaDisciplinassCadastrados();

            DAODisciplinas estado = new DAODisciplinas();
            String tabela = "";
            List<Disciplinas> lista = estado.listInOrderNome();
            for (Disciplinas l : lista) {
                tabela += "<tr>"
                        + "<td>" + l.getIdDisciplinas()+ "</td>"
                        + "<td>" + l.getNomeDisciplinas() + "</td>"
                        + "</tr>";
            }
            System.out.println(tabela);
            request.getSession().setAttribute("resultado2", tabela);
            response.sendRedirect(request.getContextPath() + "/paginas/tabelaDisciplinas.jsp");

            /*
            String resultado = "";
            if (nomeDisciplinas == null || nomeDisciplinas.equals("")) {
            resultado = listaDisciplinassCadastrados();
            } else {
            resultado = listaDisciplinasNome(nomeDisciplinas);
            }
            request.getSession().setAttribute("resultado", resultado);
            response.sendRedirect(request.getContextPath() + "/paginas/tabelaDisciplinas.jsp");
            }*/
        }
    }

    /* 
    protected String listaDisciplinasNome(String nomeDisciplinas) {
        DAODisciplinas estado = new DAODisciplinas();
        String tabela = "";
        List<Disciplinas> lista = estado.listByNome(nomeDisciplinas);
        for (Disciplinas l : lista) {
            tabela += "<tr>"
                    + "<td>" + l.getSiglaDisciplinas()+ "</td>"
                    + "<td>" + l.getNomeDisciplinas()+ "</td>"
                    + "</tr>";
        }
        System.out.println(tabela);
        
        return tabela;
    }
     */

    protected String listaDisciplinassCadastrados() {
        DAODisciplinas disciplinas
                = new DAODisciplinas();
        String tabela = "";
        /*
        List<Disciplinas> lista = estado.listInOrderNome();
        for (Disciplinas l : lista) {
            tabela += "<tr>"
                    + "<td>" + l.getSiglaDisciplinas()+ "</td>"
                    + "<td>" + l.getNomeDisciplinas()+ "</td>"
                    + "</tr>";
        }
         */
        String text = new String();
        String[] aux;
        text = "";
        dados = controle2.listInOrderNome();
        for (Disciplinas linha : dados) {
            aux = String.valueOf(linha).split("-");
            text
                    += "<tr>"
                    + "<td>" + aux[0] + "</td>"
                    + "<td>" + aux[1] + "</td>"
                   
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
