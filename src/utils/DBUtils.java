package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import beans.Product;
import beans.UserAccount;
 
public class DBUtils {
 
  public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException {
 
      String sql = "Select a.id_user, a.user_name, a.parola, a.Admin from utilizatori a "
              + " where a.user_name = ? and a.parola= ?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, userName);
      pstm.setString(2, password);
      ResultSet rs = pstm.executeQuery();
 
      if (rs.next()) {
        
          UserAccount user = new UserAccount();
          user.setUser_name(userName);
          user.setParola(password);
          user.setId_user(rs.getInt("id_user"));
          user.setAdmin(rs.getBoolean("admin"));
         
        
          return user;
      }
      return null;
  }
 
  public static UserAccount findUser(Connection conn, String userName) throws SQLException {
 
      String sql = "Select a.id_user, a.user_name, a.parola, a.Admin from utilizatori a " + " where a.id_user = ? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, userName);
 
      ResultSet rs = pstm.executeQuery();
 
      if (rs.next()) {
          String password = rs.getString("parola");
          
          UserAccount user = new UserAccount();
          user.setUser_name(userName);
          user.setParola(password);
          user.setId_user(rs.getInt("id_user"));
          user.setAdmin(rs.getBoolean("admin"));
         
          return user;
      }
      return null;
  }
 
  public static List<Product> queryProduct(Connection conn) throws SQLException {
      String sql = "Select a.id_produs, a.nume, a.pret_pornire, a.nume_vanzator, a.poza,a.id_licitatie, a.id_bidder from produse a ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      ResultSet rs = pstm.executeQuery();
      List<Product> list = new ArrayList<Product>();
      while (rs.next()) {
          String id_produs = rs.getString("id_produs");
          String nume = rs.getString("nume");
          int pret_pornire = rs.getInt("pret_pornire");
          String nume_vanzator = rs.getString("nume_vanzator");
          String poza = rs.getString("poza");
          int id_licitatie = rs.getInt("id_licitatie");
          int id_bidder = rs.getInt("id_bidder");
          
          
          Product product = new Product();
          product.setId_produs(pret_pornire);
          product.setNume(nume);
          product.setPret_pornire(pret_pornire);
          product.setNume_vanzator(nume_vanzator);
          product.setPoza(poza);
          product.setId_licitatie(id_licitatie);
          product.setId_licitatie(id_licitatie);
          list.add(product);
      }
      return list;
  }
 
  public static Product findProduct(Connection conn, String code) throws SQLException {
      String sql = "Select a.id_produs, a.nume, a.pret_pornire, a.nume_vanzator, a.poza,a.id_licitatie, a.id_bidder from produse a ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setString(1, code);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
          String nume = rs.getString("nume");
          int pret_pornire = rs.getInt("pret_pornire");
          String nume_vanzator = rs.getString("nume_vanzare");
          String poza = rs.getString("poza");
          int id_licitatie = rs.getInt("id_licitatie");
          int id_bidder = rs.getInt("id_bidder");
          Product product = new Product(Integer.parseInt(code), nume, pret_pornire, nume_vanzator, poza,id_licitatie);
          return product;
      }
      return null;
  }
 
  public static void updateProduct(Connection conn, Product product) throws SQLException {
      String sql = "Update Product set nume =?, pret_pornire =?, nume_vanzator =?, poza =?, id_licitatie =?, id_bidder =? where id_produs=? ";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, product.getNume());
      pstm.setInt(2, product.getPret_pornire());
      pstm.setString(3, product.getNume_vanzator());
      pstm.setString(4, product.getPoza());
      pstm.setInt(5, product.getId_produs());
      pstm.setInt(6, product.getId_licitatie());
      pstm.setInt(7, product.getId_bidder());
      pstm.executeUpdate();
  }
 
  public static void insertProduct(Connection conn, Product product) throws SQLException {
      String sql = "Insert into Product(id_produs, nume, pret_pornire, nume_vanzator, poza, id_licitatie, id_bidder) values (?,?,?,?,?)";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setInt(1, product.getId_produs());
      pstm.setString(2, product.getNume());
      pstm.setInt(3, product.getPret_pornire());
      pstm.setString(4, product.getNume_vanzator());
      pstm.setString(5, product.getPoza());
      pstm.setInt(6, product.getId_licitatie());
      pstm.setInt(7, product.getId_bidder());
 
      pstm.executeUpdate();
  }
 
  public static void deleteProduct(Connection conn, String code) throws SQLException {
      String sql = "Delete Product where id_produs= ?";
 
      PreparedStatement pstm = conn.prepareStatement(sql);
 
      pstm.setString(1, code);
 
      pstm.executeUpdate();
  }
 
}