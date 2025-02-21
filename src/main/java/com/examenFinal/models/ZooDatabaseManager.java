package com.examenFinal.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ZooDatabaseManager implements IZooDataAccess{
	private static ZooDatabaseManager instance;
    private Connection connection;
    private static final String URL = "jdbc:sqlite:zoo.db";

    // Constructeur privé (Singleton)
    private ZooDatabaseManager() {
        try {
            

            // Connexion à la base de données
            this.connection = DriverManager.getConnection(URL);
            System.out.println(" Connexion réussie à SQLite !");

            // Création des tables si elles n'existent pas
            try (Statement stmt = connection.createStatement()) {
                stmt.execute("CREATE TABLE IF NOT EXISTS Animal (id INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT, espece TEXT, age INTEGER,regimeAlimentaire TEXT)");
               // stmt.execute("CREATE TABLE IF NOT EXISTS Membre (id INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT, email TEXT)");
               // stmt.execute("CREATE TABLE IF NOT EXISTS Emprunt (id INTEGER PRIMARY KEY AUTOINCREMENT, livreId INTEGER, membreId INTEGER, dateEmprunt TEXT, dateRetour TEXT, FOREIGN KEY(livreId) REFERENCES Livre(id), FOREIGN KEY(membreId) REFERENCES Membre(id))");
            }
        
        } catch (SQLException e) {
            System.err.println(" Erreur de connexion à SQLite !");
            e.printStackTrace();
            System.exit(1);
        }
    }

    // Méthode pour obtenir l'instance unique (Singleton)
    public static ZooDatabaseManager getInstance() {
        if (instance == null) {
            instance = new ZooDatabaseManager();
        }
        return instance;
    }

    // === GESTION DES LIVRES ===
    @Override
    public void ajouterAnimal(Animal animal) {
        String sql = "INSERT INTO Animal (nom, espece, age,regimeAlimentaire) VALUES (?, ?, ?,?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, animal.getNom());
            pstmt.setString(2, animal.getEspece());
            pstmt.setInt(3, animal.getAge());
            pstmt.setString(4, animal.getRegimeAlimentaire());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerAnimal(int id) {
        String sql = "DELETE FROM Animal WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Animal> getTousLesAnimaux() {
        List<Animal> animaux = new ArrayList<>();
        String sql = "SELECT * FROM Animal";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                animaux.add(new Animal(rs.getInt("id"), rs.getString("nom"), rs.getString("espece"), rs.getInt("age"), rs.getString("regimeAlimentaire")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animaux;
    }

    @Override
	public void modifierAnimal(Animal animal) {
		String sql = "UPDATE Animal set nom = ? espece = ? age = ? regimeAlimentaire = ? WHERE id = ?";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, animal.getNom());
            pstmt.setString(2, animal.getEspece());
            pstmt.setInt(3, animal.getAge());
            pstmt.setString(4, animal.getRegimeAlimentaire());
            pstmt.setInt(5, animal.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

    

   

    // === MÉTHODES UTILITAIRES POUR RÉCUPÉRER UN LIVRE OU UN MEMBRE PAR ID ===
    public Animal getLivreById(int id) {
        String sql = "SELECT * FROM Animal WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Animal(rs.getInt("id"), rs.getString("nom"), rs.getString("espece"), rs.getInt("age"), rs.getString("regimeAlimentaire"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    

    // === MÉTHODE POUR FERMER LA CONNEXION À LA BASE DE DONNÉES ===
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("🔌 Connexion SQLite fermée.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	
}
