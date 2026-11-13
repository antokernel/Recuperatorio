package parcialmuseocultural;

import java.util.ArrayList;
import java.util.List;

/**
 * Museo que administra una coleccion de obras de distintos tipos.
 */
public class Museo {

    private final String nombre;
    private final List<Obra> obras;

    /**
     * Crea un museo vacio.
     *
     * @param nombre nombre del museo
     */
    public Museo(String nombre) {
        Obra.validarTexto(nombre, "El nombre del museo es obligatorio.");
        this.nombre = nombre;
        this.obras = new ArrayList<>();
    }

    /**
     * Obtiene el nombre del museo.
     *
     * @return nombre del museo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Incorpora una obra si no existe otra con el mismo codigo y autor.
     *
     * @param obra obra a incorporar
     * @throws ObraDuplicadaException si ya existe una obra igual
     */
    public void agregarObra(Obra obra) throws ObraDuplicadaException {
        if (obra == null) {
            throw new IllegalArgumentException("La obra es obligatoria.");
        }
        if (obras.contains(obra)) {
            throw new ObraDuplicadaException("Ya existe una obra con codigo '"
                    + obra.getCodigo() + "' y autor '" + obra.getAutor() + "'.");
        }
        obras.add(obra);
    }

    /**
     * Devuelve una copia de las obras, respetando el orden de insercion.
     *
     * @return lista de obras
     */
    public List<Obra> obtenerObras() {
        return new ArrayList<>(obras);
    }

    /**
     * Filtra las obras por estado de conservacion, respetando el orden de insercion.
     *
     * @param estado estado buscado
     * @return obras con el estado indicado
     */
    public List<Obra> filtrarPorEstado(EstadoConservacion estado) {
        if (estado == null) {
            throw new IllegalArgumentException("El estado es obligatorio.");
        }
        List<Obra> resultado = new ArrayList<>();
        for (Obra obra : obras) {
            if (obra.getEstado() == estado) {
                resultado.add(obra);
            }
        }
        return resultado;
    }

    /**
     * Devuelve la obra con mayor costo mensual de conservacion.
     * Si hay empate, devuelve la primera encontrada.
     *
     * @return obra de mayor costo, o null si no hay obras
     */
    public Obra obtenerObraDeMayorCosto() {
        Obra mayor = null;
        for (Obra obra : obras) {
            if (mayor == null || obra.calcularCostoMensual() > mayor.calcularCostoMensual()) {
                mayor = obra;
            }
        }
        return mayor;
    }
}