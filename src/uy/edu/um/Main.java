package src.uy.edu.um;

import src.uy.edu.um.funciones.LectorCSV;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        LectorCSV misFunciones = new LectorCSV();
        misFunciones.cargarMusicas();
        //funcion creada para ver el correcto funcionamiento

        misFunciones.Top5Canciones50top("2024-05-13");
        misFunciones.CantArtistaEnTop50EnFecha("Tommy Richman   ","2024-05-13");


    }
}