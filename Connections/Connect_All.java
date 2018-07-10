package Connections;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import sqlv1.pkg4.GUI;

public class Connect_All {


        Connection CONNECT;
 
        private String USER_NAME = "admin";
        private String USER_PASS = "admin1";
        private String USER_PASS_FREE;
        private String USER_NAME_FREE;
        private String URL;

        public Connect_All(String URL){
            this.URL = URL;
        }
        
        public Connect_All(String URL, String USER_NAME_FREE, String USER_PASS_FREE){
            this.URL = URL;
            this.USER_NAME_FREE = USER_NAME_FREE;
            this.USER_PASS_FREE = USER_PASS_FREE;
        }
        
        public  void connectOnFree(){
         //   if(CONNECT == null){

                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    CONNECT = DriverManager.getConnection(URL,USER_NAME_FREE,USER_PASS_FREE);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);// Logger.getLogger(Connections.Connect_All.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                
                GUI.putLog("Соединение с БД установлено" + "\n");
                
         //   }
        }
        
        public  void connectOn(){
         //   if(CONNECT == null){

                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    CONNECT = DriverManager.getConnection(URL,USER_NAME,USER_PASS);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);// Logger.getLogger(Connections.Connect_All.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                
                GUI.putLog("Соединение с БД установлено" + "\n");
                
         //   }
        }
        
        public void connectOff(){
            try {
                CONNECT.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(Connections.Connect_All.class.getName()).log(Level.SEVERE, null, ex);
            }
             finally{
                    if (CONNECT != null) try { CONNECT.close(); } catch(Exception e) {}  
                }
            GUI.putLog("Соединение с БД закрыто" + "\n");
        }

        public ResultSet query(String query){
            ResultSet RESULT = null;
            try {
                Statement stmt = CONNECT.createStatement();
                RESULT = stmt.executeQuery(query);
            } catch (SQLException ex) {
                Logger.getLogger(Connections.Connect_All.class.getName()).log(Level.SEVERE, null, ex);

            }
            return RESULT;

        }

    }
