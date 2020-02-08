/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iham_project.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePanel extends JComponent {

    private BufferedImage image;
    private int width ,height;
    Graphics2D g2;

    public ImagePanel(BufferedImage image,int width, int height) {
        this.width =width;
        this.height =width;
        this.image = image;
        
    }
   

  
    protected void paintComponent(Graphics g) {

        if (image == null) {
            image = (BufferedImage) createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        } else {
            g2 = image.createGraphics();
        }

        g.drawImage(image, 0, 0, null);
    }

  
        public void clear() {
        g2.setPaint(Color.BLACK);
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.BLACK);
        repaint();

    }

  
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
     public Dimension getPreferredSize() {
         System.out.println("width = "+width+" , height = "+height);
        return new Dimension(width, height);
    }

}
