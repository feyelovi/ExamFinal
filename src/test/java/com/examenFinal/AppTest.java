package com.examenFinal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.examenFinal.controller.ZooService;
import com.examenFinal.models.Animal;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import tpjava2.models.Book;
import tpjava2.models.BookDao;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	
        
            ZooService service = new ZooService();
            Animal animal = new Animal(0, "Test Book", "ISBN123",  1, "ISBN123");
            
            // Create
            service.ajouterAnimal(animal.getNom(),animal.getEspece(),animal.getAge(),animal.getRegimeAlimentaire());
            assertNotNull(animal.getAge());
            service.supprimerAnimal();
            
        
    }
}
