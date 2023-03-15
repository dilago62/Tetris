/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import iu.VentanaPrincipal;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author a22davidil
 */
public class Xogo {

    private int ladoCadrado = 32;
    private int maxX = ladoCadrado*10;
    private int maxY = ladoCadrado*20;
    private boolean pausa;
    private int numeroLineas = 0;
    private ArrayList<Cadrado> cadradosChan = new ArrayList();
    private Ficha fichaActual;
    private Iterator<Cadrado> cadrados;
    private VentanaPrincipal ventana;

    public Xogo(VentanaPrincipal ventana) {

        this.ventana = ventana;
    }

    public boolean xenerarNovaFicha() {

        int pieza = (int) (Math.random() * 4);
        switch (pieza) {

            case 0:
            default:
                FichaCadrada fichaC = new FichaCadrada(this);
                setFichaActual(fichaC);
                break;
            case 1:
                FichaBarra fichaB = new FichaBarra(this);
                setFichaActual(fichaB);
                break;
            case 2:
                FichaL fichaL = new FichaL(this);
                setFichaActual(fichaL);
                break;
            case 3:
                FichaT fichaT = new FichaT(this);
                setFichaActual(fichaT);
                break;
        }
        for (int contador = 0; contador < getFichaActual().getCadrados().size(); contador++) {
            getVentana().pintarCadrado(getFichaActual().getCadrados().get(contador).getLblCadrado());
        }

        return true;
    }

    public void moverFichaAbaixo() {
        if (chocarFichaCoChan()) {
            engadirFichaAoChan();
            borrarLinasCompletas();
        } else {
            getFichaActual().moverAbaixo();
        }
    }

    public void moverFichaDereita() {
        if (validar('d')) {
            getFichaActual().moverDereita();
        }
    }

    public void moverFichaEsquerda() {
        if (validar('e')) {
            getFichaActual().moverEsquerda();
        }
    }

    public void rotarFicha() {
        getFichaActual().rotar();
    }

    public boolean chocarFichaCoChan() {
        for (int contador = 0; contador < getFichaActual().getCadrados().size(); contador++) {
            if (chocarChan(getFichaActual().getCadrados().get(contador).getX(), getFichaActual().getCadrados().get(contador).getY())) {

                return true;
            }
        }
        return false;
    }

    public void engadirFichaAoChan() {
        getCadradosChan().addAll(getFichaActual().getCadrados());
        xenerarNovaFicha();
    }

    public void borrarLinasCompletas() {
        int cadradosFila = 0;
        for (int contador = 0; contador < cadradosChan.size(); contador++) {
            for(int contador2 = 0; contador< cadradosChan.size(); contador2++){
                if(cadradosChan.get(contador).getY()==cadradosChan.get(contador2).getY()){
                    cadradosFila++;
                    if (cadradosFila==12){
                        borrarLina(cadradosChan.get(contador).getY());
                        cadradosFila = 0;
                        contador2=0;
                    }
                }
            }
        }
    }

    public void borrarLina(int y) {
        for (int contador = 0; contador < getCadradosChan().size(); contador++) {
            if (getCadradosChan().get(contador).getY() == y) {
                getVentana().borrarCadrado(getCadradosChan().get(contador).getLblCadrado());
                getCadradosChan().remove(getCadradosChan().get(contador));
                contador--;
            }
        }
        baixarCadrados(y);
    }

    public boolean ePosicionValida(int x, int y) {
        if (validarXY(x, y)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validarXY(int x, int y) {
        return !cadradoEnXY(x, y) && x < getMaxX() && y < getMaxY() && x >= 0 && y >= 0;
    }

    private boolean chocarChan(int x, int y) {
        if (cadradoEnXY(x, y+ladoCadrado) || y + getLadoCadrado() == getMaxY()) {
            return true;
        }
        return false;
    }

    private boolean cadradoEnXY(int x, int y) {
        for (int contador = 0; contador < getCadradosChan().size(); contador++) {
            if (x == getCadradosChan().get(contador).getX()) {
                if (y == getCadradosChan().get(contador).getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void baixarCadrados(int y) {
        for (int contador = 0; contador < cadradosChan.size(); contador++) {
            if (cadradosChan.get(contador).getY() > y) {
                cadradosChan.get(contador).setY(-ladoCadrado);
            }
        }
    }

    private boolean validar(char lado) {
        Iterator<Cadrado> iterCadrados = getFichaActual().getCadrados().iterator();
        while (iterCadrados.hasNext()) {
            Cadrado temporal = iterCadrados.next();
            if (lado == 'e') {
                if (!ePosicionValida(temporal.getX() - ladoCadrado, temporal.getY())) {
                    return false;
                }
            } else if (lado == 'd') {
                if (!ePosicionValida(temporal.getX() + ladoCadrado, temporal.getY())) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getLadoCadrado() {
        return ladoCadrado;
    }

    public void setLadoCadrado(int ladoCadrado) {
        this.ladoCadrado = ladoCadrado;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public boolean isPausa() {
        return pausa;
    }

    public void setPausa(boolean pausa) {
        this.pausa = pausa;
    }

    public int getNumeroLineas() {
        return numeroLineas;
    }

    public void setNumeroLineas(int numeroLineas) {
        this.numeroLineas = numeroLineas;
    }

    public ArrayList<Cadrado> getCadradosChan() {
        return cadradosChan;
    }

    public void setCadradosChan(ArrayList<Cadrado> cadradosChan) {
        this.cadradosChan = cadradosChan;
    }

    public Ficha getFichaActual() {
        return fichaActual;
    }

    public void setFichaActual(Ficha fichaActual) {
        this.fichaActual = fichaActual;
    }

    public VentanaPrincipal getVentana() {
        return ventana;
    }

    public void setVentana(VentanaPrincipal ventana) {
        this.ventana = ventana;
    }
}
