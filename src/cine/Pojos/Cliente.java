package cine.Pojos;

public class Cliente extends Persona {

    private long telefono;
    private boolean esSocio;
    private boolean realizaFacturacion;

    public Cliente(String nombre, String apellido, long identificacion, long telefono, boolean esSocio) {
        super(nombre, apellido, identificacion);
        this.esSocio = esSocio;
        this.telefono = telefono;
        this.identificacion = identificacion;
    }

    public Cliente() {

    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = true;
        if ((o != null) && (o instanceof Empleado)) {
            Cliente cliente = (Cliente) o;
            if (identificacion == cliente.identificacion) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "\tTeléfono: " + + telefono + "\n"
                + "\tEl Cliente es socio: " + esSocio;
    }

    public boolean verificarSiEsSocio() {
        return esSocio;
    }

    public boolean verificarSiFactura(boolean verificarSiFacturacion) {
        return verificarSiFacturacion;
    }

    public long getTelefono() {
        return telefono;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public void setApellido(String newApellido) {
        apellido = newApellido;
    }

    public void setTelefono(long newTelefono) {
        telefono = newTelefono;
    }

    public boolean isEsSocio() {
        return esSocio;
    }

    public void setEsSocio(boolean esSocio) {
        this.esSocio = esSocio;
    }

    public boolean isRealizaFacturacion() {
        return realizaFacturacion;
    }

    public void setRealizaFacturacion(boolean realizaFacturacion) {
        this.realizaFacturacion = realizaFacturacion;
    }

}
