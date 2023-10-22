package sistemapaneles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CuadrosGUI {
    private JFrame frame;
    private JPanel[] cuadros;
    private int hora = 0;
    private JLabel relojLabel;
    private Timer timer;
    private List<String> elementos = Arrays.asList("Refrigeradora", "Televisión", "Cocina", "Computadora", "Videojuego", "Sistema de bombillos", "Microondas", "Lavadora");
    private Casa casa;

    public CuadrosGUI(Casa casa) {
        this.casa = casa;

        frame = new JFrame("Cuadros con Hora Avanzando");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(); // Panel principal
        mainPanel.setLayout(new BorderLayout());

        JPanel cuadrosPanel = new JPanel(); // Panel para los cuadros
        cuadrosPanel.setLayout(new GridLayout(3, 3));

        cuadros = new JPanel[8];
        for (int i = 0; i < 8; i++) {
            cuadros[i] = new JPanel();
            cuadros[i].setLayout(new BorderLayout());
            cuadros[i].add(new JLabel(elementos.get(i), SwingConstants.CENTER));
            cuadros[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            cuadrosPanel.add(cuadros[i]);
        }

        relojLabel = new JLabel("00:00", SwingConstants.CENTER);
        mainPanel.add(cuadrosPanel, BorderLayout.CENTER);
        mainPanel.add(relojLabel, BorderLayout.NORTH);

        JButton historialButton = new JButton("Ver Historial");
        mainPanel.add(historialButton, BorderLayout.SOUTH); // Agregar botón en la parte inferior

        frame.add(mainPanel);
        frame.setSize(600, 400);
        frame.setVisible(true);

        historialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre la ventana de historial al hacer clic en el botón
                mostrarVentanaHistorial();
            }
        });

        timer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avanzarHora();
            }
        });
        timer.start();
    }

    private void avanzarHora() {
        hora = (hora + 1) % 25;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String tiempo = String.format("%02d:00", hora);
        relojLabel.setText(tiempo);

        for (int i = 0; i < 8; i++) {
            if (casa.estadoDispositivo(elementos.get(i), hora)) {
                cuadros[i].setBackground(Color.GREEN);
            } else {
                cuadros[i].setBackground(Color.RED);
            }
        }
    }

    private void mostrarVentanaHistorial() {
        // Crear y mostrar la ventana de historial
        JFrame historialFrame = new JFrame("Historial");
        JTextArea historialTextArea = new JTextArea();
        historialTextArea.setEditable(false);

        // Leer el contenido del archivo historial.txt
        try {
            FileReader fileReader = new FileReader("./src/sistemapaneles/historial.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder historial = new StringBuilder();
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                historial.append(linea).append("\n");
            }
            bufferedReader.close();

            // Agregar el contenido del historial al JTextArea
            historialTextArea.setText(historial.toString());
        } catch (IOException e) {
            // Manejo de errores en caso de que ocurra una excepción de E/S
            historialTextArea.setText("No se pudo cargar el historial.");
        }

        historialFrame.add(new JScrollPane(historialTextArea));
        historialFrame.setSize(400, 300);
        historialFrame.setVisible(true);
    }
}