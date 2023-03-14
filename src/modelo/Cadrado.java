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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getCorRecheo() {
        return corRecheo;
    }

    public void setCorRecheo(Color corRecheo) {
        this.corRecheo = corRecheo;
    }

    public JLabel getLblCadrado() {
        return lblCadrado;
    }

    public void setLblCadrado(JLabel lblCadrado) {
        this.lblCadrado = lblCadrado;
    }
}
