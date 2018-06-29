/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOEstado;
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
import javax.swing.JTextArea;

/**
 *
 * @author Jaque
 */
@WebServlet(name = "EstadoServlet", urlPatterns = {"/tabelaEstado"})
public class EstadoServlet extends HttpServlet {

    Locale ptBr = new Locale("pt", "BR");
    NumberFormat formatoDinheiro = NumberFormat.getCurrencyInstance(ptBr);
    DAOEstado controle = new DAOEstado();
    List<Estado> dados = new ArrayList<>();

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
        String nomeEstado = "";
        nomeEstado = request.getParameter("nomeEstado");
        try (PrintWriter out = response.getWriter()) {

          //  String resultado = listaEstadosCadastrados();

            DAOEstado estado = new DAOEstado();
            String tabela = "";
            List<Estado> lista = estado.listInOrderNome();
            for (Estado l : lista) {
                tabela += "<tr>"
                        + "<td>" + l.getSiglaEstado() + "</td>"
                        + "<td>" + l.getNomeEstado() + "</td>"
                        + "</tr>";
            }
            System.out.println(tabela);
            request.getSession().setAttribute("resultado", tabela);
            response.sendRedirect(request.getContextPath() + "/paginas/tabelaEstado.jsp");

            /*
            String resultado = "";
            if (nomeEstado == null || nomeEstado.equals("")) {
            resultado = listaEstadosCadastrados();
            } else {
            resultado = listaEstadoNome(nomeEstado);
            }
            request.getSession().setAttribute("resultado", resultado);
            response.sendRedirect(request.getContextPath() + "/paginas/tabelaEstado.jsp");
            }*/
        }
    }

    /* 
    protected String listaEstadoNome(String nomeEstado) {
        DAOEstado estado = new DAOEstado();
        String tabela = "";
        List<Estado> lista = estado.listByNome(nomeEstado);
        for (Estado l : lista) {
            tabela += "<tr>"
                    + "<td>" + l.getSiglaEstado()+ "</td>"
                    + "<td>" + l.getNomeEstado()+ "</td>"
                    + "</tr>";
        }
        System.out.println(tabela);
        
        return tabela;
    }
     */

    protected String listaEstadosCadastrados() {
        DAOEstado estado = new DAOEstado();
        String tabela = "";
        /*
        List<Estado> lista = estado.listInOrderNome();
        for (Estado l : lista) {
            tabela += "<tr>"
                    + "<td>" + l.getSiglaEstado()+ "</td>"
                    + "<td>" + l.getNomeEstado()+ "</td>"
                    + "</tr>";
        }
         */
        String text = new String();
        String[] aux;
        text = "";
        dados = controle.listInOrderNome();
        for (Estado linha : dados) {
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
