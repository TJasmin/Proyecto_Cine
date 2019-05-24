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
public enum Facturacion {

    NO_FACTURA(true), SI_FACTURA(false);
    boolean respuesta;

    private Facturacion(boolean respuesta) {
        this.respuesta = respuesta;
    }

    public boolean isRespuesta() {
        return respuesta;
    }
}
