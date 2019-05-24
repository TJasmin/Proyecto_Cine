/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cine.Archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tania
 */
public class Archivo {

    public void leerArchivo(File archivo) {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                linea = br.readLine();
                while (linea != null) {
                    System.out.println(linea);
                    linea = br.readLine();
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("Problema al momento de leer el archivo" + archivo.getPath()+ ex.getMessage());
        }
    }

    public void escrituraArhivo(Object cine ,File archivo) {
        try {
            try (PrintWriter pw = new PrintWriter(new FileWriter(archivo),true)) {
                pw.print(cine);
//                pw.write((String) cine);
                pw.close();
            }
        } 
        catch(FileNotFoundException ffn){
            System.out.println("Archivo no existente");
        }
                catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
