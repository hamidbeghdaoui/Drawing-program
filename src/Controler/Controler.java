/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import iham_project.Modele.ListeModele;
import iham_project.Modele.Modele;
import iham_project.View.Jframe_Affichage;
import iham_project.View.View;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Controler {

    ListeModele LM;
    Modele M;
    View V;
    boolean getMo = false;

    public Controler(ListeModele LM, View V) {
        this.LM = LM;
        this.V = V;
        M = LM.getModele();
        intitControler();
    }

    private void synchronization() {
        M = new Modele(M.getBg_coler(), M.getColer(), M.getW(),
                M.getH(), M.getBtn_select(), M.getBtn_gomme_active(), M.getImage());
        System.out.println("M.getBtn_select()  = " + M.getBtn_select());
        V.getP_Graphique().Event(M.getBtn_select(), M.getBtn_gomme_active(), M.getW(), M.getH(), M.getColer(), M.getBg_coler());
        V.getB_bgImage().setBackground(M.getBg_coler());
        V.getB_coler().setBackground(M.getColer());
        V.getTf_w().setText("" + M.getW());
        V.getTf_h().setText("" + M.getH());
        if (M.getImage() != null) {
            V.panel_graphique(false, M.getImage().getWidth(), M.getImage().getWidth());
            V.getP_Graphique().setImage(M.getImage());
        }

        btnSelectActive(M.getBtn_select());
        if (M.getBtn_gomme_active()) {
            V.getB_g().setBackground(new java.awt.Color(153, 153, 153));
        } else {
            V.getB_g().setBackground(Color.white);
        }

    }

    public void intitControler() {
        synchronization();
        V.getP_Graphique().addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent e) {
                V.getLX().setText("X : " + e.getX());
                V.getLY().setText("Y : " + e.getY());
            }
        });
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
                M.setImage(V.getP_Graphique().getImage());
                LM.insertLM(M);
                ColorChooser("b_bgImage");
                V.getP_Graphique().btnBg(M.getBg_coler());
            }
        });

        // btn color
        V.getB_coler().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M.setImage(V.getP_Graphique().getImage());
                LM.insertLM(M);
                ColorChooser("b_coler");

            }
        });

        // btn c1
        V.getB_c1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LM.insertLM(M);
                btnActionPerformed(evt, "b_c1");
            }
        });

        // btn c2 
        V.getB_c2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                LM.insertLM(M);
                btnActionPerformed(evt, "b_c2");
            }
        });

        // btn r1
        V.getB_r1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                LM.insertLM(M);
                btnActionPerformed(evt, "b_r1");
            }
        });

        // btn r2
        V.getB_r2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                LM.insertLM(M);
                btnActionPerformed(evt, "b_r2");
            }
        });

        // btn st
        V.getB_st().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                LM.insertLM(M);
                btnActionPerformed(evt, "b_st");
            }
        });

        // btn gomme
        V.getB_g().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M.setImage(V.getP_Graphique().getImage());
                LM.insertLM(M);
                b_gActionPerformed(evt);
            }
        });

    }

    public void EventFortolBar() {
        V.getB14().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                // System.out.println("iham_project.View.View.initComponents() w=" + V.getP_Graphique().getWidth() + " , h = " + V.getP_Graphique().getHeight());
                BufferedImage image;
                image = V.getP_Graphique().getImage();
                new Jframe_Affichage(image.getWidth(), image.getHeight(), image).setVisible(true);

            }
        });

        V.getB2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M.setImage(V.getP_Graphique().getImage());
                LM.insertLM(M);
                ImageChooser();
                //  V.getP_Graphique().btnBgImage();
            }
        });

        V.getB12().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M.setImage(V.getP_Graphique().getImage());
                LM.insertLM(M);
                zom(true);

            }
        });

        V.getB13().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M.setImage(V.getP_Graphique().getImage());
                LM.insertLM(M);
                zom(false);
            }
        });

        V.getB11().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M.setImage(V.getP_Graphique().getImage());
                LM.insertLM(M);
                rotation();
            }
        });
        V.getB10().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M.setImage(V.getP_Graphique().getImage());
                LM.insertLM(M);
                for (int i = 0; i < 3; i++) {

                    rotation();
                }
            }
        });

        V.getB8().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (LM.getCtrlZSize() > 1) {
                    M = LM.getMO();
                }
                synchronization();
            }
        });

        V.getB9().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (LM.getCtrlYSize() > 1) {
                    M = LM.getPL();
                }
                synchronization();
            }
        });

        V.getB1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                int input = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de cette procédure?", "Avertissement", JOptionPane.YES_NO_CANCEL_OPTION);
                if (input == 0) {
                    M = new Modele();
                    LM.deleteListe();
                    synchronization();
                    V.getP_Graphique().clear();
                }
            }
        });
        V.getB4().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                BufferedImage bi = V.getP_Graphique().getImage();
                JFileChooser f = new JFileChooser();
                if(f != null){
                    f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                f.showSaveDialog(null);
                 File outputfile = new File(f.getSelectedFile()+"/save" + Math.random() * 100  + ".png");
                try {
                    ImageIO.write(bi, "png", outputfile);
                } catch (IOException ex) {
                    Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            }
        });

        V.getB3().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
         
                try {
                    // retrieve image
                    BufferedImage bi = V.getP_Graphique().getImage();
                    String name = JOptionPane.showInputDialog("name file", "image" + Math.random() * 100);
                    if (name != null) {

                        File outputfile = new File("image/" + name + ".png");
                        ImageIO.write(bi, "png", outputfile);
                    }
                } catch (IOException e) {
                    System.out.println("" + e.getMessage());
                }

            }
        });
        
        V.getB5().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
             BufferedImage bi = V.getP_Graphique().getImage();
                LM.coli = bi;
            }
        });
        
        V.getB6().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
             BufferedImage bi = V.getP_Graphique().getImage();
                LM.coli = bi;
                 M = new Modele();
                    LM.deleteListe();
                    synchronization();
                    V.getP_Graphique().clear();
            }
        });
        
        V.getB7().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                       V.getP_Graphique().setImage(LM.coli);
                       V.getP_Graphique().setSize(40, 40);
                         System.out.println("hom hom hom");
                        synchronization();
                     
                 
                    
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
        M.setImage(V.getP_Graphique().getImage());
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

    private void ImageChooser() {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File file = chooser.getSelectedFile();
            if (file != null) {
                BufferedImage img = ImageIO.read(file);
                // V.panel_graphique(false, img.getWidth(), img.getHeight());
                M.setImage(img);
            }
        } catch (IOException ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
        }

        synchronization();
    }
// --------------------------------rotation -----------------------------------

    private void rotation() {
        BufferedImage img = V.getP_Graphique().getImage();
        img = rotateCw(img);
        // V.panel_graphique(false, img.getWidth(), img.getHeight());
        M.setImage(img);
        synchronization();
        // V.getP_Graphique().btnBgImage();
    }

    public static BufferedImage rotateCw(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage newImage = new BufferedImage(height, width, img.getType());

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                newImage.setRGB(height - 1 - j, i, img.getRGB(i, j));
            }
        }
        return newImage;
    }

    // ---------------------------- Zomme ------------------------------------------------------
    private void zom(boolean bool) {
        BufferedImage img = V.getP_Graphique().getImage();
        Image newImage;
        if (bool) {
            newImage = img.getScaledInstance((int) (img.getWidth() * 1.2), (int) (img.getHeight() * 1.2), Image.SCALE_DEFAULT);
        } else {
            newImage = img.getScaledInstance((int) (img.getWidth() * 0.8), (int) (img.getHeight() * 0.8), Image.SCALE_DEFAULT);

        }
        img = toBufferedImage(newImage);
        // System.out.println(".actionPerformed() image = "+img);
        // V.panel_graphique(false, img.getWidth(), img.getWidth());
        //System.out.println(".actionPerformed() siZ  = "+V.getP_Graphique().getWidth());
        M.setImage(img);
        synchronization();
        // V.getP_Graphique().btnBgImage();

    }

    // ------------------------------- convertir Image ----> BufferedImage --------------------------
    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }

}
