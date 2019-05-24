package cine.Pojos;

public class Persona {

    protected String nombre;
    protected long identificacion;
    protected String apellido;

    public Persona(String nombre, String apellido, long identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.apellido = apellido;
    }

    public Persona() {
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String newNombre) {
        nombre = newNombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(long newIdentificacion) {
        identificacion = newIdentificacion;
    }

    @Override
    public String toString() {
        return "\tNombre: " + nombre +" " + apellido+"\n "
                + "\tIdentificacion: " + identificacion;
    }
    

}
