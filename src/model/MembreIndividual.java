package model;


import java.awt.*;

import java.io.*;
import java.sql.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import appli.smslog;
import view.MembreView;
import view.MenuAdmin;
import SMS.img.*;
import SMS.bin.StudentMgmtSys.*;
import appli.smslog;
import view.*;
import appli.*;

@SuppressWarnings({ "unused" })
public class MembreIndividual extends JFrame {
	/**
	 * @author MAHJOUR MORAD
	 * @author LAMYAA RAKIK*/
	private static final long serialVersionUID = 1L;
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pstm = null;
	private JButton jButton2, jButton3, jButton4, jButton5, jButton6, jButton7;
	private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel6, jLabel7, lbl_img,
			lbl_img1;
	private JPanel jPanel1, jPanel2;
	private JTextField jTextField1, jTextField2, jTextField3, jTextField4, jTextField6;
	@SuppressWarnings("unused")
	private ImageIcon format = null;
	String filename = null;
	byte[] person_image = null;
	private JLabel lblLieu;
	private JLabel lblDescriptif;
	private JTextField textField_1;
	private JTextField textField;
	private JButton btnNewButton;
	/**
	 * 
	 */
	public MembreIndividual() {
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
		jButton2.setForeground(new Color(255, 250, 240));
		jButton2.setBackground(new Color(105, 105, 105));
		jButton3 = new JButton();
		jButton3.setForeground(new Color(255, 250, 240));
		jButton4 = new JButton();
		jButton4.setBackground(new Color(105, 105, 105));
		jButton4.setForeground(new Color(255, 250, 240));
		jButton5 = new JButton();
		jButton5.setBackground(new Color(105, 105, 105));
		jButton5.setForeground(new Color(255, 250, 240));
		jButton7 = new JButton();
		jButton7.setBackground(new Color(105, 105, 105));
		jButton7.setForeground(new Color(255, 250, 240));
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
	
		jTextField6 = new JTextField();
		jLabel7 = new JLabel();
		jLabel7.setForeground(SystemColor.windowBorder);
		jLabel6 = new JLabel();
		lbl_img = new JLabel();
		lbl_img1 = new JLabel();
		lbl_img1.setHorizontalAlignment(SwingConstants.CENTER);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new Color(255, 250, 240));

		jLabel1.setFont(new Font("Tahoma", 1, 12)); // NOI18N
		jLabel1.setText("Chercher membre par ID");

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

		jButton3.setIcon(null); // NOI18N
		jButton3.setText("Modifier");
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton4.setIcon(null); // NOI18N
		jButton4.setText("Supprimer");
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jButton5.setIcon(null); // NOI18N
		jButton5.setText("Reset");
		jButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jButton7.setIcon(null); // NOI18N
		jButton7.setText("back");
		jButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});

		jPanel2.setBackground(SystemColor.controlHighlight);

		jLabel2.setFont(new Font("Tahoma", 1, 11)); // NOI18N
		jLabel2.setText("Id");

		jLabel3.setFont(new Font("Tahoma", 1, 11)); // NOI18N
		jLabel3.setText("Prenom");

		jTextField2.setFont(new Font("Tahoma", 1, 12)); // NOI18N
		jTextField2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jTextField2ActionPerformed(evt);
			}
		});

		jTextField3.setFont(new Font("Tahoma", 1, 12)); // NOI18N

		jLabel4.setFont(new Font("Tahoma", 1, 11)); // NOI18N
		jLabel4.setText("Nom");

		jTextField4.setFont(new Font("Tahoma", 1, 12));

		jButton6.setText(" Images");
		jButton6.setBackground(new Color(105, 105, 105));
		jButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

		jTextField6.setFont(new Font("Tahoma", 1, 12)); // NOI18N

		jLabel7.setFont(new Font("Tahoma", 1, 11)); // NOI18N
		jLabel7.setText("Date de naissance");

		jLabel6.setFont(new Font("Tahoma", 1, 18)); // NOI18N
		jLabel6.setForeground(SystemColor.textInactiveText);
		jLabel6.setText("Information de l'evenemt");

		lbl_img1.setBackground(new Color(0, 0, 153));
		lbl_img1.setFont(new Font("Tahoma", 1, 14)); // NOI18N
		lbl_img1.setForeground(SystemColor.windowBorder);
		lbl_img1.setText("Image Attach Here");
		
		lblLieu = new JLabel();
		lblLieu.setForeground(SystemColor.windowBorder);
		lblLieu.setText("Filiere");
		lblLieu.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblDescriptif = new JLabel();
		lblDescriptif.setForeground(SystemColor.windowBorder);
		lblDescriptif.setText("Niveau universitaire");
		lblDescriptif.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnNewButton = new JButton("Menu principal");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MenuAdmin().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(105, 105, 105));
		btnNewButton.setForeground(new Color(255, 250, 240));

		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2Layout.setHorizontalGroup(
			jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(jPanel2Layout.createSequentialGroup()
							.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup()
									.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
										.addGroup(jPanel2Layout.createSequentialGroup()
											.addGap(9)
											.addComponent(lblLieu, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
											.addGap(26)
											.addComponent(lblDescriptif, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
											.addGap(26))
										.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
											.addGroup(jPanel2Layout.createSequentialGroup()
												.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
												.addGap(26)
												.addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGap(26))
											.addGroup(jPanel2Layout.createSequentialGroup()
												.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
												.addGap(26)
												.addComponent(jLabel4)
												.addGap(104))))
									.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
										.addComponent(jTextField6, Alignment.TRAILING, 181, 181, 181)
										.addComponent(textField_1, 181, 181, 181)
										.addGroup(jPanel2Layout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)))
									.addGap(225))
								.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lbl_img, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lbl_img1, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel2Layout.createSequentialGroup()
									.addGap(105)
									.addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)))
							.addGap(115))
						.addGroup(jPanel2Layout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(93))))
		);
		jPanel2Layout.setVerticalGroup(
			jPanel2Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addGap(200)
					.addComponent(lbl_img, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
					.addGap(200))
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup()
							.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup()
									.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
										.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
										.addGroup(jPanel2Layout.createSequentialGroup()
											.addGap(0, 17, Short.MAX_VALUE)
											.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(jLabel2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
												.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))))
									.addGap(74))
								.addGroup(jPanel2Layout.createSequentialGroup()
									.addGap(67)
									.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel7)
								.addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(69)
							.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblLieu, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblDescriptif, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel2Layout.createSequentialGroup()
									.addGap(8)
									.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)))
							.addGap(117))
						.addGroup(jPanel2Layout.createSequentialGroup()
							.addGap(60)
							.addComponent(lbl_img1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)))
					.addGap(183)
					.addComponent(btnNewButton)
					.addGap(53))
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addContainerGap(389, Short.MAX_VALUE)
					.addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(251))
		);
		jPanel2.setLayout(jPanel2Layout);

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 1339, Short.MAX_VALUE))
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addGap(19)
							.addComponent(jLabel1)
							.addGap(18)
							.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
							.addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(70)
							.addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(jButton4)
							.addGap(18)
							.addComponent(jButton3)
							.addGap(26)
							.addComponent(jButton2)
							.addGap(16)))
					.addGap(16))
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
							.addGap(6))
						.addComponent(jTextField1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
							.addComponent(jButton7, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
							.addComponent(jButton5, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
							.addComponent(jButton4, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
							.addComponent(jButton3, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
							.addComponent(jButton2, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		jPanel1.setLayout(jPanel1Layout);

		GroupLayout layout = new GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 1365, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(127, Short.MAX_VALUE))
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
			String sql = "select * from membre where id_per=? ";

			pstm = con.prepareStatement(sql);
			pstm.setString(1, jTextField1.getText());
			rs = pstm.executeQuery();
			while (rs.next()) {

				String add1 = rs.getString("id");
				jTextField2.setText(add1);
				String add2 = rs.getString("nom");
				jTextField4.setText(add2);
				
				String add4 = rs.getString("prenom");
				jTextField3.setText(add4);
				String add6 = rs.getString("dateNaissance");
				jTextField6.setText(add6);
				String add7 = rs.getString("filiere");
				textField.setText(add7);
				String add8 = rs.getString("niveauUniveritaire");
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

	private void jButton5ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton5ActionPerformed
		// TODO add your handling code here:
		jTextField1.setText("");
		jTextField2.setText("");
		jTextField3.setText("");
		jTextField4.setText("");
		textField.setText("");
		textField_1.setText("");
	
		jTextField6.setText("");

		lbl_img1.setIcon(null);
	}// GEN-LAST:event_jButton5ActionPerformed

	private void jButton4ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
		// TODO add your handling code here:
		if (jTextField1.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Record is Not Selected");
		} else {
			int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete record?", "Delete",
					JOptionPane.YES_NO_OPTION);
			if (p == 0) {
				String sql = "delete from event where id_per=? ";
				try {
					pstm = con.prepareStatement(sql);
					pstm.setString(1, jTextField1.getText());
					pstm.execute();

					JOptionPane.showMessageDialog(null, "Record Deleted successfully");
					jTextField1.setText("");
					jTextField2.setText("");
					jTextField3.setText("");
					jTextField4.setText("");
					textField.setText("");
					textField_1.setText("");
			
					jTextField6.setText("");
			
					lbl_img1.setIcon(null);
				} catch (Exception e) {

					JOptionPane.showMessageDialog(null, e);
				} finally {

					try {
						rs.close();
						pstm.close();

					} catch (Exception e) {

					}
				}
			}
		}
	}// GEN-LAST:event_jButton4ActionPerformed

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		// TODO add your handling code here:
		if (jTextField1.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Record is Not Selected");
		} else {
			int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to update?", "Update Record",
					JOptionPane.YES_NO_OPTION);
			if (p == 0) {
				try {
					String value0 = jTextField1.getText();
					String value1 = jTextField2.getText();
					String value2 = jTextField4.getText();
					String value3 = jTextField3.getText();
					String value4 = jTextField6.getText();
			
					String value5 = textField.getText();
					String value6 = textField_1.getText();
		

					String sql = "update membre set id='" + value1 + "',nom='" + value2 + "', prenom='"
							+ value3 + "', " + "dateNaissance='" + value4 + "',filiere='" + value5 + "',niveauUniveritaire='"
							+ value6 + "'"
						

							+ "where id_per='" + value0 + "' ";

					pstm = con.prepareStatement(sql);
					// pst.setBytes(1,person_image);
					pstm.execute();
					JOptionPane.showMessageDialog(null, "RecordSuccessfully Updated");

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				} finally {

					try {
						rs.close();
						pstm.close();

					} catch (Exception e) {

					}
				}
			}

		}
	}// GEN-LAST:event_jButton3ActionPerformed

	private void jButton7ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton7ActionPerformed
		// TODO add your handling code here:
		new MembreView().setVisible(true);
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
			java.util.logging.Logger.getLogger(MembreIndividual.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MembreIndividual.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MembreIndividual.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MembreIndividual.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MembreIndividual().setVisible(true);
			}
		});
	}

}
