/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peorAjuste;

import java.util.ArrayList;

/**
 *
 * @author izacc
 */
public class peor {
    private int tam;
    private String[] posiciones;
    private int resultante;
    private ArrayList<Proceso> listaProcesos;
    
    public peor(int tam){
        this.tam = tam;
        resultante = tam;
        posiciones = new String[tam];
        listaProcesos = new ArrayList<>();
        
        for(int x = 0 ; x<posiciones.length ; x++){
            posiciones[x]="-";
        }
    }
    
    public void addProceso(Proceso p){
        
        if(p.getTamaño()<tam && listaProcesos.isEmpty()){
            
            System.out.println("Se agrega: "+p.getNombre()+" de tamaño: "+p.getTamaño());
            
            p.setPosInicio(0);
            p.setPosFinal(p.getTamaño()-1);
            listaProcesos.add(p);
            resultante = resultante - p.getTamaño();
            
            for(int x = 0 ; x<p.getTamaño() ; x++){
                posiciones[x]=""+p.getNombre();
            }
        }else{
            
            if(p.getTamaño()<=resultante){
                
                ArrayList<Integer[]> libres = new ArrayList<>();
                int aux=0;
                Integer[] pieza ;
                int flag1 = -1;
                int flag2 = -1;

                for(int x = 0 ; x<posiciones.length ; x++){
                    if(posiciones[x].equals("-") && x!=posiciones.length-1){
                        aux++;
                        if(flag1==-1){
                            flag1 = x;
                        }
                    }else{
                        if((flag1!=-1 && flag2==-1) || x==posiciones.length-1){
                            flag2=x;

                            pieza = new Integer[3];
                            pieza[0]=aux+1; //tamaño del bloque libre
                            pieza[1]=flag1; // inicio del bloque
                            pieza[2]=flag2; //fin del bloque

                            libres.add(pieza);
                            flag1=-1;
                            flag2=-1;
                            aux=0;
                        }
                    }
                    //System.out.println();
                }

                int mayor=0;
                int inicio = -1;
                int fin = -1;

                for(int x = 0 ; x<libres.size() ; x++){
                    if(libres.get(x)[0]>mayor){
                        mayor = libres.get(x)[0];
                        inicio = libres.get(x)[1];
                        fin = libres.get(x)[2];
                    }
                }
                
                int stop = inicio+p.getTamaño();
                for(int x = inicio ; x< stop ; x++){
                    posiciones[x]=""+p.getNombre();
                }
                
                System.out.println("Se agrega: "+p.getNombre()+" de tamaño: "+p.getTamaño());
                
                p.setPosInicio(inicio);
                p.setPosFinal(stop-1);
                listaProcesos.add(p);
                resultante = resultante - p.getTamaño();
            }
        }
    }
    
    public void deleteProceso(String ident){
        for(int x = 0 ; x<this.listaProcesos.size() ; x++){
            if(this.listaProcesos.get(x).getNombre().equals(ident)){
                resultante = resultante+this.listaProcesos.get(x).getTamaño();
                System.out.println("Se elimina: "+ident+" de tamaño: "+this.listaProcesos.get(x).getTamaño());
                this.listaProcesos.remove(x);
            }
        }
        
        for(int x = 0 ; x<this.posiciones.length ; x++){
            if(this.posiciones[x].equals(ident)){
               this.posiciones[x]="-"; 
            }
        }
    }
    
    public String toString(){
        String aux="";
        for(int x = 0 ; x<this.posiciones.length ; x++){
            if(x==0){
                aux=this.posiciones[x];
            }else{
                aux+=","+this.posiciones[x];
            }
        }
        return aux;
    }
}
