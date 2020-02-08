/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import iham_project.Modele.Modele;
import iham_project.View.Jframe_Affichage;
import iham_project.View.View;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class Controler {

    Modele M;
    View V;

    public Controler(Modele M, View V) {
        this.M = M;
        this.V = V;
        intitControler();
    }

    private void synchronization() {
        V.getP_Graphique().Event(M.getBtn_select(), M.getBtn_gomme_active(), M.getW(), M.getH(), M.getColer(), M.getBg_coler());
 
        V.getB_bgImage().setBackground(M.getBg_coler());
        V.getB_coler().setBackground(M.getColer());
        V.getTf_w().setText("" + M.getW());
        V.getTf_h().setText("" + M.getH());
        if (M.getImage() != null) V.getP_Graphique().setImage(M.getImage());
        
        btnSelectActive(M.getBtn_select());
        if (M.getBtn_gomme_active()) {
            V.getB_g().setBackground(new java.awt.Color(153, 153, 153));
        } else {
            V.getB_g().setBackground(Color.white);
        }
    }

    public void intitControler() {
        V.getP_Graphique().addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent e) {
                V.getLX().setText("X : " + e.getX());
                V.getLY().setText("Y : " + e.getY());
            }
        });
        synchronization();
        EventForPanelLeft();
        EventFortolBar();
        EventForMenuBar();

    }

    public void EventForPanelLeft() {

        // textFiled w
        V.getTf_w().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_w_h_Released(evt);
            }

            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_w_h_KeyTyped(evt, V.getTf_w());
            }
        });

        // textFiled h
        V.getTf_h().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_w_h_Released(evt);
            }

            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_w_h_KeyTyped(evt, V.getTf_h());
            }
        });

        // btn background
        V.getB_bgImage().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColorChooser("b_bgImage");
                V.getP_Graphique().btnBg(M.getBg_coler());
            }
        });

        // btn color
        V.getB_coler().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColorChooser("b_coler");

            }
        });

        // btn c1
        V.getB_c1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt, "b_c1");
            }
        });

        // btn c2 
        V.getB_c2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt, "b_c2");
            }
        });

        // btn r1
        V.getB_r1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt, "b_r1");
            }
        });

        // btn r2
        V.getB_r2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt, "b_r2");
            }
        });

        // btn st
        V.getB_st().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt, "b_st");
            }
        });

        // btn gomme
        V.getB_g().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_gActionPerformed(evt);
            }
        });

    }

    public void EventFortolBar() {
      V.getB14().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
        System.out.println("iham_project.View.View.initComponents() w=" +V.getP_Graphique().getWidth() +" , h = "+V.getP_Graphique().getHeight());
        
                    BufferedImage image ;
                    image = V.getP_Graphique().getImage();
                    new Jframe_Affichage(image.getWidth(),image.getHeight(),image).setVisible(true);
                  
            }
        });
      
      V.getB2().addActionListener(new java.awt.event.ActionListener(){
      public void actionPerformed(java.awt.event.ActionEvent evt) {
       ImageChooser();
       V.getP_Graphique().btnBgImage();
      }
      });
    }
    public void EventForMenuBar() {
     
    }

    private void ColorChooser(String btn) {
        Color newColor = JColorChooser.showDialog(null, "Choose a color", null);
        if (btn.equals("b_bgImage")) {
            M.setBg_coler(newColor);
        } else {
            M.setColer(newColor);
        }
        synchronization();

    }

    private void btnActionPerformed(java.awt.event.ActionEvent evt, String btn) {
        M.setBtn_select(btn);
        synchronization();
    }

    // event btn gomme
    private void b_gActionPerformed(java.awt.event.ActionEvent evt) {
        M.setBtn_gomme_active(!M.getBtn_gomme_active());
        synchronization();
    }

    public void btnSelectActive(String btn) {
        btnSelectNonActive();
        switch (btn) {
            case "b_c1":
                V.getB_c1().setBackground(new java.awt.Color(153, 153, 153));
                break;
            case "b_c2":
                V.getB_c2().setBackground(new java.awt.Color(153, 153, 153));
                break;
            case "b_r1":
                V.getB_r1().setBackground(new java.awt.Color(153, 153, 153));
                break;
            case "b_r2":
                V.getB_r2().setBackground(new java.awt.Color(153, 153, 153));
                break;
            case "b_st":
                V.getB_st().setBackground(new java.awt.Color(153, 153, 153));
                break;
        }

    }

    private void btnSelectNonActive() {
        V.getB_c1().setBackground(Color.white);
        V.getB_c2().setBackground(Color.white);
        V.getB_r1().setBackground(Color.white);
        V.getB_r2().setBackground(Color.white);
        V.getB_st().setBackground(Color.white);

    }

    //----------------------  textField tw th  ----------------------------
    private void tf_w_h_Released(java.awt.event.KeyEvent evt) {
        M.setW(Integer.parseInt(V.getTf_w().getText()));
        M.setH(Integer.parseInt(V.getTf_h().getText()));
        synchronization();
    }

    private void tf_w_h_KeyTyped(java.awt.event.KeyEvent evt, JTextField f) {
        FonctionKeyNumiro(evt);
        lenghtinput(f, 1);
    }

    //----------------------  end textField tw th  ----------------------------
    private void lenghtinput(javax.swing.JTextField t, int taile) {
        if (t.getText().trim().length() > taile) {
            String s = "";
            for (int i = 0; i < taile; i++) {
                s = s + t.getText().charAt(i);

            }
            t.setText(s);

        }
    }

    private void FonctionKeyNumiro(java.awt.event.KeyEvent evt) {
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }
    
    private void ImageChooser(){
        try {
            JFileChooser  chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File file = chooser.getSelectedFile();
            BufferedImage  img=ImageIO.read(file);
            V.panel_graphique(false, img.getWidth(), img.getHeight());
            M.setImage(img);
        } catch (IOException ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        synchronization();
    }

}
