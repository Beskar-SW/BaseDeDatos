import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Update {
    String nom,Editorial,Fecha,edicion;
    DefaultTableModel model;
    JTable table;
    App con = new App();
    public Update(String nom, String editorial, String fecha, String edicion, DefaultTableModel model, JTable table) throws SQLException {
        this.nom = nom;
        Editorial = editorial;
        Fecha = fecha;
        this.edicion = edicion;
        this.model = model;
        this.table= table;
        String a = String.valueOf(model.getValueAt(table.getSelectedRow(),0));
        String b = String.valueOf(model.getValueAt(table.getSelectedRow(),1));
        String c = String.valueOf(model.getValueAt(table.getSelectedRow(),2));
        String d = String.valueOf(model.getValueAt(table.getSelectedRow(),3));
        String e = String.valueOf(model.getValueAt(table.getSelectedRow(),4));
        Statement st = con.getCon().createStatement();

        if (nom.length()!=0 && editorial.length()!=0 && fecha.length()!=0 && edicion.length()!=0) {
            st.executeUpdate("UPDATE libros set nombre='"+nom+"' ,editorial='"+editorial+"', añopub='"+fecha+"' , edicion='"+edicion+"' where idLibros='"+a+"' ");
            ResultSet rs = st.executeQuery("Select * from libros");
            model.setRowCount(0);
            while (rs.next()) {
                Object[] row = new Object[5];
                for (int i = 0; i < row.length; i++) {
                    row[i]=rs.getString(i+1);
                }
                model.addRow(row);
            }
        }else if(nom.length()==0 || editorial.length()==0 || fecha.length()==0 || edicion.length()==0){
            nom=b;
            editorial=c;
            fecha=d;
            edicion=e;
            st.executeUpdate("UPDATE libros set nombre='"+nom+"',editorial='"+editorial+"', añopub='"+fecha+"', edicion='"+edicion+"' where idLibros='"+a+"' ");
            ResultSet rs = st.executeQuery("Select * from libros");
            model.setRowCount(0);
            while (rs.next()) {
                Object[] row = new Object[5];
                for (int i = 0; i < row.length; i++) {
                    row[i]=rs.getString(i+1);
                }
                model.addRow(row);
            }

        }
    }
    
}
