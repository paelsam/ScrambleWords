package Models;

import java.util.ArrayList;

/**
 * esta clase esta contenida en la clase game y contine atributos y metodos que
 * gestionan las
 * listas de palabras y letras del archivo de texto.
 */
public class Palabra {

    private ArrayList<String> letras;
    private ArrayList<String> palabras;

    // constructor
    public Palabra() {
        letras = new ArrayList<String>();
        palabras = new ArrayList<String>();
    }

    /**
     * @param letra es un objeto tipo string que representa una letra de la lista de
     *              letras.
     * @return void.
     *         esta funcion adiciona cada letra obtenida del archivo de texto al
     *         atributo lista de letras.
     */

    public void addLetra(String letra) {
        letras.add(letra);
    }

    /**
     * @param palabra objeto de tipo string que representa una palabra obtenida del
     *                archivo de texto
     * @return void
     *         funcion que adiciona cada palabra del archivo de texto a la lista de
     *         palabras.
     */
    public void addPalabra(String palabra) {
        palabras.add(palabra);
    }

    /**
     * @param length parametro de tipo int que representa la longitud de una
     *               palabra.
     * @return una lista donde estan todas las palabras de la lista palabra con la
     *         longitud especificada.
     *         esta funcion saca las palabras de la lista palabras de un determinado
     *         tamaño y debuelve una lista con estas palabras
     */
    public ArrayList<String> getPalabraByLength(int length) {
        ArrayList<String> resultado = new ArrayList<>();
        for (String palabra : palabras) {
            if (palabra.length() == length) {
                resultado.add(palabra);
            }
        }
        return resultado;
    }

    /**
     * 
     * @return la lista de letras.
     */
    public ArrayList<String> getLetras() {
        return letras;
    }

    /**
     * 
     * @return la lista de palabras
     */
    public ArrayList<String> getPalabras() {
        return palabras;
    }
}
