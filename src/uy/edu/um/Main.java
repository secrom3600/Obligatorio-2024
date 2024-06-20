package src.uy.edu.um;

import src.uy.edu.um.funciones.LectorCSV;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        LectorCSV misFunciones = new LectorCSV();
        misFunciones.cargarMusicas();
        //funcion creada para ver el correcto funcionamiento

        misFunciones.Top5Canciones50top("2024-05-13");
        misFunciones.CantArtistaEnTop50EnFecha("Tommy Richman   ","2024-05-13");
        misFunciones.CancionesConTempo(101.061,127.986,"2024-02-05","2024-05-05");

        misFunciones.Top7ArtistasEnTops50("2024-02-05","2024-05-05");

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Seleccione una opción:");
            System.out.println("1- Top 10 canciones en un país dado");
            System.out.println("2- Top 5 canciones que aparecen en top 50 en un día dado");
            System.out.println("3- Top 7 artistas que más aparecen en los top 50 para un rango de fechas");
            System.out.println("4- Cantidad de veces que aparece un artista específico en un top 50 en una fecha dada");
            System.out.println("5- Cantidad de canciones con un tempo en un rango específico para un rango específico de fechas.");
            System.out.println("6- Salir");
            System.out.print("Ingrese su opción: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (option) {
                case 1:
                    misFunciones.Top10CancionesEnUnDia(misFunciones,scanner);
                    break;
                case 2:
                    misFunciones.Top5Canciones50top(misFunciones, scanner);
                    break;
                case 3:
                    misFunciones.Top7ArtistasEnTops50(misFunciones, scanner);
                    break;
                case 4:
                    misFunciones.CantArtistaEnTop50EnFecha(misFunciones, scanner);
                    break;
                case 5:
                    misFunciones.CancionesConTempo(misFunciones, scanner);
                    break;
                case 6:
                    exit = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }

        scanner.close();
    }
    private static void top10CancionesEnUnDia(LectorCSV misFunciones, Scanner scanner) {
        System.out.print("Ingrese el país: ");
        String pais = scanner.nextLine();
        System.out.print("Ingrese la fecha (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();
        misFunciones.Top10CancionesEnUnDia(pais, fecha);
    }

    private static void top5Canciones50top(LectorCSV misFunciones, Scanner scanner) {
        System.out.print("Ingrese la fecha (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();
        misFunciones.Top5Canciones50top(fecha);
    }

    private static void top7ArtistasEnTops50(LectorCSV misFunciones, Scanner scanner) {
        System.out.print("Ingrese la fecha de inicio (YYYY-MM-DD): ");
        String fechaInicio = scanner.nextLine();
        System.out.print("Ingrese la fecha de fin (YYYY-MM-DD): ");
        String fechaFin = scanner.nextLine();
        misFunciones.Top7ArtistasEnTops50(fechaInicio, fechaFin);
    }

    private static void cantArtistaEnTop50EnFecha(LectorCSV misFunciones, Scanner scanner) {
        System.out.print("Ingrese el nombre del artista: ");
        String artista = scanner.nextLine();
        System.out.print("Ingrese la fecha (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();
        misFunciones.CantArtistaEnTop50EnFecha(artista, fecha);
    }

    private static void cancionesConTempo(LectorCSV misFunciones, Scanner scanner) {
        System.out.print("Ingrese el tempo mínimo: ");
        double tempoMin = scanner.nextDouble();
        System.out.print("Ingrese el tempo máximo: ");
        double tempoMax = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Ingrese la fecha de inicio (YYYY-MM-DD): ");
        String fechaInicio = scanner.nextLine();
        System.out.print("Ingrese la fecha de fin (YYYY-MM-DD): ");
        String fechaFin = scanner.nextLine();
        misFunciones.CancionesConTempo(tempoMin, tempoMax, fechaInicio, fechaFin);
    }
}