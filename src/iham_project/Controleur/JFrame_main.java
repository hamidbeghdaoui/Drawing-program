/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iham_project.Controleur;

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
public class JFrame_main extends JFrame {

    Modele m;
    ListeModele lm;

    public JFrame_main() {
        setTitle("Interface main");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 700);
        lm = new ListeModele();
        m = lm.getModele();
        initComponents();
        synchronizationModel(false);
        setResizable(false);
        setLocationRelativeTo(null);

    }

    private void initComponents() {
        setLayout(new BorderLayout(5, 5));
        nav_bar();
        tool_bar();
        panel_left();
        panel_graphique();

        p_center = new JPanel();
        p_center.setBorder(new EmptyBorder(20, 10, 10, 10));
        p_center.setBackground(Color.white);

        // function  event 
        p_center.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                p2MouseDragged(evt);
            }
        });

       

        // end event
        add(p_left, BorderLayout.WEST);
        add(p_center, BorderLayout.CENTER);
        p_center.add(p_Graphique);
    }

   

    private void p2MouseDragged(java.awt.event.MouseEvent evt) {
        Graphics2D g = (Graphics2D) getGraphics();
        int x = p_left.getWidth() + 5 + evt.getX();
        int y = menuBar.getHeight() + tb.getHeight() + 30 + evt.getY();
        if (evt.getX() > 0 && evt.getY() > 0) {
            printBtn(g, x, y, m.getW(), m.getH());
        }

    }

    // function Panel Imagepanel panem graphique
    private void panel_graphique() {
        String path = "C:\\Users\\Hamid\\Downloads\\Templates Bootstrap\\التعاليم للملابس التركية\\img\\portfolio\\logo2.png";
         int w = 1100;
          int h = 500;
        try {
            // p_Graphique = new ImagePanel(path);
          //  p_Graphique = new ImagePanel(1100, 500, path);
           // Image img = ImageIO.read(new File(path)).getScaledInstance(w, h, Image.SCALE_SMOOTH);
            p_Graphique = new ImagePanel(null);
            p_Graphique.setImage(w, h, m.getImage());
            
        } catch (Exception ex) {
            Logger.getLogger(JFrame_main.class.getName()).log(Level.SEVERE, null, ex);
        }
         p_Graphique.setBackground(Color.white);
      
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
        JLabel l1 = new JLabel("Background Image");
        l1.setBorder(new EmptyBorder(10, 2, 5, 2));
        b_bgImage.setBackground(m.getBg_coler());
        b_bgImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColorChooser("b_bgImage");
                 
            }
        });

        b_coler = new JButton(" ");
        JLabel l2 = new JLabel("coler");
        l2.setBorder(new EmptyBorder(20, 2, 5, 2));
        b_coler.setBackground(m.getColer());
        b_coler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColorChooser("b_coler");
                 
            }
        });

        JLabel l3 = new JLabel("Outils");
        l3.setBorder(new EmptyBorder(20, 2, 5, 2));

        b_c1 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/c1.png")));
        b_r2 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/r2.png")));
        b_c2 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/c2.png")));
        b_r1 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/r1.png")));
        b_g = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/g.png")));
        b_g.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_gActionPerformed(evt);
            }
        });

        b_c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt, "b_c1");
            }
        });

        b_c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt, "b_c2");
            }
        });

        b_r1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt, "b_r1");
            }
        });

        b_r2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt, "b_r2");
            }
        });

        b_c1.setBackground(Color.white);
        b_c2.setBackground(Color.white);
        b_r1.setBackground(Color.white);
        b_r2.setBackground(Color.white);
        b_g.setBackground(Color.white);
        JLabel l_w = new JLabel("  W :");
        l_w.setBorder(new EmptyBorder(20, 2, 5, 2));

        JLabel l_h = new JLabel("  H :");
        l_h.setBorder(new EmptyBorder(20, 2, 5, 2));
        tf_w = new JTextField("" + m.getW());
        tf_h = new JTextField("" + m.getH());

        tf_w.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_w_h_Released(evt);
            }

            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_w_h_KeyTyped(evt, tf_w);
            }
        });

        tf_h.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_w_h_Released(evt);
            }

            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_w_h_KeyTyped(evt, tf_h);
            }
        });

        p_left.add(l1);
        p_left.add(b_bgImage);
        p_left.add(l2);
        p_left.add(b_coler);
        p_left.add(l3);
        p_left.add(b_c1);
        p_left.add(new JLabel(" "));
        p_left.add(b_r2);
        p_left.add(new JLabel(" "));
        p_left.add(b_c2);
        p_left.add(new JLabel(" "));
        p_left.add(b_r1);
        p_left.add(new JLabel(" "));
        p_left.add(b_g);
        p_left.add(l_w);
        p_left.add(tf_w);
        p_left.add(l_h);
        p_left.add(tf_h);

    }

    // function Toolbar 
    private void tool_bar() {
        tb = new JToolBar();
        tb.setBackground(Color.white);
        JButton b1 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/1.png")));
        JButton b2 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/2.png")));
        JButton b3 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/3.png")));
        JButton b4 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/4.png")));
        JButton b5 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/5.png")));
        JButton b6 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/6.png")));
        JButton b7 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/7.png")));
        JButton b8 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/8.png")));
        JButton b9 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/9.png")));
        JButton b10 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/10.png")));
        JButton b11 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/11.png")));
        JButton b12 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/12.png")));
        JButton b13 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/13.png")));
        JButton b14 = new JButton(new ImageIcon(getClass().getResource("/icon/tool bar/14.png")));
        
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m = lm.getMO();
                synchronizationModel(false);
                
                System.out.println(lm.getMO().getBtn_select());
                    
                
            }
        });
        b14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    new Jframe_Affichage(p_center.getWidth()+5,p_center.getHeight()+30,createImage()).setVisible(true);
                     //System.out.println("w :"+p_center.getWidth()+",h :"+p_center.getHeight());
                    } catch (AWTException ex) {
                    
                }
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

    private void synchronizationModel(boolean bool) {
        int w = 1100;
          int h = 500;
        btnSelectActive(m.getBtn_select());
        if (m.getBtn_gomme_active()) {
            b_g.setBackground(new java.awt.Color(153, 153, 153));
        } else {
            b_g.setBackground(Color.white);
        }
        tf_w.setText("" + m.getW());
        tf_h.setText("" + m.getH());
        b_bgImage.setBackground(m.getBg_coler());
        b_coler.setBackground(m.getColer());
        p_center.setBackground(m.getBg_coler());
        p_Graphique.setBackground(m.getBg_coler());
        p_Graphique.setImage(w, h, m.getImage());
        if(bool){
            roter();
        }
        
    }
    
    private void roter(){
        int w = 1100;
          int h = 500;
                  String path = "C:\\Users\\Hamid\\Downloads\\Templates Bootstrap\\التعاليم للملابس التركية\\img\\portfolio\\logo2.png";

           try {
             //p_Graphique.setImage(w, h, m.getImage());
             m= new Modele(m.getBg_coler(), m.getColer(), m.getW(), m.getH(), m.getBtn_select(), m.getBtn_gomme_active(), ImageIO.read(new File(path)).getScaledInstance(w, h, Image.SCALE_SMOOTH));
             // Image img = ImageIO.read(new File(path)).getScaledInstance(w, h, Image.SCALE_SMOOTH);
             lm.addModele(m);
            //p_Graphique = new ImagePanel(null);
           // p_Graphique.setImage(w, h, img);
           
             lm.afficherLM();
        } catch (Exception E) {
           
        }
    }
    private void btnSelectActive(String btn) {
        btnSelectNonActive();
        switch (btn) {
            case "b_c1":
                b_c1.setBackground(new java.awt.Color(153, 153, 153));
                break;
            case "b_c2":
                b_c2.setBackground(new java.awt.Color(153, 153, 153));
                break;
            case "b_r1":
                b_r1.setBackground(new java.awt.Color(153, 153, 153));
                break;
            case "b_r2":
                b_r2.setBackground(new java.awt.Color(153, 153, 153));
        }

    }

    private void btnSelectNonActive() {
        b_c1.setBackground(Color.white);
        b_c2.setBackground(Color.white);
        b_r1.setBackground(Color.white);
        b_r2.setBackground(Color.white);

    }

    private void printBtn(Graphics2D g, int x, int y, int w, int h) {
        String btn = m.getBtn_select();
        g.setColor(m.getColer());
        if (m.getBtn_gomme_active()) {
            g.setColor(m.getBg_coler());
        }

        switch (btn) {
            case "b_c1":
                g.drawOval(x, y, w, h);
                break;
            case "b_c2":
                g.fillOval(x, y, w, h);
                break;
            case "b_r1":
                g.fillRect(x, y, w, h);
                break;
            case "b_r2":
                g.drawRect(x, y, w, h);
        }

    }

    private void btnActionPerformed(java.awt.event.ActionEvent evt, String btn) {
        m.setBtn_select(btn);
        synchronizationModel(true);
    }

    private void b_gActionPerformed(java.awt.event.ActionEvent evt) {
        m.setBtn_gomme_active(!m.getBtn_gomme_active());
        synchronizationModel(true);
    }

    private void FonctionKeyNumiro(java.awt.event.KeyEvent evt) {
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }

    private void lenghtinput(javax.swing.JTextField t, int taile) {
        if (t.getText().trim().length() > taile) {
            String s = "";
            for (int i = 0; i < taile; i++) {
                s = s + t.getText().charAt(i);

            }
            t.setText(s);

        }
    }

    private void tf_w_h_KeyTyped(java.awt.event.KeyEvent evt, JTextField f) {
        FonctionKeyNumiro(evt);
        lenghtinput(f, 1);
    }

    private void tf_w_h_Released(java.awt.event.KeyEvent evt) {
        m.setW(Integer.parseInt(tf_w.getText()));
        m.setH(Integer.parseInt(tf_h.getText()));
        synchronizationModel(true);
    }
    
    private void ColorChooser(String btn){
         Color newColor = JColorChooser.showDialog(null, "Choose a color", null);       
         if(btn.equals("b_bgImage")){
             m.setBg_coler(newColor);
         }else{
             m.setColer(newColor);
         }
         
         synchronizationModel(true);
    }
    
    private BufferedImage createImage() throws AWTException { 
             int x = this.getX()+p_center.getX()+4 ;
             int y = this.getY()+menuBar.getHeight()+tb.getHeight()+30 ;
             int w = 1049;
             int h = 607;
        Rectangle screenRect = new Rectangle(x,y ,w ,h);
        

        
        BufferedImage bi = new Robot().createScreenCapture(screenRect);
        
        return bi;
    }

    //                                 varible 
    // btn p_left
    JButton b_c1, b_r2, b_c2, b_r1, b_g, b_coler, b_bgImage;
    // Jtext fild
    JTextField tf_w, tf_h;

    //panel
    ImagePanel p_Graphique;
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

}
