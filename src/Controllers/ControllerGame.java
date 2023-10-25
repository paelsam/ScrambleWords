package Controllers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JLabel;

import Models.Game;
import Views.GUI;

public class ControllerGame {
    static private GUI gui;
    static private Game game; 
    static private ArrayList<String[][]> matricesPalabras;

    public void iniciarWindow() {
        gui = new GUI();
        game = new Game();
        matricesPalabras = new ArrayList<>();
        gui.iniciarGUI();
        game.leerArchivo();
    }

    // Al inciar la ronda, añadimos las letras a sus respectivos labels y habilitamos
    // los botones de la gui
    public void iniciarRonda() {
        // Añadiendo las letras
        ArrayList<String> letrasRonda = game.getRonda().getLetras();
        gui.addBLetras(letrasRonda);
    }

    public void imprimirLabelsPorLongitud(int longitud, String[][] matriz) {
        for ( String[] palabras : matriz ) {
            for ( int i = 0; i < palabras.length; i++ ) {
                if ( longitud == 3 ) 
                    gui.addPanelTres(gui.crearLabel("", Color.BLACK));
                if ( longitud == 4 )      
                    gui.addPanelCuatro(gui.crearLabel("", Color.BLACK)); 
                if ( longitud == 5 )
                    gui.addPanelCinco(gui.crearLabel("", Color.BLACK));
                if ( longitud == 6 )
                    gui.addPanelSeis(gui.crearLabel("", Color.BLACK));
            }
        }
    }


    public void crearMatrizPalabrasPorLongitud() {
        for ( int i = 3; i <= 6; i++ ) {
            // Se llama la matriz dependiendo de la longitud
            ArrayList<String> palabrasPorLongitud = game.getRonda().getPalabraByLength(i);
            int cantidadPalabras = palabrasPorLongitud.size();

            // Matriz de la cantidad de palabras por la longitud de las letras
            String[][] matrizPalabras = new String[cantidadPalabras][];

            // Se añade a la matriz el array de letras de la palabra correspondiente
            for ( int j = 0; j < palabrasPorLongitud.size(); j++) {
                matrizPalabras[j] = palabrasPorLongitud.get(j).trim().split("");
            }

            // Se añade la matriz de palabras al ArrayList 
            matricesPalabras.add(matrizPalabras);

            imprimirLabelsPorLongitud(i, matrizPalabras);

            // Se vacía la matriz de palabras nuevamente
            Arrays.fill(matrizPalabras, null);
        }
    }

    public static void verificarPalabra(String palabra) {
        boolean resultado = game.verificarPalabra(palabra);
        if (resultado) {
            // Mensaje cuando el resultado es true
            System.out.println("La palabra es válida.");
        } else {
            // Mensaje cuando el resultado es false
            System.out.println("La palabra no es válida.");
        }
    }

}
