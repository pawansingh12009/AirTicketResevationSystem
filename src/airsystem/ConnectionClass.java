/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author admin
 */
class ConnectionClass {
public static Connection connect() throws Exception
{  
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection con =DriverManager.getConnection("jdbc:oracle:thin:@User-PC:1521:xe","system","system");
         return con;
}
  
    }
