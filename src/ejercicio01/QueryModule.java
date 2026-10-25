package ejercicio01;

/**
 * Módulo de consultas: lee la configuración compartida.
 */
public class QueryModule {

    private final LibraryConfiguration configuration = LibraryConfiguration.getInstance();

    public LibraryConfiguration getConfiguration() {
        return configuration;
    }

    public void showConfiguration() {
        System.out.println("[Módulo de consultas] " + configuration.getLibraryName()
                + " | Máx. libros por socio: " + configuration.getMaxBooksPerMember()
                + " | Plazo de devolución: " + configuration.getReturnDeadlineDays() + " días");
    }
}
