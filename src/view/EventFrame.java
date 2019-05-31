package view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import appli.smslog;

import java.io.*;
import java.sql.*;
/**
 * @author MAHJOUR MORAD
 * @author LAMYAA RAKIK*/
public class EventFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new EventFrame();
		
	}

	Container c;
	JPanel p2, p3, p5;
	ImageIcon img;
	JLabel l4, l5, l6, l11, l15;
	JTextField t3, t4, t5, t10, t20, t21;
	JButton logout, save, show, attach;
	JLabel attached;

	static final String DB_URL = "jdbc:mysql://localhost/student";
	static final String USER = "root";
	static final String PASS = "";
	String s;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel panel;
	private JLabel label;
	/** 
	 * cadre de l'interface*/
	public EventFrame() {
		// TODO Auto-generated constructor stub
		// first panel
		c = getContentPane();
		try {
		}
		catch(Exception e ) {System.out.println("erreur erreur erreur "+ e);}

		// third panel
		p3 = new JPanel();
		p3.setLayout(null);
		p3.setBackground(UIManager.getColor("Button.background"));
		p3.setBounds(0, 80, 1200, 400);

		// fifth panel
		p5 = new JPanel();
		p5.setLayout(null);
		p5.setBackground(new Color(150, 150, 255));

		JLabel year = new JLabel(" Passed Year");
		year.setBounds(900, 540, 200, 30);
		year.setFont(new Font(year.getName(), Font.BOLD, 18));
		t20 = new JTextField();
		t20.setBounds(880, 580, 250, 35);
		t21 = new JTextField();
		t21.setBounds(880, 640, 250, 35);
		p5.add(year);
		p5.add(t20);
		p5.add(t21);

		l4 = new JLabel("Lieu");
		l4.setBounds(20, 350, 130, 30);
		t3 = new JTextField(50);
		t3.setBounds(111, 350, 150, 30);

		l5 = new JLabel("Date Debut:");
		l5.setBounds(20, 283, 80, 30);
		t4 = new JTextField(50);
		t4.setBounds(111, 283, 150, 30);

		l6 = new JLabel("Date Fin");
		l6.setBounds(285, 283, 130, 30);
		t5 = new JTextField(50);
		t5.setBounds(388, 283, 160, 30);

		l11 = new JLabel("Descriptif");
		l11.setBounds(20, 426, 130, 30);
		t10 = new JTextField(50);
		t10.setBounds(111, 415, 410, 187);

		attach = new JButton("Attach Image");
		attach.setBackground(new Color(105, 105, 105));
		attach.setForeground(new Color(255, 250, 240));
		attach.setBounds(851, 421, 150, 40);
		p3.add(attach);
		attached = new JLabel("Attach Image Here");
		attached.setBounds(869, 180, 200, 200);
		attached.setForeground(Color.BLACK);
		p3.add(attached);

		// for uploading photo
		attach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Image", "jpg", "JPG", "JPEG", "png");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {

					File selectedFile = file.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					attached.setIcon(ResizeImage(path));
					s = path;
				} else if (result == JFileChooser.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "file not selected");
				}
			}
		});
		p3.add(l4);
		p3.add(t3);
		p3.add(l5);
		p3.add(t4);
		p3.add(l6);
		p3.add(t5);
		p3.add(l11);
		p3.add(t10);
		c.add(p3);
		
		textField = new JTextField(50);
		textField.setBounds(111, 223, 150, 30);
		p3.add(textField);
		
		textField_1 = new JTextField(50);
		textField_1.setBounds(384, 223, 150, 30);
		p3.add(textField_1);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(20, 223, 80, 30);
		p3.add(lblId);
		
		JLabel lblTitre = new JLabel("Titre:");
		lblTitre.setBounds(285, 223, 80, 30);
		p3.add(lblTitre);
		
				// Second panel
				p2 = new JPanel();
				p3.add(p2);
				p2.setLayout(null);
				p2.setBackground(new Color(105, 105, 105));
				p2.setBounds(0, 66, 1200, 40);
				JLabel label1 = new JLabel("Ajouter Evenement");
				label1.setBounds(107, -10, 300, 50);
				p2.add(label1);
				label1.setFont(new Font(label1.getName(), Font.BOLD, 20));
				label1.setForeground(new Color(255, 250, 240));
				
				panel = new JPanel();
				panel.setLayout(null);
				panel.setBackground(new Color(255, 250, 240));
				panel.setBounds(0, 0, 1101, 69);
				p3.add(panel);
				
				label = new JLabel("MyClubs");
				label.setForeground(SystemColor.controlDkShadow);
				label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
				label.setBounds(69, 11, 96, 19);
				panel.add(label);
				logout = new JButton("Log-Out");
				logout.setBounds(218, 113, 120, 40);
				p3.add(logout);
				logout.setForeground(new Color(255, 250, 240));
				logout.setBackground(new Color(105, 105, 105));
				save = new JButton("Save Record");
				save.setBounds(428, 117, 120, 40);
				p3.add(save);
				save.setForeground(new Color(255, 250, 240));
				save.setBackground(new Color(105, 105, 105));
				show = new JButton("show Record");
				show.setBounds(677, 117, 110, 40);
				p3.add(show);
				show.setForeground(new Color(255, 250, 240));
				show.setBackground(new Color(105, 105, 105));
		c.add(p5, BorderLayout.SOUTH);
		// create a constructor for logout save and show button

		setSize(1107, 661);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setTitle("Evenement AppInSscience");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		shows();
		logout();
		save();
	}

	/** 
	 * Redimentionner les image pour les afficher correctemt
	 * @param path de l'image*/
	public ImageIcon ResizeImage(String Imagepath) {

		ImageIcon myImage = new ImageIcon(Imagepath);
		Image img = myImage.getImage();
		Image newImage = img.getScaledInstance(attached.getWidth(), attached.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon Image = new ImageIcon(newImage);
		return Image;
	}

	/** 
	 * Deconnetion*/
	public void logout() {
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				smslog r = new smslog();
				r.setVisible(true);
				dispose();

			}
		});
	}
	/** 
	 * voir la liste des evenements*/
	public void shows() {
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventView ad = new EventView();
				ad.setVisible(true);
				dispose();
			}
		});
	}
	/** 
	 * enregistrer le donnees de l'event dans la db*/
	public void save() {
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement stmt = null;
				String s1 = textField.getText();
				String s2 = textField_1.getText();
				String s3 = t3.getText();
				String s4 = t4.getText();
				String s5 = t5.getText();
				String s6 = t10.getText();



				if ( textField_1.getText().equals("") || t3.getText().equals("")
						|| t4.getText().equals("") || t5.getText().equals("")
						|| t10.getText().equals("")) {
					JOptionPane.showMessageDialog(save, "All record Must be fill Out");
				} else {
					try {

						conn = DriverManager.getConnection(DB_URL, USER, PASS);
						System.out.println("every thing is ok in connection");
						JOptionPane.showConfirmDialog(null, "Are you sure Insert Data?", "Delete",
								JOptionPane.YES_NO_OPTION);
						PreparedStatement ps = conn.prepareStatement(
								"INSERT INTO event(id,titre,lieu,datedebut,datefin,"
										+ "descriptif,image)"
										+ "VALUES(?,?,?,?,?,?,?)");
						System.out.println("ok in prepared statement");
						InputStream is = new FileInputStream(new File(s));
						ps.setString(1, s1);
						ps.setString(2, s2);
						ps.setString(3, s3);
						ps.setString(4, s4);
						ps.setString(5, s5);
						ps.setString(6, s6);
						
					
						ps.setBlob(7, is);
						ps.executeUpdate();
						System.out.println("ok while execute ");
						JOptionPane.showMessageDialog(save, "sucessfully inserted Data");
						
						t3.setText("");
						t4.setText("");
						t5.setText("");
				
						t10.setText("");
			
						t20.setText("");
						t21.setText("");

					} catch (SQLException se) {
						se.printStackTrace();

					} catch (Exception ek) {
						ek.printStackTrace();
					} finally {
						try {
							if (stmt != null) {
								conn.close();
							}
						} catch (SQLException se) {
						}
						try {
							if (conn != null) {
								conn.close();
							}
						} catch (SQLException se) {
							se.printStackTrace();
						} // end finally try
					} // end try
					System.out.println("good bye");
				}
			}
		});
	}
}
