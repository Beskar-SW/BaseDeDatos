import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class ListarLibro {
    String nom,Editorial,Fecha,edicion;
    DefaultTableModel model;
    ListarLibro(String nom, String Editorial, String Fecha, String edicion,DefaultTableModel model){
        App con= new App();
        this.model=model;
        this.nom=nom;
        this.Editorial=Editorial;
        this.Fecha=Fecha;
        this.edicion=edicion;
        model.setRowCount(0);
        if (edicion != null && nom != null && Editorial != null && Fecha != null && edicion != null) {
            try {
                Statement estatuto = con.getCon().createStatement();
                ResultSet rs = estatuto.executeQuery("Select * from libros where nombre='"+nom+"' AND editorial='"+Editorial+"' AND añopub='"+Fecha+"' AND edicion='"+edicion+"' ");
                while (rs.next()) {
                 Object[] row = new Object[5];
                 for (int i = 0; i < row.length; i++) {
                    row[i]=rs.getString(i+1);
                    }
                    model.addRow(row);
                }                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error, Está mal escrito algun campo", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(e.getMessage());
            }
        }
    }
}
