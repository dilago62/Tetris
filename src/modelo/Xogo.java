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

    public int ladoCadrado = 32;
    public int maxX = 320;
    public int maxY = 640;
    public boolean pausa;
    public int numeroLineas = 0;
    public ArrayList<Cadrado> cadradosChan = new ArrayList();
    public Ficha fichaActual;
    private Iterator <Cadrado> cadrados;
    public VentanaPrincipal ventana;
    
    
    public Xogo(VentanaPrincipal ventana) {
       
        this.ventana=ventana;
    }

    public void xenerarNovaFicha() {
        fichaActual = new FichaCadrada(ventana.xogo);
        
      /*  int pieza = (int) (Math.random()*4);
        if(pieza==1){
            
        }*/
    }
    
    /*public boolean chocarFichacoChan(){
        for(int contador=0;contador<fichaActual.cadrados.size() ;contador++){
            if(chocarChan(fichaActual.cadrados.get(contador).x, fichaActual.cadrados.get(contador).y)){
                
            }
        }
    }*/
    
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
    
    public boolean ePosicionValida(int x, int y){
        if (validar(x,y)){
            return true;
        }
        else {
            return false;
        }
    }
    
    private boolean validar(int x, int y){
        return !cadradoEnXY(x, y) && x<maxX && y<maxY && x>0 && y>0;
    }
    
    /*private boolean chocarChan(int x, int y){
        if
    }*/

    private boolean cadradoEnXY(int x, int y){
        for(int contador = 0; contador<cadradosChan.size(); contador++){
            if (x==cadradosChan.get(contador).x){
                if(y==cadradosChan.get(contador).y){
                    return true;
                }
            }
        }
        return false;
    }
    
    private void ordenar(){
        Cadrado temporal;
        for (int contador = 0; contador<cadradosChan.size()-1; contador++){
            for (int contador2=contador+1; contador2<cadradosChan.size(); contador2++){
                if (cadradosChan.get(contador).x>cadradosChan.get(contador2).y){
                    temporal=cadradosChan.get(contador);
                    cadradosChan.remove(temporal);
                    cadradosChan.set(contador, cadradosChan.get(contador2));
                    cadradosChan.set(contador2, temporal);
                }
            }
        }
    }
}
