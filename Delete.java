import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//insert into libros values(null,"JavaScript for Kids","Paperback","2014-12-12",2)
public class Delete {
    JTable table;
    DefaultTableModel model;
    App con = new App();
   
    public Delete(JTable table, DefaultTableModel model) {
        this.table=table;
        this.model=model;
        String a = String.valueOf(model.getValueAt(table.getSelectedRow(),0));
        
        try {
            Statement estatuto = con.getCon().createStatement();
            estatuto.executeUpdate("DELETE from libros where idLibros='"+a+"' ");         
            ResultSet rs = estatuto.executeQuery("Select * from libros");
            model.setRowCount(0);
            while (rs.next()) {
                Object[] row = new Object[5];
                for (int i = 0; i < row.length; i++) {
                    row[i]=rs.getString(i+1);
                }
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No a seleccionado nada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
