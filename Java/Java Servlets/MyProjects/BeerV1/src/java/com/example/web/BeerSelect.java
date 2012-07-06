package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.BeerExpert;    // model

/**
 * @author dimitri.tiago
 */
public class BeerSelect extends HttpServlet
{
    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        // instantiate the model
        BeerExpert beerExpert = new BeerExpert();
        ArrayList<String> beerAdvice = new ArrayList<String>();

        // obtain beer color and expert advice
        String c = request.getParameter("color");
        beerAdvice = beerExpert.getBrands(c);

        // add exert advice to request object and forward to JSP view
        request.setAttribute("styles", beerAdvice);

        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);

        /*
        // prepare response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("Beer Selection Advice<br>");
        out.println("<br>Fot beer color " + c + "<br>");

        for (String s: beerAdvice)
        {
             out.println("<br>" + s);
        }
        */
    }
}
