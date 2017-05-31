package servlet;

import beans.UserAccount;
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
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet(name = "DoBid", urlPatterns = {"/doBid"})
public class DoBid extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn = MyUtils.getStoredConnection(request);
        PreparedStatement pstm = null;
        String errorString = null;
        String succesString = null;
        boolean hasError = false;
        
        String id_produs = request.getParameter("idProdus");
        UserAccount user = MyUtils.getLoginedUser(request.getSession());
        String id_bidder = Integer.toString(user.getId_user());
        int id = 0;
        int pret_minim = 0;
        try{
            pstm = conn.prepareStatement("select id_licitatie, pret_pornire, from manager_licitatii.produse where id_produs = ?");
            pstm.setString(1, id_produs);
            ResultSet rs1 = pstm.executeQuery();
            rs1.next();
            id = rs1.getInt("id_licitatie");
            pret_minim = rs1.getInt("pret_pornire"); 
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        if(user.getAdmin()){
            id_bidder = request.getParameter("idBidder");
        }
        String bid = request.getParameter("bidValue");
        RequestDispatcher dispatcher = null;

//        if( new Integer(pret_minim) > Integer.valueOf(bid)){
//            System.out.println("Mai mare");
//            dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/produseLicitatieView.jsp");
//        }
        
        
        
        String updateSQL = "update manager_licitatii.produse " +
                "set pret_pornire = ?, id_bidder = ?"
                + "where id_produs = ?;";
        try {
            pstm = conn.prepareStatement(updateSQL);

            pstm.setString(1, bid);
            pstm.setString(2, id_bidder);
            pstm.setString(3, id_produs);

            pstm.executeUpdate();
        }
        catch(SQLException e) {
            errorString = "Eroare la adaugarea datelor in baza de date!";
            hasError = true;
            e.printStackTrace();
        }
        
        if(hasError) {
            request.setAttribute("errorString", errorString);
            dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/produseLicitatieView.jsp");
        }
        else {
            succesString = "Adaugare cu succes!";
            request.setAttribute("succesString", succesString);
            dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/produseLicitatieView.jsp");
        }
        

        response.sendRedirect(request.getContextPath() + "/licitatii");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
