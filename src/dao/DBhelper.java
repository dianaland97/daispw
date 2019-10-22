package dao;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBhelper {
    private static DBhelper db = null;
    private static Connection con = null;
    private static String driver, dbUri, user, pass;
    //private static final String confile  = "/ISPWB/configuration.txt";

    private DBhelper(){

        driver = "org.postgresql.Driver";
        dbUri = "jdbc:postgresql://localhost:5433/postgres";
        user = "postgres";
        pass = "Diana123";
        /*BufferedReader confreader = null;
        try {
            confreader = new BufferedReader(new FileReader(
                    FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + confile));
            driver = confreader.readLine();
            dbUri = confreader.readLine();
            user = confreader.readLine();
            pass = confreader.readLine();
            confreader.close();
            System.out.println("Configuration retrieve: Success");

        } catch (FileNotFoundException e) {
            System.out.println("Configuration retrieve: Failure");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Configuration retrieve: Failure");
            e.printStackTrace();
        }*/
    }

    public Connection getConnection(){
        try {
            if(con == null) {
                Class.forName(driver);
                con = DriverManager.getConnection(dbUri, user, pass);
            }else{
                return con;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public boolean conClose(){
        try {
            con.close();
            con = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static DBhelper getDBInstance(){
        if(db == null){
            db = new DBhelper();
        }
        return db;
    }

}
