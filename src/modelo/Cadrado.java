/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author a22davidil
 */
public class Cadrado {

    private int x;
    private int y;
    private Color corRecheo;
    private JLabel lblCadrado;

    public Cadrado(int x, int y, Color corRecheo, int lado) {

        this.x = x;
        this.y = y;
        this.corRecheo = corRecheo;
    }

    public String getCoordenadas() {
        return getX() + " " + getY();
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the corRecheo
     */
    public Color getCorRecheo() {
        return corRecheo;
    }

    /**
     * @param corRecheo the corRecheo to set
     */
    public void setCorRecheo(Color corRecheo) {
        this.corRecheo = corRecheo;
    }

    /**
     * @return the lblCadrado
     */
    public JLabel getLblCadrado() {
        return lblCadrado;
    }

    /**
     * @param lblCadrado the lblCadrado to set
     */
    public void setLblCadrado(JLabel lblCadrado) {
        this.lblCadrado = lblCadrado;
    }
}
