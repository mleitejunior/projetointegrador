package visual;

import dao.DAOConnection;
import java.awt.Color;
import java.sql.Connection;
import javax.swing.JOptionPane;
import resources.WindowFrame;

public class Login extends WindowFrame {
    

    public Login() {
        setUndecorated(true);
        initComponents();
        setLabelBackground(labelBackground);
        setSize(1280,800);
        setBackground(new Color(0,0,0,0));
        setBackgroundMovable();
        btnEnviar.setBorderPainted(false); 
        //btnEnviar.setContentAreaFilled(false); 
        btnEnviar.setFocusPainted(false); 
        btnEnviar.setOpaque(false);
        this.getRootPane().setDefaultButton(btnEnviar);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        txtLogin = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnFechar2 = new javax.swing.JButton();
        labelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("LOGIN");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(490, 373, 120, 17);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("SENHA");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(490, 480, 130, 20);

        btnEnviar.setBackground(new java.awt.Color(0, 184, 229));
        btnEnviar.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviar.setText("ENVIAR");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnviar);
        btnEnviar.setBounds(490, 600, 330, 60);

        txtLogin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtLogin.setForeground(new java.awt.Color(102, 102, 102));
        txtLogin.setText("mleitejunior");
        getContentPane().add(txtLogin);
        txtLogin.setBounds(490, 390, 340, 30);

        txtPassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(102, 102, 102));
        txtPassword.setText("1234");
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(txtPassword);
        txtPassword.setBounds(490, 500, 340, 30);

        btnFechar2.setBackground(new java.awt.Color(255, 0, 0));
        btnFechar2.setFont(new java.awt.Font("Arial Black", 0, 8)); // NOI18N
        btnFechar2.setForeground(new java.awt.Color(255, 255, 255));
        btnFechar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/btnfechar.png"))); // NOI18N
        btnFechar2.setContentAreaFilled(false);
        btnFechar2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFechar2.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btnFechar2.setMaximumSize(new java.awt.Dimension(30, 30));
        btnFechar2.setMinimumSize(new java.awt.Dimension(30, 30));
        btnFechar2.setPreferredSize(new java.awt.Dimension(30, 30));
        btnFechar2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/btnfecharover.png"))); // NOI18N
        btnFechar2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/btnfecharover.png"))); // NOI18N
        btnFechar2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/btnfecharover.png"))); // NOI18N
        btnFechar2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/btnfechar.png"))); // NOI18N
        btnFechar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechar2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnFechar2);
        btnFechar2.setBounds(1250, 0, 30, 30);

        labelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/loginbackground.png"))); // NOI18N
        getContentPane().add(labelBackground);
        labelBackground.setBounds(0, 0, 1280, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        Connection database;
        int access;
        try {
            database = DAOConnection.getConexao();
            if(DAOConnection.login(txtLogin.getText(), txtPassword.getText())){
                access = DAOConnection.getAccess();
                MainFrame mainFrame = new MainFrame();
                System.out.println(access);
                mainFrame.setAccess(access);
                mainFrame.setAccessLevel();
                mainFrame.setDatabase(database);
                mainFrame.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
            }
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        
        
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnFechar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechar2ActionPerformed
        dispose();
    }//GEN-LAST:event_btnFechar2ActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnFechar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelBackground;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
