package Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
    }

    // Al inciar la ronda, añadimos las letras a sus respectivos labels y
    // habilitamos
    // los botones de la gui
    public static void iniciarRonda() {
        // Añadiendo las letras
        ArrayList<String> letrasRonda = game.getRonda().getLetras();
        Collections.shuffle(letrasRonda);
        gui.addBLetras(letrasRonda);
        gui.addNumRonda(game.getNumeroRonda());
        crearMatrizPalabrasPorLongitud();
    
    }

    public static void crearMatrizLabelsPorLongitud(int longitud, String[][] matriz) {
        if (longitud == 3) 
            gui.addMatrizLong3(matriz);
        if (longitud == 4) 
            gui.addMatrizLong4(matriz);
        if (longitud == 5)
            gui.addMatrizLong5(matriz);
        if ( longitud == 6)
            gui.addMatrizLong6(matriz);
    }

    public static void crearMatrizPalabrasPorLongitud() {
        for (int i = 3; i <= 6; i++) {
            // La longitud del array de palabras dependiendo de la longitud
            int cantidadPalabras = game.getRonda().getPalabraByLength(i).size();

            // Matriz de la cantidad de palabras por la longitud de las letras
            String[][] matrizPalabras = new String[cantidadPalabras][i];

            crearMatrizLabelsPorLongitud(i, matrizPalabras);

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
            gui.addLMensaje("CORRECTO :D");
        } else {
            if ( game.getPalabrasEncontradas().contains(palabra) )
                gui.addLMensaje("YA ESCRIBISTE ESTA PALABRA >:(");
            else
                gui.addLMensaje("LA PALABRA NO ES VÁLIDA :'(");
        }
    }

    public static boolean condicionDeVictoria() {
        //Si el tamano de los dos vectores es igual concluimos que el usuario ha superado la ronda
        int tamanioPalabrasEncontradas = game.getPalabrasEncontradas().size();
        int tamanioPalabrasPartida = game.getRonda().getPalabras().size();

        if ( tamanioPalabrasEncontradas == tamanioPalabrasPartida ) {
            gui.addLMensaje("HAZ GANADO ESTA RONDA, PUEDES PASAR A LA SIGUIENTE :D");
            return true;
        } else 
            return false;
    }

    public static void cambiarRonda() {
        game.cambiarRonda();
        iniciarRonda();
    }

}
