/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iham_project.Controleur;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author Hamid
 */
public class JFrame_main extends JFrame{

    public JFrame_main() {
        setTitle("Interface");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 700);
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        
    }
    
    private void initComponents (){
        setLayout(new BorderLayout(5, 5));
        menuBar = new JMenuBar();
        Fichier   = new JMenu("Fichier");
        Edition   = new JMenu("Edition");
        Insertion = new JMenu("Insertion");
        Outils    = new JMenu("Outils");
        Couleurs  = new JMenu("Couleurs");
        Image     = new JMenu("Image");
        Affichage = new JMenu("Affichage");
        Aide      = new JMenu("Aide");
        menuBar_add();
        add(menuBar,BorderLayout.NORTH);
        JPanel pl =new JPanel();
        pl.setBackground(Color.BLACK);
        JPanel pc = new JPanel();
        pc.setBackground(Color.white);
     //   pl.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(pl,BorderLayout.WEST);
        add(pc,BorderLayout.CENTER);
    }
    
    
    
   private void menuBar_add(){
     menuBar.add(Fichier);
     menuBar.add(Edition);
     menuBar.add(Insertion);
     menuBar.add(Outils);
     menuBar.add(Couleurs);
     menuBar.add(Image);
     menuBar.add(Affichage);
     menuBar.add(Aide); 
   }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
JMenuBar menuBar;
JMenu Fichier , Edition ,Insertion ,Outils ,Couleurs ,Image ,Affichage ,Aide ;
JMenuItem menuItem;
JRadioButtonMenuItem rbMenuItem;
JCheckBoxMenuItem cbMenuItem;
}
