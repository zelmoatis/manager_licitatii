package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import beans.UserAccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.MyUtils;
 
@WebServlet(urlPatterns = { "/licitatii" })
public class ShowLicitatii extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public ShowLicitatii() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        UserAccount loginedUser = MyUtils.getLoginedUser(session);
	   
        if (loginedUser == null) {
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/homeView.jsp");

            dispatcher.forward(request, response);
        }

        request.setAttribute("user", loginedUser);


        Connection conn = MyUtils.getStoredConnection(request);
        PreparedStatement pstm;
        String getPar = request.getParameter("id");
        if(getPar == null) {
            String querySQL = "select l.id_licitatie, l.min_increment,l.data_licitatie,l.ora from manager_licitatii.licitatii l where l.data_licitatie < curdate()";       
            ResultSet rs = null;
            try {
                pstm = conn.prepareStatement(querySQL);
                rs = pstm.executeQuery();
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
            session.setAttribute("results", rs);
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/showLicitatiiView.jsp");
            dispatcher.forward(request, response);
        }else{
            String querySQL = "select * from manager_licitatii.produse where id_licitatie = ?";       
            ResultSet rs = null;
            try {
                pstm = conn.prepareStatement(querySQL);
                pstm.setString(1, getPar);
                rs = pstm.executeQuery();
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
            querySQL = "select min_increment from manager_licitatii.licitatii where id_licitatie = ?";
            ResultSet rsaux = null;
            int minincrement = 0;
            try {
                pstm = conn.prepareStatement(querySQL);
                pstm.setString(1, getPar);
                rsaux = pstm.executeQuery();
                while(rsaux.next()){
                    minincrement = rsaux.getInt("min_increment");
                }
                rsaux.close();
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("min", minincrement);
            session.setAttribute("prodResults", rs);
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/produseLicitatieView.jsp");
            dispatcher.forward(request, response);
        }
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}