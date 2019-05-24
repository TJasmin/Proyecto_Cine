/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cine.Enumeraciones;

/**
 *
 * @author andres1994
 */
public enum Sueldo {

    TIENDA(16.5), BOLETERIA(26.65), ADMINISTRACION(40);
    double sueldo;

    Sueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }

}
