/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iham_project.View;

import iham_project.Modele.ListeModele;
import iham_project.Modele.Modele;
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.MenuBar;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.util.concurrent.ThreadLocalRandom.current;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Hamid
 */
public class View extends JFrame {

    Modele m;
    ListeModele lm;

    public View() {
        setTitle("Interface main");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 700);
        lm = new ListeModele();
        m = lm.getModele();
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        
        setVisible(true);
    }

    private void initComponents() {
        setLayout(new BorderLayout(5, 5));
        nav_bar();
        tool_bar();
        panel_left();
        panel_graphique(true , 0 , 0);
         
        add(p_left, BorderLayout.WEST);
        JScrollPane jsp = new JScrollPane(p_Graphique);
        add(jsp, BorderLayout.CENTER);
      
      
    }

   

    // function Panel Imagepanel panem graphique
    public void panel_graphique(boolean ImageNull , int w  , int h) {
      
        try {
            if(ImageNull){
                p_Graphique = new drawarea();
            }else{
              
              p_Graphique.setSize(w, h);
              
        }
           
          
         
            
            
        } catch (Exception ex) {
            System.out.println("iham_project.View.View.panel_graphique()");
        }
       
      
    }

    // function void panel center
    private void panel_center() {

    }

    // function panel left
    private void panel_left() {
        p_left = new JPanel();
        p_left.setBackground(Color.white);
        p_left.setLayout(new BoxLayout(p_left, BoxLayout.PAGE_AXIS));
        p_left.setBorder(new EmptyBorder(20, 10, 10, 10));
        b_bgImage = new JButton(" ");
        JLabel l1 = new JLabel("Background : ");
        l1.setBorder(new EmptyBorder(10, 2, 5, 2));
       

        b_coler = new JButton(" ");
        JLabel l2 = new JLabel("color :  ");
        l2.setBorder(new EmptyBorder(20, 2, 5, 2));
        
        JLabel l3 = new JLabel("Outils :");

        b_c1 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/c1.png")));
        b_r2 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/r2.png")));
        b_c2 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/c2.png")));
        b_r1 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/r1.png")));
        b_g = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/g.png")));
        b_st = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/st.png")));
       

        b_c1.setBackground(Color.white);
        b_c2.setBackground(Color.white);
        b_r1.setBackground(Color.white);
        b_r2.setBackground(Color.white);
        b_st.setBackground(Color.white);
        JLabel l_w = new JLabel("W      ");
       // l_w.setBorder(new EmptyBorder(2, 2, 5, 2));

        JLabel l_h = new JLabel("      H");
       // l_h.setBorder(new EmptyBorder(2, 2, 5, 2));
        tf_w = new JTextField("" + m.getW());
        tf_w.setBorder(new EmptyBorder(5, 20, 5, 20));
        tf_h = new JTextField("" + m.getH());
        tf_h.setBorder(new EmptyBorder(5, 20, 5, 20));

        JPanel pbg = new JPanel();
        pbg.setLayout(new FlowLayout(FlowLayout.LEFT,5,15)); 
        pbg.add(l1);
        pbg.add(b_bgImage);
        
        JPanel pco = new JPanel();
        pco.setLayout(new FlowLayout(FlowLayout.LEFT,5,15)); 
        pco.add(l2);
        pco.add(new JLabel("          "));
        pco.add(b_coler);
        
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.CENTER,5,15)); 
        p1.add(b_r2);
        p1.add(b_c1);
        
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.CENTER,5,15)); 
        p2.add(b_r1);
        p2.add(b_c2);
        
        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.CENTER,5,15)); 
        p3.add(b_g);
        p3.add(b_st);
        
        JPanel p4 = new JPanel();
        p4.setLayout(new FlowLayout(FlowLayout.CENTER,5,5)); 
        p4.add(l_w);
        p4.add(l_h);
        
        JPanel p5 = new JPanel();
        p5.setLayout(new FlowLayout(FlowLayout.CENTER,5,5)); 
        p5.add(tf_w);
        p5.add(tf_h);
        
        JPanel p6 = new JPanel();
        p6.setLayout(new FlowLayout(FlowLayout.CENTER,20,50));
        LX = new JLabel("x : "+0);
        LX.setFont(new java.awt.Font("Tahoma", 0, 11));
        LY = new JLabel("Y : "+0);
        LY.setFont(new java.awt.Font("Tahoma", 0, 11));
        p6.add(LX);
        p6.add(LY);
        
         JPanel p7= new JPanel();
         p7.setLayout(new FlowLayout(FlowLayout.CENTER,0,0)); 
        p7.add(l3);
        pbg.setBackground(Color.white);
        pco.setBackground(Color.white);
        p1.setBackground(Color.white);
        p2.setBackground(Color.white);
        p3.setBackground(Color.white);
        p4.setBackground(Color.white);
        p6.setBackground(Color.white);
        p7.setBackground(Color.white);
        
        p_left.add(pbg);
        p_left.add(pco);
        
        p_left.add(p7);
        
        p_left.add(p1);
        p_left.add(p2);
        p_left.add(p3);
        
        p_left.add(p4);
        p_left.add(p5);
        p_left.add(p6);

    }

    // function Toolbar 
    private void tool_bar() {
        tb = new JToolBar();
        tb.setBackground(Color.white);
         b1 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/1.png")));
         b2 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/2.png")));
         b3 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/3.png")));
         b4 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/4.png")));
         b5 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/5.png")));
         b6 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/6.png")));
         b7 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/7.png")));
         b8 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/8.png")));
         b9 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/9.png")));
         b10 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/10.png")));
         b11 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/11.png")));
         b12 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/12.png")));
         b13 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/13.png")));
         b14 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/14.png")));
        
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                    
                
            }
        });
       
        b1.setBackground(Color.white);
        b2.setBackground(Color.white);
        b3.setBackground(Color.white);
        b4.setBackground(Color.white);
        b5.setBackground(Color.white);
        b6.setBackground(Color.white);
        b7.setBackground(Color.white);
        b8.setBackground(Color.white);
        b9.setBackground(Color.white);
        b10.setBackground(Color.white);
        b11.setBackground(Color.white);
        b12.setBackground(Color.white);
        b13.setBackground(Color.white);
        b14.setBackground(Color.white);

        tb.add((new JLabel("   ")));
        tb.add(b1);
        tb.add(b2);
        tb.add(b3);
        tb.add(b4);
        tb.add((new JLabel("   ")));
        tb.add(b5);
        tb.add(b6);
        tb.add(b7);
        tb.add((new JLabel("   ")));
        tb.add(b8);
        tb.add(b9);
        tb.add((new JLabel("   ")));
        tb.add(b10);
        tb.add(b11);
        tb.add((new JLabel("   ")));
        tb.add(b12);
        tb.add(b13);
        tb.add((new JLabel("    ")));
        tb.add(b14);
        add(tb, BorderLayout.NORTH);
    }

    //  function navbar
    private void nav_bar() {
        menuBar = new JMenuBar();
        menuBar.setBackground(Color.white);
        menuBar_add();
        Item_menuBar_add_Fichier();
        Item_menuBar_add_Edition();
        Item_menuBar_add_Insertion();
        Item_menuBar_add_Outils();
        Item_menuBar_add_Couleurs();
        Item_menuBar_add_Image();
        Item_menuBar_add_Aide();
        Item_menuBar_add_Affichage();
        setJMenuBar(menuBar);

    }

    private void menuBar_add() {
        Fichier = new JMenu("Fichier");
        Edition = new JMenu("Edition");
        Insertion = new JMenu("Insertion");
        Outils = new JMenu("Outils");
        Couleurs = new JMenu("Couleurs");
        MenuImage = new JMenu("Image");
        Affichage = new JMenu("Affichage");
        Aide = new JMenu("Aide");
        menuBar.add(Fichier);
        menuBar.add(Edition);
        menuBar.add(Insertion);
        menuBar.add(Outils);
        menuBar.add(Couleurs);
        menuBar.add(MenuImage);
        menuBar.add(Affichage);
        menuBar.add(Aide);

    }

    private void Item_menuBar_add_Fichier() {
        Fichier_nouvelle_image = new JMenuItem("nouvelle image", null);
        Fichier_nouvelle_image.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

        Fichier_ouvrir_fichier_image = new JMenuItem("ouvrir fichier image", null);
        Fichier_ouvrir_fichier_image.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

        Fichier_enregistrer = new JMenuItem("enregistrer", null);
        Fichier_enregistrer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        Fichier_enregistrer_sous = new JMenuItem("enregistrer sous", null);
        Fichier_enregistrer_sous.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));

        Fichier_imprimer = new JMenuItem("imprimer", null);

        Fichier_mise_en_page = new JMenuItem("mise en page", null);

        Fichier_fermer_image = new JMenuItem("fermer image", null);
        Fichier_fermer_image.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));

        Fichier_quitter = new JMenuItem("quitter", null);
        Fichier_quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

        Fichier.add(Fichier_nouvelle_image);
        Fichier.add(Fichier_ouvrir_fichier_image);
        Fichier.addSeparator();
        Fichier.add(Fichier_enregistrer);
        Fichier.add(Fichier_enregistrer_sous);
        Fichier.add(Fichier_fermer_image);
        Fichier.addSeparator();
        Fichier.add(Fichier_imprimer);
        Fichier.addSeparator();
        Fichier.add(Fichier_mise_en_page);
        Fichier.addSeparator();
        Fichier.add(Fichier_quitter);

    }

    private void Item_menuBar_add_Edition() {
        Edition_selection = new JMenu("sélection");
        Edition_detection_de_contour = new JMenuItem("détection de contour", null);
        Edition_selectionner_tout = new JMenuItem("sélectionner tout", null);
        Edition_selection_par_couleurs = new JMenuItem("sélection par couleurs", null);
        Edition_selection_rectangulaire = new JMenuItem("sélection rectangulair", null);
        Edition_selection_a_main_levee = new JMenuItem("sélection à main levée", null);
        Edition_selection.add(Edition_detection_de_contour);
        Edition_selection.add(Edition_selectionner_tout);
        Edition_selection.add(Edition_selection_par_couleurs);
        Edition_selection.add(Edition_selection_rectangulaire);
        Edition_selection.add(Edition_selection_a_main_levee);

        Edition_effacer_contenu_image = new JMenuItem("effacer contenu image", null);
        Edition_copier = new JMenuItem("copier", null);
        Edition_couper = new JMenuItem("couper", null);

        Edition_coller = new JMenu("coller");
        Edition_coller_coller = new JMenuItem("coller", null);
        Edition_coller_comme_nouvelle_image = new JMenuItem("coller comme nouvelle image", null);
        Edition_coller.add(Edition_coller_coller);
        Edition_coller.add(Edition_coller_comme_nouvelle_image);

        Edition_dupliquer_image = new JMenuItem("dupliquer image", null);
        Edition_annuler = new JMenuItem("annuler", null);
        Edition_historique_d_annulation = new JMenuItem("historique d’annulation", null);

        Edition.add(Edition_selection);
        Edition.add(Edition_effacer_contenu_image);
        Edition.add(Edition_copier);
        Edition.add(Edition_couper);
        Edition.add(Edition_coller);
        Edition.add(Edition_dupliquer_image);
        Edition.add(Edition_annuler);
        Edition.add(Edition_historique_d_annulation);

    }

    private void Item_menuBar_add_Insertion() {
        Cercle = new JMenuItem("Cercle", null);
        pinceau = new JMenuItem("pinceau", null);
        Insertion.add(Cercle);
        Insertion.add(pinceau);

    }

    private void Item_menuBar_add_Outils() {
        Crayon = new JMenuItem("Crayon", null);
        Rectangle = new JMenuItem("Rectangle", null);
        gomme = new JMenuItem("gomme", null);
        Outils.add(Crayon);
        Outils.add(Rectangle);
        Outils.add(gomme);

    }

    private void Item_menuBar_add_Couleurs() {
        balance_des_couleurs = new JMenuItem("balance des couleurs", null);
        inverser_couleurs = new JMenuItem("inverser couleurs", null);
        luminosite = new JMenuItem("luminosité", null);
        contraste = new JMenuItem("contraste (Augmenter le contraste)", null);

        Couleurs_nettete = new JMenu("netteté");
        flou_gaussien = new JMenuItem("flou gaussien", null);
        flou_cinetique = new JMenuItem("flou cinétique", null);
        renforcer_la_nettete = new JMenuItem("renforcer la netteté", null);
        Couleurs_nettete.add(flou_gaussien);
        Couleurs_nettete.add(flou_cinetique);
        Couleurs_nettete.add(renforcer_la_nettete);

        Couleurs_effets = new JMenu("effets ");
        effet_soleil_levant = new JMenuItem("effet soleil levant", null);
        effet_toile_impressionniste = new JMenuItem("effet toile impressionniste", null);
        effet_mosaique = new JMenuItem("effet mosaïque", null);
        Couleurs_effets.add(effet_soleil_levant);
        Couleurs_effets.add(effet_toile_impressionniste);
        Couleurs_effets.add(effet_mosaique);

        mode_niveaux_de_gris = new JMenuItem("mode niveaux de gris", null);

        Couleurs.add(balance_des_couleurs);
        Couleurs.add(inverser_couleurs);
        Couleurs.add(luminosite);
        Couleurs.add(contraste);
        Couleurs.add(Couleurs_nettete);
        Couleurs.add(Couleurs_effets);
        Couleurs.add(luminosite);

    }

    private void Item_menuBar_add_Image() {
        Deplacement = new JMenuItem("Deplacement", null);
        Retourner = new JMenuItem("Retourner", null);
        MenuImage.add(Deplacement);
        MenuImage.add(Retourner);

    }

    private void Item_menuBar_add_Affichage() {
        Ajuster_l_image_a_la_fenetre = new JMenuItem("Ajuster l’image à la fenêtre", null);
        plein_ecran = new JMenuItem("plein écran", null);
        taille_de_l_impression = new JMenuItem("taille de l’impression", null);
        taille_de_l_image = new JMenuItem("taille de l’image", null);

        Affichage_rotation = new JMenu("rotation");
        rotation_droite = new JMenuItem("rotation droite", null);
        rotation_gauche = new JMenuItem("rotation gauche", null);
        Affichage_rotation.add(rotation_droite);
        Affichage_rotation.add(rotation_gauche);

        Affichage_zoom = new JMenu("zoom");
        zoom_avant = new JMenuItem("zoom avant", null);
        zoom_arriere = new JMenuItem("zoom arrière", null);
        Affichage_zoom.add(zoom_avant);
        Affichage_zoom.add(zoom_arriere);

        preferences = new JMenuItem("preferences", null);

        Affichage.add(Ajuster_l_image_a_la_fenetre);
        Affichage.add(plein_ecran);
        Affichage.add(taille_de_l_impression);
        Affichage.add(taille_de_l_image);
        Affichage.add(Affichage_rotation);
        Affichage.add(Affichage_zoom);
        Affichage.add(preferences);

    }

    private void Item_menuBar_add_Aide() {
        Aide_Aide = new JMenuItem("Aide", null);
        Aide_contextuelle = new JMenuItem(" Aide contextuelle", null);
        Aide.add(Aide_Aide);
        Aide.add(Aide_contextuelle);

    }


    

 

 

  

  

   




   
    
   
    
    public BufferedImage createImage() throws AWTException { 
             int x = this.getX()+p_Graphique.getX()+4 ;
             int y = this.getY()+menuBar.getHeight()+tb.getHeight()+30 ;
             int w = 1049;
             int h = 607;
        Rectangle screenRect = new Rectangle(x,y ,w ,h);
        

        
        BufferedImage bi = new Robot().createScreenCapture(screenRect);
        
        return bi;
    }

    //                                 varible 
    // btn p_left
    JButton b_st, b_c1, b_r2, b_c2, b_r1, b_g, b_coler, b_bgImage;
    
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14;
    // Jtext fild
    JTextField tf_w, tf_h;
    JLabel LX, LY;

    //panel
    //ImagePanel p_Graphique;
    drawarea p_Graphique;
    JPanel p_left, p_center;

    //tool bar
    JToolBar tb;

    //navbar
    JMenuBar menuBar;
    JMenu Fichier, Edition, Insertion, Outils, Couleurs, MenuImage, Affichage, Aide, Edition_selection, Edition_coller, Couleurs_nettete,
            Couleurs_effets, Affichage_rotation, Affichage_zoom;

    JMenuItem Fichier_nouvelle_image, Fichier_ouvrir_fichier_image, Fichier_enregistrer,
            Fichier_enregistrer_sous, Fichier_imprimer, Fichier_mise_en_page, Fichier_fermer_image, Fichier_quitter;

    JMenuItem Edition_detection_de_contour, Edition_selectionner_tout, Edition_selection_par_couleurs, Edition_selection_rectangulaire, Edition_selection_a_main_levee,
            Edition_effacer_contenu_image, Edition_copier, Edition_couper, Edition_coller_coller,
            Edition_coller_comme_nouvelle_image,
            Edition_dupliquer_image, Edition_annuler, Edition_historique_d_annulation;

    JMenuItem Cercle, pinceau;

    JMenuItem Crayon, Rectangle, gomme;
    JMenuItem colorer_selection, balance_des_couleurs, inverser_couleurs, luminosite, contraste, flou_gaussien, flou_cinetique, renforcer_la_nettete, effet_soleil_levant, effet_toile_impressionniste, effet_mosaique, mode_niveaux_de_gris;

    JMenuItem Deplacement, Retourner;

    JMenuItem Ajuster_l_image_a_la_fenetre, plein_ecran, taille_de_l_impression, taille_de_l_image, rotation_droite, rotation_gauche, zoom_avant, zoom_arriere, preferences;

    JMenuItem Aide_Aide, Aide_contextuelle;

    public JButton getB1() {
        return b1;
    }

    public JButton getB2() {
        return b2;
    }

    public JButton getB3() {
        return b3;
    }

    public JButton getB4() {
        return b4;
    }

    public JButton getB5() {
        return b5;
    }

    public JButton getB6() {
        return b6;
    }

    public JButton getB7() {
        return b7;
    }

    public JButton getB8() {
        return b8;
    }

    public JButton getB9() {
        return b9;
    }

    public JButton getB10() {
        return b10;
    }

    public JButton getB11() {
        return b11;
    }

    public JButton getB12() {
        return b12;
    }

    public JButton getB13() {
        return b13;
    }

    public JButton getB14() {
        return b14;
    }
    
    
    
     public JLabel getLX() {
        return LX;
    }

    public JLabel getLY() {
        return LY;
    }
    
    
     public Modele getM() {
        return m;
    }

    public ListeModele getLm() {
        return lm;
    }

    public JButton getB_st() {
        return b_st;
    }

    public JButton getB_c1() {
        return b_c1;
    }

    public JButton getB_r2() {
        return b_r2;
    }

    public JButton getB_c2() {
        return b_c2;
    }

    public JButton getB_r1() {
        return b_r1;
    }

    public JButton getB_g() {
        return b_g;
    }

    public JButton getB_coler() {
        return b_coler;
    }

    public JButton getB_bgImage() {
        return b_bgImage;
    }

    public JTextField getTf_w() {
        return tf_w;
    }

    public JTextField getTf_h() {
        return tf_h;
    }

    public drawarea getP_Graphique() {
        return p_Graphique;
    }

    public JPanel getP_left() {
        return p_left;
    }

    public JPanel getP_center() {
        return p_center;
    }

    public JToolBar getTb() {
        return tb;
    }

   

    public JMenu getFichier() {
        return Fichier;
    }

    public JMenu getEdition() {
        return Edition;
    }

    public JMenu getInsertion() {
        return Insertion;
    }

    public JMenu getOutils() {
        return Outils;
    }

    public JMenu getCouleurs() {
        return Couleurs;
    }

    public JMenu getMenuImage() {
        return MenuImage;
    }

    public JMenu getAffichage() {
        return Affichage;
    }

    public JMenu getAide() {
        return Aide;
    }

    public JMenu getEdition_selection() {
        return Edition_selection;
    }

    public JMenu getEdition_coller() {
        return Edition_coller;
    }

    public JMenu getCouleurs_nettete() {
        return Couleurs_nettete;
    }

    public JMenu getCouleurs_effets() {
        return Couleurs_effets;
    }

    public JMenu getAffichage_rotation() {
        return Affichage_rotation;
    }

    public JMenu getAffichage_zoom() {
        return Affichage_zoom;
    }

    public JMenuItem getFichier_nouvelle_image() {
        return Fichier_nouvelle_image;
    }

    public JMenuItem getFichier_ouvrir_fichier_image() {
        return Fichier_ouvrir_fichier_image;
    }

    public JMenuItem getFichier_enregistrer() {
        return Fichier_enregistrer;
    }

    public JMenuItem getFichier_enregistrer_sous() {
        return Fichier_enregistrer_sous;
    }

    public JMenuItem getFichier_imprimer() {
        return Fichier_imprimer;
    }

    public JMenuItem getFichier_mise_en_page() {
        return Fichier_mise_en_page;
    }

    public JMenuItem getFichier_fermer_image() {
        return Fichier_fermer_image;
    }

    public JMenuItem getFichier_quitter() {
        return Fichier_quitter;
    }

    public JMenuItem getEdition_detection_de_contour() {
        return Edition_detection_de_contour;
    }

    public JMenuItem getEdition_selectionner_tout() {
        return Edition_selectionner_tout;
    }

    public JMenuItem getEdition_selection_par_couleurs() {
        return Edition_selection_par_couleurs;
    }

    public JMenuItem getEdition_selection_rectangulaire() {
        return Edition_selection_rectangulaire;
    }

    public JMenuItem getEdition_selection_a_main_levee() {
        return Edition_selection_a_main_levee;
    }

    public JMenuItem getEdition_effacer_contenu_image() {
        return Edition_effacer_contenu_image;
    }

    public JMenuItem getEdition_copier() {
        return Edition_copier;
    }

    public JMenuItem getEdition_couper() {
        return Edition_couper;
    }

    public JMenuItem getEdition_coller_coller() {
        return Edition_coller_coller;
    }

    public JMenuItem getEdition_coller_comme_nouvelle_image() {
        return Edition_coller_comme_nouvelle_image;
    }

    public JMenuItem getEdition_dupliquer_image() {
        return Edition_dupliquer_image;
    }

    public JMenuItem getEdition_annuler() {
        return Edition_annuler;
    }

    public JMenuItem getEdition_historique_d_annulation() {
        return Edition_historique_d_annulation;
    }

    public JMenuItem getCercle() {
        return Cercle;
    }

    public JMenuItem getPinceau() {
        return pinceau;
    }

    public JMenuItem getCrayon() {
        return Crayon;
    }

    public JMenuItem getRectangle() {
        return Rectangle;
    }

    public JMenuItem getGomme() {
        return gomme;
    }

    public JMenuItem getColorer_selection() {
        return colorer_selection;
    }

    public JMenuItem getBalance_des_couleurs() {
        return balance_des_couleurs;
    }

    public JMenuItem getInverser_couleurs() {
        return inverser_couleurs;
    }

    public JMenuItem getLuminosite() {
        return luminosite;
    }

    public JMenuItem getContraste() {
        return contraste;
    }

    public JMenuItem getFlou_gaussien() {
        return flou_gaussien;
    }

    public JMenuItem getFlou_cinetique() {
        return flou_cinetique;
    }

    public JMenuItem getRenforcer_la_nettete() {
        return renforcer_la_nettete;
    }

    public JMenuItem getEffet_soleil_levant() {
        return effet_soleil_levant;
    }

    public JMenuItem getEffet_toile_impressionniste() {
        return effet_toile_impressionniste;
    }

    public JMenuItem getEffet_mosaique() {
        return effet_mosaique;
    }

    public JMenuItem getMode_niveaux_de_gris() {
        return mode_niveaux_de_gris;
    }

    public JMenuItem getDeplacement() {
        return Deplacement;
    }

    public JMenuItem getRetourner() {
        return Retourner;
    }

    public JMenuItem getAjuster_l_image_a_la_fenetre() {
        return Ajuster_l_image_a_la_fenetre;
    }

    public JMenuItem getPlein_ecran() {
        return plein_ecran;
    }

    public JMenuItem getTaille_de_l_impression() {
        return taille_de_l_impression;
    }

    public JMenuItem getTaille_de_l_image() {
        return taille_de_l_image;
    }

    public JMenuItem getRotation_droite() {
        return rotation_droite;
    }

    public JMenuItem getRotation_gauche() {
        return rotation_gauche;
    }

    public JMenuItem getZoom_avant() {
        return zoom_avant;
    }

    public JMenuItem getZoom_arriere() {
        return zoom_arriere;
    }

    public JMenuItem getPreferences() {
        return preferences;
    }

    public JMenuItem getAide_Aide() {
        return Aide_Aide;
    }

    public JMenuItem getAide_contextuelle() {
        return Aide_contextuelle;
    }

}


