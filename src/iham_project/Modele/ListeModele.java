/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iham_project.Modele;

import java.util.ArrayList;

public class ListeModele {

    ArrayList<Modele> LM;
    int i = -1;

    public ListeModele() {
        LM = new ArrayList<>();
        LM.add(new Modele());
        i = 0;
    }

    public Modele getModele() {
        return LM.get(i);
    }

    public Modele getMO() {
        if (LM.size()-1 > 0) {
            i--;
            return LM.get(i);
        }
        return LM.get(i);
    }

    public Modele getPL() {
        if (LM.size() > i) {
            i++;
            return LM.get(i);
        }
        return LM.get(i);
    }

    public void addModele(Modele m) {
        i++;
        LM.add(m);
    }

    
    public  void afficherLM(){
            System.out.println("_______________________");
        for (int j = 0; j < LM.size(); j++) {
            Modele m = LM.get(j);
            System.out.println("getBtn_select :"+m.getBtn_select()+" , "+m.getColer()+","+m.getBtn_gomme_active()+","+m.getImage());
            
        }
    }
}
