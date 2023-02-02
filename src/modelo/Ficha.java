/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author a22davidil
 */
public abstract class Ficha {

    public ArrayList<Cadrado> cadrados = new ArrayList();
    private Iterator<Cadrado> iterCadrados;
    public Xogo xogo;

    public Ficha(Xogo xogo) {
        this.xogo = xogo;
    }

}
