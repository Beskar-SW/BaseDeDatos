import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class insert {
    String nom,Editorial,Fecha,edicion;
    DefaultTableModel model;
    JTable table;
    App con = new App();
    public insert(String nom, String editorial, String fecha, String edicion, DefaultTableModel model) {
        this.nom = nom;
        Editorial = editorial;
        Fecha = fecha;
        this.edicion = edicion;
        this.model = model;
        try {
            Statement st = con.getCon().createStatement();
            st.executeUpdate("Insert into libros values(null, '"+nom+"', '"+editorial+"', '"+fecha+"', '"+edicion+"')");
            ResultSet rs = st.executeQuery("Select * from libros");
            model.setRowCount(0);
            while (rs.next()) {
                Object[] row = new Object[5];
                for (int i = 0; i < row.length; i++) {
                    row[i]=rs.getString(i+1);
                }
                model.addRow(row);
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
