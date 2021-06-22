/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g4s22p10rpr.Almacen;

import g4s22p10rpr.Informacion.Datos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import jdk.jfr.events.FileWriteEvent;


/**
 *
 * @author ABIGAILSOFIA
 */
public class Archivo {
    public void grabar (Datos datos){
        try{
            FileWriter archivo = new FileWriter ("Datos.txt",true);
            BufferedWriter bw = new BufferedWriter(archivo);
            bw.write(datos.getNombre() + "\n");
            bw.write(datos.getEdad() + "\n");
            bw.close();
            
        } catch(Exception ex){
         ex.printStackTrace();
        }
    }
    public List<Datos> leer(){
        List<Datos> Listadatos = new ArrayList<>();
        Datos datos;
        String cadena= "";
        try{
            
            FileReader archivo = new FileReader("Datos.txt");
            BufferedReader br  = new BufferedReader(archivo);
            while ((cadena = br.readLine()) !=null){
                datos = new Datos();
                datos.setNombre(cadena);
                cadena = br.readLine();
                datos.setEdad(Integer.parseInt(cadena));
                Listadatos.add(datos);
            }
            
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return Listadatos;
    }
}
