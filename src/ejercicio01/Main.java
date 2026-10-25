package ejercicio01;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 1: Configuración general de la biblioteca ===");

        LoanModule loanModule = new LoanModule();
        QueryModule queryModule = new QueryModule();

        System.out.println("\n--- Configuración inicial ---");
        loanModule.showConfiguration();
        queryModule.showConfiguration();

        // Comprobación de identidad: ambos módulos deben usar el mismo objeto
        System.out.println("\n--- Comprobación de identidad ---");
        boolean sameInstance = loanModule.getConfiguration() == queryModule.getConfiguration();
        System.out.println("¿Ambos módulos usan el mismo objeto? " + (sameInstance ? "Sí" : "No"));
        System.out.println("Identidad (préstamos): " + System.identityHashCode(loanModule.getConfiguration()));
        System.out.println("Identidad (consultas): " + System.identityHashCode(queryModule.getConfiguration()));

        // Se modifica desde el módulo de préstamos y se verifica en ambos
        System.out.println("\n--- Modificación desde el módulo de préstamos ---");
        loanModule.getConfiguration().setLibraryName("Biblioteca Municipal Sarmiento");
        loanModule.getConfiguration().setMaxBooksPerMember(5);
        loanModule.getConfiguration().setReturnDeadlineDays(21);
        loanModule.showConfiguration();
        queryModule.showConfiguration();

        // Validaciones
        System.out.println("\n--- Validación de valores inválidos ---");
        try {
            loanModule.getConfiguration().setLibraryName("   ");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            queryModule.getConfiguration().setMaxBooksPerMember(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            queryModule.getConfiguration().setReturnDeadlineDays(-7);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- Configuración final (sin cambios por los errores) ---");
        loanModule.showConfiguration();
        queryModule.showConfiguration();
    }
}
