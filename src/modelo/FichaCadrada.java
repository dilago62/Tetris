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
        Cadrado cadrado0 = new Cadrado(120,0, Color.YELLOW);
        Cadrado cadrado1 = new Cadrado(120,30, Color.YELLOW);
        Cadrado cadrado2 = new Cadrado(150,30, Color.YELLOW);
        Cadrado cadrado3 = new Cadrado(150,0, Color.YELLOW);
        cadrados.add(cadrado0);
        cadrados.add(cadrado1);
        cadrados.add(cadrado2);
        cadrados.add(cadrado3);
        
    }
    
}
