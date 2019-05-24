/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cine.Excepciones;

/**
 *
 * @author andres1994
 */
public class MisExcepciones extends Exception {

    public MisExcepciones(String message) {
        super(message);
    }

    public MisExcepciones() {

    }

    public String numerosFueraDelIntervalo() {
        return "Error: Numero elegido, fuera del intervalo del menu";

    }

    public String dobleRegistro() {
        return "Error: El empleado ya esta registrado";
    }

    public String dobleRegistroPeli() {
        return "Error: La pelicula ya esta registrado";
    }

    public String dobleRegistroPro() {
        return "Error: El producto ya esta registrado";
    }

    public String numeroErroneo() {
        return "Error: El valor ingresado no es posible ";

    }

    public String personaNoEncontrada() {
        return "Error: Persona no encontrado";
    }
    public String Disponibilidad(){
        return "La pelicula ingresada no se encuentra disponible: ";
    }

}
