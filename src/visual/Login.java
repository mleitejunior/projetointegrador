package visual;

import dao.DAOConnection;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    
    //VARIAVEIS PARA ARRASTAR JANELA VISUAL
    private int pX,pY;

    public Login() {
        setUndecorated(true);
        initComponents();
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
        getContentPane().add(txtLogin);
        txtLogin.setBounds(490, 390, 340, 30);

        txtPassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(102, 102, 102));
        getContentPane().add(txtPassword);
        txtPassword.setBounds(490, 500, 340, 30);

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

    public void setBackgroundMovable(){
        labelBackground.addMouseListener(new MouseAdapter(){
        @Override
        public void mousePressed(MouseEvent me)
            {
            // Get x,y and store them
            pX=me.getX();
            pY=me.getY();
            }
        });
        
        // Add MouseMotionListener for detecting drag
        labelBackground.addMouseMotionListener(new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent me)
            {
                // Set the location
                // get the current location x-co-ordinate and then get
                // the current drag x co-ordinate, add them and subtract most recent
                // mouse pressed x co-ordinate
                // do same for y co-ordinate
                setLocation(getLocation().x+me.getX()-pX,getLocation().y+me.getY()-pY);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelBackground;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
