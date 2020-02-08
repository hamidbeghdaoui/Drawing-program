/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iham_project.Controleur;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import javax.swing.JFrame;

/**
 *
 * @author Hamid
 */
public class Jframe_Affichage extends JFrame {

    public Jframe_Affichage(int w, int x, Image image) {
        setTitle("Interface affichage");
        // setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(w, x);
        initComponents(image);
        setResizable(false);
        setLocationRelativeTo(null);

    }

    private void initComponents(Image image) {
        setLayout(new BorderLayout(5, 5));
        add(new ImagePanel(image), BorderLayout.CENTER);
    }

}
