import Controllers.ControllerGame;

public class App {
    public static void main(String[] args) throws Exception     
    {
        ControllerGame miJuego = new ControllerGame();
        miJuego.inciarWindow();
        miJuego.iniciarRonda();
        miJuego.crearMatrizPalabrasPorLongitud();

        // GUI miGUI = new GUI();
        // miGUI.iniciarGUI();
    }
}
