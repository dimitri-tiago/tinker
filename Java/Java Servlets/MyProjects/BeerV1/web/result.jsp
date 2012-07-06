<%@ page import="java.util.ArrayList" %>

<html>
    <head>
        <title>Beer Recommendations JSP</title>
    </head>
    <body>
        <h1 align="center">Beer Recommendations JSP</h1>
        <p></p>

        <%
            ArrayList<String> styles = (ArrayList<String>) request.getAttribute("styles");
            String adminEmail = getServletContext().getInitParameter("adminEmail");
            String mainEmail = getServletContext().getInitParameter("mainEmail");

            for (String s : styles)
            {
                out.print("<br>try: " + s);
            }

            out.print("<br>Admin Email: " + adminEmail);
            out.print("<br>Main Email: " + mainEmail);
        %>
    </body>
</html>
