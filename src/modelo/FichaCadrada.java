/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.Color;

/**
 *
 * @author a22davidil
 */
public class FichaCadrada extends Ficha{

    public FichaCadrada(Xogo xogo) {
        super(xogo);
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
    } 

    public boolean rotar() {
        return true;
    }
}
