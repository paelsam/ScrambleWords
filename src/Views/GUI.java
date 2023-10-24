package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

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
    JToggleButton[] bLetras;

    //Labels
    JLabel lTituloJuego;
    JLabel lRonda;
    JLabel lNumRonda;
    JLabel lPalabra;

    //Constructor
    public GUI() 
    {
        setTitle("Scramble Words");
        setSize(940,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

    // Generar Labels de las palabras
    // Los labels deben tener un tamaño de 25
    public JLabel crearLabel(String texto, Color color) 
    {
        // Instanciando label
        JLabel nuevoLabel = new JLabel(texto);
    
        // Añadiendo background, alineación y más estilos
        nuevoLabel.setBackground(color);
        nuevoLabel.setFocusable(false);
        nuevoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nuevoLabel.setVerticalAlignment(SwingConstants.CENTER);
        nuevoLabel.setFont(new Font("VCR OSD Mono", Font.PLAIN, 25));
        nuevoLabel.setBorder(BorderFactory.createLineBorder(colorFondo));
        nuevoLabel.setPreferredSize(new Dimension(30, 30));

        return nuevoLabel;
    }


    public void iniciarGUI() 
    {
        //Instanciar Botones
        bIniciarJuego = new JButton(new ImageIcon(getClass().getResource("/images/start.png"))); 
        bIniciarJuego.setFocusable(false); bIniciarJuego.setBorder(BorderFactory.createLineBorder(colorTres));
        bSiguienteJuego = new JButton(new ImageIcon(getClass().getResource("/images/next.png")));
        bSiguienteJuego.setFocusable(false); bSiguienteJuego.setBorder(BorderFactory.createLineBorder(colorCuatro));
        bEliminarPalabra = new JButton(new ImageIcon(getClass().getResource("/images/trash.png")));
        bEliminarPalabra.setFocusable(false); bEliminarPalabra.setBorder(BorderFactory.createLineBorder(colorCuatro));
        bValidarPalabra = new JButton("");

        bLetras = new JToggleButton[6];
        
        for ( int i = 0;  i < bLetras.length; i++ ) {
            bLetras[i] = new JToggleButton("");
            bLetras[i].setBackground(colorCuatro);
            bLetras[i].setPreferredSize(new Dimension(50,50));
            bLetras[i].setFocusable(false);
            bLetras[i].setFont(new Font("VCR OSD Mono", Font.PLAIN, 25));
        }
        

        // Instanciando labels
        lTituloJuego = new JLabel("Scramble Words");
        lRonda = new JLabel("Ronda: ");
        lNumRonda = new JLabel();
        lPalabra = new JLabel("AMARTE");
                
        //! La fuente se encuentra en la carpeta de assets
        lTituloJuego.setFont(new Font("VCR OSD Mono", Font.PLAIN, 30));
        lPalabra.setFont(new Font("VCR OSD Mono", Font.PLAIN, 35));

        //Asignar el tamaño de los labels
        lRonda.setPreferredSize(new Dimension(70, 80));
        lNumRonda.setPreferredSize(new Dimension(70,80));

        lTituloJuego.setHorizontalAlignment(SwingConstants.CENTER);
        lTituloJuego.setVerticalAlignment(SwingConstants.CENTER);
        lPalabra.setHorizontalAlignment(SwingConstants.CENTER);
        lPalabra.setVerticalAlignment(SwingConstants.CENTER);

        // Añadiendo tamaño a los botones
        bIniciarJuego.setPreferredSize(new Dimension(60,60));
        bSiguienteJuego.setPreferredSize(new Dimension(60, 60));
        bEliminarPalabra.setPreferredSize(new Dimension(60,60));
        bValidarPalabra.setPreferredSize(new Dimension(60, 60));

        // Añadiendo fondo a los botones (Se deben cambiar Leo)
        bIniciarJuego.setBackground(colorFondo);
        bSiguienteJuego.setBackground(colorFondo);
        bEliminarPalabra.setBackground(colorSeis);
        bValidarPalabra.setBackground(colorCinco);

        
        //Añadiendo el color de letra a los labels        
        lTituloJuego.setForeground(colorTres);
        lRonda.setForeground(colorTres);
        lNumRonda.setForeground(colorTres);
        lPalabra.setForeground(colorSeis);

        // Definiendo páneles y añadiendo márgenes
        pNorte = new JPanel(new BorderLayout(10, 10));
        pNorte.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Paneles que guardan la longitud de letras
        pPalabras = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        pLongTres = new JPanel(new FlowLayout()); pLongCuatro = new JPanel(new FlowLayout());
        pLongCinco = new JPanel(new FlowLayout()); pLongSeis = new JPanel(new FlowLayout());
        pLongTres.add(crearLabel("A", Color.BLACK)); pLongTres.add(crearLabel("B", Color.BLACK)); 
        pLongTres.add(crearLabel("C", Color.BLACK));  pLongTres.add(crearLabel("A", Color.BLACK)); pLongTres.add(crearLabel("B", Color.BLACK)); 
        pLongTres.add(crearLabel("C", Color.BLACK)); pLongTres.add(crearLabel("A", Color.BLACK)); pLongTres.add(crearLabel("B", Color.BLACK)); 
        pLongTres.add(crearLabel("C", Color.BLACK));

        pLongTres.setBackground(colorTres);
        pLongTres.setPreferredSize(new Dimension(150, 300));
        pLongTres.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(colorBorde, 3), "3 Letras", TitledBorder.CENTER, TitledBorder.CENTER));
        // Ejemplos (Borrarlos después)
        pLongTres.add(crearLabel("A", Color.BLACK)); pLongTres.add(crearLabel("B", Color.BLACK)); 
        pLongTres.add(crearLabel("C", Color.BLACK));  pLongTres.add(crearLabel("A", Color.BLACK)); pLongTres.add(crearLabel("B", Color.BLACK)); 
        pLongTres.add(crearLabel("C", Color.BLACK)); 

        pLongCuatro.setBackground(colorCuatro);
        pLongCuatro.setPreferredSize(new Dimension(200, 300));
        pLongCuatro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(colorBorde, 3), "4 Letras", TitledBorder.CENTER, TitledBorder.CENTER));
        // Ejemplos (Borrarlos después)
        pLongCuatro.add(crearLabel("A", Color.BLACK)); pLongCuatro.add(crearLabel("B", Color.BLACK)); 
        pLongCuatro.add(crearLabel("C", Color.BLACK)); pLongCuatro.add(crearLabel("D", Color.BLACK));        
        
        pLongCinco.setBackground(colorCinco);
        pLongCinco.setPreferredSize(new Dimension(210, 300));
        pLongCinco.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(colorBorde, 3), "5 Letras", TitledBorder.CENTER, TitledBorder.CENTER));
        // Ejemplos (Borrarlos después)
        pLongCinco.add(crearLabel("A", Color.BLACK)); pLongCinco.add(crearLabel("B", Color.BLACK)); 
        pLongCinco.add(crearLabel("C", Color.BLACK)); pLongCinco.add(crearLabel("D", Color.BLACK));
        pLongCinco.add(crearLabel("E", Color.BLACK));        
        
        pLongSeis.setBackground(colorSeis);
        pLongSeis.setPreferredSize(new Dimension(240, 300));
        pLongSeis.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(colorBorde, 3), "6 Letras", TitledBorder.CENTER, TitledBorder.CENTER));
        // Ejemplos (Borrarlos después)
        pLongSeis.add(crearLabel("A", Color.BLACK)); pLongSeis.add(crearLabel("B", Color.BLACK)); 
        pLongSeis.add(crearLabel("C", Color.BLACK)); pLongSeis.add(crearLabel("D", Color.BLACK));
        pLongSeis.add(crearLabel("E", Color.BLACK)); pLongSeis.add(crearLabel("F", Color.BLACK));       
        

        //(Paneles que contienen las palabras)
        pLetras = new JPanel(new FlowLayout());
        // pLetras.setBorder(BorderFactory.createLineBorder(colorBorde, 2));

        pSur = new JPanel(new BorderLayout(10, 10));
        pSur.setBorder(new EmptyBorder(10, 10, 10, 10));

        //Color de fondo a los paneles
        pNorte.setBackground(colorFondo);
        pPalabras.setBackground(colorBorde);
        pLetras.setBackground(colorFondo);
        pSur.setBackground(colorFondo);

        //Añaniendo componentes en la parte superior
        pNorte.add(bIniciarJuego, BorderLayout.WEST);
        pNorte.add(lTituloJuego, BorderLayout.CENTER);
        // pNorte.add(lRonda);
        // pNorte.add(lNumRonda);
        pNorte.add(bSiguienteJuego, BorderLayout.EAST);

        // Añadiendo componentes en la parte central
        pPalabras.add(pLongTres);
        pPalabras.add(pLongCuatro);
        pPalabras.add(pLongCinco);
        pPalabras.add(pLongSeis);

        //Añaniendo componentes en la parte inferior
        pSur.add(lPalabra, BorderLayout.NORTH);
        pSur.add(pLetras, BorderLayout.SOUTH);

        pLetras.add(bEliminarPalabra);
        for ( JToggleButton toggleButton : bLetras)
            pLetras.add(toggleButton);
        pLetras.add(bValidarPalabra);

        add(pNorte,BorderLayout.NORTH);
        add(pPalabras, BorderLayout.CENTER);
        add(pSur,BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public void addBLetras(ArrayList<String> letras) {
        for ( int i = 0; i < bLetras.length; i++) {
            String el = letras.get(i).toUpperCase();
            bLetras[i].setText(el);
        }
    }
}
