package org.algoplex.personne;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {

    private String url;
    private String user;
    private String pass;

    public DAOFactory(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }
    public static DAOFactory getInstance() {
        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DAOFactory instance= new DAOFactory("jdbc:postgresql://localhost:5432/utilisateurs_nom","postgres","root");
        return instance;
    }

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,pass);
    }
    public UtilisateurDAO getUtilisateurDao(){
        return new UtilisateurDAOlmp(this);
    }
}