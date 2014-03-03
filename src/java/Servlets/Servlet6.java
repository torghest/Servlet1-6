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
@WebServlet(urlPatterns = {"/Servlet6"})
public class Servlet6 extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccesoJDBC jdbc = new AccesoJDBC();
        String[] res = jdbc.selPorOficio(request.getQueryString());
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet6</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet6 at " + request.getContextPath() + "</h1>");
            for (int i = 0; i < res.length; i++){
                out.println(i+1+".//"+res[i]);
                out.println("<br/>");
            }
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}
