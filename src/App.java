import Controllers.ControllerGame;

public class App {
    public static void main(String[] args) throws Exception {
        ControllerGame miJuego = new ControllerGame();
        miJuego.inciarWindow();
        ControllerGame.iniciarRonda();
        ControllerGame.crearMatrizPalabrasPorLongitud();

        // GUI miGUI = new GUI();
        // miGUI.iniciarGUI();
    }
}
