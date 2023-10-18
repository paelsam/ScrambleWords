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
    private ArrayList<String> letras;
    private ArrayList<String> palabras;
    private int numPalabra;

    public Game() {
        letras = new ArrayList<String>();
        palabras = new ArrayList<String>();
        listaPalabras = new ArrayList<String[]>();
        numPalabra = 0;
    }

    /**
     * Esta funcion lee el archivo de texto plano y guarda cada conjunto de letras y
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

        // Cambié la ruta en la que se guardaba el archivo txt 
        archivo = new File("src" + File.separator + "assets" + File.separator + "palabras.txt");
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                datos = linea.split(",");
                if (datos.length > 0) 
                    listaPalabras.add(datos);
                else
                    continue;
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            return "No se encontró ningun archivo";

        } catch (IOException e) {
            return "No se pudo leer la linea";
        }
        return "Se leyó la informacion del archivo";
    }

    /**
     * Esta funcion se debe utilizar desde el controlador para cambiar de palabra
     * cuando el usuario haya llenado todas las palabras de un conjunto de letras en
     * la GUI.Esta funcion actualiza los Arrays letras y palabras del juego.Cada vez
     * que es llamado pasa a la siguiente palabra.
     */
    public void cambiarPalabra() {
        // Vaciar los ArrayList antes de añadir otro
        letras.clear();
        palabras.clear();
        if (numPalabra < 10) {
            String[] conjunto = listaPalabras.get(numPalabra);
            for (int i = 0; i < conjunto.length; i++) {
                if (conjunto[i].length() <= 1) 
                    letras.add(conjunto[i]); 
                if (conjunto[i].length() >= 3) 
                    palabras.add(conjunto[i]);
            }
            numPalabra++;
        }

    }

    // Obetener el ArrayList de listaPalabras es innecesario

    public int getNumPalabra() {
        return this.numPalabra;
    }

    public ArrayList<String> getLetras() {
        return this.letras;
    }

    public ArrayList<String> getPalabras() {
        return this.palabras;
    }
}
