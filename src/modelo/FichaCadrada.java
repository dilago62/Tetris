/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.Color;

/**
 *prueba
 * @author a22davidil
 */
public class FichaCadrada extends Ficha {

    private Cadrado cadrado0 = new Cadrado(4 * getXogo().getLadoCadrado(), 0, Color.YELLOW, getXogo().getLadoCadrado());
    private Cadrado cadrado1 = new Cadrado(5 * getXogo().getLadoCadrado(), 0, Color.YELLOW, getXogo().getLadoCadrado());
    private Cadrado cadrado2 = new Cadrado(5 * getXogo().getLadoCadrado(), getXogo().getLadoCadrado(), Color.YELLOW, getXogo().getLadoCadrado());
    private Cadrado cadrado3 = new Cadrado(4 * getXogo().getLadoCadrado(), getXogo().getLadoCadrado(), Color.YELLOW, getXogo().getLadoCadrado());

    public FichaCadrada(Xogo xogo) {
        super(xogo);
        cadrados.add(cadrado0);
        cadrados.add(cadrado1);
        cadrados.add(cadrado2);
        cadrados.add(cadrado3);
        pintarLabels(xogo);
    }

    public boolean rotar() {
        return true;
    }
}
