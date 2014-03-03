package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import JDBC.AccesoJDBC;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
@WebServlet(urlPatterns = {"/Servlet5"})
public class Servlet5 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccesoJDBC jdbc = new AccesoJDBC();
        String nom = request.getParameter("nombre").trim();
        String ap1 = request.getParameter("apellido1").trim();
        String ap2 = request.getParameter("apellido2").trim();
        String dir = request.getParameter("direccion").trim();
        String prov = request.getParameter("provincia").trim();
        String sexo = request.getParameter("sexo").trim();
        String[] sisAux = request.getParameterValues("sistema");
        String com = request.getParameter("comentario").trim();
        String sis = "";
        if (sisAux != null){
            for (int i = 0; i < sisAux.length; i++){
                sis += sisAux[i];
            }
        }
        int res = jdbc.altaCliente(nom, ap1, ap2, dir, prov, sexo, sis, com);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet5</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet5 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}
