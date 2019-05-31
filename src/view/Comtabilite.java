package view;
import appli.*;
import model.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Comtabilite extends JFrame {

	private JPanel contentPane;
	private JTextField textField_charges;
	private JTextField textField_produit;
	private JTextField textField_result;
	private JTable table_charges;
	private JTable table_produit;
	private static final long serialVersionUID = 1L;
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	String sql;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Comtabilite frame = new Comtabilite();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private void updatetableProduit() {
		try {

			String sql = "select Produits,Montant from produit";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			table_produit.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {

			try {
				rs.close();
				pst.close();

			} catch (Exception e) {

			}
		}
	}
	private void updatetableCharges() {
		try {

			String sql = "select Charge,Montant from charges";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			table_charges.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {

			try {
				rs.close();
				pst.close();

			} catch (Exception e) {

			}
		}
	}
	public Comtabilite() {
		conn = dbconnect.java_db();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\admin\\Desktop\\Downloads\\hackathon2.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(184, 0, 633, 47);
		panel.setBackground(new Color(255, 250, 240));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("MyClubs");
		label.setBounds(69, 11, 96, 19);
		label.setForeground(SystemColor.controlDkShadow);
		label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(184, 46, 633, 37);
		panel_1.setBackground(new Color(105, 105, 105));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblComptabilit = new JLabel("Comptabilit\u00E9");
		lblComptabilit.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblComptabilit.setForeground(new Color(255, 250, 240));
		lblComptabilit.setBackground(new Color(105, 105, 105));
		lblComptabilit.setBounds(116, 11, 129, 15);
		panel_1.add(lblComptabilit);
		
		JButton btnNewButton = new JButton("Total Produits");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String sql = "select SUM(Montant) from produit  ";

					pst = conn.prepareStatement(sql);
					rs = pst.executeQuery();
					while (rs.next()) {

						String add1 = rs.getString("SUM(Montant)");
						textField_produit.setText(add1);}
			} catch (Exception es) {

			} finally {

				try {

					rs.close();
					pst.close();

				} catch (Exception ec) {

				}}
				
			}
		});
		btnNewButton.setBounds(515, 326, 114, 23);
		btnNewButton.setBackground(new Color(105, 105, 105));
		btnNewButton.setForeground(new Color(255, 250, 240));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Total Charges");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String sql = "select SUM(Montant) from charges  ";

					pst = conn.prepareStatement(sql);
					rs = pst.executeQuery();
					while (rs.next()) {

						String add1 = rs.getString("SUM(Montant)");
						textField_charges.setText(add1);}
			} catch (Exception es) {

			} finally {

				try {

					rs.close();
					pst.close();

				} catch (Exception ec) {

				}}
			}}
		);
		btnNewButton_1.setBounds(232, 326, 129, 23);
		btnNewButton_1.setForeground(new Color(255, 250, 240));
		btnNewButton_1.setBackground(new Color(105, 105, 105));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton_1);
		
		textField_charges = new JTextField();
		textField_charges.setBounds(381, 326, 107, 20);
		contentPane.add(textField_charges);
		textField_charges.setColumns(10);
		
		textField_produit = new JTextField();
		textField_produit.setBounds(662, 326, 99, 20);
		contentPane.add(textField_produit);
		textField_produit.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Resultat");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String sql = "select(select sum(Montant) from produit)-(select sum(Montant) from charges) from produit "
							;

					pst = conn.prepareStatement(sql);
					rs = pst.executeQuery();
					while (rs.next()) {

						String add1 = rs.getString("(select sum(Montant) from produit)-(select sum(Montant) from charges)");
						textField_result.setText(add1);}
			} catch (Exception es) {

			} finally {

				try {

					rs.close();
					pst.close();

				} catch (Exception ec) {

				}}
			}
		});
		btnNewButton_2.setBounds(515, 377, 107, 23);
		btnNewButton_2.setForeground(new Color(255, 250, 240));
		btnNewButton_2.setBackground(new Color(105, 105, 105));
		contentPane.add(btnNewButton_2);
		
		textField_result = new JTextField();
		textField_result.setBounds(664, 378, 109, 20);
		contentPane.add(textField_result);
		textField_result.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 183, 447);
		panel_2.setBackground(new Color(105, 105, 105));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnAcceuil = new JButton("Acceuil");
		btnAcceuil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAcceuil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {Menu m=new Menu();
			m.setVisible(true);
			dispose();
			
			}
		});
		btnAcceuil.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAcceuil.setForeground(new Color(255, 250, 240));
		btnAcceuil.setBackground(new Color(105, 105, 105));
		btnAcceuil.setBounds(0, 88, 183, 46);
		panel_2.add(btnAcceuil);
		
		JButton btnAfficherMembre = new JButton("Afficher Membre");
		btnAfficherMembre.setForeground(new Color(255, 250, 240));
		btnAfficherMembre.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAfficherMembre.setBackground(SystemColor.controlDkShadow);
		btnAfficherMembre.setBounds(0, 134, 183, 46);
		panel_2.add(btnAfficherMembre);
		
		JButton btnGestionMembre = new JButton("gestion membre");
		btnGestionMembre.setForeground(new Color(255, 250, 240));
		btnGestionMembre.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGestionMembre.setBackground(SystemColor.controlDkShadow);
		btnGestionMembre.setBounds(0, 180, 183, 46);
		panel_2.add(btnGestionMembre);
		
		JButton btnEvenements = new JButton("Evenements");
		btnEvenements.setForeground(new Color(255, 250, 240));
		btnEvenements.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEvenements.setBackground(SystemColor.controlDkShadow);
		btnEvenements.setBounds(0, 226, 183, 46);
		panel_2.add(btnEvenements);
		
		JButton btnProjets = new JButton("Projets");
		btnProjets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProjets.setForeground(new Color(255, 250, 240));
		btnProjets.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnProjets.setBackground(SystemColor.controlDkShadow);
		btnProjets.setBounds(0, 272, 183, 46);
		panel_2.add(btnProjets);
		
		JButton btnTrsorerie = new JButton("Tr\u00E9sorerie");
		btnTrsorerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Comtabilite().setVisible(true);
				dispose();
			}
		});
		btnTrsorerie.setForeground(new Color(255, 250, 240));
		btnTrsorerie.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTrsorerie.setBackground(SystemColor.controlDkShadow);
		btnTrsorerie.setBounds(0, 317, 183, 46);
		panel_2.add(btnTrsorerie);
		
		JLabel lblMembre = new JLabel("Membre");
		lblMembre.setForeground(new Color(255, 250, 250));
		lblMembre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMembre.setBounds(64, 45, 46, 14);
		panel_2.add(lblMembre);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(235, 128, 253, 187);
		contentPane.add(scrollPane);
		
		table_charges = new JTable();
		table_charges.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Charges", "Montant"
			}
		));
		scrollPane.setViewportView(table_charges);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(536, 128, 253, 187);
		contentPane.add(scrollPane_1);
		
		table_produit = new JTable();
		table_produit.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Produit", "Montant"
			}
		));
		scrollPane_1.setViewportView(table_produit);
		updatetableCharges();
		updatetableProduit();
		
	}}

