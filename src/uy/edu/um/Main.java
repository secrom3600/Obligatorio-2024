package src.uy.edu.um;

import src.uy.edu.um.funciones.LectorCSV;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        LectorCSV misFunciones = new LectorCSV();
        misFunciones.cargarMusicas();
        //funcion creada para ver el correcto funcionamiento

        misFunciones.Top5Canciones50top("2024-04-26");



    }
}