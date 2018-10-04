/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quine_Mcclu;

/**
 *
 * @author izacc
 */
public class elemento {
    
    private String bit[];
    private String posicionTabla;
    private int nomUnos;
    private int posicionUX[];
    private int posicionX[];
    private int marca;
    
    public elemento(String bit[],String posicion){
        this.bit = bit;
        this.posicionTabla = posicion;
        this.nomUnos = 0;
        this.marca=0;
        
        contar();
        buscarPosicionUX();
        buscarPosicionX();
    }
    
    public void contar(){
        for(int x = 0 ; x<bit.length ; x++){
            if(bit[x].equals("1") || bit[x].equals("X")){
                this.nomUnos++;
            }
        }
    }
    
    public void buscarPosicionUX(){
        int aux = 0;
        for(int x = 0 ; x < bit.length; x++){
            if(bit[x].equals("1")){
                aux++;
            }
        }
        
        this.posicionUX = new int[aux];
        int y =0;
        
        for(int x = 0 ; x<bit.length ; x++){
            if(bit[x].equals("1")){
                this.posicionUX[y]=x;
                y++;
            }
        }
    }
    
    public void buscarPosicionX(){
        int aux = 0;
        for(int x = 0 ; x < bit.length; x++){
            if(bit[x].equals("X")){
                aux++;
            }
        }
        
        this.posicionX = new int[aux];
        int y =0;
        
        for(int x = 0 ; x<bit.length ; x++){
            if(bit[x].equals("X")){
                this.posicionX[y]=x;
                y++;
            }
        }
    }
    
    public String Bit(){
        String aux="";
        for(int x = 0 ; x<this.bit.length ; x++){
            if(x==0){
                aux = bit[x];
            }else{
                aux += bit[x];
            }
        }
        return aux;
    }
    
    public String[] getBit() {
        return bit;
    }

    public String getPosicionTabla() {
        return posicionTabla;
    }

    public int getNomUnos() {
        return nomUnos;
    }

    public int[] getPosicionUX() {
        buscarPosicionUX();
        return posicionUX;
    }

    public int[] getPosicionX() {
        return posicionX;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }
    
}
