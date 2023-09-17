package prueba;

import javax.swing.*;
import java.awt.*;

public class VentanaRecomendaciones extends JFrame {

    public VentanaRecomendaciones() {
        // Configuración básica de la ventana
        setTitle("Recomendaciones");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout de la ventana
        setLayout(new BorderLayout());

        // Etiqueta de "Recomendaciones"
        JLabel etiquetaRecomendaciones = new JLabel("Recomendaciones");
        etiquetaRecomendaciones.setHorizontalAlignment(JLabel.CENTER);
        add(etiquetaRecomendaciones, BorderLayout.NORTH);

        // Área de texto para mostrar el mensaje "prueba"
        JTextArea areaTexto = new JTextArea("Mensaje de prueba");
        areaTexto.setEditable(false);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER); // Agregar un JScrollPane para desplazarse en el área de texto
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                VentanaRecomendaciones ventana = new VentanaRecomendaciones();
                ventana.setVisible(true);
            }
        });
    }
}