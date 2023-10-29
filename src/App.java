import Controllers.ControllerGame;

/**
 * Clase app que ejecuta el el método main
 * 
 * @author Elkin Samir Angulo Panameño
 * @author Leonardo Cuadro Lopez
 * @author Andres David Ortega 
 * @author Juan Sebastian Tobar Moriones 
 * 
 * @version 1.0
 */
public class App {
    /**
     * Instancia un objeto de la clase ControllerGame
     * y llama al método inciarWindow que ejecuta el juego
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception     
    {
        ControllerGame miJuego = new ControllerGame();
        miJuego.iniciarWindow();
    }
}
