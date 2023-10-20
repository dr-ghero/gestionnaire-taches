package org.algoplex.personne;
import java.util.List;

public interface UtilisateurDAO {
     List<Utilisateurs> afficheUtilisateurs();
     void ajouteUtilisateur(Utilisateurs utilisateurs);
}
