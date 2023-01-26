/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.tp_coutier_grandjean;

import java.util.Scanner;

/**
 * Classe permettant de gérer les Joueurs du jeu
 * @author Domitille
 */
public class Joueur {
    
    //Attributs
    private String nom;
    private boolean role; //true si le joueur est le décodeur, false sinon
    private int score;
    
    //Constructeur
    public Joueur(){
        this.nom = "toto";
        this.role = true;
        this.score = 0;
    }
    
    //Setters et Getters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    /**
     * Fonction permettant d'initialiser un joueur au début d'une partie
     * @param estDecodeur : booelan indiquant si ce joueur est le premier à décoder (true si c'est le cas)
     */
    public void initialisationJoueur(boolean estDecodeur){
        
        // permet de dire si le joueur est décodeur au début de la partie
        this.setRole(estDecodeur);
        
        // permet de mettre le nom du personnage
        Scanner scan = new Scanner(System.in);
        boolean valide = false;
        String choix;
        
        System.out.println("Entrez le nom du Joueur :");
        while (!valide){
            choix = scan.nextLine();
            if (!choix.equals("")){
                this.setNom(choix);
                valide = true;
            }else{
                System.out.println("Oups, reessaie un nom de personnage correct !");
            }     
        }    
    }
    
       /**
     * Permet de mettre à jour le score du joueur quand il trouve la bonne combinaison
     * @param jeu : Plateau de la manche en cours
     */
    
    public void ajoutScore(Plateau jeu){
        this.setScore(this.getScore()+ jeu.getLigneJouee());
    }
    
}
