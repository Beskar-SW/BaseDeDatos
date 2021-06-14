import java.sql.*;
public class App {
    Connection con;
    
    public App(){
        try {
            System.out.println("Conexión a la base de datos");
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/libreria", "root","root");
            
            if(con!=null){
                System.out.println("Conexión de base de datos exitosa");
            }
        
        } catch (SQLException e) {
            System.out.println("Error de conexión a la Base de datos");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (Exception e){
            System.out.print("Se ha encontrado un error: " + e.getMessage());
        }
    }

    public Connection getCon() {
        return con;
    }

    public void Disconnect() {
        con=null;
    }
}
