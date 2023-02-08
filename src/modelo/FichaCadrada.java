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
 *
 * @author a22davidil
 */
public class FichaCadrada extends Ficha {

    public FichaCadrada(Xogo xogo) {
        super(xogo);

        Cadrado cadrado0 = new Cadrado(120, 0, Color.YELLOW);
        Cadrado cadrado1 = new Cadrado(120, 30, Color.YELLOW);
        Cadrado cadrado2 = new Cadrado(150, 30, Color.YELLOW);
        Cadrado cadrado3 = new Cadrado(150, 0, Color.YELLOW);

        crearCadrado();
    }
    
    private void crearCadrado(){
        Cadrado cadrado0 = new Cadrado(4*xogo.ladoCadrado,4*xogo.ladoCadrado, Color.YELLOW);
        Cadrado cadrado1 = new Cadrado(5*xogo.ladoCadrado,4*xogo.ladoCadrado, Color.YELLOW);
        Cadrado cadrado2 = new Cadrado(5*xogo.ladoCadrado,5*xogo.ladoCadrado, Color.YELLOW);
        Cadrado cadrado3 = new Cadrado(4*xogo.ladoCadrado,5*xogo.ladoCadrado, Color.YELLOW);

        cadrados.add(cadrado0);
        cadrados.add(cadrado1);
        cadrados.add(cadrado2);
        cadrados.add(cadrado3);


        for (int i = 0; i < cadrados.size(); i++) {
            Border borde;
            borde = BorderFactory.createLineBorder(Color.black);
            cadrados.get(i).lblCadrado=new JLabel();
            cadrados.get(i).lblCadrado.setBorder(borde);
            cadrados.get(i).lblCadrado.setBackground(Color.YELLOW);
            cadrados.get(i).lblCadrado.setVisible(true);
            cadrados.get(i).lblCadrado.setOpaque(true);
            cadrados.get(i).lblCadrado.setSize(32, 32);

        }

    }


    } 

    public boolean rotar() {
        return true;
    }

}
