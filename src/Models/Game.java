package Models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase Game: implementa la logica del juego.Esta clase esta
 * contenida en la clase Controlador
 * 
 * @author Elkin Samir Angulo Panameño
 * @author Leonardo Cuadro Lopez
 * @author Andres David Ortega 
 * @author Juan Sebastian Tobar Moriones 
 * 
 * @version 1.0
 */

public class Game {

    // Lista de objetos Palabra
    private ArrayList<Palabra> listaRondas;

    // Para añadir las palabras que se vallan encontrando
    private ArrayList<String> palabrasEncontradas;

    // Manejar las rondas
    private int ronda;

    public Game() {
        listaRondas = new ArrayList<Palabra>();
        palabrasEncontradas = new ArrayList<String>();
        ronda = 0;
    }

    /**
     * Esta funcion lee el archivo de texto plano y guarda cada conjunto de letras y
     * las palabras correspondientes en un Array de tipo string para cada conjunto.
     * en total son 10 arrays, ya que hay 10 conjuntos de palabras.
     * Estos 10 arrays son guardados en la variable listaPalabras de tipo ArrayList.
     * 
     * @return un string que confirma si se pudo leer el archivo o no.
     */
    public String leerArchivo() {
        BufferedReader br;
        FileReader fr;
        File archivo;
        String linea;
        String[] datos;

        // Cambié la ruta en la que se guardaba el archivo txt
        archivo = new File("src" + File.separator + "assets" + File.separator + "palabras.txt");

        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                Palabra nuevaPalabra = new Palabra();
                datos = linea.split(",");
                if (datos.length > 0)
                    for (String dato : datos)
                        if (dato.length() <= 1)
                            nuevaPalabra.addLetra(dato);
                        else
                            nuevaPalabra.addPalabra(dato);
                listaRondas.add(nuevaPalabra);
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
     * getter de listaRondas
     * 
     * @return lista de las rondas(palabras)
     */
    public ArrayList<Palabra> getListaRondas() {
        return listaRondas;
    }

    /**
     * getter de ronda
     * 
     * @return retorna un objeto Palabra de la listaRondas.
     */
    public Palabra getRonda() {
        return listaRondas.get(ronda);
    }

    /**
     * @return el numero del indice de la palabra siguiente en la lista ronda
     */
    public int getNumeroRonda() {
        return ronda + 1;
    }

    /**
     * Funcion que aumenta el contador de la ronda y retorna la siguiente palabra de
     * la ronda.
     * 
     * @return retorna el objeto Palabra de la ronda cuando el usuario ha completado
     *         todas las
     *         palabras de la ronda
     */
    public Palabra cambiarRonda() {
        if (ronda >= listaRondas.size() - 1)
            ronda = 0;
        else
            ronda++;
        // Pasamos a una nueva ronda, se borran las palabras encontradas de la anterior
        // ronda
        palabrasEncontradas.clear();
        return listaRondas.get(ronda);
    }

    /**
     * @return la lista de palabras encontradas
     */
    public ArrayList<String> getPalabrasEncontradas() {
        return palabrasEncontradas;
    }

    /**
     * Verifica si String pasado por parámetro está en la lista de palabras de
     * la ronda actual y en la lista de palabras encontradas.
     * 
     * @param palabra
     * @return true o false
     */
    public boolean verificarPalabra(String palabra) {
        if (getRonda().getPalabraByLength(palabra.length()).contains(palabra)
                && !palabrasEncontradas.contains(palabra)) {
            palabrasEncontradas.add(palabra);
            return true;
        }
        return false;
    }
}
