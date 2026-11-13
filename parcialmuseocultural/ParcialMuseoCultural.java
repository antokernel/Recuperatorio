
package parcialmuseocultural;

import java.util.List;

/**
 * Programa principal del parcial: Sistema Gestion Museo Cultural.
 */
public class ParcialMuseoCultural {

    /**
     * Punto de entrada del programa.
     *
     * @param args argumentos de linea de comandos (no se usan)
     */
    public static void main(String[] args) {
        Museo museo = new Museo("Museo Aurora");

        try {
            museo.agregarObra(new Pintura("OB-101", "L. Vega",
                    EstadoConservacion.DELICADO, 500));
            museo.agregarObra(new Escultura("OB-102", "M. Solis",
                    EstadoConservacion.REGULAR, 12));
            museo.agregarObra(new DocumentoAntiguo("OB-103", "Anonimo",
                    EstadoConservacion.DELICADO, 300));
            museo.agregarObra(new Pintura("OB-104", "M. Solis",
                    EstadoConservacion.BUENO, 700));
            museo.agregarObra(new Escultura("OB-101", "L. Vega",
                    EstadoConservacion.BUENO, 5));
        } catch (ObraDuplicadaException e) {
            System.out.println("No se pudo agregar: " + e.getMessage());
        }

        System.out.println("Obras registradas:");
        mostrarObras(museo.obtenerObras());

        System.out.println("\nPlanes de restauracion:");
        mostrarRestauraciones(museo.obtenerObras());

        System.out.println("\nPreparacion de exhibiciones:");
        mostrarExhibiciones(museo.obtenerObras());

        System.out.println("\nObras en estado DELICADO:");
        mostrarObras(museo.filtrarPorEstado(EstadoConservacion.DELICADO));

        System.out.println("\nObra de mayor costo:");
        mostrarMayorCosto(museo.obtenerObraDeMayorCosto());
    }

    private static void mostrarObras(List<Obra> obras) {
        for (Obra obra : obras) {
            System.out.println(obra);
        }
    }

    private static void mostrarRestauraciones(List<Obra> obras) {
        for (Obra obra : obras) {
            if (obra instanceof Restaurable restaurable) {
                System.out.println(restaurable.generarPlanRestauracion());
            } else {
                System.out.println("La obra " + obra.getCodigo() + " no admite restauracion.");
            }
        }
    }

    private static void mostrarExhibiciones(List<Obra> obras) {
        for (Obra obra : obras) {
            if (obra instanceof Exhibible exhibible) {
                System.out.println(exhibible.prepararExhibicion());
            } else {
                System.out.println("La obra " + obra.getCodigo() + " no admite exhibicion.");
            }
        }
    }

    private static void mostrarMayorCosto(Obra obra) {
        if (obra == null) {
            System.out.println("No hay obras registradas.");
        } else {
            System.out.println(obra);
        }
    }
}