/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author a22davidil
 */
public class Xogo {

    int ladoCadrado = 30;
    int maxX = 300;
    int maxY = 600;
    boolean pausa;
    int numeroLineas = 0;
    ArrayList<Cadrado> cadradosChan = new ArrayList();
    Ficha fichaActual;

    public Xogo() {
    }

    public void xenerarNovaFicha() {
        fichaActual = new FichaCadrada();
        /*int pieza = (int) (Math.random()*4);
        if(pieza==1){
            
        }*/
    }
    public void engadirFichaAoChan(){
        cadradosChan.addAll(fichaActual.cadrados);
        fichaActual=null;
        borrarLina();
    }
    
    public void borrarLina(){
        int linea;
        ordenar();
        ArrayList temporal = cadradosChan;
        for(linea=20; linea>0; linea--){
            
            
        }
    }
    private void ordenar(){
        Cadrado temporal;
        for (int contador = 0; contador<cadradosChan.size()-1; contador++){
            for (int contador2=contador+1; contador2<cadradosChan.size(); contador2++){
                if (cadradosChan.get(contador).getX()>cadradosChan.get(contador2).getY()){
                    temporal=cadradosChan.get(contador);
                    cadradosChan.remove(temporal);
                    cadradosChan.set(contador, cadradosChan.get(contador2));
                    cadradosChan.set(contador2, temporal);
                }
            }
        }
    }
}
