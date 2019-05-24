package cine.Pojos;

import cine.Interfaces.ListarObjeto;
import java.util.Objects;

public class Pelicula {

    private String actor;
    private String director;
    private String productor;
    private String nombre;
    private boolean disponibilidad;
    private int año;

    public Pelicula(String nombre, int año, String actor, String director, String productor, boolean disponibilidad) {
        this.actor = actor;
        this.director = director;
        this.productor = productor;
        this.nombre = nombre;
        this.año = año;
        this.disponibilidad = disponibilidad;
    }

    public Pelicula() {
    }
    @Override
 public boolean equals(Object p) {
        boolean result = true;
        if ((p != null) && (p instanceof Pelicula)) {
            Pelicula peli = (Pelicula) p;
            if ((nombre.equals(peli.nombre))) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.nombre);
        return hash;
    }
    @Override
    public String toString() {
        return "Nombre: " + this.getNombre() + "\n"
                + "Año: " + this.getAño() + "\n"
                + "Actor: " + this.getActor() + "\n"
                + "Director:" + this.getDirector() + "\n"
                + "Productor: " + this.getProductor() + "\n"
                + "Dusponibilidad: " + this.isDisponibilidad()+ "\n";
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String newActor) {
        actor = newActor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String newDirector) {
        director = newDirector;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String newProductor) {
        productor = newProductor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String newNombre) {
        nombre = newNombre;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int newAño) {
        año = newAño;
    }
}
