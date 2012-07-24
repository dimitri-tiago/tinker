/*
 * myTasks
 * July 24 2012
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TaskManager;

/**
 *
 * @author dimitri.tiago
 */
public class TaskController extends HttpServlet 
{
    @Override
    public void init()
    {
       TaskManager taskManager = new TaskManager();
       getServletContext().setAttribute("taskManager", taskManager);
    }
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        TaskManager taskManager = (TaskManager) getServletContext().getAttribute("taskManager");
        String operation = (String) request.getParameter("submit");

        if (operation.equals("Add Task List"))
        {
            // add task list to master list
            String listName         = (String) request.getParameter("listName");
            String listDescription  = (String) request.getParameter("listDescription");
            
            taskManager.addList(listName, listDescription);
        }
        else if (operation.equals("Add Task"))
        {
            // add task to list
            String taskName         = (String) request.getParameter("taskName");
            String taskDescription  = (String) request.getParameter("taskDescription");
            String taskList         = (String) request.getParameter("taskList");
            
            taskManager.addTask(taskName, taskDescription, taskList.equals("") ? "master" : taskList);
        }

        // prepare response object
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TaskController</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Servlet TaskController at " + request.getContextPath() + "</h1>");
            
            out.println("</body>");
            out.println("</html>");
        } 
        finally 
        {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
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
