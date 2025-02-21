package com.examenFinal.controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import com.examenFinal.models.Animal;
import com.examenFinal.models.ZooDatabaseManager;
import com.examenFinal.view.FenetrePrincipale;






public class ZooService {

	private final ZooDatabaseManager zooDatabaseManager;
    private FenetrePrincipale viewPrincipal;
    public ZooService() {
        this.zooDatabaseManager = ZooDatabaseManager.getInstance();
       this.viewPrincipal = new FenetrePrincipale();
        
        viewPrincipal.getBtnAJouter().addActionListener(e -> ajouterAnimal(viewPrincipal.getTextField().getText(),viewPrincipal.getTextField_1().getText() , Integer.parseInt(viewPrincipal.getTextField_2().getText()),viewPrincipal.getTextField_3().getText()));
        viewPrincipal.getBtnSupprimer().addActionListener(e -> supprimerAnimal());
        viewPrincipal.getBtnModifier().addActionListener(e -> modifierAnimal(1,viewPrincipal.getTextField().getText(),viewPrincipal.getTextField_1().getText() , Integer.parseInt(viewPrincipal.getTextField_2().getText()),viewPrincipal.getTextField_3().getText()));
        viewPrincipal.getBtnAffAnimaux().addActionListener(e -> refreshTable());
        refreshTable();
        //viewPrincipal.getBtnActualiser().addActionListener(e -> refreshTable());
    }

	
	// === GESTION DES LIVRES ===
    public void ajouterAnimal(String nom, String espece,int age, String regimeAlimentaire) {
    	Animal animal = new Animal(0, nom, espece, age,regimeAlimentaire);
        zooDatabaseManager.ajouterAnimal(animal);
        System.out.println("Animal ajouté avec succès !");
       refreshTable();
    }
    public void modifierAnimal(int id,String nom, String espece,int age, String regimeAlimentaire) {
    	Animal animal = new Animal(id, nom, espece, age,regimeAlimentaire);
        zooDatabaseManager.modifierAnimal(animal);
        System.out.println("Animal modifie avec succès !");
       refreshTable();
    }

    public void supprimerAnimal() {
    	int selectedRow = viewPrincipal.getTable().getSelectedRow();
        if (selectedRow != -1) {
            int id1 = Integer.parseInt(viewPrincipal.getTable().getValueAt(selectedRow, 0).toString()) ;
           
            zooDatabaseManager.supprimerAnimal(id1);
            JOptionPane.showMessageDialog(null, "Animal supprimé avec succès !");
          
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner un animal à supprimer.");
        }
        
        
        refreshTable();
    }

    public List<Animal> listerAnimal() {
        return zooDatabaseManager.getTousLesAnimaux();
    }
    public FenetrePrincipale getView() {
    	return viewPrincipal;
    }
    public void refreshTable() {
        updateTable(listerAnimal());
    }
    private void updateTable(List<Animal> listAnimaux) {
        String[] columnNames = {"ID", "NOM", "ESPECE", "AGE","REGIMEALIMENTAIRE"};
        String[][] data = new String[listerAnimal().size()][5];
        for (int i = 0; i < listerAnimal().size(); i++) {
            Animal animal = listerAnimal().get(i);
            data[i][0] = String.valueOf(animal.getId());
            data[i][1] = animal.getNom();
            data[i][2] = animal.getEspece();
            data[i][3] = String.valueOf(animal.getAge());
            data[i][4] = animal.getRegimeAlimentaire();
            
            
        }
        viewPrincipal.getTable().setModel(new DefaultTableModel(data, columnNames));
    }
}
