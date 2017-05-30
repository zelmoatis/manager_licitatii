package beans;

public class UserAccount {
	 
   private int id_user;
   private String user_name;
   private String parola;
   private Boolean admin = false;

    public UserAccount() {
    }

    public UserAccount(int id_user, String user_name, String parola) {
        this.id_user = id_user;
        this.user_name = user_name;
        this.parola = parola;
    }

    public int getId_user() {
        return id_user;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getParola() {
        return parola;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
   
  
 
   
	 
}
