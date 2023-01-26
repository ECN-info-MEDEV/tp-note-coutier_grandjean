/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.tp_coutier_grandjean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
     * Liste des couleurs de pion possible
     */
    private static final String[] COULEURP={"J","b","R","V","B","N"};
    private static final List<String> COULEURPIONS= Arrays.asList(COULEURP);
    /**
     * Liste des couleurs de marqueur possible
     */
    private static final String[] COULEURM={"o","x"};
    private static final List<String> COULEURMARQUEURS= Arrays.asList(COULEURM);
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
    /**
     * nombre de lignes jouées
     */
    private int ligneJouee;
    
    //CONSTRUCTEURS
    /**
     * Constructeur par défaut
     */
    public Plateau(){
        
        listePions= new ArrayList<>();
        listeMarqueurs = new ArrayList<>();
        code=new ArrayList<>();
        ligneJouee=0;
    }
    
    //GETTERS ET SETTERS

    public List<List<String>> getListePions() {
        return listePions;
    }

    public void setListePions(List<List<String>> listePions) {
        this.listePions = listePions;
    }

    public List<List<String>> getListeMarqueurs() {
        return listeMarqueurs;
    }

    public void setListeMarqueurs(List<List<String>> listeMarqueurs) {
        this.listeMarqueurs = listeMarqueurs;
    }

    public List<String> getCode() {
        return code;
    }

    public void setCode(List<String> code) {
        this.code = code;
    }

    public int getLigneJouee() {
        return ligneJouee;
    }

    public void setLigneJouee(int ligneJouee) {
        this.ligneJouee = ligneJouee;
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
        this.ligneJouee=0;
        
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
    
    /**
     * Permet au joueur de choisir 4 pions
     * @param scan scan utilisé
     * @return la liste des pions choisis
     */
    public List<String> choixPions(Scanner scan){
        
        int i;
        boolean valide;
        String choix;
        List<String> pions = new ArrayList();
        
        //Pour les 4 pions
        for (i=0;i<LARGEURPIONS;i++){
            System.out.println("Ton pion " + (i+1) + " sera de couleur");
            for(String c: COULEURPIONS){
                System.out.println("- " + c);                 
                }
            valide = false;
            choix="";
            //On vérifie que le choix est valide
            while(!valide){
                choix=scan.nextLine();
                if (COULEURPIONS.contains(choix)){
                    valide = true;
                    pions.add(choix);
                }else{
                    System.out.println("Cette couleur n'est pas valide, réessaie.");
                }
            }
        }
        
        //Récapitulatif
        System.out.print("Tu as choisi :");
        for (String p : pions){
            System.out.print(p+" ");
        }
        System.out.println(" ");
        
        return pions;
    }
    
    /**
     * Permet au joueur de choisir un code couleur à faire deviner
     * @param scan scanner utilisé
     */
    public void choixCode(Scanner scan){
        
        //Rappelle de la légende
        System.out.println("Légende des pions : J = jaune, b = bleu, R = rouge, V = vert, B = blanc, N = noir" );
        
        //Annonce de l'action au joueur
        System.out.println("Choisis ton code secret de gauche à droite : ");
        
        this.code = choixPions(scan);
        
    }
    
    /**
     * Permet au joueur de choisir une combinaison à tester.
     * @param scan 
     */
    public void choixCombinaison(Scanner scan){
        
        List<String> combi = new ArrayList();
        
        //Rappelle de la légende
        System.out.println("Légende des pions : J = jaune, b = bleu, R = rouge, V = vert, B = blanc, N = noir" );
        
        //Annonce de l'action au joueur
        System.out.println("Choisis la combinaison à tester de gauche à droite : ");
        
        combi=choixPions(scan);

        //Mise à jour du plateau
        this.listePions.set((ligneJouee), combi);
    }
    
}
