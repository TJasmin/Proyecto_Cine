/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cine.Pojos;

import java.util.Objects;

/**
 *
 * @author US
 */
public class Empleado extends Persona {

    private String usuario;
    private String contraseña;
    private double sueldoDiario;
    protected int edad;
    private int diasTrabajados = 0;

    public Empleado(String nombre, String apellido, int edad, long identificacion, double sueldo, String usuario, String contraseña) {
        super(nombre, apellido, identificacion);
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.identificacion = identificacion;
        this.sueldoDiario = sueldo;
        this.contraseña = contraseña;
        this.usuario = usuario;
    }

    public Empleado() {
    }

    public String registrarSugerenciasYReclamos() {
        return null;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String newUsuario) {
        usuario = newUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int newEdad) {
        edad = newEdad;
    }

    public double getSueldoDiario() {
        return sueldoDiario;
    }

    public void setSueldoDiario(double sueldoDiario) {
        this.sueldoDiario = sueldoDiario;
    }

    public void setContraseña(String newContraseña) {
        contraseña = newContraseña;
    }

    public void verificarSiFactura() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.usuario);
        hash = 61 * hash + Objects.hashCode(this.contraseña);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj != null) && (obj instanceof Empleado)) {
            Empleado empleado = (Empleado) obj;
            if (usuario.equals(empleado.usuario) || identificacion == empleado.identificacion) {
                return true;
            }
        }
        return false;

    }

    @Override
    public String toString() {
        return "\n"
                + super.toString() + "\n"
                + "\tEdad: " + edad + " años\n"
                + "\tSueldo Diario: " + sueldoDiario;
    }

    public int asistir() {
        diasTrabajados++;
        if (diasTrabajados > 30) {
            diasTrabajados = 1;
        }
        return diasTrabajados;

    }

}
