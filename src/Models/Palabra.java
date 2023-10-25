package Models;

import java.util.ArrayList;

public class Palabra {

    private final ArrayList<String> letras;
    private final ArrayList<String> palabras;

    public Palabra() {
        letras = new ArrayList<String>();
        palabras = new ArrayList<String>();
    }

    public void addLetra(String letra) {
        letras.add(letra);
    }

    public void addPalabra(String palabra) {
        palabras.add(palabra);
    }

    public ArrayList<String> getPalabraByLength(int length) {
        ArrayList<String> resultado = new ArrayList<>();
        for (String palabra : palabras) {
            if (palabra.length() == length) {
                resultado.add(palabra);
            }
        }
        return resultado;
    }

    public ArrayList<String> getLetras() {
        return letras;
    }

    public ArrayList<String> getPalabras() {
        return palabras;
    }
}
