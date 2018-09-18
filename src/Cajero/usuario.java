/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cajero;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author izacc
 */
public class usuario {
    
    private int id;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String direccion;
    private double fondo;
    private String CURP;
    private String nip;
    private String numeroTarjeta;
    private ArrayList<movimientos> m;
    
    public usuario(String nombre, String apellidoP, String apellidoM, String direccion, double fondo, String CURP) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.direccion = direccion;
        this.fondo = fondo;
        this.CURP = CURP;
        
        this.nip = ""+ThreadLocalRandom.current().nextInt(1000, 4000); 
        this.numeroTarjeta = "";  
        
        m = new ArrayList<>();
    }
    
    public usuario(String nombre, double fondo) {
        this.nombre = nombre;
        this.apellidoP = "";
        this.apellidoM = "";
        this.direccion = "";
        this.fondo = fondo;
        this.CURP = "";
        
        this.nip = ""+ThreadLocalRandom.current().nextInt(1000, 4000); 
        this.numeroTarjeta = "";  
        
         m = new ArrayList<>();
    }
    
    public void registrarMovimiento(movimientos m){
        this.m.add(m);
    }
    
    public double getFondo() {
        return fondo;
    }

    public void setFondo(double fondo) {
        this.fondo = fondo;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCURP() {
        return CURP;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public String toString() {
        return "usuario{" + "nombre : " + nombre + ", fondo : " + fondo + ", nip : " + nip + ", numeroTarjeta : " + numeroTarjeta + '}';
    }

    
    
    
}
