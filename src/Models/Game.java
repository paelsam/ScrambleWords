package Models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Clase Game: implementa la logica del juego.Esta clase esta
 * contenida en la clase Controlador
 * @version 1.0
 */

public class Game {

    private ArrayList<String[]> listaPalabras;
    private int numPalabra;
    private String[] letras;
    private String[] palabras;

    public Game() {
        letras = new String[6];
        palabras = new String[12];
        numPalabra = 0;
    }

    /**
     * esta funcion lee el archivo de texto plano y guarda cada conjunto de letras y
     * las palabras correspondientes en un
     * Array de tipo string para cada conjunto. en total son 10 arrays, ya que hay
     * 10 palabras. Estos 10 arrays son
     * guardados en la variable listaPalabras de tipo ArrayList.
     * 
     * @return un string que confirma si se pudo leer el archivo o no.
     */
    public String leerArchivo() {
        FileReader fr;
        String linea;
        BufferedReader br;
        File archivo;
        String[] datos;

        archivo = new File("src" + File.separator + "palabras.txt");
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            listaPalabras = new ArrayList<String[]>();
            while ((linea = br.readLine()) != null) {
                datos = linea.split(",");
                if (datos.length > 0) {

                    listaPalabras.add(datos);
                }
            }
            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            return "no se encontro ningun archivo";

        } catch (IOException e) {
            return "no se pudo leer la linea";
        }
        return "se leyo la informacion desde archivo";
    }

    /**
     * esta funcion se debe utilizar desde el controlador para cambiar de palabra
     * cuando el usuario haya llenado todas las palabras de un conjunto de letras en
     * la GUI.Esta funcion actualiza los Arrays letras y palabras del juego.Cada vez
     * que es llamado pasa a la siguiente palabra.
     */
    public void cambiarPalabra() {
        if (numPalabra < 10) {
            String[] conjunto = listaPalabras.get(numPalabra);

            for (int i = 0; i < conjunto.length; i++) {
                if (i < 6) {

                    letras[i] = conjunto[i];
                    if (i > 5) {
                        palabras[i] = conjunto[i];
                    }
                }
            }
            numPalabra++;

        }

    }

    public ArrayList<String[]> getListaPalabras() {
        return listaPalabras;
    }

    public int getNumPalabra() {
        return numPalabra;
    }

    public String[] getLetras() {
        return letras;
    }

    public String[] getPalabras() {
        return palabras;
    }
}
