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
public enum Socio {
    ES_SOCIO(true),NO_ES_SOCIO(false);
    boolean socio;

    Socio(boolean esSocio) {
        this.socio = esSocio;
    }

    public boolean isSocio() {
        return socio;
    }


    
    
}
