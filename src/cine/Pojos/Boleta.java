package cine.Pojos;

public class Boleta {

    private int numeroDeBoleta;
    private int numeroDeAsiento;
    private int numeroDeSala;
    private String horarioDePelicula; 
    private Pelicula pelicula;
    
    public Boleta(int numeroDeAsiento, int numeroDeSala, Pelicula pelicula,String horarioDePelicula) {
        this.numeroDeAsiento = numeroDeAsiento;
        this.numeroDeSala = numeroDeSala;
        this.horarioDePelicula = horarioDePelicula;
        this.pelicula = pelicula;

    }

    public int getNumeroDeBoleta() {
        return numeroDeBoleta;
    }

    public void setNumeroDeBoleta(int newNumeroDeBoleta) {
        numeroDeBoleta = newNumeroDeBoleta;
    }

    public int getNumeroDeAsiento() {
        return numeroDeAsiento;
    }

    public void setNumeroDeAsiento(int newNumeroDeAsiento) {
        numeroDeAsiento = newNumeroDeAsiento;
    }

    public int getNumeroDeSala() {
        return numeroDeSala;
    }

    public void setNumeroDeSala(int newNumeroDeSala) {
        numeroDeSala = newNumeroDeSala;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula newPelicula) {
        pelicula = newPelicula;
    }
    public String getHorarioDePelicula() {
        return horarioDePelicula;
    }

    public void setHorarioDePelicula(String horarioDePelicula) {
        this.horarioDePelicula = horarioDePelicula;
    }
    @Override
    public String toString() {
        return "Pelicula: " + pelicula.getNombre() + "\n"
                +"Numero de sala: " + getNumeroDeSala() + "\n"
                +"Numero de asiento: " + getNumeroDeAsiento() + "\n"
                +"Hora: " + getHorarioDePelicula();
    }
}
