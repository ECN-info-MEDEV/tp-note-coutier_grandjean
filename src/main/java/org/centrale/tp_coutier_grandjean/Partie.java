/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.tp_coutier_grandjean;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe permettant de gérer une partie
 * @author Domitille
 */
public class Partie {
    
    // Attributs
    
    private float nbMancheTot; //Nombre de manches qui seront jouées (doit être un nb pair)
    private List<Joueur> joueurs;
    private Plateau plateau;
    private int mancheActuelle; //num de la manche en cours
    
    // Constructeur
    public Partie(){
        this.mancheActuelle = 1;
        this.nbMancheTot = 0;
        this.plateau = new Plateau();
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        joueurs = new ArrayList<>();
        joueurs.add(j1);
        joueurs.add(j2);
    }
    
    //setters et getters

    public float getNbMancheTot() {
        return nbMancheTot;
    }

    public void setNbMancheTot(float nbMancheTot) {
        this.nbMancheTot = nbMancheTot;
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public int getMancheActuelle() {
        return mancheActuelle;
    }

    public void setMancheActuelle(int mancheActuelle) {
        this.mancheActuelle = mancheActuelle;
    }
    
    
    /**
     * Méthode permettant d'initialiser une partie
     */ 
    public void initialisationPartie(){
        
        // Initialisation des joueurs
        System.out.println("Initialisation du premier joueur qui sera le premier à décoder : ");
        boolean role = true;
        for (int i = 0; i<2; i++){
            if (i == 1){
                System.out.println("Initialisation du second joueur qui sera le premier à coder : ");
            }
            joueurs.get(i).initialisationJoueur(role);
            role = false;
        }
        
        // Initialisation du plateau de jeu
        this.plateau.initialisationPlateau();
        
        // Initialisation du nombre de manches
        Scanner scan = new Scanner(System.in);
        boolean valide = false;
        float choix;
        
        System.out.println("Entrez le nombre de manche que vous voulez jouer");
        System.out.println("Ce nombre doit être pair afin que chacun des joueurs soit autant de fois codeur et décodeur :");
        
        while (!valide){
            if(scan.hasNextInt()){
                choix = scan.nextInt();
                scan.nextLine();
                if (choix%2 == 0){
                    this.setNbMancheTot(choix);
                    valide = true;
                }else{
                    System.out.println("Oups, réessaie un nombre de manches correct !");
                }
            }else{
                System.out.println("Oups, réessaie un nombre de manches correct !");
            }
        }   
        
    }
    
    /**
     * Méthode permettant de gérer un tour de jeu 
     * @return retourne si la partie est finie ou non
     */
    
    public boolean tourDeJeu(){
        Scanner scan = new Scanner(System.in);
        Joueur codeur = new Joueur();
        Joueur decodeur = new Joueur();
        
        // Le joueur qui code décide du code
        for (Joueur j: joueurs){
            if (!j.isRole()){
                System.out.println("C'est à " + j.getNom() + " de choisir le code");
                this.getPlateau().choixCode(scan);
                codeur = j;
            }

            else{
                decodeur = j;

            }
        }
        
        
        // l'autre joueur tente de trouver le code
        boolean echec = true;
        while(echec){
            System.out.println("");
            this.getPlateau().affichePlateau();
            System.out.println("");
            System.out.println("C'est à " + decodeur.getNom() + " de trouver le code");
            this.getPlateau().choixCombinaison(scan);
            System.out.println("");
            System.out.println("C'est à " + codeur.getNom() + " de vérifier le code");
            boolean trouve = this.getPlateau().verifCombinaison(scan);
            this.getPlateau().setLigneJouee(this.getPlateau().getLigneJouee() + 1);
            if (trouve){
                echec = false;
                codeur.ajoutScore(this.getPlateau());
                System.out.println("C'est gagné !");
            }
        }
        
        // Le code a été trouvé, on inverse les rôles des joueurs
        for (Joueur j: joueurs){
            j.setRole(!j.isRole());
        }
        
        // On passe à la manche suivante 
        this.setMancheActuelle(this.getMancheActuelle()+1);
        
        // On nettoie le plateau
        this.getPlateau().nettoyerPlateau();
        
        return this.getMancheActuelle() <= this.getNbMancheTot();
    }
    
    
}