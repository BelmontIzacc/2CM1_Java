/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peorAjuste;

/**
 *
 * @author izacc
 */
public class Proceso {
    private String nombre;
    private int Tamaño;
    private int posInicio;
    private int posFinal;
    
    public Proceso(String n,int t) {
        this.nombre = n;
        this.Tamaño = t;
        this.posInicio = 0;
        this.posFinal = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamaño() {
        return Tamaño;
    }

    public void setTamaño(int Tamaño) {
        this.Tamaño = Tamaño;
    }

    public int getPosInicio() {
        return posInicio;
    }

    public void setPosInicio(int posInicio) {
        this.posInicio = posInicio;
    }
    
    public int getPosFinal() {
        return this.posFinal;
    }
    
    public void setPosFinal(int posFinal) {
        this.posFinal = posFinal;
    }
}