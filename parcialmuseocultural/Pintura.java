
package parcialmuseocultural;

/**
 * Pintura de la coleccion. Puede restaurarse y exhibirse.
 */
public class Pintura extends Obra implements Restaurable, Exhibible {

    private final int superficieCm2;

    /**
     * Crea una pintura.
     *
     * @param codigo codigo de la obra
     * @param autor autor de la obra
     * @param estado estado de conservacion
     * @param superficieCm2 superficie en cm2 (debe ser mayor que cero)
     */
    public Pintura(String codigo, String autor, EstadoConservacion estado,
            int superficieCm2) {
        super(codigo, autor, estado);
        if (superficieCm2 <= 0) {
            throw new IllegalArgumentException("La superficie debe ser mayor que cero.");
        }
        this.superficieCm2 = superficieCm2;
    }

    /**
     * Obtiene la superficie.
     *
     * @return superficie en cm2
     */
    public int getSuperficieCm2() {
        return superficieCm2;
    }

    @Override
    public int calcularCostoMensual() {
        return 100 + superficieCm2 / 10;
    }

    @Override
    public String generarPlanRestauracion() {
        return "Plan de restauracion de pintura: " + getCodigo();
    }

    @Override
    public String prepararExhibicion() {
        return "Exhibicion de pintura preparada: " + getCodigo();
    }

    @Override
    public String toString() {
        return "Pintura [" + datosComunes() + ", superficieCm2=" + superficieCm2
                + ", costo=" + calcularCostoMensual() + "]";
    }
}