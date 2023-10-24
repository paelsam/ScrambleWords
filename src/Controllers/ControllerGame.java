package Controllers;

import java.util.ArrayList;

import Models.Game;
import Views.GUI;

public class ControllerGame {
    static private GUI gui;
    static private Game game; 

    public void inciarWindow() {
        gui = new GUI();
        game = new Game();
        gui.iniciarGUI();
        game.leerArchivo();
    }

    // Al inciar la ronda, añadimos las letras a sus respectivos labels y habilitamos
    // los botones de la gui
    public void iniciarRonda() {

        // Añadiendo las letras
        ArrayList<String> letrasRonda = game.getRonda().getLetras();
        gui.addBLetras(letrasRonda);

        
    }

}
