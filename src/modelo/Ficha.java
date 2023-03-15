/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author a22davidil
 */
public abstract class Ficha {

    protected ArrayList<Cadrado> cadrados = new ArrayList();
    protected Xogo xogo;
    protected Border borde;

    public Ficha(Xogo xogo) {
        this.xogo = xogo;
    }

    public boolean moverDereita() {
        for (int contador = 0; contador < getCadrados().size(); contador++) {
            getCadrados().get(contador).setX(getCadrados().get(contador).getX() + getXogo().getLadoCadrado());
            getCadrados().get(contador).getLblCadrado().setLocation(getCadrados().get(contador).getX(), getCadrados().get(contador).getY());
        }
        return true;
    }

    public boolean moverEsquerda() {
        for (int contador = 0; contador < getCadrados().size(); contador++) {
            getCadrados().get(contador).setX(getCadrados().get(contador).getX() - getXogo().getLadoCadrado());
            getCadrados().get(contador).getLblCadrado().setLocation(getCadrados().get(contador).getX(), getCadrados().get(contador).getY());
        }
        return true;
    }

    public boolean moverAbaixo() {
        for (int contador = 0; contador < getCadrados().size(); contador++) {
            getCadrados().get(contador).setY(getCadrados().get(contador).getY() + getXogo().getLadoCadrado());
            getCadrados().get(contador).getLblCadrado().setLocation(getCadrados().get(contador).getX(), getCadrados().get(contador).getY());
        }
        return true;
    }

    protected void pintarLabels(Xogo xogo1) {
        for (int i = 0; i < getCadrados().size(); i++) {
            borde=BorderFactory.createLineBorder(Color.black);
            cadrados.get(i).setLblCadrado(new JLabel());
            cadrados.get(i).getLblCadrado().setBorder(borde);
            cadrados.get(i).getLblCadrado().setBackground(cadrados.get(i).getCorRecheo());
            cadrados.get(i).getLblCadrado().setOpaque(true);
            cadrados.get(i).getLblCadrado().setSize(xogo.getLadoCadrado(), xogo.getLadoCadrado());
            cadrados.get(i).getLblCadrado().setLocation(getCadrados().get(i).getX(), getCadrados().get(i).getY());
        }
    }
    public abstract boolean rotar();

    public ArrayList<Cadrado> getCadrados() {
        return cadrados;
    }

    public void setCadrados(ArrayList<Cadrado> cadrados) {
        this.cadrados = cadrados;
    }

    public Xogo getXogo() {
        return xogo;
    }

    public void setXogo(Xogo xogo) {
        this.xogo = xogo;
    }

}
