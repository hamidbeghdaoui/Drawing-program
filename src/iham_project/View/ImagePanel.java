/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iham_project.Controleur;



import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

class ImagePanel extends JPanel {

    int width, height;
    Image bg;
    BufferedImage img;
  
    public ImagePanel(int width, int height, String path) throws IOException {
        img = ImageIO.read(new File(path));
        if(img.getWidth()<width){
         this.width =  img.getWidth();  
        }else{
        this.width = width;   
        }
        if(img.getHeight()<height){
         this.height =  img.getHeight();  
        }else{
        this.height = height;   
        }
       
        this.bg = ImageIO.read(new File(path)).getScaledInstance(this.width, this.height, Image.SCALE_SMOOTH);
    }

    public ImagePanel(Image bg) {
        this.bg = bg;
    }
    
    public void setImage(int w , int h,Image bg){
        this.width = w;
        this.height = h;
        this.bg = bg; 
    }
    

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        grphcs.drawImage(bg, 0, 0, null);
    }
}
