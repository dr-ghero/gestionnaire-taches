package org.algoplex.personne;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDAOlmp implements UtilisateurDAO{
    private DAOFactory daoFactory;

    public UtilisateurDAOlmp(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public List<Utilisateurs> afficheUtilisateurs() {
        List<Utilisateurs>listeDesUtilisateurs=new ArrayList<>();
        Connection connection=null;
        Statement satement;
        ResultSet resultSet;
        String query="SELECT * FROM organisation.personnes";
        try{
            connection=daoFactory.getConnection();
            satement= connection.createStatement();
            resultSet=satement.executeQuery(query);
            while (resultSet.next()){
                Utilisateurs utilisateurs=new Utilisateurs();
                utilisateurs.setNom(resultSet.getString("nom"));
                utilisateurs.setPrenom(resultSet.getString("prenom"));
                listeDesUtilisateurs.add(utilisateurs);
            }
        }catch(SQLException e){e.printStackTrace();}

        return listeDesUtilisateurs;
    }

    @Override
    public void ajouteUtilisateur(Utilisateurs utilisateurs) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String qury="INSERT INTO organisation.personnes VALUES(?,?)";

        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement(qury);
            preparedStatement.setString(1,utilisateurs.getNom());
            preparedStatement.setString(2,utilisateurs.getPrenom());
            preparedStatement.executeUpdate();
        }catch (SQLException e){e.printStackTrace();}
    }
}
