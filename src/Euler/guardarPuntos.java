/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Euler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author izacc
 */
public class guardarPuntos {
        public static void guardarInstancias(euler eu) {
        
        System.out.println("-------------------- Guardar Instancias --------------------");
        //llamamos el metodo que permite cargar la ventana
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(file);
        //abrimos el archivo seleccionado
        File abre = file.getSelectedFile();

        String ruta = abre.getAbsolutePath();
        File archivo = new File(ruta + ".txt");
        BufferedWriter bw = null;
        
        double[][] matriz = new double[eu.getXtabla().length][2];
        for(int x = 0 ; x < eu.getXtabla().length ; x++)
        {
            matriz[x][0] = eu.getXtabla()[x];
            matriz[x][1] = eu.getYtabla()[x];
        }
        try {
            if (archivo.exists()) {
                JOptionPane.showMessageDialog(null, "Archivo ya Existente",
                        "ERROR!!!", JOptionPane.ERROR_MESSAGE);
            } else {
                bw = new BufferedWriter(new FileWriter(archivo));
                for (int x = 0; x < matriz.length; x++) {
                    for (int y = 0; y < matriz[0].length; y++) 
                    {
                        if (y == matriz[0].length - 1) {
                            bw.append("" + matriz[x][y]);
                        } else {
                            bw.append("" + matriz[x][y] + ",");
                        }
                    }
                    bw.newLine();
                }
                bw.close();
                System.out.println("-------------------- Instancias Guardadas --------------------");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
