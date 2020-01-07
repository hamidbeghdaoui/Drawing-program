/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iham_project.Modele;

import java.awt.Color;
import java.awt.Image;

/**
 *
 * @author Hamid
 */
public class Modele {

    private Color bg_coler = Color.WHITE;
    private Color coler = Color.black;
    private int W = 10, H = 10;
    private String btn_select = "b_r2";
    private Boolean btn_gomme_active = false;
    Image image =null;

    public Modele() {

    }
    public Modele(Color bg_coler ,Color coler ,int W ,int H ,String btn_select ,Boolean btn_gomme_active ,Image image) {
         this.bg_coler = bg_coler;
         this.coler = coler;
         this.H = H;
         this.W = W;
         this.btn_gomme_active = btn_gomme_active;
         this.btn_select  = btn_select;
         this.image = image;
    }
    
    
    
    
    
    
    
    
    

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Boolean getBtn_gomme_active() {
        return btn_gomme_active;
    }

    public void setBtn_gomme_active(Boolean btn_gomme_active) {
        this.btn_gomme_active = btn_gomme_active;
    }

    public void setBtn_select(String btn_select) {
        this.btn_select = btn_select;
    }

    public String getBtn_select() {
        return btn_select;
    }

    public Color getBg_coler() {
        return bg_coler;
    }

    public Color getColer() {
        return coler;
    }

    public int getW() {
        return W;
    }

    public int getH() {
        return H;
    }

    public void setBg_coler(Color bg_coler) {
        this.bg_coler = bg_coler;
    }

    public void setColer(Color coler) {
        this.coler = coler;
    }

    public void setW(int W) {
        this.W = W;
    }

    public void setH(int H) {
        this.H = H;
    }

}
