package Controllers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import Models.Game;
import Views.GUI;

public class ControllerGame {
    static private GUI gui;
    static private Game game; 

    public void inciarWindow() {
        gui = new GUI();
        game = new Game();
        gui.iniciarGUI();
        game.leerArchivo();
        game.cambiarRonda(); game.cambiarRonda();
        game.cambiarRonda(); 

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
            ArrayList<String> palabrasPorLongitud = game.getRonda().getPalabraByLength(i);
            // Matriz de la cantidad de palabras por la longitud de las letras
            String[][] matrizPalabras = new String[palabrasPorLongitud.size()][];
            for ( int j = 0; j < palabrasPorLongitud.size(); j++) {
                matrizPalabras[j] = palabrasPorLongitud.get(j).trim().split("");
            }
            imprimirLabelsPorLongitud(i, matrizPalabras);
            Arrays.fill(matrizPalabras, null);
        }
    }

}
