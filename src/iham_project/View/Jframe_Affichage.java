/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iham_project.View;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author Hamid
 */
public class Jframe_Affichage extends JFrame {
   private  int w,h;
    private BufferedImage image;
    public Jframe_Affichage(int w, int h, BufferedImage image) {
        this.image = image;
        this.w = w;
        this.h = h;
        setTitle("Interface affichage");
        setSize(1060,620 );
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);

    }

    private void initComponents() {
        setLayout(new BorderLayout(5, 5));
        JScrollPane jsp = new JScrollPane(new ImagePanel(image,w,h));
        add(jsp, BorderLayout.CENTER);
    }

}
