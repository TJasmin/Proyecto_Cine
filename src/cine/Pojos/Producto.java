package cine.Pojos;

import java.util.Objects;

public class Producto {

    private float costo;
    private String nombre;
    private String tamaño;
    private int cantidad;
    private int codigo;

    public Producto(String nombre, String tamaño, float costo, int cantidad) {
        this.costo = costo;
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.cantidad = cantidad;

    }
    
    public Producto() {

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object d) {
        boolean result = true;
        if ((d != null) && (d instanceof Producto)) {
            Producto pro = (Producto) d;
            if ((nombre.equals(pro.nombre))) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Codigo: " + this.getCodigo() + "\n"
                + "Nombre: " + this.getNombre() + "\n"
                + "Tamaño: " + this.getTamaño() + "\n"
                + "Costo: " + this.getCosto() + "\n"
                + "Cantidad: " + this.getCantidad() + "\n";
    }

    public int getCodigo() {
        return codigo = (int) (Math.random() * 1000);
    }

    public float getCosto() {
        return costo;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setCosto(float newCosto) {
        costo = newCosto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String newNombre) {
        nombre = newNombre;
    }

    public void setTamano(String newTamano) {
        tamaño = newTamano;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean verificarPromocion() {
        return false;
    }

}
