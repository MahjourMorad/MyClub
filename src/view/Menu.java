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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * @author MAHJOUR MORAD
 * @author LAMYAA RAKIK*/
public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 250, 240));
		panel.setBounds(184, 0, 633, 47);
		contentPane.add(panel);
		
		JLabel label = new JLabel("MyClubs");
		label.setForeground(SystemColor.controlDkShadow);
		label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		label.setBounds(69, 11, 96, 19);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(SystemColor.controlDkShadow);
		panel_1.setBounds(184, 46, 633, 37);
		contentPane.add(panel_1);
		
		JLabel lblMenuPrincipal = new JLabel("Menu principal");
		lblMenuPrincipal.setForeground(new Color(255, 250, 240));
		lblMenuPrincipal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMenuPrincipal.setBackground(SystemColor.controlDkShadow);
		lblMenuPrincipal.setBounds(116, 11, 129, 15);
		panel_1.add(lblMenuPrincipal);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(SystemColor.controlDkShadow);
		panel_2.setBounds(0, 0, 183, 447);
		contentPane.add(panel_2);
		
		JButton button = new JButton("Acceuil");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {Menu m=new Menu();
			m.setVisible(true);
			dispose();
			
			}
		});
		button.setForeground(new Color(255, 250, 240));
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBackground(SystemColor.controlDkShadow);
		button.setBounds(0, 88, 183, 46);
		panel_2.add(button);
		
		JButton button_1 = new JButton("Afficher Membre");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MembreIndividual().setVisible(true);
				dispose();
			}
		});
		button_1.setForeground(new Color(255, 250, 240));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBackground(SystemColor.controlDkShadow);
		button_1.setBounds(0, 134, 183, 46);
		panel_2.add(button_1);
		
		JButton button_2 = new JButton("gestion membre");
		button_2.setForeground(new Color(255, 250, 240));
		button_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_2.setBackground(SystemColor.controlDkShadow);
		button_2.setBounds(0, 180, 183, 46);
		panel_2.add(button_2);
		
		JButton button_3 = new JButton("Evenements");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EventView().setVisible(true); 
				dispose();
			}
		});
		button_3.setForeground(new Color(255, 250, 240));
		button_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_3.setBackground(SystemColor.controlDkShadow);
		button_3.setBounds(0, 226, 183, 46);
		panel_2.add(button_3);
		
		JButton button_4 = new JButton("Projets");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProjetView().setVisible(true);
				dispose();
			}
		});
		button_4.setForeground(new Color(255, 250, 240));
		button_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_4.setBackground(SystemColor.controlDkShadow);
		button_4.setBounds(0, 272, 183, 46);
		panel_2.add(button_4);
		
		JButton button_5 = new JButton("Tr\u00E9sorerie");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Comtabilite().setVisible(true);
				dispose();
			}
		});
		button_5.setForeground(new Color(255, 250, 240));
		button_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_5.setBackground(SystemColor.controlDkShadow);
		button_5.setBounds(0, 317, 183, 46);
		panel_2.add(button_5);
		
		JLabel label_2 = new JLabel("Membre");
		label_2.setForeground(new Color(255, 250, 250));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(64, 45, 46, 14);
		panel_2.add(label_2);
		
		JLabel lblBonjourSelectionner = new JLabel("Bonjour , selectionner l'un des choix suivant");
		lblBonjourSelectionner.setBounds(323, 94, 310, 47);
		contentPane.add(lblBonjourSelectionner);
		
		JButton btnConsulterMe = new JButton("Consulter Membre");
		btnConsulterMe.setBackground(new Color(105, 105, 105));
		btnConsulterMe.setForeground(new Color(255, 250, 240));
		btnConsulterMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MembreViewUser().setVisible(true);
				dispose();
			}
		});
		btnConsulterMe.setBounds(292, 183, 145, 47);
		contentPane.add(btnConsulterMe);
		
		JButton btnConsulterEvenement = new JButton("Consulter evenement");
		btnConsulterEvenement.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {new EventViewUser().setVisible(true);
			dispose();
			}
		});
		btnConsulterEvenement.setForeground(new Color(255, 250, 240));
		btnConsulterEvenement.setBackground(new Color(105, 105, 105));
		btnConsulterEvenement.setBounds(488, 183, 145, 47);
		contentPane.add(btnConsulterEvenement);
		
		JButton btnConsulterProjet = new JButton("Consulter projet");
		btnConsulterProjet.setForeground(new Color(255, 250, 240));
		btnConsulterProjet.setBackground(new Color(105, 105, 105));
		btnConsulterProjet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProjetViewUser().setVisible(true);
				dispose();
			}
		});
		btnConsulterProjet.setBounds(292, 272, 145, 47);
		contentPane.add(btnConsulterProjet);
		
		JButton btnConsulterTresorerie = new JButton("Consulter tresorerie");
		btnConsulterTresorerie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Comtabilite c=new Comtabilite();
				c.setVisible(true);
                dispose();
			}
		});
		btnConsulterTresorerie.setForeground(new Color(255, 250, 240));
		btnConsulterTresorerie.setBackground(new Color(105, 105, 105));
		btnConsulterTresorerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Comtabilite().setVisible(true);
				dispose();
				
			}
		});
		btnConsulterTresorerie.setBounds(488, 272, 145, 47);
		contentPane.add(btnConsulterTresorerie);
		
		JButton btnNewButton = new JButton("Se deconnecter");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {new smslog().setVisible(true);
			dispose();
			}
		});
		btnNewButton.setBackground(new Color(105, 105, 105));
		btnNewButton.setForeground(new Color(255, 250, 240));
		btnNewButton.setBounds(519, 372, 188, 47);
		contentPane.add(btnNewButton);
	}
}
