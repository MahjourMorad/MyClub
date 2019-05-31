package view;
import appli.*;
import model.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import appli.smslog;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdmin frame = new MenuAdmin();
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
	public MenuAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 717, 430);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 250, 240));
		panel_1.setBounds(184, 0, 664, 47);
		panel.add(panel_1);
		
		JLabel label = new JLabel("MyClubs");
		label.setForeground(SystemColor.controlDkShadow);
		label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		label.setBounds(69, 11, 96, 19);
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(SystemColor.controlDkShadow);
		panel_2.setBounds(184, 46, 623, 37);
		panel.add(panel_2);
		
		JLabel label_1 = new JLabel("Menu principal");
		label_1.setForeground(new Color(255, 250, 240));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBackground(SystemColor.controlDkShadow);
		label_1.setBounds(116, 11, 129, 15);
		panel_2.add(label_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(SystemColor.controlDkShadow);
		panel_3.setBounds(0, 0, 183, 447);
		panel.add(panel_3);
		
		JButton button = new JButton("Acceuil");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuAdmin m=new MenuAdmin();
				m.setVisible(true);
				dispose();
				
			}
		});
		button.setForeground(new Color(255, 250, 240));
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBackground(SystemColor.controlDkShadow);
		button.setBounds(0, 88, 183, 46);
		panel_3.add(button);
		
		JButton button_1 = new JButton("Afficher Membre");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MembreView().setVisible(true);
				dispose();
			}
		});
		button_1.setForeground(new Color(255, 250, 240));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBackground(SystemColor.controlDkShadow);
		button_1.setBounds(0, 134, 183, 46);
		panel_3.add(button_1);
		
		JButton button_2 = new JButton("gestion membre");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MembreIndividual().setVisible(true);
				dispose();
			}
		});
		button_2.setForeground(new Color(255, 250, 240));
		button_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_2.setBackground(SystemColor.controlDkShadow);
		button_2.setBounds(0, 180, 183, 46);
		panel_3.add(button_2);
		
		JButton button_3 = new JButton("Evenements");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EventIndividual().setVisible(true);
				dispose();
			}
		});
		button_3.setForeground(new Color(255, 250, 240));
		button_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_3.setBackground(SystemColor.controlDkShadow);
		button_3.setBounds(0, 226, 183, 46);
		panel_3.add(button_3);
		
		JButton button_4 = new JButton("Projets");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProjectFrame().setVisible(true);
				dispose();
			}
		});
		button_4.setForeground(new Color(255, 250, 240));
		button_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_4.setBackground(SystemColor.controlDkShadow);
		button_4.setBounds(0, 272, 183, 46);
		panel_3.add(button_4);
		
		JButton button_5 = new JButton("Tr\u00E9sorerie");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ComptabiliteAdmin().setVisible(true);
				dispose();
			}
		});
		button_5.setForeground(new Color(255, 250, 240));
		button_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_5.setBackground(SystemColor.controlDkShadow);
		button_5.setBounds(0, 317, 183, 46);
		panel_3.add(button_5);
		
		JLabel lblAdmin = new JLabel("admin");
		lblAdmin.setForeground(new Color(255, 250, 250));
		lblAdmin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAdmin.setBounds(64, 45, 46, 14);
		panel_3.add(lblAdmin);
		
		JLabel label_3 = new JLabel("Bonjour , selectionner l'un des choix suivant");
		label_3.setBounds(323, 94, 310, 47);
		panel.add(label_3);
		
		JButton btnMembre = new JButton(" Membre");
		btnMembre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMembre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MembreView().setVisible(true);
				dispose();
			}
		});
		btnMembre.setForeground(new Color(255, 250, 240));
		btnMembre.setBackground(SystemColor.controlDkShadow);
		btnMembre.setBounds(292, 183, 145, 47);
		panel.add(btnMembre);
		
		JButton btnEvenement = new JButton("evenement");
		btnEvenement.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 new EventView().setVisible(true);
				 dispose();
			}
		});
		btnEvenement.setForeground(new Color(255, 250, 240));
		btnEvenement.setBackground(SystemColor.controlDkShadow);
		btnEvenement.setBounds(488, 183, 145, 47);
		panel.add(btnEvenement);
		
		JButton btnProjet = new JButton(" projet");
		btnProjet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ProjetView().setVisible(true);
				dispose();
			}
		});
		btnProjet.setForeground(new Color(255, 250, 240));
		btnProjet.setBackground(SystemColor.controlDkShadow);
		btnProjet.setBounds(292, 272, 145, 47);
		panel.add(btnProjet);
		
		JButton btnTresorerie = new JButton(" tresorerie");
		btnTresorerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTresorerie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ComptabiliteAdmin us=new ComptabiliteAdmin();
				us.setVisible(true);
                dispose();
			}
		});
		btnTresorerie.setForeground(new Color(255, 250, 240));
		btnTresorerie.setBackground(SystemColor.controlDkShadow);
		btnTresorerie.setBounds(488, 272, 145, 47);
		panel.add(btnTresorerie);
		
		JButton btnSeDeconnecter = new JButton("se deconnecter");
		btnSeDeconnecter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {new smslog().setVisible(true);
			dispose();
			}
		});
		btnSeDeconnecter.setBackground(new Color(105, 105, 105));
		btnSeDeconnecter.setForeground(new Color(255, 250, 240));
		btnSeDeconnecter.setBounds(504, 382, 117, 37);
		panel.add(btnSeDeconnecter);
	}

}
