package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dimitri.tiago
 */
public class ListenerTester extends HttpServlet
{   
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        // obtain servlet context init parameters
        Dog dog = (Dog) getServletContext().getAttribute("dog");

        // prepare response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("Dog breed:<br>");
        out.println(dog.getBreed());
    } 
}