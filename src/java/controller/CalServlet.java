/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class CalServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        double num1 = Double.parseDouble(request.getParameter("num1"));
        double num2 = Double.parseDouble(request.getParameter("num2"));
        String operator = request.getParameter("compute");
        if (operator.equals("add")) {
            out.println(num1 + num2);
        } else if (operator.equals("subtract")) {
            out.println(num1 - num2);
        } else if (operator.equals("multiply")) {
            out.println(num1 * num2);
        } else if (operator.equals("divide")) {
            out.println(num1 / num2);
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
        String txt1 = request.getParameter("num1");
        String txt2 = request.getParameter("num2");
        int num1, num2, result = 0;
        try {
            num1 = Integer.parseInt(txt1);
            try {
                num2 = Integer.parseInt(txt2);
                if (num2 != 0) {
                    String operation = request.getParameter("operation");

                    switch (operation) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "x":
                            result = num1 * num2;
                            break;
                        case ":":
                            if (num2 == 0) {

                            } else {
                                result = num1 / num2;
                            }
                            break;
                    }
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet NewServlet</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<form name=\"input\">\n"
                            + "            <table>\n"
                            + "                <tr>\n"
                            + "                    <td>First:</td><td><text type=\"text\"/>" + num1 + "</td>\n"
                            + "                </tr>\n"
                            + "                <tr>\n"
                            + "                    <td>Second:</td><td><text type=\"text\" name=\"num2\"/>" + num2 + "</td>\n"
                            + "                </tr>\n"
                            + "                <tr>\n"
                            + "                    <td>Operator:</td><td> <select name=\"operation\">\n"
                            + "                            <option>+</option>\n"
                            + "                            <option>-</option>\n"
                            + "                            <option>x</option>\n"
                            + "                            <option>:</option>\n"
                            + "                        </select></td>\n"
                            + "                </tr>\n"
                            + "                <tr>\n"
                            + "                    <td></td><td><input type=\"submit\" value=\"Compute\"/></td>\n"
                            + "                </tr>\n"
                            + "                <tr>\n"
                            + "                    <td>Result:</td><td><text type=\"text\" name=\"result\"/>" + result + "</td>\n"
                            + "                </tr>\n"
                            + "            </table>\n"
                            + "        </form>");
                    out.println("</body>");
                    out.println("</html>");
                } else {

                }

            } catch (NumberFormatException e) {

            }
        } catch (NumberFormatException e) {

        }
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
