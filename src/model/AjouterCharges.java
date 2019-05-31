package model;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.ComptabiliteAdmin;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author MAHJOUR MORAD
 * @author LAMYAA RAKIK*/

public class AjouterCharges extends JDialog {
    /**
     * */
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	static final String DB_URL = "jdbc:mysql://localhost/student";
	static final String USER = "root";
	static final String PASS = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AjouterCharges dialog = new AjouterCharges();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * pour ajouter des charges dans la db  pas d'argument pas de retours
	 */
	public AjouterCharges() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBackground(new Color(255, 250, 240));
			panel.setBounds(0, 0, 434, 37);
			contentPanel.add(panel);
			{
				JLabel label = new JLabel("MyClubs");
				label.setForeground(SystemColor.controlDkShadow);
				label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
				label.setBounds(69, 11, 96, 19);
				panel.add(label);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBackground(SystemColor.controlDkShadow);
			panel.setBounds(0, 38, 434, 37);
			contentPanel.add(panel);
			{
				JLabel lblAjouterCharge = new JLabel("Ajouter Charge");
				lblAjouterCharge.setForeground(new Color(255, 250, 240));
				lblAjouterCharge.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblAjouterCharge.setBackground(SystemColor.controlDkShadow);
				lblAjouterCharge.setBounds(116, 11, 129, 15);
				panel.add(lblAjouterCharge);
			}
		}
		{
			JLabel lblNewLabel = new JLabel("Charge");
			lblNewLabel.setForeground(new Color(105, 105, 105));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel.setBounds(25, 86, 61, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setBounds(118, 86, 86, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Montant");
			lblNewLabel_1.setForeground(new Color(105, 105, 105));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_1.setBounds(25, 137, 61, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(118, 134, 86, 20);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Ajouter");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {Connection conn = null;
					Statement stmt = null;
					String s1 = textField.getText();
					String s2 = textField_1.getText();
					

					if (textField.getText().equals("") ||textField_1.getText().equals("") ) {
						JOptionPane.showMessageDialog(okButton, "All record Must be fill Out");
					} else {
						try {

							conn = DriverManager.getConnection(DB_URL, USER, PASS);
							System.out.println("every thing is ok in connection");
							JOptionPane.showConfirmDialog(null, "Are you sure Insert Data?", "Delete",
									JOptionPane.YES_NO_OPTION);
							PreparedStatement ps = conn.prepareStatement(
									"INSERT INTO charges(Charge,Montant)"
											+ "VALUES(?,?)");
							System.out.println("ok in prepared statement");
						
							ps.setString(1, s1);
							ps.setString(2, s2);
							
						
							ps.executeUpdate();
							System.out.println("ok while execute ");
							JOptionPane.showMessageDialog(okButton, "sucessfully inserted Data");
							textField.setText("");
							textField_1.setText("");
							

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
					}});
				okButton.setForeground(new Color(255, 250, 240));
				okButton.setBackground(new Color(105, 105, 105));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						ComptabiliteAdmin ca=new ComptabiliteAdmin();
						ca.setVisible(true);
		                dispose();
					}
				});
				cancelButton.setBackground(new Color(105, 105, 105));
				cancelButton.setForeground(new Color(255, 250, 240));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
