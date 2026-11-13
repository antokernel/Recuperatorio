package parcialmuseocultural;

import java.util.Objects;

/**
 * Modelo base de las obras de la coleccion del museo.
 */
public abstract class Obra {

    private final String codigo;
    private final String autor;
    private final EstadoConservacion estado;

    /**
     * Crea una obra validando sus datos comunes.
     *
     * @param codigo codigo de la obra
     * @param autor autor de la obra
     * @param estado estado de conservacion
     */
    protected Obra(String codigo, String autor, EstadoConservacion estado) {
        validarTexto(codigo, "El codigo es obligatorio.");
        validarTexto(autor, "El autor es obligatorio.");
        if (estado == null) {
            throw new IllegalArgumentException("El estado de conservacion es obligatorio.");
        }
        this.codigo = codigo;
        this.autor = autor;
        this.estado = estado;
    }

    /**
     * Valida que un texto no sea nulo ni este en blanco.
     *
     * @param texto texto a validar
     * @param mensaje mensaje de la excepcion si el texto es invalido
     */
    protected static void validarTexto(String texto, String mensaje) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
    }

    /**
     * Obtiene el codigo.
     *
     * @return codigo de la obra
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Obtiene el autor.
     *
     * @return autor de la obra
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Obtiene el estado de conservacion.
     *
     * @return estado de conservacion
     */
    public EstadoConservacion getEstado() {
        return estado;
    }

    /**
     * Calcula el costo mensual de conservacion segun el tipo de obra.
     * El costo se calcula a partir de los atributos, no se almacena.
     *
     * @return costo mensual de conservacion
     */
    public abstract int calcularCostoMensual();

    /**
     * Arma el texto con los datos comunes a todas las obras.
     *
     * @return datos comunes en formato texto
     */
    protected String datosComunes() {
        return "codigo=" + codigo + ", autor=" + autor + ", estado=" + estado;
    }

    /**
     * La identidad no depende del tipo de obra ni de sus caracteristicas.
     *
     * @param obj objeto a comparar
     * @return true si tienen el mismo codigo y autor
     */
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Obra otra)) {
            return false;
        }
        return codigo.equals(otra.codigo) && autor.equals(otra.autor);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(codigo, autor);
    }
}