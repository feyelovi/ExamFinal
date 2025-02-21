package com.examenFinal.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;

public class FenetrePrincipale extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnAJouter;
	private JButton btnAffEnclos;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JButton btnAffAnimaux;
	
	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}

	public JButton getBtnAJouter() {
		return btnAJouter;
	}

	public void setBtnAJouter(JButton btnAJouter) {
		this.btnAJouter = btnAJouter;
	}

	public JButton getBtnAffEnclos() {
		return btnAffEnclos;
	}

	public void setBtnAffEnclos(JButton btnAffEnclos) {
		this.btnAffEnclos = btnAffEnclos;
	}

	public JButton getBtnModifier() {
		return btnModifier;
	}

	public void setBtnModifier(JButton btnModifier) {
		this.btnModifier = btnModifier;
	}

	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}

	public void setBtnSupprimer(JButton btnSupprimer) {
		this.btnSupprimer = btnSupprimer;
	}

	public JButton getBtnAffAnimaux() {
		return btnAffAnimaux;
	}

	public void setBtnAffAnimaux(JButton btnAffAnimaux) {
		this.btnAffAnimaux = btnAffAnimaux;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	private JTable table;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public FenetrePrincipale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 634, 445);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion Des Animaux");
		lblNewLabel.setBounds(169, 11, 131, 14);
		panel.add(lblNewLabel);
		
		JLabel lbl_nom = new JLabel("Nom");
		lbl_nom.setBounds(10, 41, 46, 14);
		panel.add(lbl_nom);
		
		JLabel lbl_espece = new JLabel("Espece");
		lbl_espece.setBounds(10, 80, 46, 14);
		panel.add(lbl_espece);
		
		JLabel lbl_age = new JLabel("Age");
		lbl_age.setBounds(10, 124, 46, 14);
		panel.add(lbl_age);
		
		JLabel lbl_regime = new JLabel("Regime ");
		lbl_regime.setBounds(10, 169, 46, 14);
		panel.add(lbl_regime);
		
		textField = new JTextField();
		textField.setBounds(66, 38, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(66, 77, 86, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(66, 121, 86, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(66, 166, 86, 20);
		panel.add(textField_3);
		
		JLabel lbl_list = new JLabel("Liste");
		lbl_list.setBounds(289, 225, 46, 14);
		panel.add(lbl_list);
		
		table = new JTable();
		table.setBounds(32, 250, 592, 184);
		panel.add(table);
		
		btnAJouter = new JButton("Ajouter");
		btnAJouter.setBounds(221, 160, 89, 23);
		panel.add(btnAJouter);
		
		btnAffEnclos = new JButton("Aff Enclos");
		btnAffEnclos.setBounds(461, 37, 89, 23);
		panel.add(btnAffEnclos);
		
		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(221, 41, 89, 23);
		panel.add(btnModifier);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(221, 94, 89, 23);
		panel.add(btnSupprimer);
		
		btnAffAnimaux = new JButton("Aff Animaux");
		btnAffAnimaux.setBounds(461, 94, 89, 23);
		panel.add(btnAffAnimaux);
		
	}
	private void ouvrirFenetre(JPanel panel, String titre) {
        JFrame frame = new JFrame(titre);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetrePrincipale frame = new FenetrePrincipale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}*/

