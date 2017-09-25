package fr.univ_amu.iut;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by s16011665 on 25/09/17.
 */
public class ConnexionUnique {
    private Connection connection;
    private static ConnexionUnique instance = null;
    private static final String CONNECT_URL = "jdbc:mysql://mysql-kris.alwaysdata.net:3306/kris_tp1";
    private static final String LOGIN = "kris";
    private static final String PASSWORD = "kris";

    private ConnexionUnique() {
        try {
            connection = DriverManager.getConnection(CONNECT_URL,LOGIN,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){return connection;}

    public static ConnexionUnique getInstance(){
        if(instance == null)
            instance = new ConnexionUnique();
        return instance;
    }
}
