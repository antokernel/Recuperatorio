
package parcialmuseocultural;


public class Escultura extends Obra implements Exhibible {
    private final int pesoKg;
    
    public Escultura(String codigo, String autor, EstadoConservacion estado, 
            int pesoKg) {
        super(codigo, autor, estado);
        if(pesoKg <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que cero.");
        }
        this.pesoKg = pesoKg;
    }
    public int getPesoKg() {
        return pesoKg;
    }
    @Override
    
    public int calcularCostoMensual() {
        return 80 + pesoKg * 15;
    }
    @Override
    public String prepararExhibicion() {
        return "Exhibicion de escultura preparada: " + getCodigo();
    }
    @Override
    public String toString() {
        return "Escultura [" + datosComunes() + ", pesoKg" + pesoKg 
                + ", costo=" + calcularCostoMensual() + "]";
    }
    
}