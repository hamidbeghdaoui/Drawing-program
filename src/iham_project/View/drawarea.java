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

public class drawarea extends JComponent {

    private BufferedImage image;
    private int width ,height;
    private int currentX, currentY, PX, PY, RX, RY;
    private String btn;
    private Color col, bg;
    private boolean Btn_gomme_active;
    private int w, h;
    private boolean isbgColorChange;
    private boolean isbgImageChange = false;
    Graphics2D g2;

    public drawarea() {
    }

    public drawarea(int width, int height) {
        this.width = width;
        this.height = height;
    }
   

    public void Event(String b, boolean bool, int wi, int he, Color color, Color bgC) {
        btn = b;
        Btn_gomme_active = bool;
        w = wi;
        h = he;
        col = color;
        bg = bgC;

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                PX = e.getX();
                PY = e.getY();

            }

            public void mouseReleased(MouseEvent e) {

                RX = e.getX();
                RY = e.getY();
                if (isbgColorChange) {
                    if (!isbgImageChange) {
                        clear();
                    }
                    isbgColorChange = false;
                    isbgImageChange = false;
                } else {
                    g2.setPaint(col);
                    if (Btn_gomme_active) {
                        g2.setPaint(bg);
                    }
                    System.out.println(".mouseReleased()r = " + btn);
                    switch (btn) {
                        case "b_r2":
                            if (RX - PX > 0 && RY - PY > 0) {
                                g2.drawRect(PX, PY, RX - PX, RY - PY);

                            }

                            if (RX - PX < 0 && RY - PY < 0) {
                                g2.drawRect(RX, RY, PX - RX, PY - RY);

                            }

                            if (RX - PX > 0 && RY - PY < 0) {
                                g2.drawRect(PX, RY, RX - PX, RX - PX);

                            }

                            if (RX - PX < 0 && RY - PY > 0) {
                                g2.drawRect(RX, PY, PX - RX, RY - PY);
                            }
                            break;
                        case "b_c1":
                            if (RX - PX > 0 && RY - PY > 0) {
                                g2.drawOval(PX, PY, RX - PX, RY - PY);

                            }

                            if (RX - PX < 0 && RY - PY < 0) {
                                g2.drawOval(RX, RY, PX - RX, PY - RY);

                            }

                            if (RX - PX > 0 && RY - PY < 0) {
                                g2.drawOval(PX, RY, RX - PX, RX - PX);

                            }

                            if (RX - PX < 0 && RY - PY > 0) {
                                g2.drawOval(RX, PY, PX - RX, RY - PY);
                            }
                            break;
                    }

                    repaint();

                }

            }

        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();
                if (isbgColorChange) {
                    if (!isbgImageChange) {
                        clear();
                    }

                } else {

                    g2.setPaint(col);
                    if (Btn_gomme_active) {
                        g2.setPaint(bg);
                    }
                    switch (btn) {
                        case "b_st":
                            g2.drawLine(PX, PY, currentX, currentY);
                            PX = currentX;
                            PY = currentY;
                            break;
                        case "b_c2":
                            System.out.println("currentX =" + currentX + " , (currentX+w)/2) = " + (currentX + w) / 2 + "");
                            g2.fillOval(currentX - ((w) / 2), +currentY - ((h) / 2), w, h);
                            break;
                        case "b_r1":
                            g2.fillRect(currentX - ((w) / 2), +currentY - ((h) / 2), w, h);
                            break;

                    }
                    repaint();
                }

            }

        });

    }

    public void btnBg(Color bg) {
        this.bg = bg;
        this.isbgColorChange = true;
    }

    public void btnBgImage() {
        isbgImageChange = true;
        this.isbgColorChange = true;
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
        g2.setPaint(bg);
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.BLACK);
        repaint();

    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
          width = image.getWidth();
        height = image.getHeight();
        System.out.println("width = "+image.getWidth());
        System.out.println("height = "+image.getHeight());
       
        this.image = image;
       

    }
    
     public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

}
