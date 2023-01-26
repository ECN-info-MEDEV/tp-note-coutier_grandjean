/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.tp_coutier_grandjean;

import java.util.Scanner;

/**
 *
 * @author Manon Coutier
 */
public class Manon {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        Plateau p = new Plateau();
        p.initialisationPlateau();
        System.out.println(p.verifCombinaison(scan));
        p.affichePlateau();
        
    }
}
