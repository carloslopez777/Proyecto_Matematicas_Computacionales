import javax.swing.JOptionPane;

public class AlgoritmoEuclides extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AlgoritmoEuclides.class.getName());

    public AlgoritmoEuclides() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPrimerNumero = new javax.swing.JTextField();
        txtSegundoNumero = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaProcedimiento = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        lblResultado = new javax.swing.JLabel();
        btnLimpiarCampos = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Algoritmo Euclides");

        txtPrimerNumero.addActionListener(this::txtPrimerNumeroActionPerformed);

        txtSegundoNumero.addActionListener(this::txtSegundoNumeroActionPerformed);

        jLabel3.setText("Segundo número:");

        btnCalcular.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCalcular.setText("Calcular MCD");
        btnCalcular.addActionListener(this::btnCalcularActionPerformed);

        txaProcedimiento.setColumns(20);
        txaProcedimiento.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txaProcedimiento.setRows(5);
        jScrollPane1.setViewportView(txaProcedimiento);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("MCD: ");

        lblResultado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblResultado.setText("Resultado");

        btnLimpiarCampos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiarCampos.setText("Limpiar Campos");
        btnLimpiarCampos.addActionListener(this::btnLimpiarCamposActionPerformed);

        jLabel5.setText("Primer número:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(139, 139, 139))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(btnCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(52, 52, 52)
                        .addComponent(btnLimpiarCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(74, 74, 74))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(38, 38, 38)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSegundoNumero)
                            .addComponent(txtPrimerNumero)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(88, 88, 88)))
                        .addGap(51, 51, 51)))
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrimerNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(txtSegundoNumero))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiarCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(lblResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrimerNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrimerNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrimerNumeroActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        try{
            int a = Integer.parseInt(txtPrimerNumero.getText().trim());
            int b = Integer.parseInt(txtSegundoNumero.getText().trim());

            if (a <= 0 || b <= 0) {
                JOptionPane.showMessageDialog(
    this, "Ingresa dos números enteros positivos mayor a 0.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Algoritmo de Euclides MCD: ")
                .append(a).append(", ").append(b).append("\n\n");
 
        int paso = 1;
        while (b != 0) {
            int cociente = a / b;
            int residuo = a % b;
            sb.append("Paso ").append(paso).append(":  ")
            .append(a).append(" ÷ ").append(b).append(" = ")
            .append(cociente).append(", residuo ").append(residuo).append("\n");
            a = b;
            b = residuo;
            paso++;
        }
 
        txaProcedimiento.setText(sb.toString());
        txaProcedimiento.setCaretPosition(0);
        lblResultado.setText("" + a);
        
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog
        (this, "Ingresa números válidos.", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void txtSegundoNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSegundoNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSegundoNumeroActionPerformed

    private void btnLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCamposActionPerformed
        txtPrimerNumero.setText("");
        txtSegundoNumero.setText("");
        txaProcedimiento.setText("");
        lblResultado.setText("");
        txtPrimerNumero.requestFocus();
    }//GEN-LAST:event_btnLimpiarCamposActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new AlgoritmoEuclides().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnLimpiarCampos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JTextArea txaProcedimiento;
    private javax.swing.JTextField txtPrimerNumero;
    private javax.swing.JTextField txtSegundoNumero;
    // End of variables declaration//GEN-END:variables
}