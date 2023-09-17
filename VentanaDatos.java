package prueba;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VentanaDatos extends JFrame {
    private JTextField cantidadPaneles;
    private JTextField consumoRefrigeradora;
    private JTextField consumoCocinaElectrica;
    private JTextField consumoHorno;
    private JTextField consumoLicuadora;
    private JTextField consumoArrocera;
    private JTextField consumoTelevisor;
    private JTextField consumoLavadora;
    private JTextField consumoSecadora;

    public VentanaDatos() {
        // Configuración básica de la ventana
        setTitle("Ingresar Datos de Consumo");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(10, 2, 10, 10)); // Diseño de cuadrícula para organizar los componentes

        // Etiquetas y campos de entrada para cada dato
        JLabel etiquetaPaneles = new JLabel("Cantidad de Paneles Solares:");
        cantidadPaneles = new JTextField();

        JLabel etiquetaRefrigeradora = new JLabel("Consumo de Refrigeradora (kWh):");
        consumoRefrigeradora = new JTextField();

        JLabel etiquetaCocinaElectrica = new JLabel("Consumo de Cocina Eléctrica (kWh):");
        consumoCocinaElectrica = new JTextField();

        JLabel etiquetaHorno = new JLabel("Consumo de Horno (kWh):");
        consumoHorno = new JTextField();

        JLabel etiquetaLicuadora = new JLabel("Consumo de Licuadora (kWh):");
        consumoLicuadora = new JTextField();

        JLabel etiquetaArrocera = new JLabel("Consumo de Arrocera (kWh):");
        consumoArrocera = new JTextField();

        JLabel etiquetaTelevisor = new JLabel("Consumo de Televisor (kWh):");
        consumoTelevisor = new JTextField();

        JLabel etiquetaLavadora = new JLabel("Consumo de Lavadora (kWh):");
        consumoLavadora = new JTextField();

        JLabel etiquetaSecadora = new JLabel("Consumo de Secadora (kWh):");
        consumoSecadora = new JTextField();

        // Botón para enviar los datos
        JButton botonEnviar = new JButton("Enviar");

        // Agregar componentes a la ventana
        add(etiquetaPaneles);
        add(cantidadPaneles);
        add(etiquetaRefrigeradora);
        add(consumoRefrigeradora);
        add(etiquetaCocinaElectrica);
        add(consumoCocinaElectrica);
        add(etiquetaHorno);
        add(consumoHorno);
        add(etiquetaLicuadora);
        add(consumoLicuadora);
        add(etiquetaArrocera);
        add(consumoArrocera);
        add(etiquetaTelevisor);
        add(consumoTelevisor);
        add(etiquetaLavadora);
        add(consumoLavadora);
        add(etiquetaSecadora);
        add(consumoSecadora);
        add(new JLabel()); // Espacio en blanco
        add(botonEnviar);

        // Configurar el ActionListener para el botón
        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes obtener los valores ingresados en los campos de entrada
                String cantidadPanelesText = cantidadPaneles.getText();
                String consumoRefrigeradoraText = consumoRefrigeradora.getText();
                // ... Obtener los valores de los otros campos de entrada

                // Luego puedes procesar los datos como desees, por ejemplo, guardarlos en una base de datos o realizar cálculos
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                VentanaDatos ventana = new VentanaDatos();
                ventana.setVisible(true);
            }
        });
    }
}
