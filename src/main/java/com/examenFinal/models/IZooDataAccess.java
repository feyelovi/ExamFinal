package com.examenFinal.models;

import java.util.List;

public interface IZooDataAccess {
	void ajouterAnimal(Animal animal);
    void supprimerAnimal(int id);
    List<Animal> getTousLesAnimaux();
    void modifierAnimal(Animal animal);

}
