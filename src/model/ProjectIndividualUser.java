package model;
import java.awt.BorderLayout;

import SMS.img.*;
import SMS.bin.StudentMgmtSys.*;
import appli.smslog;
import view.*;
import appli.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import appli.smslog;
import view.MenuAdmin;
/**
 * 
 * @author MAHJOUR MORAD
 * @author LAMYAA RAKIK*/
public class ProjectIndividualUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pstm = null;
	private JButton jButton2, jButton6, jButton7;
	private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel6, lbl_img,
			lbl_img1;
	private JPanel jPanel1, jPanel2;
	private JTextField jTextField1, jTextField2, jTextField3, jTextField4;
	@SuppressWarnings("unused")
	private ImageIcon format = null;
	String filename = null;
	byte[] person_image = null;
	private JLabel lblLieu;
	private JLabel lblDescriptif;
	private JTextField textField_1;
	private JTextField textField;
	private JButton button;
	/**
	 * Fera appel a la connection*/
	public ProjectIndividualUser() {
		// TODO Auto-generated constructor stub
		initComponents();
		con = dbconnect.java_db();
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
		setResizable(false);
		setTitle("MyClubs");
	}

	private void initComponents() {
		jPanel1 = new JPanel();
		jLabel1 = new JLabel();
		jLabel1.setForeground(SystemColor.controlDkShadow);
		JTextField jTextField = new JTextField();
		jTextField1 = new JTextField();
		jButton2 = new JButton();
		jButton7 = new JButton();
		jButton7.setForeground(new Color(255, 250, 240));
		jButton7.setBackground(new Color(105, 105, 105));
		jPanel2 = new JPanel();
		jLabel2 = new JLabel();
		jLabel2.setForeground(SystemColor.windowBorder);
		jLabel3 = new JLabel();
		jLabel3.setForeground(SystemColor.windowBorder);
		jTextField2 = new JTextField();
		jTextField3 = new JTextField();
		jLabel4 = new JLabel();
		jLabel4.setForeground(SystemColor.windowBorder);
		jTextField4 = new JTextField();
		jButton6 = new JButton();
		jButton6.setForeground(new Color(255, 250, 240));
		jLabel6 = new JLabel();
		lbl_img = new JLabel();
		lbl_img1 = new JLabel();
		lbl_img1.setHorizontalAlignment(SwingConstants.CENTER);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new Color(255, 250, 240));

		jLabel1.setFont(new Font("Tahoma", 1, 12)); // NOI18N
		jLabel1.setText("Chercher projet par ID");

		jTextField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});
		jTextField1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				jTextField1KeyReleased(evt);
			}
		});

		
		jButton2.setText("Logged Out");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		
		jButton7.setText("Back");
		jButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});

		jPanel2.setBackground(SystemColor.controlHighlight);

		jLabel2.setFont(new Font("Tahoma", 1, 11)); // NOI18N
		jLabel2.setText("Id");

		jLabel3.setFont(new Font("Tahoma", 1, 11)); // NOI18N
		jLabel3.setText("Chef de projet");

		jTextField2.setFont(new Font("Tahoma", 1, 12)); // NOI18N
		jTextField2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jTextField2ActionPerformed(evt);
			}
		});

		jTextField3.setFont(new Font("Tahoma", 1, 12)); // NOI18N

		jLabel4.setFont(new Font("Tahoma", 1, 11)); // NOI18N
		jLabel4.setText("Titre");

		jTextField4.setFont(new Font("Tahoma", 1, 12));

		jButton6.setText(" Images");
		jButton6.setBackground(new Color(105, 105, 105));
		jButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

		jLabel6.setFont(new Font("Tahoma", 1, 18)); // NOI18N
		jLabel6.setForeground(SystemColor.textInactiveText);
		jLabel6.setText("Information de l'evenemt");

		lbl_img1.setBackground(new Color(0, 0, 153));
		lbl_img1.setFont(new Font("Tahoma", 1, 14)); // NOI18N
		lbl_img1.setForeground(SystemColor.windowBorder);
		lbl_img1.setText("Image Attach Here");
		
		lblLieu = new JLabel();
		lblLieu.setForeground(SystemColor.windowBorder);
		lblLieu.setText("Membres");
		lblLieu.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblDescriptif = new JLabel();
		lblDescriptif.setForeground(SystemColor.windowBorder);
		lblDescriptif.setText("Descriptif");
		lblDescriptif.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		button = new JButton("Menu principal");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MenuAdmin().setVisible(true);
				dispose();
			}
		});
		button.setForeground(new Color(255, 250, 240));
		button.setBackground(SystemColor.controlDkShadow);

		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2Layout.setHorizontalGroup(
			jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup()
							.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(jPanel2Layout.createSequentialGroup()
									.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(jLabel4)
									.addGap(26)
									.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel2Layout.createSequentialGroup()
									.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel2Layout.createSequentialGroup()
									.addComponent(lblLieu, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField))
								.addGroup(jPanel2Layout.createSequentialGroup()
									.addComponent(lblDescriptif, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
							.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lbl_img1, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel2Layout.createSequentialGroup()
									.addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
									.addGap(131))))
						.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl_img, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(488))
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addGap(935)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(529, Short.MAX_VALUE))
		);
		jPanel2Layout.setVerticalGroup(
			jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addGap(200)
					.addComponent(lbl_img, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
					.addGap(200))
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup()
							.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
								.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
								.addGroup(jPanel2Layout.createSequentialGroup()
									.addGap(0, 6, Short.MAX_VALUE)
									.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(jLabel2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
										.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
								.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLieu, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
							.addGap(64)
							.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDescriptif, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
							.addGap(18))
						.addGroup(jPanel2Layout.createSequentialGroup()
							.addGap(60)
							.addComponent(lbl_img1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(3)))
					.addGap(100)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(124))
		);
		jPanel2.setLayout(jPanel2Layout);

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addGap(19)
							.addComponent(jLabel1)
							.addGap(18)
							.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE)
							.addGap(158)
							.addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(624)
							.addComponent(jButton2)
							.addGap(0, 20, Short.MAX_VALUE))
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
							.addGap(6))
						.addComponent(jButton2, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
							.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(jButton7, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		jPanel1.setLayout(jPanel1Layout);

		GroupLayout layout = new GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(99, Short.MAX_VALUE))
		);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton6ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton6ActionPerformed
		// TODO add your handling code here:

		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File f = chooser.getSelectedFile();

		filename = f.getAbsolutePath();
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lbl_img1.getWidth(),
				lbl_img1.getHeight(), Image.SCALE_DEFAULT));
		lbl_img1.setIcon(imageIcon);
		try {

			File image = new File(filename);
			@SuppressWarnings("resource")
			FileInputStream fis = new FileInputStream(image);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];

			for (int readNum; (readNum = fis.read(buf)) != -1;) {

				bos.write(buf, 0, readNum);
			}
			person_image = bos.toByteArray();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);

		}

	}// GEN-LAST:event_jButton6ActionPerformed

	private void jTextField1ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField1ActionPerformed

	private void jTextField1KeyReleased(KeyEvent evt) {// GEN-FIRST:event_jTextField1KeyReleased
		// TODO add your handling code here:
		try {
			String sql = "select * from projets where id_pr=? ";

			pstm = con.prepareStatement(sql);
			pstm.setString(1, jTextField1.getText());
			rs = pstm.executeQuery();
			while (rs.next()) {

				String add1 = rs.getString("id");
				jTextField2.setText(add1);
				String add2 = rs.getString("titre");
				jTextField4.setText(add2);
				
				String add4 = rs.getString("membres");
				jTextField3.setText(add4);
				
				String add7 = rs.getString("chef_projet");
				textField.setText(add7);
				String add8 = rs.getString("description");
				textField_1.setText(add8);
			
				byte[] img = rs.getBytes("image");
				ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lbl_img1.getWidth(),
						lbl_img1.getHeight(), Image.SCALE_SMOOTH));
				lbl_img1.setIcon(imageIcon);
			}
		} catch (Exception e) {

		} finally {

			try {

				rs.close();
				pstm.close();

			} catch (Exception e) {

			}
		}

	}// GEN-LAST:event_jTextField1KeyReleased

	private void jTextField2ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jTextField2ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField2ActionPerformed

	private void jButton2ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		// TODO add your handling code here:
		new smslog().setVisible(true);
		dispose();
	}// GEN-LAST:event_jButton2ActionPerformed

	private void jButton7ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton7ActionPerformed
		// TODO add your handling code here:
		new ProjetView().setVisible(true);
		dispose();
	}// GEN-LAST:event_jButton7ActionPerformed

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting
		// code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
		 * html
		 */
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ProjetIndividual.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ProjetIndividual.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ProjetIndividual.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ProjetIndividual.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ProjetIndividual().setVisible(true);
			}
		});
	}


}
