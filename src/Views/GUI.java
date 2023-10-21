package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame {

    //Paleta de colores
    public static Color colorFondo = new Color(70,66,94);
    public static Color colorTres = new Color(0,185,190);
    public static Color colorCuatro = new Color(255,238,204);
    public static Color colorCinco = new Color(255,176,163);
    public static Color colorSeis = new Color(255,105,115);
    public static Color colorBorde = new Color(21,120,140);

    //Páneles
    JPanel pNorte;
    JPanel pPalabras;
    JPanel pLongTres, pLongCuatro, pLongCinco, pLongSeis;
    JPanel pLetras;
    JPanel pSur;

    //Botones 
    JButton bIniciarJuego, bSiguienteJuego;
    JButton bEliminarPalabra, bValidarPalabra;

    //Labels
    JLabel lTituloJuego;
    JLabel lRonda;
    JLabel lNumRonda;
    JLabel lPalabra;

    //Constructor
    public GUI() 
    {
        setTitle("Juego de Palabras");
        setSize(800,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setBackground(colorFondo);
    }

    // Generar Labels de las palabras
    public JLabel crearLabel(String texto, Color color) 
    {
        // Instanciando label
        JLabel nuevoLabel = new JLabel(texto);
    
        // Añadiendo background
        nuevoLabel.setBackground(color);
        nuevoLabel.setFocusable(false);
        nuevoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nuevoLabel.setVerticalAlignment(SwingConstants.CENTER);

        return nuevoLabel;
    }


    public void iniciarGUI() 
    {
        //Instanciar Botones
        bIniciarJuego = new JButton("");
        bSiguienteJuego = new JButton("");
        bEliminarPalabra = new JButton("");
        bValidarPalabra = new JButton("");

        lTituloJuego = new JLabel("Juego de Palabras");
        lRonda = new JLabel("Ronda: ");
        lNumRonda = new JLabel();
        lPalabra = new JLabel("PRUEBA");

        //Asignar el tamaño de los labels
        lTituloJuego.setPreferredSize(new Dimension(90,80));
        lRonda.setPreferredSize(new Dimension(70, 80));
        lNumRonda.setPreferredSize(new Dimension(70,80));
        lPalabra.setPreferredSize(new Dimension(70, 80));

        lTituloJuego.setHorizontalAlignment(SwingConstants.CENTER);
        lTituloJuego.setVerticalAlignment(SwingConstants.CENTER);
        lPalabra.setHorizontalAlignment(SwingConstants.CENTER);
        lPalabra.setVerticalAlignment(SwingConstants.CENTER);

        //(Fonts)
        
        //Añadiendo el color de letra a los labels        
        lTituloJuego.setForeground(colorTres);
        lRonda.setForeground(colorTres);
        lNumRonda.setForeground(colorTres);
        lPalabra.setForeground(colorSeis);


        pNorte = new JPanel(new BorderLayout());
        pPalabras = new JPanel(new BorderLayout());
        //(Paneles que contienen las palabras)
        pLetras = new JPanel(new BorderLayout());
        pSur = new JPanel(new BorderLayout());

        //Bordes de los paneles
        pLetras.setBorder(BorderFactory.createBevelBorder(WIDTH,colorBorde,Color.WHITE));
        //(BorderFactory de los paneles)

        //Color de fondo a los paneles
        pNorte.setBackground(colorFondo);
        pPalabras.setBackground(colorFondo);
        pLetras.setBackground(colorFondo);
        pSur.setBackground(colorFondo);

        //Añaniendo componentes en la parte superior
        pNorte.add(bIniciarJuego, BorderLayout.WEST);
        pNorte.add(lTituloJuego, BorderLayout.CENTER);
        // pNorte.add(lRonda);
        // pNorte.add(lNumRonda);
        pNorte.add(bSiguienteJuego, BorderLayout.EAST);

        //Añaniendo componentes en la parte inferior
        pSur.add(bEliminarPalabra, BorderLayout.WEST);
        pSur.add(lPalabra, BorderLayout.CENTER);
        pSur.add(bValidarPalabra, BorderLayout.EAST);


        add(pNorte,BorderLayout.NORTH);
        add(pSur,BorderLayout.SOUTH);

        setBackground(colorFondo);
        setVisible(true);
    }

    

}
