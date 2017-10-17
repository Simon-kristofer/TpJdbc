package fr.univ_amu.iut;

import fr.univ_amu.iut.DAO.DAO;
import fr.univ_amu.iut.DAO.DAOEtudiant;
import fr.univ_amu.iut.DAO.JDBC.DAOEtudiantJDBC;
import fr.univ_amu.iut.beans.Etudiant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by s16011665 on 16/10/17.
 */
public class TestDAOEtudiant {


    public static void main(String[] args) throws SQLException {
        DAO<Etudiant> etudiantDAO=new DAOEtudiantJDBC();
        ArrayList<Etudiant> et = new ArrayList<Etudiant>();

        et.addAll(etudiantDAO.FindAll());





        // Connexion a la base
       /* System.out.println("Connexion");
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);

            // Affichage du resultat
            ArrayList<Etudiant> et = new ArrayList<Etudiant>();
            while (rset.next()){
                Etudiant etudiant= new Etudiant();
                creerEtudiant(rset, etudiant);
                et.add(etudiant);
                System.out.print(etudiant);
            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }*/
    }


    private static void creerEtudiant(ResultSet rset, Etudiant etudiant) throws SQLException {
        etudiant.setNumEt(rset.getInt("NUM_ET") );
        etudiant.setNomEt(rset.getString("NOM_ET"));
        etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
        etudiant.setAnnee(rset.getInt("ANNEE"));
        etudiant.setVilleEt(rset.getString("VILLE_ET"));
        etudiant.setCpEt(rset.getString("CP_ET"));
        etudiant.setGroupe(rset.getInt("GROUPE"));
    }

    public int computeNbEtudiant() {
        String req ="SELECT COUNT(*) FROM ETUDIANT";
        try (Connection conn = ConnexionUnique.getInstance().getConnection()) {
            Statement stmt=conn.createStatement();
            ResultSet rset=stmt.executeQuery(req);
            return rset.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }



}
