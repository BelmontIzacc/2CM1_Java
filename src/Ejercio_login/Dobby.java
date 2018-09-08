/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercio_login;

/**
 *
 * @author izacc
 */
public class Dobby {
  
    public String nombre;
    public String usuario;
    public String contraseña;
    public String paterno;
    public String materno;
    
  public Dobby(){
  }
  
  public String getNombre()
  {
      return nombre;
  }
  public String  getUsuario()
  {
      return usuario;  
  }
  public String getContraseña(){
      return contraseña;
  }

    void Datos(String C1, String C2, String C3, String C4, String C5) {
        this.nombre = C1;
        this.paterno = C2;
        this.materno = C3;
        this.contraseña = C4;
        this.usuario = C5;
    }

    public String getPaterno() {
        return paterno;
    }

    public String getMaterno() {
        return materno;
    }

    @Override
    public String toString() {
        return "Dobby{" + "nombre = " + nombre + ", usuario = " + usuario + ", contrase\u00f1a = " + contraseña + ", paterno = " + paterno + ", materno = " + materno + '}';
    }
    
    
}

