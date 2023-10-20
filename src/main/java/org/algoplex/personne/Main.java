package org.algoplex.personne;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args){
        DAOFactory daoFactory= DAOFactory.getInstance();
        UtilisateurDAO utilisateurDao=daoFactory.getUtilisateurDao();
        List<Utilisateurs> list=utilisateurDao.afficheUtilisateurs();

        for (Utilisateurs utilisateurs : list) {
            System.out.println(utilisateurs.getPrenom()+" "+utilisateurs.getNom());
        }
        Utilisateurs utilisateurs =new Utilisateurs();
        utilisateurs.setNom("MBAZOUA");
        utilisateurs.setPrenom("Marie");
        utilisateurDao.ajouteUtilisateur(utilisateurs);

            //System.out.println(utilisateurs.getPrenom()+" "+utilisateurs.getNom());

    }


}
