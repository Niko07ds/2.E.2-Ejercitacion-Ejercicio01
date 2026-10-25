package ejercicio01;

/**
 * Módulo de préstamos: consulta y modifica la configuración compartida.
 */
public class LoanModule {

    private final LibraryConfiguration configuration = LibraryConfiguration.getInstance();

    public LibraryConfiguration getConfiguration() {
        return configuration;
    }

    public void showConfiguration() {
        System.out.println("[Módulo de préstamos] " + configuration.getLibraryName()
                + " | Máx. libros por socio: " + configuration.getMaxBooksPerMember()
                + " | Plazo de devolución: " + configuration.getReturnDeadlineDays() + " días");
    }
}
