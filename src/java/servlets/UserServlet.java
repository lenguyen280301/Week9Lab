/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Wicncjjd
 */
public class UserServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService us= new UserService();
        HttpSession session=request.getSession();
        String action = request.getParameter("action");
        ArrayList<User> users;
        List<User> users;
        try {
            if (action != null && !action.equals("")) {
                String email = request.getParameter("email").replaceAll(" ", "\\+");
                switch (action) {
                    case "edit":
                        User user = us.get(email);
                        session.setAttribute("user", user);
                        break;
                    case "delete":
                        us.delete(email);
                }
                
            } 
            users=us.getAll();
            session.setAttribute("users", users);
        } 
        catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
        }
         
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp" ).forward(request, response); 
       
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
