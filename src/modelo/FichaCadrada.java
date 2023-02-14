/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;
import modelo.Cadrado;

/**
 * ykj
 * @author a22davidil
 */
public class FichaCadrada extends Ficha {

    public FichaCadrada(Xogo xogo) {
        super(xogo);
        crearCadrado();
        pintarFigura();
    }
    
    private void crearCadrado(){
        Cadrado cadrado0 = new Cadrado(4*xogo.ladoCadrado,0, Color.YELLOW);
        Cadrado cadrado1 = new Cadrado(5*xogo.ladoCadrado,0, Color.YELLOW);
        Cadrado cadrado2 = new Cadrado(5*xogo.ladoCadrado,xogo.ladoCadrado, Color.YELLOW);
        Cadrado cadrado3 = new Cadrado(4*xogo.ladoCadrado,xogo.ladoCadrado, Color.YELLOW);

        cadrados.add(cadrado0);
        cadrados.add(cadrado1);
        cadrados.add(cadrado2);
        cadrados.add(cadrado3);

        for (int i = 0; i < cadrados.size(); i++) {
            Border borde;
            borde = BorderFactory.createLineBorder(Color.black);
            cadrados.get(i).lblCadrado.setBorder(borde);
            cadrados.get(i).lblCadrado.setBackground(cadrados.get(i).corRecheo);
            cadrados.get(i).lblCadrado.setVisible(true);
            cadrados.get(i).lblCadrado.setOpaque(true);
            cadrados.get(i).lblCadrado.setSize(xogo.ladoCadrado, xogo.ladoCadrado);
        }

    } 

    public boolean rotar() {
        return true;
    }

}
