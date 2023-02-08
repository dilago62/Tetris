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
    
    public boolean moverDereita(){
        if(validar('d')){
            for(int contador = 0; contador<cadrados.size(); contador++){
                cadrados.get(contador).x=+xogo.ladoCadrado;
            }
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean moverEsquerda(){
        if(validar('e')){
            for(int contador = 0; contador<cadrados.size(); contador++){
                cadrados.get(contador).x=+xogo.ladoCadrado;
            }
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean moverAbaixo(){
        if(validar('b')){
            for(int contador = 0; contador<cadrados.size(); contador++){
                cadrados.get(contador).x=+xogo.ladoCadrado;
            }
            return true;
        }
        else{
            return false;
        }
    }
    
    public abstract boolean rotar();
    
    private boolean validar(char lado){
        iterCadrados=cadrados.iterator();
        while(iterCadrados.hasNext()){
            Cadrado temporal = iterCadrados.next();
            if(lado=='e'){
                if(!xogo.ePosicionValida(temporal.x-xogo.ladoCadrado, temporal.y)){
                    return false;
                }
            }
            else if(lado=='d'){
                if(!xogo.ePosicionValida(temporal.x+xogo.ladoCadrado, temporal.y)){
                    return false;
                }
            }
            else if(lado=='b'){
                if(!xogo.ePosicionValida(temporal.x, temporal.y+xogo.ladoCadrado)){
                    return false;
                }
            }
        }
        return true;
    }
    
}
