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
    public int x;
    public int y;
    public Color corRecheo;
    public JLabel lblCadrado;

    public Cadrado(int x, int y, Color corRecheo) {
        this.x = x;
        this.y = y;
        this.corRecheo = corRecheo;
        lblCadrado = new JLabel();
        lblCadrado.setLocation(x, y);
        lblCadrado.setBackground(corRecheo);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getCoordenadas(){
        return x+" "+y;
    }
}
