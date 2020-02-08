/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iham_project;

import Controler.Controler;
import iham_project.Modele.Modele;
import iham_project.View.View;

/**
 *
 * @author Hamid
     */
public class IHAM_PROJECT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Controler(new Modele() , new View());
      // new View().setVisible(true);
    }
    
}
