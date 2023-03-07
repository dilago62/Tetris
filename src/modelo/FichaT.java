/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author a22davidil
 */
public class FichaT extends Ficha {

    Cadrado cadrado0 = new Cadrado(4 * xogo.ladoCadrado, 0, Color.MAGENTA, xogo.ladoCadrado);
    Cadrado cadrado1 = new Cadrado(4 * xogo.ladoCadrado, xogo.ladoCadrado, Color.MAGENTA, xogo.ladoCadrado);
    Cadrado cadrado2 = new Cadrado(4 * xogo.ladoCadrado, xogo.ladoCadrado * 2, Color.MAGENTA, xogo.ladoCadrado);
    Cadrado cadrado3 = new Cadrado(5 * xogo.ladoCadrado, xogo.ladoCadrado, Color.MAGENTA, xogo.ladoCadrado);
    Border borde;
    int posicion;

    public FichaT(Xogo xogo) {
        super(xogo);
        cadrados.add(cadrado0);
        cadrados.add(cadrado1);
        cadrados.add(cadrado2);
        cadrados.add(cadrado3);

        for (int i = 0; i < cadrados.size(); i++) {

            borde = BorderFactory.createLineBorder(Color.black);
            cadrados.get(i).lblCadrado = new JLabel();
            cadrados.get(i).lblCadrado.setBorder(borde);
            cadrados.get(i).lblCadrado.setBackground(cadrados.get(i).corRecheo);
            cadrados.get(i).lblCadrado.setOpaque(true);
            cadrados.get(i).lblCadrado.setSize(xogo.ladoCadrado, xogo.ladoCadrado);
            cadrados.get(i).lblCadrado.setLocation(cadrados.get(i).x, cadrados.get(i).y);
        }

    }

    public boolean rotar() {
        return true;
    }

}
