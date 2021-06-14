import java.awt.event.*;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Frame extends JFrame{

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
        JTextField text3 = new JTextField("Año Publicación",18);
        JTextField text4 = new JTextField("WTF",18);
        JTable table = new JTable();

        //Entrys
        text.setBounds(1, 1, 256, 30);
        text.setBorder(BorderFactory.createLineBorder(Color.blue));
        text.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                text.setText(null);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                
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
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                
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
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                
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
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        
        //Buttons
        b1.setBounds(1,  text.getHeight() + 3, 256, 40);
        b1.setText("Listar libros");
        b1.addActionListener( e -> System.out.println("Hola"));
        b1.setFocusable(false);

        b2.setBounds(b1.getWidth(), b1.getY(), text.getWidth(), 40);
        b2.setText("Delete");
        b2.addActionListener(e-> System.out.println(bg.getIconWidth()+"  "+bg.getIconHeight()));
        b2.setFocusable(false);

        b3.setBounds(b1.getWidth()*2, b1.getY(), text.getWidth(), 40);
        b3.setText("Update");
        //b3.addActionListener(e-> System.out.println(bg.getIconWidth()+"  "+bg.getIconHeight()));
        b3.setFocusable(false);

        b4.setBounds(b1.getWidth()*3, b1.getY(), text.getWidth(), 40);
        b4.setText("Insert");
        //b4.addActionListener(e-> System.out.println(bg.getIconWidth()+"  "+bg.getIconHeight()));
        b4.setFocusable(false);

        //Tables
        table.setBounds(1, text.getHeight()+b1.getHeight()+5, bg.getIconWidth(), 300);
        table.setSelectionBackground(new Color(0x123456));


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
    
        public static void main(String[] args) {
        new Frame();
    }
}
