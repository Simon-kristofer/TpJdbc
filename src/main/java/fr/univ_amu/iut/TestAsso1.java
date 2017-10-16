package fr.univ_amu.iut;

import fr.univ_amu.iut.beans.Etudiant;
import fr.univ_amu.iut.beans.Module;
import fr.univ_amu.iut.beans.Prof;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by s16011665 on 25/09/17.
 */
public class TestAsso1 {

    // La requete de test
    static final String reqProfs = "SELECT * " +
            "FROM PROF";

    static final String reqModule = "SELECT * " +
            "FROM MODULE WHERE CODE=?" ;

    public static void main(String[] args) throws SQLException {
        // Connexion a la base
        System.out.println("Connexion");
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + reqProfs);
            ResultSet rset = stmt.executeQuery(reqProfs);
            ArrayList<Prof> myList = new ArrayList<>();
            while (rset.next()){
                Prof p = new Prof();
                p.setNumProf(rset.getInt("NUM_PROF"));
                p.setNomProf(rset.getString("NOM_PROF"));
                p.setPrenomProf(rset.getString("PRENOM_PROF"));
                Module spec = new Module();
                spec.setCode(rset.getString("MAT_SPEC"));
                p.setMatSpec(spec);
                myList.add(p);
            }
            for (int i = 0 ; i != myList.size() ; ++i)
                System.out.println(myList.get(i).toString());
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
    }

 /*   private static Prof creerProf(ResultSet rset) throws SQLException {
        Prof prof = new Prof();
        prof.setNumProf(rset.getInt("NUM_PROF") );
        prof.setNomProf(rset.getString("NOM_PROF"));
        prof.setPrenomProf(rset.getString("PRENOM_PROF"));
        prof.setVilleProf(rset.getString("VILLE_PROF"));
        prof.setCpProf(rset.getString("CP_PROF"));
        prof.setMatSpec(creerModule(rset.getString("MAT_SPEC")));
        return prof;
    }

    private static Module creerModule(String code) throws SQLException {
        Connection conn = ConnexionUnique.getInstance().getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(reqModule);
        preparedStatement.setString(1,code);
        ResultSet resultSet = preparedStatement.executeQuery();
        return creerModule(resultSet);
    }

    private static Module creerModule(ResultSet rset) throws SQLException {
        Module module = new Module();
        module.setCode(rset.getString("CODE"));
        module.setLibelle(rset.getString("LIBELLE"));
        module.sethCoursPrev(rset.getInt("HCOURSPREV"));
        module.sethCoursRea(rset.getInt("HCOURSREA"));
        module.sethCoursRea(rset.getInt("COURSREA"));
        module.sethCoursPrev(rset.getInt("COURSPREV"));
        module.setCoefCc(rset.getInt("COEFCC"));
        module.setCoefCc(rset.getInt("COEFTEST"));


        return module;
    }*/
}
