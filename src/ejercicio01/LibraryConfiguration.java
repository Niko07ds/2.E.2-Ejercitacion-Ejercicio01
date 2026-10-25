package ejercicio01;

/**
 * Configuración general de la biblioteca.
 * Singleton básico con inicialización perezosa (lazy).
 */
public class LibraryConfiguration {

    // Única instancia de la clase; se crea la primera vez que se solicita
    private static LibraryConfiguration instance;

    private String libraryName;
    private int maxBooksPerMember;
    private int returnDeadlineDays;

    // Constructor privado: impide instanciar la clase desde el código cliente
    private LibraryConfiguration() {
        this.libraryName = "Biblioteca Central";
        this.maxBooksPerMember = 3;
        this.returnDeadlineDays = 14;
    }

    // Punto de acceso global: devuelve siempre la misma instancia
    public static synchronized LibraryConfiguration getInstance() {
        if (instance == null) {
            instance = new LibraryConfiguration();
        }
        return instance;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        if (libraryName == null || libraryName.isBlank()) {
            throw new IllegalArgumentException("El nombre de la biblioteca no puede estar vacío.");
        }
        this.libraryName = libraryName.trim();
    }

    public int getMaxBooksPerMember() {
        return maxBooksPerMember;
    }

    public void setMaxBooksPerMember(int maxBooksPerMember) {
        if (maxBooksPerMember <= 0) {
            throw new IllegalArgumentException("El máximo de libros por socio debe ser mayor a cero.");
        }
        this.maxBooksPerMember = maxBooksPerMember;
    }

    public int getReturnDeadlineDays() {
        return returnDeadlineDays;
    }

    public void setReturnDeadlineDays(int returnDeadlineDays) {
        if (returnDeadlineDays <= 0) {
            throw new IllegalArgumentException("El plazo de devolución debe ser mayor a cero.");
        }
        this.returnDeadlineDays = returnDeadlineDays;
    }
}
