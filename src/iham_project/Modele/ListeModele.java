/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iham_project.Modele;


import java.util.LinkedList;

public class ListeModele {

    LinkedList<Modele> CtrlZ;
    LinkedList<Modele> CtrlY;

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

    public Modele getMO() {
       if( CtrlZ.size() > 1){
          CtrlY.addFirst( CtrlZ.getFirst() );
          CtrlZ.removeFirst();
       }
      return CtrlZ.getFirst();
    }

    public Modele getPL() {
         if( !CtrlY.isEmpty()){
          CtrlZ.addFirst( CtrlY.getFirst() );
          CtrlY.removeFirst();
       }
         return CtrlZ.getFirst();
    }

   
}
