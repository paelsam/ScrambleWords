package Models;

import java.util.ArrayList;

/**
 * Esta clase esta contenida en la clase game y contine atributos y metodos que
 * gestionan las listas de palabras y letras del archivo de texto.
 * 
 * @author Elkin Samir Angulo Panameño
 * @author Leonardo Cuadro Lopez
 * @author Andres David Ortega 
 * @author Juan Sebastian Tobar Moriones 
 * 
 * @version 1.0
 */
public class Palabra {

    private ArrayList<String> letras;
    private ArrayList<String> palabras;

    public Palabra() {
        letras = new ArrayList<String>();
        palabras = new ArrayList<String>();
    }

    /**
     * Funcion que adiciona cada letra obtenida del archivo de texto al atributo
     * lista de letras.
     * 
     * @param letra es un objeto tipo string que representa una letra de la lista de
     *              letras.
     * 
     * @return void
     */
    public void addLetra(String letra) {
        letras.add(letra);
    }

    /**
     * Funcion que adiciona cada palabra del archivo de texto a la lista de
     * palabras.
     * 
     * @param palabra objeto de tipo string que representa una palabra obtenida del
     *                archivo de texto
     * 
     * @return void
     */
    public void addPalabra(String palabra) {
        palabras.add(palabra);
    }

    /**
     * Funcion que retorna las palabras de la lista palabras de un determinado
     * tamaño y devuelve una lista con estas palabras
     * 
     * @param length parametro de tipo int que representa la longitud de una
     *               palabra.
     * 
     * @return una lista donde estan todas las palabras de la lista palabra con la
     *         longitud especificada.
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
     * getter del ArrayList de letras
     * 
     * @return la lista de letras.
    */
    public ArrayList<String> getLetras() {
        return letras;
    }

    /**
     * getter del ArrayList de palabras 
     * 
     * @return la lista de palabras
    */
    public ArrayList<String> getPalabras() {
        return palabras;
    }
}
