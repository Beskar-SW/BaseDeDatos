import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LibrosDB {
    Libros libro = new Libros();  
    App con= new App();
    
    public ArrayList buscarLibro(){
        ArrayList list = new ArrayList(5);
        try {
            Statement estatuto = con.getCon().createStatement();
            ResultSet rs = estatuto.executeQuery("Select * from libros");

            while(rs.next()){
                libro.setId(Integer.parseInt(rs.getString("idLibros")));
                libro.setNom(rs.getString("nombre"));
                libro.setEditorial(rs.getString("editorial"));
                libro.setAño(Integer.parseInt(rs.getString("añopub")));
                libro.setFecha(rs.getString("añopub"));
                list.add(libro);
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
