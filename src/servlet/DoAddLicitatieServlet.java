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


@WebServlet(name = "DoAddLicitatieServlet", urlPatterns = {"/doAddLicitatie"})
public class DoAddLicitatieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn = MyUtils.getStoredConnection(request);
        PreparedStatement pstm = null;
        String errorString = null;
        String succesString = null;
        boolean hasError = false;

        String min_increment = request.getParameter("min_increment");
        String data_licitatie = request.getParameter("data_licitatie");
        String ora = request.getParameter("ora");
       
        String updateSQL = "insert into manager_licitatii.licitatii " +
                "values(default, ?, ?, ?, default );";
        try {
            pstm = conn.prepareStatement(updateSQL);

            pstm.setString(1, min_increment);
            pstm.setString(2, data_licitatie);
            pstm.setString(3, ora);

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
            
            dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/addLicitatieView.jsp");
        }
        else {
            succesString = "Adaugare cu succes!";
            //trimite si id-ul licitatiei
            request.setAttribute("succesString", succesString);
            dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/addLicitatieView.jsp");
        }

        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
