import Models.Game;

public class App {
    public static void main(String[] args) throws Exception {
        Game palabras = new Game();
        palabras.leerArchivo();
        palabras.cambiarPalabra();
        palabras.cambiarPalabra();
        palabras.cambiarPalabra();
        
        for ( String uletras : palabras.getLetras())
            System.out.println(uletras);
        for ( String upalabras : palabras.getPalabras() )
            System.out.println(upalabras);
    }
}
