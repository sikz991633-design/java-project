package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class HostnameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String hostname;

        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            hostname = "Unknown";
        }

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Deployment Status</title></head>");
        out.println("<body style='font-family:Arial;text-align:center;margin-top:60px;'>");
        out.println("<h1 style='color:green;'>Deployment Successful!</h1>");
        out.println("<h2>Application is running successfully.</h2>");
        out.println("<h3>Hostname: " + hostname + "</h3>");
        out.println("</body>");
        out.println("</html>");
    }
}
