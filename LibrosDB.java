import java.sql.*;
import javax.swing.JOptionPane;

public class LibrosDB {
    Libros libro = new Libros();  
    App con= new App();
    
    public String[][] buscarLibro(){
        String[][] list = new String[(5)][];
        try {
            Statement estatuto = con.getCon().createStatement();
            ResultSet rs = estatuto.executeQuery("Select * from libros");

            while(rs.next()){
                libro.setId(rs.getString("idLibros"));
                libro.setNom(rs.getString("nombre"));
                libro.setEditorial(rs.getString("editorial"));
                libro.setEdicion(rs.getString("edicion"));
                libro.setFecha(rs.getString("añopub"));
                
            }
            rs.close();
            estatuto.close();
            con.Disconnect();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

}
