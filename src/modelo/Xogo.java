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
    public ArrayList <Cadrado> cadradosChan = new ArrayList();
    public Ficha fichaActual;
    private Iterator <Cadrado> cadrados;
    public VentanaPrincipal ventana;
    
    
    public Xogo(VentanaPrincipal ventana) {
       
        this.ventana=ventana;
    }

    public boolean xenerarNovaFicha() {
        int pieza = (int) (Math.random()*4);
        switch (pieza){
            case 0:
                fichaActual = new FichaCadrada(this);
                break;
            case 1:
                fichaActual = new FichaBarra(this);
                break;
            case 2:
                fichaActual = new FichaL(this);
                break;
            case 3:
                fichaActual = new FichaT(this);
                break;
        }
        
        
        return true; 
    }
    
    public void moverFichaAbaixo(){
        if(chocarFichaCoChan()){
            engadirFichaAoChan();
            borrarLinasCompletas();
            xenerarNovaFicha();
        }
        else{
            fichaActual.moverAbaixo();
        }
    }
    
    public void moverFichaDereita(){
        if (validar('d')) {
            fichaActual.moverDereita();
        } 
    }
    
    public void moverFichaEsquerda(){
        if (validar('e')) {
            fichaActual.moverEsquerda();
        } 
    }
    
    public boolean chocarFichaCoChan(){
        for(int contador=0;contador<fichaActual.cadrados.size() ;contador++){
            if(chocarChan(fichaActual.cadrados.get(contador).x, fichaActual.cadrados.get(contador).y)){
                return true;
            }
        }
        return false;
    }
    
    public void engadirFichaAoChan(){
        cadradosChan.addAll(fichaActual.cadrados);
    }
    
    public void borrarLinasCompletas(){
        ordenar();
        ArrayList <Cadrado> temporal = cadradosChan;
        for(int contador = 0; contador<cadradosChan.size(); contador++){
            if(temporal.isEmpty()){
                temporal.add(cadradosChan.get(contador));
            }
            else if(temporal.get(0).y==cadradosChan.get(contador).y){
               temporal.add(cadradosChan.get(contador));
               if(temporal.size()==10){
                  borrarLina(temporal.get(1).y);
                  temporal.clear();
                  contador=-10;
               }
            }
            else{
                temporal.clear();
            }
        }
    }
    
    public void borrarLina(int y){
       for(int contador = 0; contador<cadradosChan.size(); contador++){
           if(cadradosChan.get(contador).y==y){
               ventana.borrarCadrado(cadradosChan.get(contador).lblCadrado);
               contador--;
           }
       }
       baixarCadrados(y);
    }
    
    public boolean ePosicionValida(int x, int y){
        if (validarXY(x,y)){
            return true;
        }
        else {
            return false;
        }
    }
    
    private boolean validarXY(int x, int y){
        return !cadradoEnXY(x, y) && x<maxX && y<maxY && x>=0 && y>=0;
    }
    
    private boolean chocarChan(int x, int y){
        if(cadradoEnXY(x,y) || y+ladoCadrado==maxY){
          return true;  
        }
        return false;
    }

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
    
    private void baixarCadrados(int y){
        for (int contador = 0; contador<cadradosChan.size(); contador++){
            if(cadradosChan.get(contador).y>y){
                cadradosChan.get(contador).y=-ladoCadrado;
            }
        }
    }
    
    private void ordenar(){
        Cadrado temporal;
        for (int contador = 0; contador<cadradosChan.size()-1; contador++){
            for (int contador2=contador+1; contador2<cadradosChan.size(); contador2++){
                if (cadradosChan.get(contador).y>cadradosChan.get(contador2).y){
                    temporal=cadradosChan.get(contador);
                    cadradosChan.remove(temporal);
                    cadradosChan.set(contador, cadradosChan.get(contador2));
                    cadradosChan.set(contador2, temporal);
                }
            }
        }
    }
    
    private boolean validar(char lado) {
        Iterator<Cadrado> iterCadrados = fichaActual.cadrados.iterator();
        while (iterCadrados.hasNext()) {
            Cadrado temporal = iterCadrados.next();
            if (lado == 'e') {
                if (!ePosicionValida(temporal.x - ladoCadrado, temporal.y)) {
                    return false;
                }
            } else if (lado == 'd') {
                if (!ePosicionValida(temporal.x + ladoCadrado, temporal.y)) {
                    return false;
                }
            }
        }
        return true;
    }
}
