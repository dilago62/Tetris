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
public class FichaBarra extends Ficha {
    
    Cadrado cadrado0 = new Cadrado(4*xogo.ladoCadrado,0, Color.CYAN, xogo.ladoCadrado);
    Cadrado cadrado1 = new Cadrado(4*xogo.ladoCadrado,xogo.ladoCadrado, Color.CYAN, xogo.ladoCadrado);
    Cadrado cadrado2 = new Cadrado(4*xogo.ladoCadrado,xogo.ladoCadrado*2, Color.CYAN, xogo.ladoCadrado);
    Cadrado cadrado3 = new Cadrado(4*xogo.ladoCadrado,xogo.ladoCadrado*3, Color.CYAN, xogo.ladoCadrado);
    Border borde;
    int posicion;
    
    public FichaBarra(Xogo xogo) {
        super(xogo);
        posicion = 1;
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
        pintarFigura();
    } 

    public boolean rotar() {
        switch (posicion){
            case 1:
                if(xogo.ePosicionValida(cadrado0.x-xogo.ladoCadrado, cadrado0.y+xogo.ladoCadrado) &&
                        xogo.ePosicionValida(cadrado2.x+xogo.ladoCadrado, cadrado2.y-xogo.ladoCadrado) &&
                        xogo.ePosicionValida(cadrado3.x+xogo.ladoCadrado*2, cadrado3.y-xogo.ladoCadrado*2)){
                    cadrado0.x=cadrado0.x-xogo.ladoCadrado;
                    cadrado0.y=cadrado0.y+xogo.ladoCadrado;
                    cadrado2.x=cadrado2.x+xogo.ladoCadrado;
                    cadrado2.y=cadrado2.y-xogo.ladoCadrado;
                    cadrado3.x=cadrado3.x+xogo.ladoCadrado*2;
                    cadrado3.y=cadrado3.y-xogo.ladoCadrado*2;
                    posicion = 2;
                    return true;
                }
                else{
                    return false;
                }
            case 2:
                if(xogo.ePosicionValida(cadrado0.x+xogo.ladoCadrado, cadrado0.y-xogo.ladoCadrado) &&
                        xogo.ePosicionValida(cadrado2.x-xogo.ladoCadrado, cadrado2.y+xogo.ladoCadrado) &&
                        xogo.ePosicionValida(cadrado3.x-xogo.ladoCadrado*2, cadrado3.y+xogo.ladoCadrado*2)){
                    cadrado0.x=cadrado0.x+xogo.ladoCadrado;
                    cadrado0.y=cadrado0.y-xogo.ladoCadrado;
                    cadrado2.x=cadrado2.x-xogo.ladoCadrado;
                    cadrado2.y=cadrado2.y+xogo.ladoCadrado;
                    cadrado3.x=cadrado3.x-xogo.ladoCadrado*2;
                    cadrado3.y=cadrado3.y+xogo.ladoCadrado*2;
                    posicion = 1;
                    return true;
                }
                else{
                    return false;
                }
            default:
                return false;
        }
    }
}
