/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author a22davidil
 */
public abstract class Ficha {

    public ArrayList<Cadrado> cadrados = new ArrayList();
    public Xogo xogo;

    public Ficha(Xogo xogo) {
        this.xogo = xogo;
    }

    public boolean moverDereita() {
        for (int contador = 0; contador < cadrados.size(); contador++) {
            cadrados.get(contador).x = +xogo.ladoCadrado;
        }
        pintarFigura();
        return true;
    }

    public boolean moverEsquerda() {
        for (int contador = 0; contador < cadrados.size(); contador++) {
            cadrados.get(contador).x = +xogo.ladoCadrado;
        }
        pintarFigura();
        return true;
    }

    public boolean moverAbaixo() {
        for (int contador = 0; contador < cadrados.size(); contador++) {
            cadrados.get(contador).y = +xogo.ladoCadrado;
        }
        pintarFigura();
        return true;

    }

    public abstract boolean rotar();

    protected void pintarFigura() {
        for (int contador = 0; contador < cadrados.size(); contador++) {
            xogo.ventana.pintarCadrado(cadrados.get(contador).lblCadrado);
        }
    }

}
