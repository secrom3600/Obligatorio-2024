package src.uy.edu.um;

import src.uy.edu.um.funciones.Funciones;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static String LectorCSV;

    public static void main(String[] args) {

        Funciones misFunciones = new Funciones();
        misFunciones.cargarMusicas();
        //funcion creada para ver el correcto funcionamiento
        //misFunciones.Top5Canciones50top("2024-05-13");
        //misFunciones.CantArtistaEnTop50EnFecha("Tommy Richman   ","2024-05-13");
        //misFunciones.CancionesConTempo(101.061,127.986,"2024-02-05","2024-05-05");
        //misFunciones.Top7ArtistasEnTops50("2024-02-05","2024-05-05");

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
                    System.out.println("Ingrese el país: ");
                    String pais = scanner.nextLine();
                    System.out.println("Ingrese la fecha en formato (YYYY-MM-DD): ");
                    String fecha = scanner.nextLine();
                    misFunciones.Top10CancionesEnUnDia(pais, fecha);
                    break;
                case 2:
                    System.out.println("Ingrese la fecha en formato (YYYY-MM-DD): ");
                    String dia = scanner.nextLine();
                    misFunciones.Top5Canciones50top(dia);
                    break;
                case 3:
                    System.out.println("Ingrese la fecha de inicio en formato (YYYY-MM-DD):: ");
                    String fechaIn = scanner.nextLine();
                    System.out.println("Ingrese la fecha de fin en formato (YYYY-MM-DD): ");
                    String fechaOut = scanner.nextLine();
                    misFunciones.Top7ArtistasEnTops50(fechaIn, fechaOut);
                    break;
                case 4:
                    System.out.println("Ingrese el artista: ");
                    String artista = scanner.nextLine();
                    System.out.println("Ingrese la fecha en formato (YYYY-MM-DD): ");
                    String fechas = scanner.nextLine();
                    misFunciones.CantArtistaEnTop50EnFecha(artista, fechas);
                    break;
                case 5:
                    System.out.println("Ingrese el tempo inicial: ");
                    Double tempoIn = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Ingrese el tempo final: ");
                    Double tempoOut = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Ingrese la fecha de inicio en formato (YYYY-MM-DD): ");
                    String fechaInicio = scanner.nextLine();
                    System.out.println("Ingrese la fecha de fin en formato (YYYY-MM-DD): ");
                    String fechaFin = scanner.nextLine();
                    misFunciones.CancionesConTempo(tempoIn, tempoOut, fechaInicio, fechaFin);
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
}