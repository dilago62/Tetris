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
            setBorde(BorderFactory.createLineBorder(Color.black));
            getCadrados().get(i).setLblCadrado(new JLabel());
            getCadrados().get(i).getLblCadrado().setBorder(getBorde());
            getCadrados().get(i).getLblCadrado().setBackground(getCadrados().get(i).getCorRecheo());
            getCadrados().get(i).getLblCadrado().setOpaque(true);
            getCadrados().get(i).getLblCadrado().setSize(xogo1.getLadoCadrado(), xogo1.getLadoCadrado());
            getCadrados().get(i).getLblCadrado().setLocation(getCadrados().get(i).getX(), getCadrados().get(i).getY());
        }
    }
    public abstract boolean rotar();

    /**
     * @return the cadrados
     */
    public ArrayList<Cadrado> getCadrados() {
        return cadrados;
    }

    /**
     * @param cadrados the cadrados to set
     */
    public void setCadrados(ArrayList<Cadrado> cadrados) {
        this.cadrados = cadrados;
    }

    /**
     * @return the xogo
     */
    public Xogo getXogo() {
        return xogo;
    }

    /**
     * @param xogo the xogo to set
     */
    public void setXogo(Xogo xogo) {
        this.xogo = xogo;
    }

    /**
     * @return the borde
     */
    protected Border getBorde() {
        return borde;
    }

    /**
     * @param borde the borde to set
     */
    protected void setBorde(Border borde) {
        this.borde = borde;
    }

}
