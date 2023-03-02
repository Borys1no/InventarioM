package inventariom;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;
/**
 *
 * @author borys
 */
public class Conexion {
    private final String base = "inventory";
    private final String user = "root";
    private final String password = "root";
    private final String url = "jdbc:mysql://localhost:3306/"+base+"?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private Connection con = null;
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=(Connection)DriverManager.getConnection(this.url, this.user, this.password);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }catch (ClassNotFoundException e2){
            System.out.println(e2.getMessage());
        }
        return con;
    }
    
    
}
