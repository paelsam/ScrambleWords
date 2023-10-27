package Controllers;

import java.util.ArrayList;
import java.util.Arrays;

import Models.Game;
import Views.GUI;

public class ControllerGame {
    static private GUI gui;
    static private Game game;

    public void iniciarWindow() {
        gui = new GUI();
        game = new Game();
        gui.iniciarGUI();
        game.leerArchivo();
        game.cambiarRonda(); cambiarRonda();
    }

    // Al inciar la ronda, añadimos las letras a sus respectivos labels y
    // habilitamos
    // los botones de la gui
    public static void iniciarRonda() {
        // Añadiendo las letras
        ArrayList<String> letrasRonda = game.getRonda().getLetras();
        gui.addBLetras(letrasRonda);
    }

    public void imprimirLabelsPorLongitud(int longitud, String[][] matriz) {
        if (longitud == 3) 
            gui.addMatrizLong3(matriz);
        if (longitud == 4) 
            gui.addMatrizLong4(matriz);
        if (longitud == 5)
            gui.addMatrizLong5(matriz);
        if ( longitud == 6)
            gui.addMatrizLong6(matriz);
    }

    public void crearMatrizPalabrasPorLongitud() {
        for (int i = 3; i <= 6; i++) {
            // La longitud del array de palabras dependiendo de la longitud
            int cantidadPalabras = game.getRonda().getPalabraByLength(i).size();

            // Matriz de la cantidad de palabras por la longitud de las letras
            String[][] matrizPalabras = new String[cantidadPalabras][i];

            imprimirLabelsPorLongitud(i, matrizPalabras);

            // Se llena la matriz de Palabras con null
            Arrays.fill(matrizPalabras, null);
        }
    }

    public static void verificarPalabra(String palabra) {
        boolean resultado = game.verificarPalabra(palabra);
        if (resultado) {
            int posicionPalabra =  game.getRonda().getPalabraByLength(palabra.length()).indexOf(palabra);
            // Imprime la palabra en la GUI
            gui.showPalabra(palabra, posicionPalabra);
            System.out.println("La palabra es válida.");
        } else {
            // Mensaje cuando el resultado es false
            System.out.println("La palabra no es válida.");
        }
    }

    public static void cambiarRonda() {
        game.cambiarRonda();
        iniciarRonda();
    }

}
