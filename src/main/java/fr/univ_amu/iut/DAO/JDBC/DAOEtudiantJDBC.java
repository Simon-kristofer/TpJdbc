package fr.univ_amu.iut.DAO.JDBC;

import fr.univ_amu.iut.ConnexionUnique;
import fr.univ_amu.iut.DAO.DAOEtudiant;
import fr.univ_amu.iut.beans.Etudiant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOEtudiantJDBC implements DAOEtudiant {
    @Override
    public int computeNbEtudiant() {
        return 0;
    }

    @Override
    public List<Etudiant> findByAnnee(int annee) {
        String req = "SELECT* FROM ETUDIANT WHERE ANNEE_ET="+annee;
        try (Connection conn = ConnexionUnique.getInstance().getConnection()) {
            Statement stmt=conn.createStatement();
            ResultSet rset=stmt.executeQuery(req);
            List<Etudiant>etudiants=new ArrayList<>();
            while (rset.next()){
                Etudiant etudiant =new Etudiant();
                etudiant.setNomEt(rset.getNString("NOM_ET"));
                etudiant.setNumEt(rset.getInt("NUM_ET"));
                etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
                etudiants.add(etudiant);
            }return etudiants;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Etudiant> findByGroupe(int groupe) {
        String req = "SELECT* FROM ETUDIANT WHERE GROUPE";
        try (Connection conn = ConnexionUnique.getInstance().getConnection()) {
            Statement stmt=conn.createStatement();
            ResultSet rset=stmt.executeQuery(req);
            List<Etudiant>etudiants=new ArrayList<>();
            while (rset.next()){
                Etudiant etudiant =new Etudiant();
                etudiant.setNomEt(rset.getNString("NOM_ET"));
                etudiant.setNumEt(rset.getInt("NUM_ET"));
                etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
                etudiants.add(etudiant);
            }return etudiants;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Etudiant> findByNom(String nomEt) {
        String req = "SELECT* FROM ETUDIANT WHERE NOM_ET";
        try (Connection conn = ConnexionUnique.getInstance().getConnection()) {
            Statement stmt=conn.createStatement();
            ResultSet rset=stmt.executeQuery(req);
            List<Etudiant>etudiants=new ArrayList<>();
            while (rset.next()){
                Etudiant etudiant =new Etudiant();
                etudiant.setNomEt(rset.getNString("NOM_ET"));
                etudiant.setNumEt(rset.getInt("NUM_ET"));
                etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
                etudiants.add(etudiant);
            }return etudiants;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(Etudiant obj) {
        String req ="DELETE FROM ETUDIANT WHERE NUM_ET"+obj.getNumEt();
        try (Connection conn = ConnexionUnique.getInstance().getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(req);
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
        } return false;

    }

    @Override
    public List<Etudiant> FindAll() {
        String req = "SELECT* FROM ETUDIANT";
        try (Connection conn = ConnexionUnique.getInstance().getConnection()) {
            Statement stmt=conn.createStatement();
            ResultSet rset=stmt.executeQuery(req);
            List<Etudiant>etudiants=new ArrayList<>();
            while (rset.next()){
                Etudiant etudiant =new Etudiant();
                etudiant.setNomEt(rset.getNString("NOM_ET"));
                etudiant.setNumEt(rset.getInt("NUM_ET"));
                etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
                etudiants.add(etudiant);
            }return etudiants;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Etudiant getById(int id) {
        String req ="SELECT* FROM ETUDIANT WHERE NUM_ET="+id;
        try (Connection conn = ConnexionUnique.getInstance().getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(req);
            Etudiant etudiant =new Etudiant();
            etudiant.setNomEt(rset.getNString("NOM_ET"));
            etudiant.setNumEt(rset.getInt("NUM_ET"));
            etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
            return etudiant;
        }catch (SQLException e) {
            e.printStackTrace();
        } return null;

    }

    @Override
    public Etudiant insert(Etudiant obj) {
        String req ="INSERT INTO ETUDIANT(NOM_ET,NUM_ET,PRENOM_ET) VALUE("+obj.getNomEt()+","+obj.getNumEt()+","+obj.getPrenomEt()+")";
        try (Connection conn = ConnexionUnique.getInstance().getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(req);
            Etudiant etudiant =new Etudiant();
            etudiant.setNomEt(rset.getNString("NOM_ET"));
            etudiant.setNumEt(rset.getInt("NUM_ET"));
            etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
            return etudiant;
        }catch (SQLException e) {
            e.printStackTrace();
        } return null;

    }

    @Override
    public boolean update(Etudiant obj) {

        String req ="UPDATE ETUDIANT SET NUM_ET="+obj.getNumEt()+"PRENOM_ET="+obj.getPrenomEt()+"NOM_ET"+obj.getNomEt();
        try (Connection conn = ConnexionUnique.getInstance().getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(req);
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
        } return false;
    }
}
