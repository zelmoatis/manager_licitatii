package servlet;

import beans.UserAccount;
import utils.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by bujor on 30.05.2017.
 */
@WebServlet(name = "AddProdusServlet", urlPatterns = {"/addProdus"})
public class AddProdusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();


        UserAccount loginedUser = MyUtils.getLoginedUser(session);


        if (loginedUser == null) {

            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        request.setAttribute("user", loginedUser);

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/addProdusView.jsp");

        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
