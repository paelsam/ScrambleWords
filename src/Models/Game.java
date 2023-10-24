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

    // Lista de objetos Palabra
    private ArrayList<Palabra> listaPalabras;

    // Para añadir las palabras que se vallan encontrando
    private ArrayList<String> palabrasEncontradas;

    // Manejar las rondas
    private int ronda;

    public Game() {
        listaPalabras = new ArrayList<Palabra>();
        palabrasEncontradas = new ArrayList<>();
        ronda = 0;
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
        BufferedReader br;
        FileReader fr; File archivo;
        String linea; String[] datos;

        // Cambié la ruta en la que se guardaba el archivo txt 
        archivo = new File("src" + File.separator + "assets" + File.separator + "palabras.txt");

        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                Palabra nuevaPalabra = new Palabra();
                datos = linea.split(",");
                if (datos.length > 0) 
                    for ( String dato : datos )
                        if (dato.length() <= 1)
                            nuevaPalabra.addLetra(dato);
                        else
                            nuevaPalabra.addPalabra(dato);
                listaPalabras.add(nuevaPalabra);
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

    public ArrayList<Palabra> getListaPalabras() {
        return listaPalabras;
    }
}
