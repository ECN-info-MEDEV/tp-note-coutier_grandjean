/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package org.centrale.tp_coutier_grandjean;

/**
 *
 * @author Domitille
 */
public class TP_COUTIER_GRANDJEAN {

    public static void main(String[] args) {
        Partie partie = new Partie();
        partie.initialisationPartie();
        boolean jouer = true;
        while (jouer){
            jouer = partie.tourDeJeu();
        }
        System.out.println("Score de " + partie.getJoueurs().get(0).getNom() + " est de " + partie.getJoueurs().get(0).getScore());
        System.out.println("Score de " + partie.getJoueurs().get(1).getNom() + " est de " + partie.getJoueurs().get(1).getScore());
        System.out.println("Jeu fini !");
    }
}
