import java.util.Scanner;

public class CesdeE {

    static Scanner sc = new Scanner(System.in);
    static String[][] estudiantes = new String[1][4]; // [Id, Nombre, Contraseña, Promedio]
    static double[] colegiaturas = new double[5];

    public static void main(String[] args) {
        agregarEstudiantes();
        mostrarResumen();
    }

    public static void agregarEstudiantes() {
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println("Ingrese el ID del estudiante:");
            estudiantes[i][0] = sc.nextLine();  // ID

            System.out.println("Ingrese el nombre del estudiante:");
            estudiantes[i][1] = sc.nextLine();  // Nombre

            System.out.println("Ingrese la contraseña del estudiante:");
            estudiantes[i][2] = sc.nextLine();  // Contraseña

            // Ingreso de notas
            double sumaNotas = 0;
            for (int j = 1; j <= 3; j++) {
                System.out.print("Ingrese la nota " + j + " (máximo 5.0): ");
                double nota = sc.nextDouble();
                while (nota < 0.0 || nota > 5.0) {
                    System.out.print("Nota inválida. Ingrese de nuevo: ");
                    nota = sc.nextDouble();
                }
                sumaNotas += nota;
            }
            sc.nextLine(); // Consumir la línea restante
            estudiantes[i][3] = String.valueOf(sumaNotas / 3); // Promedio como cadena

            // Calcular colegiatura
            double promedio = Double.parseDouble(estudiantes[i][3]);
            if (promedio >= 4.0) {
                colegiaturas[i] = 293000 * 0.8; // 20% de descuento
            } else {
                colegiaturas[i] = 293000; // Sin descuento
            }
            System.out.println("Estudiante registrado con éxito.\n");
        }
    }

    public static void mostrarResumen() {
        System.out.println("\nResumen de estudiantes:");
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i][0] != null) {
                System.out.println("ID: " + estudiantes[i][0] +
                        ", Nombre: " + estudiantes[i][1] +
                        ", Promedio: " + estudiantes[i][3] +
                        ", Colegiatura: $" + colegiaturas[i]);
            }
        }
    }
}


