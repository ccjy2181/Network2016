/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acidrain;

/**
 *
 * @author Administrator
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
   private static final String DB_DRIVER = "oracle.jdbc.OracleDriver";
   private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:orcl";
   private static final String DB_USER = "scott";
   private static final String DB_PASSWORD = "root";

   public static void main(String[] argv) {
      try {
         createDbUserTable();
      } catch (SQLException e) {
         System.out.println(e.getMessage());
      }
   }

   private static void createDbUserTable() throws SQLException {
      Connection dbConnection = null;
      Statement statement = null;
      StringBuffer strSQL = new StringBuffer();

      strSQL.append(" CREATE TABLE MEMBERLIST(                                    \n");
      strSQL.append(" ID     VARCHAR2(20),                                           \n");
      strSQL.append(" PWD      VARCHAR2(20),                                     \n");
      strSQL.append(" GENDER   VARCHAR2(10),                                     \n");
      strSQL.append(" BIRTH   VARCHAR2(20),                                     \n");
      strSQL.append(" MARRY   VARCHAR2(10),                                     \n");
      strSQL.append(" NAME   VARCHAR2(20),                                           \n");
      strSQL.append(" HOME   VARCHAR2(20),                                           \n");
      strSQL.append(" PHONE   VARCHAR2(20),                                           \n");
      strSQL.append(" EMAIL   VARCHAR2(30),                                           \n");
      strSQL.append(" ACCOUNT   NUMBER,                                           \n");
      strSQL.append(" CUSNUM   NUMBER,                                           \n");
      strSQL.append(" DEPTNO   NUMBER)                                           \n");

      try {
         dbConnection = getDBConnection();
         statement = dbConnection.createStatement();
         System.out.println(strSQL.toString());
         statement.execute(strSQL.toString());
         System.out.println("MEMLIST 테이블 생성 완료!");
      } catch (SQLException e) {
         System.out.println(e.getMessage());
      } finally {
         if (statement != null) {
            statement.close();
         }
         if (dbConnection != null) {
            dbConnection.close();
         }
      }
   }

   private static Connection getDBConnection() {
      Connection dbConnection = null;
      try {
         Class.forName(DB_DRIVER);
      } catch (ClassNotFoundException e) {
         System.out.println(e.getMessage());
      }

      try {
         dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
         return dbConnection;
      } catch (SQLException e) {
         System.out.println(e.getMessage());
      }
      return dbConnection;
   }
}