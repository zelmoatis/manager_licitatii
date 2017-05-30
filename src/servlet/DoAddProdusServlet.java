package servlet;

import utils.DBUtils;
import utils.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet(name = "DoAddProdusServlet", urlPatterns = {"/doAddProdus"})
public class DoAddProdusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn = MyUtils.getStoredConnection(request);
        PreparedStatement pstm = null;
        String errorString = null;
        String succesString = null;
        boolean hasError = false;

        String nume = request.getParameter("nume");
        String pret_pornire = request.getParameter("pret_pornire");
        String nume_vanzator = request.getParameter("nume_vanzator");
        String poza = request.getParameter("poza");

        String updateSQL = "insert into manager_licitatii.produse " +
                "values(default, ?, ?, ?, ?);";
        try {
            pstm = conn.prepareStatement(updateSQL);

            pstm.setString(1, nume);
            pstm.setString(2, pret_pornire);
            pstm.setString(3, nume_vanzator);
            pstm.setString(4, poza);

            pstm.executeUpdate();
        }
        catch(SQLException e) {
            errorString = "Eroare la adaugarea datelor in baza de date!";
            hasError = true;
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = null;


        if(hasError) {
            request.setAttribute("errorString", errorString);
            dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/addProdusView.jsp");
        }
        else {
            succesString = "Adaugare cu succes!";
            request.setAttribute("succesString", succesString);
            dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/addProdusView.jsp");
        }

        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
