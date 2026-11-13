
package parcialmuseocultural;


public class DocumentoAntiguo extends Obra implements Restaurable {
    private final int antiguedadAnios;
    
    public DocumentoAntiguo(String codigo, String autor, EstadoConservacion estado, 
            int antiguedadAnios) {
        super(codigo, autor, estado);
        if(antiguedadAnios <= 0) {
            throw new IllegalArgumentException("La antiguedad debe ser mayor que cero.");
        }
        this.antiguedadAnios = antiguedadAnios;
    }
    
    public int getAntiguedadAnios() {
        return antiguedadAnios;
    }
    @Override
    public int calcularCostoMensual() {
        return 60 + antiguedadAnios / 5;
    }
    @Override
    public String generarPlanRestauracion() {
        return "Plan de restauracion de documento: " + getCodigo();
    }
    @Override
    public String toString() {
        return "DocumentoAntiguo [" + datosComunes() + ", antiguedadAnios=" + antiguedadAnios 
                + ", costo=" + calcularCostoMensual() + "]";
    }
}
