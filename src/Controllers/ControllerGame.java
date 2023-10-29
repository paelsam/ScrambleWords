package Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import Models.Game;
import Views.GUI;

/**
 * clase Controller game la cual contiene a la clase game y la clase GUI y es la
 * que gestiona
 * la interaccion entre las dos clases
 */
public class ControllerGame {
    static private GUI gui;
    static private Game game;

    /**
     * esta funcion implementa la clase gui, la clase game y llama a los metods
     * iniciarGUI
     * y leer archivo para inicializar el juego
     */
    public void iniciarWindow() {
        gui = new GUI();
        game = new Game();
        gui.iniciarGUI();
        game.leerArchivo();
    }

    /**
     * esta función se encarga de iniciar la ronda del juego en la que se carga una
     * palabra
     * de la clase game en la GUI para que se muestre gráficamente en los toggle
     * Buttons
     * y se cargen las matrices que contendrán las palabras en los Jpanel.
     */
    public static void iniciarRonda() {
        // Añadiendo las letras
        ArrayList<String> letrasRonda = game.getRonda().getLetras();
        Collections.shuffle(letrasRonda);
        gui.addBLetras(letrasRonda);
        gui.addNumRonda(game.getNumeroRonda());
        crearMatrizPalabrasPorLongitud();

    }

    /**
     * esta funcion es una función llamada desde la función
     * crearMatrizPalabrasPorLongitud para instanciar los labels de las palabras en
     * la GUI
     * 
     * @param longitud tipo entero que representa la longitud de las palabras que
     *                 estan contenidas en la matriz
     * @param matriz   de tipo Array, este parametro representa una matriz con las
     *                 palabras de determinada longitud
     */
    public static void crearMatrizLabelsPorLongitud(int longitud, String[][] matriz) {
        if (longitud == 3)
            gui.addMatrizLong3(matriz);
        if (longitud == 4)
            gui.addMatrizLong4(matriz);
        if (longitud == 5)
            gui.addMatrizLong5(matriz);
        if (longitud == 6)
            gui.addMatrizLong6(matriz);
    }

    /**
     * esta funcion es la que crea una matriz nula de acuerdo a la cantidad de
     * palabras de determinada longitud
     * y llama a la fución crearMatrizLabelsPorLongitud para crear las matrices de
     * labels en la GUI.
     */
    public static void crearMatrizPalabrasPorLongitud() {
        for (int i = 3; i <= 6; i++) {
            // La longitud del array de palabras dependiendo de la longitud
            int cantidadPalabras = game.getRonda().getPalabraByLength(i).size();

            // Matriz de la cantidad de palabras por la longitud de las letras
            String[][] matrizPalabras = new String[cantidadPalabras][i];

            crearMatrizLabelsPorLongitud(i, matrizPalabras);

            // Se llena la matriz de Palabras con null
            // Arrays.fill(matrizPalabras, null);
        }
    }

    /**
     * esta función verifica si una palabra que ha escrito el usuario está en la
     * lista de
     * palabras de la ronda actual, entonces se introduce dicha palabra en la matriz
     * de Labels en la GUI,
     * si la palabra no está en la ronda actual, entonces se la agrega a la lista de
     * palabras encontradas
     * si esta en ella, sino se notifica al usuario que la palabra es incorrecta.
     * 
     * @param palabra tipo String, que representa una palabra que a escrito el
     *                usuario en la GUI
     */
    public static void verificarPalabra(String palabra) {
        boolean resultado = game.verificarPalabra(palabra);
        if (resultado) {
            int posicionPalabra = game.getRonda().getPalabraByLength(palabra.length()).indexOf(palabra);
            // Imprime la palabra en la GUI
            gui.showPalabra(palabra, posicionPalabra);
            gui.addLMensaje("CORRECTO :D");
        } else {
            if (game.getPalabrasEncontradas().contains(palabra))
                gui.addLMensaje("YA ESCRIBISTE ESTA PALABRA >:(");
            else
                gui.addLMensaje("LA PALABRA NO ES VÁLIDA :'(");
        }
    }

    /**
     * esta funcion invoca a la funcion cambiarRonda de la clase game para
     * actualizar la listaRondas y
     * comenzar un nueva ronda o partida en el juego.
     */
    public static void cambiarRonda() {
        game.cambiarRonda();
        iniciarRonda();
    }

}
