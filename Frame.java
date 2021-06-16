import java.awt.event.*;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.sql.*;

public class Frame extends JFrame{
    App con=new App();
    DefaultTableModel model = new DefaultTableModel();

    public Frame(){

        JButton b1,b2,b3,b4;
        b1= new JButton();
        b2= new JButton();
        b3= new JButton();
        b4= new JButton();
        ImageIcon image = new ImageIcon("D:\\Escuela\\5to Semestre\\BD\\AplicacionFundBD\\src\\libros.png");
        ImageIcon bg = new ImageIcon("D:\\Escuela\\5to Semestre\\BD\\AplicacionFundBD\\src\\bg.jpg");
        JTextField text=new JTextField("Nombre del libro",18);
        JTextField text2 = new JTextField("Editorial",18);
        JTextField text3 = new JTextField("Año Publicación (YYYY-MM-DD)",18);
        JTextField text4 = new JTextField("Numero de edición",18);
        JTable table = new JTable(model);

        //Entrys
        text.setBounds(1, 1, 256, 30);
        text.setBorder(BorderFactory.createLineBorder(Color.blue));
        text.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                text.setText(null);
                text2.setText(null);
                text3.setText(null);
                text4.setText(null);

            }

            @Override
            public void mousePressed(MouseEvent e) {                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
                    
            }
        });

        text2.setBounds(text.getWidth(),1,text.getWidth(),30);
        text2.setBorder(BorderFactory.createLineBorder(new Color(128,64,00)));
        text2.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                text2.setText(null);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                                
            }
        });

        text3.setBounds(text2.getWidth()*2, 1, text.getWidth(), 30);
        text3.setBorder(BorderFactory.createLineBorder(Color.red));
        text3.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                text3.setText(null);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                                
            }
        });

        text4.setBounds(text3.getWidth()*3, 1, text.getWidth(), 30);
        text4.setBorder(BorderFactory.createLineBorder(new Color(00,255,255)));
        text4.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                text4.setText(null);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                                
            }
        });
        
        //Buttons
        b1.setBounds(1,  text.getHeight() + 3, 256, 40);
        b1.setText("Search");
        b1.addActionListener( e -> new ListarLibro(text.getText(), text2.getText(), text3.getText(), text4.getText(), model));
        b1.setFocusable(false);

        b2.setBounds(b1.getWidth(), b1.getY(), text.getWidth(), 40);
        b2.setText("Delete");
        b2.addActionListener(e -> new Delete(table,model));
        b2.setFocusable(false);

        b3.setBounds(b1.getWidth()*2, b1.getY(), text.getWidth(), 40);
        b3.setText("Update");
        b3.addActionListener(e-> {
            try {
                new Update(text.getText(), text2.getText(), text3.getText(), text4.getText(), model,table);
            } catch (SQLException e1) {
                
                e1.printStackTrace();
            }
        });
        b3.setFocusable(false);

        b4.setBounds(b1.getWidth()*3, b1.getY(), text.getWidth(), 40);
        b4.setText("Insert");
        b4.addActionListener(e->  new insert(text.getText(), text2.getText(), text3.getText(), text4.getText(), model));
        b4.setFocusable(false);

        //Table
        model.addColumn("id");
        model.addColumn("Nombre Libro");
        model.addColumn("Editorial");
        model.addColumn("Fecha publicación");
        model.addColumn("Numero de edición");
        table.setBounds(1, text.getHeight()+b1.getHeight()+5, bg.getIconWidth(), 300);
        table.setSelectionBackground(new Color(0x123456));
        table.setBackground(new Color(159,213,209));
        table.setSelectionForeground(Color.WHITE);
        Table();
       
        //Frame Config
        setLayout(null);
        setTitle("wan shi tong library");
        setIconImage(image.getImage());
        setContentPane(new JLabel(bg));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(bg.getIconWidth(),bg.getIconHeight());
        add(text);
        add(text2);
        add(text3);
        add(text4);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(table);
        setVisible(true);
    } 

    public void Table(){
        try {
            Statement estatuto = con.getCon().createStatement();
            ResultSet rs = estatuto.executeQuery("Select * from libros");
            while (rs.next()) {
                Object[] row = new Object[5];
                for (int i = 0; i < row.length; i++) {
                    row[i]=rs.getString(i+1);
                }
                model.addRow(row);
            }
        } catch (Exception e) {

        }   
    }
    
        public static void main(String[] args) {
        new Frame();
    }
}
