/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.tp_coutier_grandjean;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe destinée à la gestion du plateau de jeu
 * @author Manon Coutier
 */
public class Plateau {
    
    //ATTRIBUTS
    /**
     * largeur du plateau de pions
     */
    private static final int LARGEURPIONS = 4;
    /**
     * largeur du plateau de marqueur
     */
    private static final int LARGEURMARQUEURS = 2;
    /**
     * hauteur globale du plateau
     */
    private static final int HAUTEUR = 12;
    /**
     * liste des Pions joués par le décodeur
     */
    private List<List<String>> listePions;
    /**
     * liste des Pions joués par le codeur
     */
    private List<List<String>> listeMarqueurs;
    /**
     * code choisi par le codeur
     */
    private List<String> code;
    
    //CONSTRUCTEURS
    /**
     * Constructeur par défaut
     */
    public Plateau(){
        
        listePions= new ArrayList<>();
        listeMarqueurs = new ArrayList<>();
        code=new ArrayList<>();
        
    }
    
    //AUTRES METHODES
    /**
     * Initialisation des deux listes constituant le plateau
     */
    public void initialisationPlateau(){
        List<String> listeP ;
        List<String> listeM ;
   
        for (int i=0; i<HAUTEUR; i++){
            listeP = new ArrayList<>();
            for (int j=0; j<LARGEURPIONS; j++){
                listeP.add(".");
            } 
            this.listePions.add(listeP);
        }
        for (int i=0; i<HAUTEUR; i++){
            listeM = new ArrayList<>();
            for (int j=0; j<LARGEURMARQUEURS; j++){
                listeM.add(".");
            } 
            this.listeMarqueurs.add(listeM);
        }   
    }
    
    /**
     * Remet à zéro le plateau pour débuter immédiatement 
     */
    public void nettoyerPlateau(){
        this.listeMarqueurs.clear();
        this.listePions.clear();
        this.code.clear();
        
        this.initialisationPlateau();
    }
    
    /**
     * Affiche le plateau et la légende.
     */
    public void affichePlateau(){
        
        int i;
        int j;
        int k;
        
        //Affichage de la légende
        System.out.println("Légende des pions : J = jaune, b = bleu, R = rouge, V = vert, B = blanc, N = noir" );
        System.out.println("Légende des marqueurs : o = petit marqueur blanc, x = petit marqueur noir" );
        
        //Affichage du plateau
        for (i=0; i<HAUTEUR;i++){
            for (j=0;j<(LARGEURPIONS);j++){
                System.out.print(listePions.get(i).get(j));
            }
            System.out.print("|");
            for (k=0;k<(LARGEURMARQUEURS);k++){
                System.out.print(listePions.get(i).get(k));
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
    
}
