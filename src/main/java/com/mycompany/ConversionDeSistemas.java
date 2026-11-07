/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.conversiondesistemas;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Isaias Quintero
 */


public class ConversionDeSistemas extends JFrame{

   private JTextField txtNumeroElegido;
    private JTextField txtNumeroConvertido;
    private JTextArea txtProcedimiento;
    private JLabel lblEstadoSistema;
    
    private String sistemaOrigen = "";       // Sistema del número que ingresa el usuario
    private String sistemaDestino = "Binario"; // Sistema al que se desea convertir (Binario por defecto)

    // Paleta de colores
    private final Color COLOR_HEADER = new Color(34, 40, 49);
    private final Color COLOR_PANEL_BG = new Color(245, 247, 250);
    private final Color COLOR_AZUL_ACTIVO = new Color(41, 128, 185);
    private final Color COLOR_VERDE_CONVERTIR = new Color(39, 174, 96);
    private final Color COLOR_BTN_INACTIVO = new Color(225, 230, 235);
    private final Color COLOR_TEXTO_DARK = new Color(44, 62, 80);

    private List<JButton> listaBotonesOrigen = new ArrayList<>();
    private List<JButton> listaBotonesDestino = new ArrayList<>();

    public ConversionDeSistemas() {
        setTitle("Proyecto 2 - Conversión de Sistemas Numéricos");
        setSize(780, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(COLOR_PANEL_BG);
        setLayout(new BorderLayout(0, 0));

        // -----------------------------------------------------------------
        // 1. ENCABEZADO SUPERIOR
        // -----------------------------------------------------------------
        JPanel panelHeader = new JPanel();
        panelHeader.setBackground(COLOR_HEADER);
        panelHeader.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 12));

        JLabel lblTitulo = new JLabel("CONVERSOR DE SISTEMAS NUMÉRICOS");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitulo.setForeground(Color.WHITE);
        panelHeader.add(lblTitulo);

        add(panelHeader, BorderLayout.NORTH);

        // -----------------------------------------------------------------
        // 2. PANEL CONTENEDOR CENTRAL
        // -----------------------------------------------------------------
        JPanel panelCuerpo = new JPanel();
        panelCuerpo.setLayout(new BoxLayout(panelCuerpo, BoxLayout.Y_AXIS));
        panelCuerpo.setOpaque(false);
        panelCuerpo.setBorder(new EmptyBorder(15, 20, 15, 20));

        // --- SISTEMA ORIGEN (ARRIBA) ---
        JPanel panelOrigen = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        panelOrigen.setOpaque(false);

        JLabel lblOrigen = new JLabel("1. Sistema Origen:");
        lblOrigen.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblOrigen.setForeground(COLOR_TEXTO_DARK);
        panelOrigen.add(lblOrigen);

        JButton btnOrigDecimal = crearBoton("Decimal");
        JButton btnOrigBinario = crearBoton("Binario");
        JButton btnOrigOctal = crearBoton("Octal");
        JButton btnOrigHexa = crearBoton("Hexadecimal");

        listaBotonesOrigen.add(btnOrigDecimal);
        listaBotonesOrigen.add(btnOrigBinario);
        listaBotonesOrigen.add(btnOrigOctal);
        listaBotonesOrigen.add(btnOrigHexa);

        panelOrigen.add(btnOrigDecimal);
        panelOrigen.add(btnOrigBinario);
        panelOrigen.add(btnOrigOctal);
        panelOrigen.add(btnOrigHexa);

        panelCuerpo.add(panelOrigen);
        panelCuerpo.add(Box.createVerticalStrut(6));

        // Indicador de teclado activo
        lblEstadoSistema = new JLabel("<- Selecciona un sistema origen arriba para habilitar el teclado", SwingConstants.CENTER);
        lblEstadoSistema.setFont(new Font("Segoe UI", Font.ITALIC, 11));
        lblEstadoSistema.setForeground(new Color(120, 130, 140));
        lblEstadoSistema.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCuerpo.add(lblEstadoSistema);
        panelCuerpo.add(Box.createVerticalStrut(10));

        // LÍNEA DE SEPARACIÓN 1
        panelCuerpo.add(new JSeparator(JSeparator.HORIZONTAL));
        panelCuerpo.add(Box.createVerticalStrut(10));

        // CAMPOS DE ENTRADA Y RESULTADO
        JPanel panelCampos = new JPanel(new GridLayout(2, 2, 10, 8));
        panelCampos.setOpaque(false);

        JLabel lblElegido = new JLabel("Número elegido:");
        lblElegido.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblElegido.setForeground(COLOR_TEXTO_DARK);

        txtNumeroElegido = new JTextField();
        txtNumeroElegido.setEnabled(false); // Bloqueado hasta seleccionar origen
        estilizarTextField(txtNumeroElegido);

        // DocumentFilter para restringir pulsaciones de teclado según el origen
        ((AbstractDocument) txtNumeroElegido.getDocument()).setDocumentFilter(new FiltroTecladoSistema());

        JLabel lblConvertido = new JLabel("Número convertido:");
        lblConvertido.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblConvertido.setForeground(COLOR_TEXTO_DARK);

        txtNumeroConvertido = new JTextField();
        txtNumeroConvertido.setEditable(false);
        txtNumeroConvertido.setForeground(COLOR_AZUL_ACTIVO);
        estilizarTextField(txtNumeroConvertido);

        panelCampos.add(lblElegido);
        panelCampos.add(txtNumeroElegido);
        panelCampos.add(lblConvertido);
        panelCampos.add(txtNumeroConvertido);

        panelCuerpo.add(panelCampos);
        panelCuerpo.add(Box.createVerticalStrut(10));

        // LÍNEA DE SEPARACIÓN 2
        panelCuerpo.add(new JSeparator(JSeparator.HORIZONTAL));
        panelCuerpo.add(Box.createVerticalStrut(10));

        // --- SISTEMA DESTINO (ABAJO) ---
        JPanel panelDestino = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        panelDestino.setOpaque(false);

        JLabel lblDestino = new JLabel("2. Convertir a (Destino):");
        lblDestino.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblDestino.setForeground(COLOR_TEXTO_DARK);
        panelDestino.add(lblDestino);

        JButton btnDestDecimal = crearBoton("Decimal");
        JButton btnDestBinario = crearBoton("Binario");
        JButton btnDestOctal = crearBoton("Octal");
        JButton btnDestHexa = crearBoton("Hexadecimal");

        listaBotonesDestino.add(btnDestDecimal);
        listaBotonesDestino.add(btnDestBinario);
        listaBotonesDestino.add(btnDestOctal);
        listaBotonesDestino.add(btnDestHexa);

        panelDestino.add(btnDestDecimal);
        panelDestino.add(btnDestBinario);
        panelDestino.add(btnDestOctal);
        panelDestino.add(btnDestHexa);

        panelCuerpo.add(panelDestino);
        panelCuerpo.add(Box.createVerticalStrut(12));

        // BOTÓN ACCIÓN DE CONVERSIÓN
        JPanel panelOperacion = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelOperacion.setOpaque(false);

        JButton btnConvertir = new JButton(" Convertir Número ");
        estilizarBoton(btnConvertir, COLOR_VERDE_CONVERTIR, Color.WHITE);
        btnConvertir.setFont(new Font("Segoe UI", Font.BOLD, 13));
        panelOperacion.add(btnConvertir);

        panelCuerpo.add(panelOperacion);
        panelCuerpo.add(Box.createVerticalStrut(8));

        // ÁREA DE PROCEDIMIENTO
        txtProcedimiento = new JTextArea();
        txtProcedimiento.setEditable(false);
        txtProcedimiento.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtProcedimiento.setBackground(Color.WHITE);
        txtProcedimiento.setForeground(COLOR_TEXTO_DARK);

        JScrollPane scrollArea = new JScrollPane(txtProcedimiento);
        scrollArea.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(200, 205, 210), 1),
                " Procedimiento Paso a Paso ",
                0, 0, new Font("Segoe UI", Font.BOLD, 11), COLOR_TEXTO_DARK
        ));

        JPanel panelGeneral = new JPanel(new BorderLayout());
        panelGeneral.setOpaque(false);
        panelGeneral.add(panelCuerpo, BorderLayout.NORTH);
        panelGeneral.add(scrollArea, BorderLayout.CENTER);
        panelGeneral.setBorder(new EmptyBorder(0, 15, 15, 15));

        add(panelGeneral, BorderLayout.CENTER);

        // -----------------------------------------------------------------
        // EVENTOS
        // -----------------------------------------------------------------
        btnOrigDecimal.addActionListener(e -> seleccionarSistemaOrigen("Decimal", btnOrigDecimal, "Permitido: solo números (0-9)"));
        btnOrigBinario.addActionListener(e -> seleccionarSistemaOrigen("Binario", btnOrigBinario, "Permitido: solo 0 y 1"));
        btnOrigOctal.addActionListener(e -> seleccionarSistemaOrigen("Octal", btnOrigOctal, "Permitido: solo octales (0-7)"));
        btnOrigHexa.addActionListener(e -> seleccionarSistemaOrigen("Hexadecimal", btnOrigHexa, "Permitido: números (0-9) y letras (A-F)"));

        btnDestDecimal.addActionListener(e -> seleccionarSistemaDestino("Decimal", btnDestDecimal));
        btnDestBinario.addActionListener(e -> seleccionarSistemaDestino("Binario", btnDestBinario));
        btnDestOctal.addActionListener(e -> seleccionarSistemaDestino("Octal", btnDestOctal));
        btnDestHexa.addActionListener(e -> seleccionarSistemaDestino("Hexadecimal", btnDestHexa));

        marcarBotonActivo(btnDestBinario, listaBotonesDestino, COLOR_AZUL_ACTIVO);
        btnConvertir.addActionListener(e -> ejecutarConversion());
    }

    // -----------------------------------------------------------------
    // CONTROL DE SISTEMAS Y RESTRICCIONES
    // -----------------------------------------------------------------

    private void seleccionarSistemaOrigen(String sistema, JButton btnActivo, String indicacion) {
        this.sistemaOrigen = sistema;
        
        // Habilitar y limpiar completamente las casillas al cambiar de sistema
        txtNumeroElegido.setEnabled(true);
        txtNumeroElegido.setText("");
        txtNumeroConvertido.setText("");
        txtProcedimiento.setText("");

        lblEstadoSistema.setText("Origen: " + sistema + " | " + indicacion);
        lblEstadoSistema.setForeground(COLOR_AZUL_ACTIVO);

        marcarBotonActivo(btnActivo, listaBotonesOrigen, COLOR_AZUL_ACTIVO);
        txtNumeroElegido.requestFocus();
    }

    private void seleccionarSistemaDestino(String sistema, JButton btnActivo) {
        this.sistemaDestino = sistema;
        marcarBotonActivo(btnActivo, listaBotonesDestino, COLOR_AZUL_ACTIVO);
    }

    private boolean esCaracterValido(String texto) {
        if (sistemaOrigen.isEmpty()) return false;

        switch (sistemaOrigen) {
            case "Binario":
                return texto.matches("^[01]+$");
            case "Octal":
                return texto.matches("^[0-7]+$");
            case "Decimal":
                return texto.matches("^[0-9]+$");
            case "Hexadecimal":
                return texto.matches("^[0-9a-fA-F]+$");
            default:
                return false;
        }
    }

    // DocumentFilter para permitir borrado (texto vacío)
    private class FiltroTecladoSistema extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string != null && esCaracterValido(string)) {
                super.insertString(fb, offset, string.toUpperCase(), attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text == null || text.isEmpty()) {
                super.replace(fb, offset, length, "", attrs);
            } else if (esCaracterValido(text)) {
                super.replace(fb, offset, length, text.toUpperCase(), attrs);
            }
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
            super.remove(fb, offset, length);
        }
    }

    // -----------------------------------------------------------------
    // ESTILIZACIÓN VISUAL
    // -----------------------------------------------------------------

    private JButton crearBoton(String texto) {
        JButton btn = new JButton(texto);
        estilizarBoton(btn, COLOR_BTN_INACTIVO, COLOR_TEXTO_DARK);
        return btn;
    }

    private void estilizarBoton(JButton btn, Color bgColor, Color fgColor) {
        btn.setBackground(bgColor);
        btn.setForeground(fgColor);
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btn.setBorder(new CompoundBorder(
                new LineBorder(bgColor.darker(), 1, true),
                new EmptyBorder(5, 12, 5, 12)
        ));
    }

    private void estilizarTextField(JTextField field) {
        field.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        field.setBorder(new CompoundBorder(
                new LineBorder(new Color(190, 195, 200), 1, true),
                new EmptyBorder(4, 8, 4, 8)
        ));
    }

    private void marcarBotonActivo(JButton btnActivo, List<JButton> grupo, Color colorActivo) {
        for (JButton b : grupo) {
            if (b == btnActivo) {
                estilizarBoton(b, colorActivo, Color.WHITE);
            } else {
                estilizarBoton(b, COLOR_BTN_INACTIVO, COLOR_TEXTO_DARK);
            }
        }
    }

    // -----------------------------------------------------------------
    // LÓGICA DE CONVERSIÓN
    // -----------------------------------------------------------------

    private void ejecutarConversion() {
        txtProcedimiento.setText("");
        txtNumeroConvertido.setText("");

        if (sistemaOrigen.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecciona primero el Sistema Origen (arriba).", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String entrada = txtNumeroElegido.getText().trim();
        if (entrada.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa un número para convertir.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (sistemaOrigen.equalsIgnoreCase(sistemaDestino)) {
            txtNumeroConvertido.setText("El número ya es " + sistemaDestino.toLowerCase());
            txtProcedimiento.setText("El número ingresado (" + entrada + ") ya se encuentra en sistema " + sistemaDestino + ".");
            return;
        }

        try {
            int baseOrigen = 10;
            if (sistemaOrigen.equals("Binario")) baseOrigen = 2;
            if (sistemaOrigen.equals("Octal")) baseOrigen = 8;
            if (sistemaOrigen.equals("Hexadecimal")) baseOrigen = 16;

            long decimalVal = Long.parseLong(entrada, baseOrigen);

            int baseDestino = 10;
            if (sistemaDestino.equals("Binario")) baseDestino = 2;
            if (sistemaDestino.equals("Octal")) baseDestino = 8;
            if (sistemaDestino.equals("Hexadecimal")) baseDestino = 16;

            StringBuilder pasoAPaso = new StringBuilder();
            pasoAPaso.append(String.format("Conversión: %s (%s) ➔ %s (Base %d)\n", entrada, sistemaOrigen, sistemaDestino, baseDestino));

            if (baseOrigen != 10) {
                pasoAPaso.append(String.format("Valor equivalente en Decimal: %d\n", decimalVal));
            }
            pasoAPaso.append(String.format("Dividiendo %d entre %d hasta llegar a 0:\n\n", decimalVal, baseDestino));

            if (decimalVal == 0) {
                txtNumeroConvertido.setText("0");
                pasoAPaso.append("Paso 1: 0 ÷ ").append(baseDestino).append(" = Cociente: 0 | Residuo: 0\n\nResultado: 0");
                txtProcedimiento.setText(pasoAPaso.toString());
                return;
            }

            long temp = decimalVal;
            StringBuilder residuoAcumulado = new StringBuilder();
            int paso = 1;

            while (temp > 0) {
                long cociente = temp / baseDestino;
                long residuo = temp % baseDestino;

                char digitoHex;
                if (residuo >= 10) {
                    digitoHex = (char) ('A' + (residuo - 10));
                } else {
                    digitoHex = (char) ('0' + residuo);
                }

                residuoAcumulado.insert(0, digitoHex);

                pasoAPaso.append(String.format("Paso %2d: %d ÷ %d = Cociente: %d | Residuo: %d", paso, temp, baseDestino, cociente, residuo));
                if (baseDestino == 16 && residuo >= 10) {
                    pasoAPaso.append(String.format(" ('%c')", digitoHex));
                }
                pasoAPaso.append("\n");

                temp = cociente;
                paso++;
            }

            pasoAPaso.append("\nLectura de residuos del último al primero (de abajo hacia arriba):\n");
            pasoAPaso.append("Resultado Final: ").append(residuoAcumulado.toString());

            txtProcedimiento.setText(pasoAPaso.toString());
            txtNumeroConvertido.setText(residuoAcumulado.toString());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El número ingresado excede el límite de cálculo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConversionDeSistemas().setVisible(true));
    }
}