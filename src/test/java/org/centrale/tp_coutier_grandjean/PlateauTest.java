/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.tp_coutier_grandjean;

import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Manon Coutier
 */
public class PlateauTest {
    
    public PlateauTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    

    /**
     * Test of initialisationPlateau method, of class Plateau.
     */
    @Test
    public void testInitialisationPlateau() {
        System.out.println("initialisationPlateau");
        Plateau instance = new Plateau();
        instance.initialisationPlateau();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nettoyerPlateau method, of class Plateau.
     */
    @Test
    public void testNettoyerPlateau() {
        System.out.println("nettoyerPlateau");
        Plateau instance = new Plateau();
        instance.nettoyerPlateau();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of affichePlateau method, of class Plateau.
     */
    @Test
    public void testAffichePlateau() {
        System.out.println("affichePlateau");
        Plateau instance = new Plateau();
        instance.affichePlateau();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of choixPions method, of class Plateau.
     */
    @Test
    public void testChoixPions() {
        System.out.println("choixPions");
        Scanner scan = null;
        Plateau instance = new Plateau();
        List<String> expResult = null;
        List<String> result = instance.choixPions(scan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of choixCode method, of class Plateau.
     */
    @Test
    public void testChoixCode() {
        System.out.println("choixCode");
        Scanner scan = null;
        Plateau instance = new Plateau();
        instance.choixCode(scan);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of choixCombinaison method, of class Plateau.
     */
    @Test
    public void testChoixCombinaison() {
        System.out.println("choixCombinaison");
        Scanner scan = null;
        Plateau instance = new Plateau();
        instance.choixCombinaison(scan);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verifCombinaison method, of class Plateau.
     */
    @Test
    public void testVerifCombinaison() {
        System.out.println("verifCombinaison");
        Scanner scan = null;
        Plateau instance = new Plateau();
        boolean expResult = false;
        boolean result = instance.verifCombinaison(scan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
