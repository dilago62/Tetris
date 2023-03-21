/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.Color;

/**
 *
 * @author a22alejandrofc
 */
public class FichaS extends Ficha {
    
    private Cadrado cadrado0 = new Cadrado(5 * getXogo().getLadoCadrado(), getXogo().getLadoCadrado()*2, Color.green, getXogo().getLadoCadrado());
    private Cadrado cadrado1 = new Cadrado(5 * getXogo().getLadoCadrado(), getXogo().getLadoCadrado(), Color.green, getXogo().getLadoCadrado());
    private Cadrado cadrado2 = new Cadrado(4 * getXogo().getLadoCadrado(), getXogo().getLadoCadrado(), Color.green, getXogo().getLadoCadrado());
    private Cadrado cadrado3 = new Cadrado(4 * getXogo().getLadoCadrado(), 0, Color.green, getXogo().getLadoCadrado());
    private int posicion;

    public FichaS(Xogo xogo) {
        super(xogo);
        cadrados.add(cadrado0);
        cadrados.add(cadrado1);
        cadrados.add(cadrado2);
        cadrados.add(cadrado3);
        pintarLabels(xogo);
    }

    public boolean rotar() {
        switch (posicion) {
            case 0:
                if (comprobar0()) {
                    rotar0();
                    return true;
                } else {
                    return false;
                }
            case 1:
                if (comprobar1()) {
                    rotar1();
                    return true;
                } else {
                    return false;
                }

            default:
                return false;
        }

    }

    private boolean comprobar1() {
        return getXogo().ePosicionValida(cadrado0.getX() + getXogo().getLadoCadrado(), cadrado0.getY() - getXogo().getLadoCadrado());
    }

    private boolean comprobar0() {
        return getXogo().ePosicionValida(cadrado0.getX() - getXogo().getLadoCadrado(), cadrado0.getY() + getXogo().getLadoCadrado());
    }

    private void rotar1() {
        cadrado0.setX(cadrado0.getX() + getXogo().getLadoCadrado());
        cadrado0.setY(cadrado0.getY() + getXogo().getLadoCadrado());
        cadrado2.setX(cadrado2.getX() - getXogo().getLadoCadrado());
        cadrado2.setY(cadrado2.getY() + getXogo().getLadoCadrado());
        cadrado3.setX(cadrado3.getX() - getXogo().getLadoCadrado()*2);
       
        posicion = 0;
    }

    private void rotar0() {
        cadrado0.setX(cadrado0.getX() - getXogo().getLadoCadrado());
        cadrado0.setY(cadrado0.getY() - getXogo().getLadoCadrado());
        cadrado2.setX(cadrado2.getX() + getXogo().getLadoCadrado());
        cadrado2.setY(cadrado2.getY() - getXogo().getLadoCadrado());
        cadrado3.setX(cadrado3.getX() + getXogo().getLadoCadrado()*2);
        posicion = 1;
    }
}
