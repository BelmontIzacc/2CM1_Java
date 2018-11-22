/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagenes;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author izacc
 */
public class FiltrosEspacial {
    
    public static Image temperatura(Image original, int valor){
        BufferedImage aux = ImageManager.toBufferedImage(original);
        //recorrer imagen
        for(int x = 0 ; x< aux.getWidth() ; x++)
        {
            for(int y = 0 ; y < aux.getHeight() ; y++)
            {
                //obtener imagen
                Color pixel = new Color(aux.getRGB(x, y));
                
                int r = pixel.getRed()+valor;
                int g = pixel.getGreen();
                int b = pixel.getBlue()-valor;
                
                if(r<0){
                    r=0;
                }else if(r>255){
                    r = 255;
                }
                if(g<0){
                    g=0;
                }else if(g>255){
                    g = 255;
                }
                if(b<0){
                    b=0;
                }else if(b>255){
                    b = 255;
                }
                pixel = new Color(r,g,b);
                aux.setRGB(x, y, pixel.getRGB());
            }    
        }
        return aux;
    }
    
    public static Image generarEscalaGrises(Image original)
    {
        BufferedImage aux = ImageManager.toBufferedImage(original);
        //recorrer imagen
         for(int x = 0 ; x< aux.getWidth() ; x++)
        {
            for(int y = 0 ; y < aux.getHeight() ; y++)
            {
                //obtener imagen
                Color pixel = new Color(aux.getRGB(x, y));
                //en base a la clase color definir un solo tono
                //para los 3 canales rgb
                // con la premisa de reducir de 2^24 a 2^8
                int nuevo = (pixel.getRed() + pixel.getGreen() + pixel.getBlue() )/3;
                pixel = new Color(nuevo,nuevo,nuevo);
                aux.setRGB(x, y, pixel.getRGB());
            }    
        }
        return ImageManager.toImage(aux);
    }
    
    public static Image umbralizacionSimple(Image original, int umbral){
        
        BufferedImage aux = ImageManager.toBufferedImage(original);
        //recorremos la imagen
        for(int x = 0 ; x< aux.getWidth() ; x++)
        {
            for(int y = 0 ; y < aux.getHeight() ; y++)
            {
                Color pixel = new Color(aux.getRGB(x, y));
                int r = pixel.getRed();
                int g = pixel.getGreen();
                int b = pixel.getBlue();
                
                if(pixel.getRed() <= umbral)
                {
                    r=0;
                }
                else
                {
                    r=255;
                }
                
                if(pixel.getGreen() <= umbral)
                {
                    g=0;
                }
                else
                {
                    g=255;
                }
                if(pixel.getBlue() <= umbral)
                {
                    b=0;
                }
                else
                {
                    b=255;
                }

                pixel = new Color(r,g,b);
                aux.setRGB(x, y, pixel.getRGB());
            }
        }
        return ImageManager.toImage(aux);
    }
}
