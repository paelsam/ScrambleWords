package Controllers;

import Models.Game;
import Views.GUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ControllerGame {
    static private GUI gui;
    static private Game game;

    // Al inciar la ronda, añadimos las letras a sus respectivos labels y habilitamos
    // los botones de la gui
    public static void iniciarRonda() {
        // Añadiendo las letras
        ArrayList<String> letrasRonda = game.getRonda().getLetras();
        gui.addBLetras(letrasRonda);
    }

    public static void imprimirLabelsPorLongitud(int longitud, String[][] matriz) {
        for (String[] palabras : matriz) {
            for (int i = 0; i < palabras.length; i++) {
                if (longitud == 3)
                    gui.addPanelTres(gui.crearLabel("", Color.BLACK));
                if (longitud == 4)
                    gui.addPanelCuatro(gui.crearLabel("", Color.BLACK));
                if (longitud == 5)
                    gui.addPanelCinco(gui.crearLabel("", Color.BLACK));
                if (longitud == 6)
                    gui.addPanelSeis(gui.crearLabel("", Color.BLACK));
            }
        }
    }

    public static void crearMatrizPalabrasPorLongitud() {
        for (int i = 3; i <= 6; i++) {
            ArrayList<String> palabrasPorLongitud = game.getRonda().getPalabraByLength(i);
            // Matriz de la cantidad de palabras por la longitud de las letras
            String[][] matrizPalabras = new String[palabrasPorLongitud.size()][];
            for (int j = 0; j < palabrasPorLongitud.size(); j++) {
                matrizPalabras[j] = palabrasPorLongitud.get(j).trim().split("");
            }
            imprimirLabelsPorLongitud(i, matrizPalabras);
            Arrays.fill(matrizPalabras, null);
        }
    }

    // Verifica la palabra que el usuario haya digitado este correcta
    public static void verificarPalabra(String palabra) {
        boolean resultado = game.verificarPalabra(palabra);
        if (resultado) {
            // Se verifica si la palabra digitada por el usuario es valida y despues mira si cumplio la condicion de victoria
            System.out.println("La palabra es válida.");
            CondicionDeVictoria();
        } else {
            // Mensaje cuando el resultado es false
            System.out.println("La palabra no es válida.");
        }
    }

    //Funcion para establecer la condicion para la victoria de una ronda
    public static boolean CondicionDeVictoria() {
        //Si el tamano de los dos vectores es igual concluimos que el usuario ha superado la ronda
        int tamanoPalabrasEncontradas = game.getPalabrasEncontradas().size();
        int tamanoPalabrasPartida = game.getRonda().getPalabras().size();

        return tamanoPalabrasPartida == tamanoPalabrasEncontradas;
    }

    //Cambiamos de ronda e iniciamos la ronda con las nuevas letras
    public static void CambioDeRonda() {
        if (CondicionDeVictoria()) {
            game.cambiarRonda();
            iniciarRonda();
        }
    }

    public void inciarWindow() {
        gui = new GUI();
        game = new Game();
        gui.iniciarGUI();
        game.leerArchivo();

    }

}
