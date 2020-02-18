/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iham_project.Modele;


import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class ListeModele {

    LinkedList<Modele> CtrlZ;
    LinkedList<Modele> CtrlY;
    public BufferedImage coli =null;
    

    public ListeModele() {
        CtrlZ = new LinkedList<>();
        CtrlY = new LinkedList<>();
        CtrlZ.add(new Modele());
    }
    private Modele getSomme(){
        return CtrlZ.getFirst();
    }
    public Modele getModele() {
        return getSomme();
    }
    public void insertLM(Modele M){
        CtrlZ.add(M);
    }
    public Modele getMO() {
      if(!CtrlZ.isEmpty()){
        CtrlY.add( CtrlZ.getLast());
        CtrlZ.removeLast();  
      }
      return CtrlZ.getLast();
    }

    public Modele getPL() {
         if( !CtrlY.isEmpty()){
          CtrlZ.add( CtrlY.getLast());
          CtrlY.removeLast();
       }
         return CtrlZ.getLast();
    }
    
    public int getCtrlZSize(){
        return CtrlZ.size();
    }
    public int getCtrlYSize(){
        return CtrlY.size();
    }
    
    public void deleteListe(){
        for (int i = 0; i < CtrlZ.size(); i++) {
            CtrlZ.remove(i);
            
        }
        for (int i = 0; i < CtrlY.size(); i++) {
           CtrlY.remove(i);
            
        }
        CtrlZ.add(new Modele());
    }

   
}
