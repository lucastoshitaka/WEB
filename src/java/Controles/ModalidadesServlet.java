/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOModalidades;
import Entidades.Modalidades;
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
@WebServlet(name = "ServletListaModalidades", urlPatterns = {"/tabelaModalidades"})
public class ModalidadesServlet extends HttpServlet {

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
        String listaModalidades = "";

        try (PrintWriter out = response.getWriter()) {
            listaModalidades = request.getParameter("Modalidades");

            String resultado = "";
            if (listaModalidades == null || listaModalidades.equals("")) {
                resultado = listaModalidadessCadastrados();
            } else {
                resultado = listaModalidadesNome(listaModalidades);
            }
            request.getSession().setAttribute("resultado3", resultado);
            response.sendRedirect(request.getContextPath() + "/paginas/tabelaModalidades.jsp");
        }
    }

    protected String listaModalidadesNome(String listaModalidades) {
        DAOModalidades aluno = new DAOModalidades();
        String tabela = "";
        List<Modalidades> lista = aluno.listByNome(listaModalidades);
        for (Modalidades l : lista) {
            tabela += "<tr>"
                    + "<td>" + l.getIdModalidades()+ "</td>"
                    + "<td>" + l.getNomeModalidades()+ "</td>"
                    
                    + "</tr>";
        }
        return tabela;
    }

    protected String listaModalidadessCadastrados() {
        DAOModalidades aluno = new DAOModalidades();
        String tabela = "";
        List<Modalidades> lista = aluno.listInOrderNome();
        for (Modalidades l : lista) {
            tabela += "<tr>"
                    + "<td>" + l.getIdModalidades()+ "</td>"
                    + "<td>" + l.getNomeModalidades()+ "</td>"
                    
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
            Logger.getLogger(ModalidadesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
      
           
        
    }

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
            Logger.getLogger(ModalidadesServlet.class.getName()).log(Level.SEVERE, null, ex);
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
