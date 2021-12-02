/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.AccountService;

/**
 *
 * @author david
 */
@WebServlet(name = "ResetPasswordServlet", urlPatterns = {"/reset"})
public class ResetPasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = req.getParameter("uuid");
        AccountService as = new AccountService();
        if (uuid == null) {
            String url = req.getRequestURL().toString();
            String email = req.getParameter("email");
            String path = getServletContext().getRealPath("/WEB-INF");
            as.resetPassword(email, path, url);
            resp.sendRedirect("reset");
        } else {
           String password = req.getParameter("password");
           if (as.changePassword(uuid, password)) {
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
           } else {
               getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
           }

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uuid = req.getParameter("uuid");
        if (uuid != null) {

            req.setAttribute("uuid", uuid);
            getServletContext().getRequestDispatcher("/WEB-INF/resetNewPassword.jsp").forward(req, resp);
        }

        getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(req, resp);
    }

}
