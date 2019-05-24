/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cine.Clases;

import cine.Excepciones.MisExcepciones;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author andres1994
 */
public class EntradaDatos {

    Scanner scanner = new Scanner(System.in);
    MisExcepciones misExcepciones = new MisExcepciones();
    public String usuario;
    public String contraseña;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {

        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
        getContraseña();

    }

    public String IngresarUsuario() {
        System.out.println("Ingrese su usuario");
        String usuario = scanner.next();
        return usuario;
    }

    public String IngresarContraseña() {
        System.out.println("Ingrese su contraseña");
        String contraseña = scanner.next();
        return contraseña;

    }

    public String IngresarNombre() {
        System.out.println("Ingrese su nombre");
        String nombre = scanner.next();
        return nombre;

    }

    public String IngresarApellido() {
        System.out.println("Ingrese su apellido");
        String apellido = scanner.next();
        return apellido;

    }

    public int IngresarEdad() {
        boolean errores = true;
        int insertarEdad = 0;
        while (errores) {
            System.out.println("Ingrese su edad");
            String edad = scanner.next();
            try {
                insertarEdad = Integer.parseInt(edad);
                errores = false;

            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor inserte un numero");
                errores = true;
            }

        }
        return insertarEdad;

    }

    public long IngresarIdentificacion() {
        boolean errores = true;
        long insertarIdentificacion = 0;
        while (errores) {
            System.out.println("Ingrese su identificacion");
            String identificacion = scanner.next();
            try {
                insertarIdentificacion = Long.parseLong(identificacion);
                errores = false;
                if (insertarIdentificacion < 1000000000) {
                    misExcepciones.numeroErroneo();
                    errores = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor inserte un numero");
                errores = true;
            }

        }
        return insertarIdentificacion;
    }

    public long IngresarCelular() {
        boolean errores = true;
        long insertarCelular = 0;
        while (errores) {
            System.out.println("Ingrese su numero de Celular");
            String celular = scanner.next();
            try {
                insertarCelular = Long.parseLong(celular);
                errores = false;
                if (insertarCelular < 800000000 || insertarCelular > 999999999) {
                    misExcepciones.numeroErroneo();
                    errores = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor inserte un numero");
                errores = true;
            }

        }
        return insertarCelular;
    }

    public String IngresarDireccion() {
        System.out.println("Ingrese su direccion");
        String direccion = scanner.next();
        return direccion;

    }

    public String IngresarEmail() {
        System.out.println("Ingrese su email");
        String email = scanner.next();
        return email;
    }

    public int IngresarAño() {
        System.out.println("Ingrese el año");
        int año = scanner.nextInt();
        return año;
    }

    public String Actor() {
        System.out.println("Ingres el actor");
        String actor = scanner.next();
        return actor;
    }

    public String Productor() {
        System.out.println("Ingres el productor");
        String productor = scanner.next();
        return productor;
    }

    public String Director() {
        System.out.println("Ingres el director");
        String director = scanner.next();
        return director;
    }

    public String Tamaño() {
        System.out.println("Ingres el tamaño");
        String tamaño = scanner.next();
        return tamaño;
    }

    public float Costo() {
        float costo = 0;
        System.out.println("Ingres el costo");
        try {
            costo = scanner.nextFloat();
        } catch (InputMismatchException ee) {
            System.out.println("Ingreso incorrecto");
        }
        return costo;
    }

    public int Cantidad() {
        int cantidad = 0;
        System.out.println("Ingrese la cantidad");
        try {
            cantidad = scanner.nextInt();
        } catch (InputMismatchException ee) {
            System.out.println("Ingreso incorrecto");
        }
        return cantidad;
    }

    public int Sala() {
        System.out.println("Ingrese el numero de sala");
        int sala = scanner.nextInt();
        return sala;
    }

    public String Horario() {
        System.out.println("Ingrese la hora de la pelicula Ejm: 15:00");
        String hora = scanner.next();
        return hora;
    }

    public String Pelicula() {

        System.out.println("Ingrese la pelicula");
        String nombre = scanner.next();
        return nombre;
    }

    public int Asiento() {
        System.out.println("Ingrese el numero de asiento");
        int asiento = scanner.nextInt();
        return asiento;
    }

    public int codigo() {
        System.out.println("Ingrese el codigo");
        int codigo = scanner.nextInt();
        return codigo;
    }

    public boolean Disponibilidad() {
        System.out.println("Ingrese si esta disponible");
        boolean disponibilidad = scanner.nextBoolean();
        return disponibilidad;
    }

    public int cantidadBoleta() {
        System.out.println("Ingrese numero de boleta adquirida");
        int num = scanner.nextInt();
        return num;
    }
//public boolean facturacion(){
//    System.out.println("Ingrese si realiza facturacion:");
//    
//}
   
}
