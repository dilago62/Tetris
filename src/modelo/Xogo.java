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

    public int ladoCadrado = 30;
    public int maxX = 300;
    public int maxY = 600;
    public boolean pausa;
    public int numeroLineas = 0;
    public ArrayList<Cadrado> cadradosChan = new ArrayList();
    public Ficha fichaActual;
    private Iterator <Cadrado> cadrados;
    
    
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
    
    public boolean ePosicionValida(int x, int y){
        if (!cadradoEnX(x) && !cadradoEnY(y) && x<maxX && y<maxY){
            return true;
        }
        else {
            return false;
        }
    }
    
    private boolean cadradoEnX (int x){
        boolean ocupado = false;
        cadrados = cadradosChan.iterator();
        while (cadrados.hasNext() && ocupado==false){ 
            if (cadrados.next().getX()==x){
                ocupado=true;
            }
        }
        return ocupado;
    }
    
    private boolean cadradoEnY (int y){
        boolean ocupado = false;
        cadrados = cadradosChan.iterator();
        while (cadrados.hasNext() && ocupado==false){ 
            if (cadrados.next().getY()==y){
                ocupado=true;
            }
        }
        return ocupado;
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
