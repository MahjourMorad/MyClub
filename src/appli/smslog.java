package appli;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import view.*;
import view.Menu;
import model.*;
public class smslog extends JFrame {
	/**
	 * @author MAHJOUR MORAD
	 * @author LAMYAA RAKIK*/
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
         new smslog();

    }

    
    private JPanel p1;
    private JLabel l1, l2;
    private JTextField t1;
    private JPasswordField pass;
    private JButton b1;
    private ImageIcon img;
    /**
     * Interface de login*/
    public smslog() {

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(245, 245, 245));
        
     

       
        l1 = new JLabel("Login");
        l1.setForeground(new Color(105, 105, 105));
        l1.setBounds(264, 136, 90, 40);
        l1.setFont(new Font("Tahoma", Font.BOLD, 13));

        l2 = new JLabel("Mot de passe");
        l2.setForeground(new Color(105, 105, 105));
        l2.setBounds(558, 136, 100, 40);
        l2.setFont(new Font("Tahoma", Font.BOLD, 13));

        t1 = new JTextField(30);
        t1.setBackground(new Color(255, 255, 255));
        t1.setForeground(new Color(112, 128, 144));
        t1.setBounds(175, 187, 230, 35);

        pass = new JPasswordField(10);
        pass.setToolTipText("");
        pass.setForeground(new Color(105, 105, 105));
        pass.setBackground(new Color(255, 255, 255));
        pass.setBounds(502, 187, 230, 35);

        b1 = new JButton("Login");
        b1.setForeground(new Color(255, 250, 240));
        b1.setBounds(404, 255, 100, 50);
        b1.setBackground(new Color(105, 105, 105));
        b1.setMnemonic('u');

        p1.add(l1);
        p1.add(l2);
        p1.add(t1);
        p1.add(pass);
        p1.add(b1);

        getContentPane().add(p1);
        
        JLabel lblLogin = new JLabel("Login");
        lblLogin.setForeground(new Color(105, 105, 105));
        lblLogin.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblLogin.setBounds(400, 91, 163, 41);
        p1.add(lblLogin);
        
        JPanel panel = new JPanel();
        panel.setForeground(new Color(255, 250, 240));
        panel.setBackground(new Color(255, 250, 240));
        panel.setBounds(0, 0, 862, 46);
        p1.add(panel);
        panel.setLayout(null);
        
        JLabel lblAisClub = new JLabel("MyClubs");
        lblAisClub.setBounds(108, 11, 95, 19);
        lblAisClub.setForeground(new Color(105, 105, 105));
        lblAisClub.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
        panel.add(lblAisClub);
        setSize(868, 390);
        setVisible(true);
        setResizable(false);
        setLocation(370, 50);
        setTitle("MyClubs");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userlogin();
       

    }

    public void userlogin() {
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String puname = t1.getText();
                @SuppressWarnings("deprecation")
				String ppaswd = pass.getText();
                if (puname.equals("user") && ppaswd.equals("user")) {
                // user side view
                	Menu us=new Menu();
                	us.setVisible(true);
                    dispose();
                } else if(puname.equals("user") && ppaswd.equals("passwd")) { // admin side view
                	MenuAdmin av=new MenuAdmin();
                	av.setVisible(true);
                    dispose();}
                else {

                    JOptionPane.showMessageDialog(null, "Wrong Password or Username");
                    t1.setText("");
                    pass.setText("");
                    t1.requestFocus();
                }
            }
        });
    }


}

