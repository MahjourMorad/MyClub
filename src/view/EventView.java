package view;

import appli.*;
import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
/**
 * @author MAHJOUR MORAD
 * @author LAMYAA RAKIK*/
public class EventView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	String sql;
	private JButton jButton1, jButton2, jButton3;
	private JLabel lbl;
	private JPanel jPanel1, jPanel2;
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private JTextField jTextField1;
	private Label label1, label2;
	private JPanel panel;
	private JLabel label;
	private JButton button;
	/**
	 * 
	 */
	public EventView() {
		// TODO Auto-generated constructor stub
		initComponents();
		conn = dbconnect.java_db();
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		 setLocation(size.width / 2 - getWidth() / 2,size.height / 2 - getHeight() / 2);
		//setLocation(60, 0);
		setResizable(false);
		setTitle("MyClubs");
		updatetable();

	}
	/**
	 *voir la list de tout les evenements 
	 */
	private void updatetable() {
		try {

			String sql = "select * from event";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			jTable1.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				pst.close();

			} catch (Exception e) {

			}
		}
	}

	private void initComponents() {
		label1 = new Label();
		label2 = new Label();
		jPanel1 = new JPanel();
		lbl = new JLabel();
		lbl.setForeground(new Color(255, 250, 240));
		jTextField1 = new JTextField();
		jButton1 = new JButton();
		jButton1.setForeground(new Color(255, 250, 240));
		jButton2 = new JButton();
		jButton2.setForeground(new Color(255, 250, 240));
		jButton3 = new JButton();
		jButton3.setForeground(new Color(255, 250, 240));
		jPanel2 = new JPanel();
		jPanel2.setForeground(UIManager.getColor("Button.background"));
		jScrollPane1 = new JScrollPane();
		jTable1 = new JTable();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		label1.setText("label1");

		label2.setText("label2");

		jPanel1.setBackground(new Color(105, 105, 105));

		lbl.setFont(new Font("Tahoma", 1, 14)); // NOI18N
		lbl.setText("Search Event ByID");

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

		jButton1.setBackground(new Color(105, 105, 105));
		jButton1.setFont(new Font("Tahoma", 1, 12)); // NOI18N
		jButton1.setIcon(null); // NOI18N
		jButton1.setText("Ajouter");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setBackground(new Color(105, 105, 105));
		jButton2.setFont(new Font("Tahoma", 1, 12)); // NOI18N
		jButton2.setIcon(null); // NOI18N
		jButton2.setText("Reset");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setBackground(new Color(105, 105, 105));
		jButton3.setFont(new Font("Tahoma", 1, 12)); // NOI18N
		jButton3.setIcon(null); // NOI18N
		jButton3.setText(" Show Individual");
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addGap(51)
					.addComponent(lbl, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jButton3)
					.addGap(153)
					.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(54)
					.addComponent(jButton2)
					.addContainerGap(115, Short.MAX_VALUE))
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addGap(23)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lbl, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
							.addComponent(jButton3, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
							.addComponent(jButton1, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
							.addComponent(jButton2, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)))
					.addContainerGap())
		);
		jPanel1.setLayout(jPanel1Layout);

		jPanel2.setBackground(UIManager.getColor("Button.background"));

		jTable1.setBackground(new Color(255, 255, 255));
		jTable1.setFont(new Font("Tahoma", 0, 14)); // NOI18N
		jTable1.setModel(
				new DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		jTable1.setIntercellSpacing(new Dimension(2, 5));
		jScrollPane1.setViewportView(jTable1);

		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2Layout.setHorizontalGroup(
			jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 1216, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jPanel2Layout.setVerticalGroup(
			jPanel2Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, jPanel2Layout.createSequentialGroup()
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(228, Short.MAX_VALUE))
		);
		jPanel2.setLayout(jPanel2Layout);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 250, 240));
		
		label = new JLabel("MyClubs");
		label.setForeground(SystemColor.controlDkShadow);
		label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		label.setBounds(69, 11, 96, 19);
		panel.add(label);
		
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

		GroupLayout layout = new GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 1228, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1238, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 1218, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
					.addContainerGap(936, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addGap(170))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(69)
					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(168, Short.MAX_VALUE))
		);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton3ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		// TODO add your handling code here:
		new EventIndividual().setVisible(true);
		// setVisible(true);
		dispose();

	}// GEN-LAST:event_jButton3ActionPerformed

	private void jButton1ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
		new EventFrame();
		dispose();
	}// GEN-LAST:event_jButton1ActionPerformed

	private void jTextField1ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField1ActionPerformed

	private void jTextField1KeyReleased(KeyEvent evt) {// GEN-FIRST:event_jTextField1KeyReleased
		// TODO add your handling code here:
		try {

			String sql = "select* from event where id = ? ";

			pst = conn.prepareStatement(sql);
			pst.setString(1, jTextField1.getText());
			rs = pst.executeQuery();
			jTable1.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {

			try {

				rs.close();
				pst.close();

			} catch (Exception e) {

			}
		}

	}// GEN-LAST:event_jTextField1KeyReleased

	private void jButton2ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		// TODO add your handling code here:
		updatetable();
		jTextField1.setText("");
	}// GEN-LAST:event_jButton2ActionPerformed

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(EventView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(EventView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(EventView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(EventView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>

		/* Create and display the form */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new EventView().setVisible(true);

			}
		});
	}

}
