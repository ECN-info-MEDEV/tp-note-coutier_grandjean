/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.tp_coutier_grandjean;

import java.util.ArrayList;
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
     * Test de initialisationPlateau, de la classe Plateau.
     */
    @Test
    public void testInitialisationPlateau() {
        Plateau p = new Plateau();
        int i;
        int j;
        p.initialisationPlateau();
        
        //Les listes ne sont plus vides
        assertFalse(p.getListeMarqueurs().isEmpty());
        assertFalse(p.getListePions().isEmpty());
        
        //Les listes ont des tailles 12*4
        assertEquals(p.getListeMarqueurs().size(),12);
        assertEquals(p.getListePions().size(),12);
        for (i=0;i<12;i++){
            assertEquals(p.getListeMarqueurs().get(i).size(),4);
            assertEquals(p.getListePions().get(i).size(),4);
        }
        
        //Les listes contiennent des points
        for (i=0;i<12;i++){
            for (j=0;j<4;j++){
                assertEquals(p.getListePions().get(i).get(j),".");
            }
        }
    }

    /**
     * Test de nettoyerPlateau, de la classe Plateau.
     */
    @Test
    public void testNettoyerPlateau() {
        
        int i;
        int j;
        List<String> listeP ;
        List<String> listeM ;
  
        Plateau p1 = new Plateau();
        Plateau p2 = new Plateau();
        p1.initialisationPlateau();
   
        for(i=0; i<20; i++){
            listeP = new ArrayList<>();
            listeM = new ArrayList<>();
            for (j=0; j<6; j++){
                listeP.add("A");
                listeM.add("A");
            } 
            p2.getListePions().add(listeP);
            p2.getListeMarqueurs().add(listeM);
        }
        
        p2.nettoyerPlateau();
            
        //les listes de p2 ont des tailles 12*4
        assertEquals(p2.getListeMarqueurs().size(),12);
        assertEquals(p2.getListePions().size(),12);
        for (i=0;i<12;i++){
            assertEquals(p2.getListeMarqueurs().get(i).size(),4);
            assertEquals(p2.getListePions().get(i).size(),4);
        }
        
        //les listes de p2 sont constitués de points
        for (i=0;i<12;i++){
            for (j=0;j<4;j++){
                assertEquals(p1.getListePions().get(i).get(j),p2.getListePions().get(i).get(j));
                assertEquals(p1.getListeMarqueurs().get(i).get(j),p2.getListeMarqueurs().get(i).get(j));
            }
            
        }
        
    }

    
}
