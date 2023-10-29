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
import javax.swing.border.TitledBorder;

import Controllers.ControllerGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import java.util.ArrayList;

/**
 * Clase GUI, es la clase que hereda de la clase Jframe e implementa la parte
 * grafica del juego
 */
public class GUI extends JFrame {

    // Paleta de colores
    public static Color colorFondo = new Color(70, 66, 94);
    public static Color colorTres = new Color(0, 185, 190);
    public static Color colorCuatro = new Color(255, 238, 204);
    public static Color colorCinco = new Color(255, 176, 163);
    public static Color colorSeis = new Color(255, 105, 115);
    public static Color colorBorde = new Color(21, 120, 140);

    // Páneles
    JPanel pNorte;
    JPanel pTitulo;
    JPanel pPalabras;
    JPanel pLong3, pLong4, pLong5, pLong6;
    JPanel pLetras;
    JPanel pSur;

    // Botones
    JButton bIniciarJuego, bSiguienteJuego;
    JButton bEliminarPalabra, bValidarPalabra;
    JToggleButton[] bLetras;

    // Labels
    JLabel[][] matrizLong3, matrizLong4, matrizLong5, matrizLong6;
    JLabel lTituloJuego;
    JLabel lRonda;
    JLabel lPalabra;
    JLabel lMensaje;

    // Constructor
    public GUI() {
        setTitle("Scramble Words");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * esta función crea un nuevo Label de la clase JLabel con sus atributos
     * determinados para
     * no repetir código a la hora de crear los labels de la matriz de labels que
     * contendrá la GUI
     * 
     * @param texto de tipo String, representa el texto que contendrá el label
     * @param color de tipo Color, representa el color que tomará el background del
     *              label
     * @return retorna el nuevo label creado de tipo JLabel
     */
    public JLabel crearLabel(String texto, Color color) {
        // Instanciando label
        JLabel nuevoLabel = new JLabel(texto);

        // Añadiendo background, alineación y más estilos
        nuevoLabel.setBackground(color);
        nuevoLabel.setFocusable(false);
        nuevoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nuevoLabel.setVerticalAlignment(SwingConstants.CENTER);
        nuevoLabel.setFont(new Font("VCR OSD Mono", Font.PLAIN, 25));
        nuevoLabel.setBorder(BorderFactory.createLineBorder(colorFondo, 2));
        nuevoLabel.setPreferredSize(new Dimension(30, 30));

        return nuevoLabel;
    }

    /**
     * esta función de tipo void es la que instancia todos los objetos necesarios
     * para que la gui funcione
     * correctamente, aquí se crean los botones, paneles, labels. se adiciona las
     * escuchas y se invocan
     * los métodos heredados de la clase Frame necesarios para que se inicie la GUI
     */
    public void iniciarGUI() {
        // Instanciar Botones y añadiéndole íconos
        bIniciarJuego = new JButton(new ImageIcon(getClass().getResource("/images/start.png")));
        bIniciarJuego.setFocusable(false);
        bIniciarJuego.setBorder(BorderFactory.createLineBorder(colorTres));
        bSiguienteJuego = new JButton(new ImageIcon(getClass().getResource("/images/next.png")));
        bSiguienteJuego.setEnabled(false);
        bSiguienteJuego.setFocusable(false);
        bSiguienteJuego.setBorder(BorderFactory.createLineBorder(colorCuatro));
        bEliminarPalabra = new JButton(new ImageIcon(getClass().getResource("/images/trash.png")));
        bEliminarPalabra.setEnabled(false);
        bEliminarPalabra.setFocusable(false);
        bEliminarPalabra.setBorder(BorderFactory.createLineBorder(colorCuatro));
        bValidarPalabra = new JButton(new ImageIcon(getClass().getResource("/images/check.png")));
        bValidarPalabra.setEnabled(false);
        bValidarPalabra.setFocusable(false);
        bValidarPalabra.setBorder(BorderFactory.createLineBorder(colorCuatro));

        // Instanciando array de botones
        bLetras = new JToggleButton[6];

        for (int i = 0; i < bLetras.length; i++) {
            bLetras[i] = new JToggleButton("");
            bLetras[i].setBackground(colorCuatro);
            bLetras[i].setPreferredSize(new Dimension(50, 50));
            bLetras[i].setFocusable(false);
            bLetras[i].setFont(new Font("VCR OSD Mono", Font.PLAIN, 25));
        }

        // Instanciando labels
        lTituloJuego = new JLabel("SCRAMBLE WORDS");
        lPalabra = new JLabel(" ");
        lRonda = new JLabel("RONDA: ");
        lMensaje = new JLabel(" ");

        // ! La fuente se encuentra en la carpeta de assets
        lTituloJuego.setFont(new Font("VCR OSD Mono", Font.PLAIN, 35));
        lPalabra.setFont(new Font("VCR OSD Mono", Font.PLAIN, 30));
        lRonda.setFont(new Font("VCR OSD Mono", Font.PLAIN, 20));
        lMensaje.setFont(new Font("VCR OSD Mono", Font.PLAIN, 20));

        lTituloJuego.setHorizontalAlignment(SwingConstants.CENTER);
        lTituloJuego.setVerticalAlignment(SwingConstants.CENTER);
        lPalabra.setHorizontalAlignment(SwingConstants.CENTER);
        lPalabra.setVerticalAlignment(SwingConstants.CENTER);
        lRonda.setVerticalAlignment(SwingConstants.CENTER);
        lRonda.setHorizontalAlignment(SwingConstants.CENTER);
        lMensaje.setVerticalAlignment(SwingConstants.CENTER);
        lMensaje.setHorizontalAlignment(SwingConstants.CENTER);

        // Añadiendo tamaño a los botones
        bIniciarJuego.setPreferredSize(new Dimension(60, 60));
        bSiguienteJuego.setPreferredSize(new Dimension(60, 60));
        bEliminarPalabra.setPreferredSize(new Dimension(60, 60));
        bValidarPalabra.setPreferredSize(new Dimension(60, 60));

        // Añadiendo fondo a los botones (Se deben cambiar Leo)
        bIniciarJuego.setBackground(colorFondo);
        bSiguienteJuego.setBackground(colorFondo);
        bEliminarPalabra.setBackground(colorSeis);
        bValidarPalabra.setBackground(colorBorde);

        // Añadiendo el color de letra a los labels
        lTituloJuego.setForeground(colorTres);
        lPalabra.setForeground(colorSeis);
        lRonda.setForeground(colorCuatro);

        // Definiendo páneles y añadiendo márgenes
        pNorte = new JPanel(new BorderLayout(10, 10));
        pNorte.setBorder(new EmptyBorder(10, 10, 10, 10));
        pTitulo = new JPanel(new BorderLayout(10, 10));

        // Paneles que guardan la longitud de letras
        pPalabras = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        pLong3 = new JPanel(new FlowLayout());
        pLong4 = new JPanel(new FlowLayout());
        pLong5 = new JPanel(new FlowLayout());
        pLong6 = new JPanel(new FlowLayout());

        pLong3.setBackground(colorTres);
        pLong3.setPreferredSize(new Dimension(150, 300));
        pLong3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(colorBorde, 3), "3 Letras",
                TitledBorder.CENTER, TitledBorder.CENTER));

        pLong4.setBackground(colorCuatro);
        pLong4.setPreferredSize(new Dimension(180, 300));
        pLong4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(colorBorde, 3), "4 Letras",
                TitledBorder.CENTER, TitledBorder.CENTER));

        pLong5.setBackground(colorCinco);
        pLong5.setPreferredSize(new Dimension(210, 300));
        pLong5.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(colorBorde, 3), "5 Letras",
                TitledBorder.CENTER, TitledBorder.CENTER));

        pLong6.setBackground(colorSeis);
        pLong6.setPreferredSize(new Dimension(240, 300));
        pLong6.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(colorBorde, 3), "6 Letras",
                TitledBorder.CENTER, TitledBorder.CENTER));

        // (Paneles que contienen las palabras)
        pLetras = new JPanel(new FlowLayout());
        // pLetras.setBorder(BorderFactory.createLineBorder(colorBorde, 2));

        pSur = new JPanel(new BorderLayout(10, 10));
        pSur.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Color de fondo a los paneles
        pNorte.setBackground(colorFondo);
        pTitulo.setBackground(colorFondo);
        pPalabras.setBackground(colorBorde);
        pLetras.setBackground(colorFondo);
        pSur.setBackground(colorFondo);

        // Añaniendo componentes en la parte superior
        pNorte.add(bIniciarJuego, BorderLayout.WEST);
        pNorte.add(pTitulo, BorderLayout.CENTER);
        pNorte.add(bSiguienteJuego, BorderLayout.EAST);

        pTitulo.add(lTituloJuego, BorderLayout.NORTH);
        pTitulo.add(lRonda, BorderLayout.CENTER);

        // Añadiendo componentes en la parte central
        pPalabras.add(pLong3);
        pPalabras.add(pLong4);
        pPalabras.add(pLong5);
        pPalabras.add(pLong6);

        // Añaniendo componentes en la parte inferior
        pSur.add(lPalabra, BorderLayout.NORTH);
        pSur.add(pLetras, BorderLayout.CENTER);
        pSur.add(lMensaje, BorderLayout.SOUTH);

        pLetras.add(bEliminarPalabra);
        for (JToggleButton toggleButton : bLetras) {
            toggleButton.setEnabled(false);
            pLetras.add(toggleButton);
        }
        pLetras.add(bValidarPalabra);

        add(pNorte, BorderLayout.NORTH);
        add(pPalabras, BorderLayout.CENTER);
        add(pSur, BorderLayout.SOUTH);

        // Eventos
        ActionEventHandler event = new ActionEventHandler();
        for (JToggleButton bLetra : bLetras)
            bLetra.addActionListener(event);
        bEliminarPalabra.addActionListener(event);

        bValidarPalabra.addActionListener(event);
        bSiguienteJuego.addActionListener(event);
        bIniciarJuego.addActionListener(event);
        addKeyListener(event);

        pack();
        setVisible(true);
    }

    /**
     * es funion de tipo void modifica el texto de los ToggleButtons con las letras
     * de la lista de letras que le ingresa
     * como parametro.
     * 
     * @param letras lista de letras de tipo ArrayList que contiene las letras de la
     *               ronda actual
     */

    public void addBLetras(ArrayList<String> letras) {
        for (int i = 0; i < bLetras.length; i++) {
            String el = letras.get(i).toUpperCase();
            bLetras[i].setText(el);
        }
    }

    /**
     * esta función elimina una determinada letra en el label lpalabra.esta funcion
     * es llamada en los métodos
     * abstractos de ActionPerformed para eliminar una letra que escribió el usuario
     * cuando deseleccione un
     * JToggleButton
     * 
     * @param letra de tipo String, representa la letra que se va a eliminar del
     *              lPalabra
     */
    public void eliminarLetraLPalabra(String letra) {
        int indice = lPalabra.getText().indexOf(letra);
        if (indice != -1) {
            String nuevaPalabra = lPalabra.getText().substring(0, indice) + lPalabra.getText().substring(indice + 1);
            lPalabra.setText(nuevaPalabra);
        }
    }

    /**
     * esta funcion adiciona una letra a el label lPalabra.
     * 
     * @param letra de tipo string, representa la letra que el usuario a ingresado a
     *              travez
     *              de un JToggleButton.
     */
    public void addLLetras(String letra) {
        lPalabra.setText(lPalabra.getText() + letra);
    }

    /**
     * esta funcion implementa la matriaLong3 con el numero de filas y columnas que
     * coinciden con el numero
     * de filas y columnas de la matriz que le entra como parametro, luego llena la
     * matrizLong3 con nuevos labels.
     * 
     * @param matriz de tipo Array en dos dimenciones, representa la matriz nula que
     *               contiene el numero
     *               de filas igual al numero de palabras de longitud 3, y el numero
     *               de columnas igual a 3
     */
    public void addMatrizLong3(String[][] matriz) {
        pLong3.removeAll();
        // Instanciando la matriz de longitud 3 con el numero de palabras
        matrizLong3 = new JLabel[matriz.length][3];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matrizLong3[i][j] = crearLabel("", Color.GREEN);
                // Se añade inmediatamente al panel de long 3
                pLong3.add(matrizLong3[i][j]);
            }
        }
        pLong3.updateUI();
    }

    /**
     * hace lo mismo que la anterior funcion pero ahora con la matrizLong4
     * 
     * @param matriz de tipo Array en dos dimenciones, representa la matriz nula que
     *               contiene el numero
     *               de filas igual al numero de palabras de longitud 4, y el numero
     *               de columnas igual a 4
     */
    public void addMatrizLong4(String[][] matriz) {
        // Instanciando la matriz de longitud 4 con el numero de palabras
        pLong4.removeAll();
        matrizLong4 = new JLabel[matriz.length][4];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matrizLong4[i][j] = crearLabel("", Color.GREEN);
                // Se añade inmediatamente al panel de long 4
                pLong4.add(matrizLong4[i][j]);
            }
        }
        pLong4.updateUI();
    }

    /**
     * hace lo mismo que la anterior funcion pero ahora con la matrizLong5
     * 
     * @param matriz de tipo Array en dos dimenciones, representa la matriz nula que
     *               contiene el numero
     *               de filas igual al numero de palabras de longitud 5, y el numero
     *               de columnas igual a 5
     */
    public void addMatrizLong5(String[][] matriz) {
        pLong5.removeAll();
        // Instanciando la matriz de longitud 5 con el numero de palabras
        matrizLong5 = new JLabel[matriz.length][5];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matrizLong5[i][j] = crearLabel("", Color.GREEN);
                // Se añade inmediatamente al panel de long 5
                pLong5.add(matrizLong5[i][j]);
            }
        }
        pLong5.updateUI();
    }

    /**
     * hace lo mismo que la anterior funcion pero ahora con la matrizLong6
     * 
     * @param matriz de tipo Array en dos dimenciones, representa la matriz nula que
     *               contiene el numero
     *               de filas igual al numero de palabras de longitud 6, y el numero
     *               de columnas igual a 6
     */
    public void addMatrizLong6(String[][] matriz) {
        pLong6.removeAll();
        // Instanciando la matriz de longitud 6 con el numero de palabras
        matrizLong6 = new JLabel[matriz.length][6];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matrizLong6[i][j] = crearLabel("", Color.GREEN);
                // Se añade inmediatamente al panel de long 6
                pLong6.add(matrizLong6[i][j]);
            }
        }
        pLong6.updateUI();
    }

    /**
     * esta función agrega las palabras validadas que ingresa el usuario a la matriz
     * correspondiente en la gui
     * de acuerdo a la longitud de la palabra.
     * 
     * @param palabra  de tipo string, representa la palabra validada que se va a
     *                 ingresar
     *                 en la matriz correspondiente en la GUI.
     * @param position de tipo string, representa la posición de la fila en la
     *                 matriz correspondiente de la GUI de
     *                 acuerdo a la longitud de la palabra en la que se va a agregar
     *                 la palabra.
     */
    public void showPalabra(String palabra, int position) {
        switch (palabra.trim().length()) {
            case 3:
                for (int i = 0; i < matrizLong3[position].length; i++)
                    matrizLong3[position][i].setText(Character.toString(palabra.charAt(i)).toUpperCase());
                pLong3.updateUI();
                break;
            case 4:
                for (int i = 0; i < matrizLong4[position].length; i++)
                    matrizLong4[position][i].setText(Character.toString(palabra.charAt(i)).toUpperCase());
                pLong4.updateUI();
                break;
            case 5:
                for (int i = 0; i < matrizLong5[position].length; i++)
                    matrizLong5[position][i].setText(Character.toString(palabra.charAt(i)).toUpperCase());
                pLong5.updateUI();
                break;
            case 6:
                for (int i = 0; i < matrizLong6[position].length; i++)
                    matrizLong6[position][i].setText(Character.toString(palabra.charAt(i)).toUpperCase());
                pLong6.updateUI();
                break;
            default:
                break;
        }
    }

    /**
     * esta funcion modifica el label lRonda de acuerdo al numero de ronda actual
     * 
     * @param ronda entero que representa el numero de la ronda actual
     */
    public void addNumRonda(int ronda) {
        lRonda.setText("RONDA: " + Integer.toString(ronda));
    }

    /**
     * esta funcion modifica el label lMensaje de acuerdo al parametro mensaje que
     * resive.
     * 
     * @param mensaje string que represena el mensaje que se mostrara en la GUI
     *                cuando el usuario
     *                no ingrese una palabra correcta o ingrese una repetida
     */
    public void addLMensaje(String mensaje) {
        lMensaje.setText(mensaje);
        lMensaje.setForeground(colorSeis);
    }

    /**
     * en esta clase se implementan los metodos abstractos ActionListener y
     * Keylistener
     * para la gestion de eventos de los componentes de la GUI
     */
    class ActionEventHandler implements ActionListener, KeyListener {

        /**
         * esta funcion gestiona los eventos que se producen en los JToggleButtons y los
         * demas botones de la GUI
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            for (JToggleButton bLetra : bLetras) {
                if (e.getSource() == bLetra) {
                    if (bLetra.isSelected())
                        addLLetras(bLetra.getText());
                    else
                        eliminarLetraLPalabra(bLetra.getText());
                    break;
                }
            }

            if (e.getSource() == bIniciarJuego) {
                ControllerGame.iniciarRonda();
                bIniciarJuego.setEnabled(false);
                bValidarPalabra.setEnabled(true);
                bEliminarPalabra.setEnabled(true);
                for (JToggleButton bLetra : bLetras)
                    bLetra.setEnabled(true);
            }

            if (e.getSource() == bEliminarPalabra) {
                for (JToggleButton bLetra : bLetras)
                    if (bLetra.isSelected())
                        bLetra.setSelected(false);
                lPalabra.setText(" ");
            }

            // Entregamos la palabra que esta en el label y la convertimos a minuscula y
            // quitamos los espacios
            if (e.getSource() == bValidarPalabra) {
                String palabraAVerficar = lPalabra.getText().trim().toLowerCase();
                ControllerGame.verificarPalabra(palabraAVerficar);
                for (JToggleButton bLetra : bLetras)
                    if (bLetra.isSelected())
                        bLetra.setSelected(false);
                lPalabra.setText(" ");
            }

            // Se presiona el boton para hacer el cambio de ronda y habilitar los botones de
            // nuevo
            if (e.getSource() == bSiguienteJuego) {
                ControllerGame.cambiarRonda();
                ControllerGame.iniciarRonda();
                bEliminarPalabra.setEnabled(true);
                bValidarPalabra.setEnabled(true);
                for (JToggleButton bLetra : bLetras) {
                    bLetra.setEnabled(true);
                }
                addLMensaje(" ");
            }
        }

        /**
         * funcion que gestiona todos los eventos que se producen al gestionar
         * una tecla.
         */
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if ((e.getKeyCode() == KeyEvent.VK_ENTER) && bValidarPalabra.isEnabled()) {
                String palabraAVerficar = lPalabra.getText().trim().toLowerCase();
                ControllerGame.verificarPalabra(palabraAVerficar);
                for (JToggleButton bLetra : bLetras)
                    if (bLetra.isSelected())
                        bLetra.setSelected(false);
                lPalabra.setText(" ");
            }

        }
    }
}
