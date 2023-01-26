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
        
    }

}
