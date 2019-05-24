package cine.Pojos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {

    private String fecha;
    private int codigo;
    private Boleteria boleteria;
    private Tienda tienda;

    public Factura(String fecha, Boleteria boleteria, Tienda tienda) {
        this.fecha = fechaActual();
        this.codigo = codigo;
        this.boleteria = boleteria;
        this.tienda = tienda;
    }

    public Factura() {

    }

    public String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        return format.format(fecha);
    }

    public String getFecha() {
        return fechaActual();
    }

    public void setFecha(String newFecha) {
        fecha = newFecha;
    }

    public int getCodigo() {
        return codigo = (int) (Math.random() * 1000);
    }

    public Boleteria getBoleteria() {
        return boleteria;
    }

    public void setBoleteria(Boleteria newBoleteria) {
        boleteria = newBoleteria;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda newTienda) {
        tienda = newTienda;
    }

    public String toString() {
        return "Fecha: " + this.getFecha() + "\n"
                + "Código: " + this.getCodigo();
    }
}
