/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quine_Mcclu;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author izacc
 */
public class mac {
    
    private int min;
    private int max;
    private int minterminos[];
    private ArrayList<elemento> tabla;
    private String resultado;
    
    public mac(int minterminos[]){
        this.minterminos = minterminos;
        this.tabla = new ArrayList<>();
        this.resultado=" ";
        
        this.min = 99;
        this.max = 0;
    }
    
    public void agregar(elemento e){
        this.tabla.add(e);
        
        if(e.getNomUnos()<min){
            min = e.getNomUnos();
        }
        if(e.getNomUnos()>max){
            max = e.getNomUnos();
        }
        
    }
    
    public void agrupacion(){
        ArrayList<ArrayList<elemento>> group = new ArrayList<ArrayList<elemento>>(max);
        ArrayList<elemento> cero = new ArrayList<>();
        ArrayList<elemento> uno = new ArrayList<>();
        ArrayList<elemento> dos = new ArrayList<>();
        ArrayList<elemento> tres = new ArrayList<>();
        ArrayList<elemento> cuatro = new ArrayList<>();
        
        
//        for(int x = min ; x<=max;x++){
//            ArrayList<elemento> aux = new ArrayList<>();
//            for(int y = 0; y<this.tabla.size();y++ ){
//                if(this.tabla.get(y).getNomUnos()==x){
//                    aux.add(this.tabla.get(y));
//                }
//            }
//            group.add(aux);
//        }
//        
//        int tam = group.size();
//        
//        for(int x = 0;x<tam; x++){
//            if(group.get(x).isEmpty()){
//                group.remove(x);
//                 x=0;
//            }
//        }

        
        int aumento = min;
        
        for(int x = 0 ; x< tabla.size(); x++){
           if(tabla.get(x).getNomUnos()==0){
               cero.add(tabla.get(x));
           }else if(tabla.get(x).getNomUnos()==1){
               uno.add(tabla.get(x));
           }else if(tabla.get(x).getNomUnos()==2){
               dos.add(tabla.get(x));
           }else if(tabla.get(x).getNomUnos()==3){
               tres.add(tabla.get(x));
           }else if(tabla.get(x).getNomUnos()==4){
               cuatro.add(tabla.get(x));
           }
        }
        
        ArrayList<elemento> ccero_uno = new ArrayList<>();
        ArrayList<elemento> cuno_dos = new ArrayList<>();
        ArrayList<elemento> cdos_tres = new ArrayList<>();
        ArrayList<elemento> ctres_cuatro = new ArrayList<>();
//        int ii=0;
//        int jj=1;
//        for(int x = 0 ; x<group.size()-1 ; x++){
//            for(int i = 0 ; i<group.get(ii).size();i++){
//                for(int j = 0 ; j<group.get(jj).size();j++){
//                    
//                }
//            }
//            ii++;
//            jj++;
//        }
        if(cero.size()>0){
            for(int i = 0 ; i<uno.size();i++){
                String c[] = new String[uno.get(i).getBit().length];
                for(int j =0 ; j<uno.get(0).getBit().length ; j++){
                    if(uno.get(i).getBit()[j].equals("1")){
                        c[j]="X";
                    }else{
                        c[j]="0";
                    }
                }
                elemento e = new elemento(c,"0,"+uno.get(i).getPosicionTabla());
                ccero_uno.add(e);
            }
        }


        for(int i = 0 ; i<uno.size();i++){
            for(int j = 0 ; j<dos.size();j++){
                if(uno.get(i).getPosicionUX()[0]==
                        dos.get(j).getPosicionUX()[0]){
                    
                    String[] aux = new String[uno.get(0).getBit().length];
                    
                    for(int z = 0 ; z<uno.get(0).getBit().length;z++){
                        if(uno.get(i).getBit()[z].equals(dos.get(j).getBit()[z])){
                            aux[z]=uno.get(i).getBit()[z];
                        }else{
                            aux[z]="X";
                        }
                    }
                    elemento e = new elemento(aux,""+uno.get(i).getPosicionTabla()+","+dos.get(j).getPosicionTabla());
                    cuno_dos.add(e);
                }else if(uno.get(i).getPosicionUX()[0]==
                        dos.get(j).getPosicionUX()[1]){
                    String[] aux = new String[uno.get(0).getBit().length];
                    
                    for(int z = 0 ; z<uno.get(0).getBit().length;z++){
                        if(uno.get(i).getBit()[z].equals(dos.get(j).getBit()[z])){
                            aux[z]=uno.get(i).getBit()[z];
                        }else{
                            aux[z]="X";
                        }
                    }
                    elemento e = new elemento(aux,""+uno.get(i).getPosicionTabla()+","+dos.get(j).getPosicionTabla());
                    cuno_dos.add(e);
                }
            }
        }
        int c = 0;
        for(int i = 0 ; i<dos.size();i++){
            for(int j = 0 ; j<tres.size();j++){
                for(int y = 0 ; y<dos.get(i).getPosicionUX().length; y++){
                    for(int z = 0 ; z<tres.get(j).getPosicionUX().length;z++){
                        if(dos.get(i).getPosicionUX()[y]==
                                tres.get(j).getPosicionUX()[z]){
                            c++;
                        }
                    }
                }
                
                if(c>=2){
                    String[] aux = new String[uno.get(0).getBit().length];
                                    
                    for(int q = 0 ; q<dos.get(0).getBit().length;q++){
                        if(dos.get(i).getBit()[q].equals(tres.get(j).getBit()[q])){
                            aux[q]=dos.get(i).getBit()[q];
                        }else{
                            aux[q]="X";
                        }
                    }

                    elemento e = new elemento(aux,""+dos.get(i).getPosicionTabla()+","+tres.get(j).getPosicionTabla());
                    cdos_tres.add(e);
                }
                
                c=0;
            }
        }
        for(int i = 0 ; i<tres.size();i++){
            for(int j = 0 ; j<cuatro.size();j++){
                for(int y = 0 ; y<tres.get(i).getPosicionUX().length; y++){
                    for(int z = 0 ; z<cuatro.get(j).getPosicionUX().length;z++){
                        if(tres.get(i).getPosicionUX()[y]==
                                cuatro.get(j).getPosicionUX()[z]){
                            c++;
                        }
                    }
                }
                
                if(c>=3){
                    String[] aux = new String[uno.get(0).getBit().length];
                                    
                    for(int q = 0 ; q<tres.get(0).getBit().length;q++){
                        if(tres.get(i).getBit()[q].equals(cuatro.get(j).getBit()[q])){
                            aux[q]=tres.get(i).getBit()[q];
                        }else{
                            aux[q]="X";
                        }
                    }

                    elemento e = new elemento(aux,""+tres.get(i).getPosicionTabla()+","+cuatro.get(j).getPosicionTabla());
                    ctres_cuatro.add(e);
                }
                
                c=0;
            }
        }
        
        ArrayList<elemento> ccero_uno_uno_dos = new ArrayList<>();
        ArrayList<elemento> cuno_dos_dos_tres = new ArrayList<>();
        ArrayList<elemento> cdos_tres_tres_cuatro = new ArrayList<>();
        
        if(cero.size()>0){
            for(int x = 0 ; x < ccero_uno.size() ; x++){
                for(int y = 0 ; y<cuno_dos.size() ; y++){
                    if(ccero_uno.get(x).getPosicionX()[0]==cuno_dos.get(y).getPosicionX()[0]){ //recorrer posiciones en caso de tener mas X

                        String[] aux = new String[uno.get(0).getBit().length];

                        for(int q = 0 ; q<ccero_uno.get(0).getBit().length;q++){
                            if(ccero_uno.get(x).getBit()[q].equals(cuno_dos.get(y).getBit()[q])){
                                aux[q]=ccero_uno.get(x).getBit()[q];
                            }else{
                                aux[q]="X";
                            }
                        }
                        ccero_uno.get(x).setMarca(1);
                        cuno_dos.get(y).setMarca(1);
                        elemento e = new elemento(aux,""+ccero_uno.get(x).getPosicionTabla()+","+cuno_dos.get(y).getPosicionTabla());
                        ccero_uno_uno_dos.add(e);
                    }
                }
            }
        }
        
        for(int i = 0 ; i<cuno_dos.size();i++){
            for(int j = 0 ; j<cdos_tres.size();j++){
                for(int y = 0 ; y<cuno_dos.get(i).getPosicionUX().length; y++){
                    for(int z = 0 ; z<cdos_tres.get(j).getPosicionUX().length;z++){
                        if(cuno_dos.get(i).getPosicionX()[0]==cdos_tres.get(j).getPosicionX()[0]){ //recorrer posiciones en caso de tener mas X
                            if(cuno_dos.get(i).getPosicionUX()[y]==
                                    cdos_tres.get(j).getPosicionUX()[z]){
                                c=2;
                            } 
                        }
                    }
                }
                
                if(c>=2){
                    String[] aux = new String[uno.get(0).getBit().length];
                                    
                    for(int q = 0 ; q<cuno_dos.get(0).getBit().length;q++){
                        if(cuno_dos.get(i).getBit()[q].equals(cdos_tres.get(j).getBit()[q])){
                            aux[q]=cuno_dos.get(i).getBit()[q];
                        }else{
                            aux[q]="X";
                        }
                    }
                    cuno_dos.get(i).setMarca(1);
                    cdos_tres.get(j).setMarca(1);
                    elemento e = new elemento(aux,""+cuno_dos.get(i).getPosicionTabla()+","+cdos_tres.get(j).getPosicionTabla());
                    cuno_dos_dos_tres.add(e);
                }
                
                c=0;
            }
        }
        
        for(int i = 0 ; i<cdos_tres.size();i++){
            for(int j = 0 ; j<ctres_cuatro.size();j++){
                for(int y = 0 ; y<cdos_tres.get(i).getPosicionUX().length; y++){
                    for(int z = 0 ; z<ctres_cuatro.get(j).getPosicionUX().length;z++){
                        if(cdos_tres.get(i).getPosicionX()[0]==ctres_cuatro.get(j).getPosicionX()[0]){
                            if(cdos_tres.get(i).getPosicionUX()[y]==
                                    ctres_cuatro.get(j).getPosicionUX()[z]){
                                c=3;
                            } 
                        }
                    }
                }
                
                if(c>=3){
                    String[] aux = new String[uno.get(0).getBit().length];
                                    
                    for(int q = 0 ; q<cdos_tres.get(0).getBit().length;q++){
                        if(cdos_tres.get(i).getBit()[q].equals(ctres_cuatro.get(j).getBit()[q])){
                            aux[q]=cdos_tres.get(i).getBit()[q];
                        }else{
                            aux[q]="X";
                        }
                    }
                    cdos_tres.get(i).setMarca(1);
                    ctres_cuatro.get(j).setMarca(1);
                    elemento e = new elemento(aux,""+cdos_tres.get(i).getPosicionTabla()+","+ctres_cuatro.get(j).getPosicionTabla());
                    cdos_tres_tres_cuatro.add(e);
                }
                
                c=0;
            }
        }
        
        ArrayList<elemento> cfinal = new ArrayList<>();
        
        if(cero.size()>0){
            for(int x = 0 ; x<ccero_uno.size();x++){
                if(ccero_uno.get(x).getMarca()==0){
                    cfinal.add(ccero_uno.get(x));
                }
            }
        }
        
        for(int x = 0 ; x<cuno_dos.size();x++){
            if(cuno_dos.get(x).getMarca()==0){
                cfinal.add(cuno_dos.get(x));
            }
        }
        
        for(int x = 0 ; x<cdos_tres.size();x++){
            if(cdos_tres.get(x).getMarca()==0){
                cfinal.add(cdos_tres.get(x));
            }
        }
        
        for(int x = 0 ; x<ctres_cuatro.size();x++){
            if(ctres_cuatro.get(x).getMarca()==0){
                cfinal.add(ctres_cuatro.get(x));
            }
        }
        
        if(ccero_uno_uno_dos.size()>=2){
            elemento aux = ccero_uno_uno_dos.get(0);
            for(int x = 1 ; x<ccero_uno_uno_dos.size(); x++){
                if(Arrays.equals(aux.getBit(), ccero_uno_uno_dos.get(x).getBit())){
                    ccero_uno_uno_dos.remove(0);
                    aux = ccero_uno_uno_dos.get(0);
                    x=1;
                }
            }
        }
        
        if(cuno_dos_dos_tres.size()>=2){
            elemento aux = cuno_dos_dos_tres.get(0);
            for(int x = 1 ; x<cuno_dos_dos_tres.size(); x++){
                if(Arrays.equals(aux.getBit(), cuno_dos_dos_tres.get(x).getBit())){
                    cuno_dos_dos_tres.remove(0);
                    aux = cuno_dos_dos_tres.get(0);
                    x=1;
                }
            }
        }
        
        if(cdos_tres_tres_cuatro.size()>=2){
            elemento aux = cdos_tres_tres_cuatro.get(0);
            for(int x = 1 ; x<cdos_tres_tres_cuatro.size(); x++){
                if(Arrays.equals(aux.getBit(), cdos_tres_tres_cuatro.get(x).getBit())){
                    cdos_tres_tres_cuatro.remove(0);
                    aux = cdos_tres_tres_cuatro.get(0);
                    x=1;
                }
            }
        }
      
        if(cero.size()>0){
            for(int x = 0 ; x<ccero_uno_uno_dos.size(); x++){
                cfinal.add(ccero_uno_uno_dos.get(x));
            }
        }
                
        for(int x = 0 ; x<cuno_dos_dos_tres.size(); x++){
            cfinal.add(cuno_dos_dos_tres.get(x));
        }
        
        for(int x = 0 ; x<cdos_tres_tres_cuatro.size(); x++){
            cfinal.add(cdos_tres_tres_cuatro.get(x));
        }
        
        for(int x = 0 ; x<cfinal.size();x++){
            if(x==0){
                this.resultado = this.resultado+interprete.convertir(cfinal.get(x).getBit());
            }else{
                this.resultado = this.resultado+"+"+interprete.convertir(cfinal.get(x).getBit());
            }
        }
    }

    public String getResultado() {
        return resultado;
    }
    
}
