/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package iu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import modelo.Xogo;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.Timer;

/**
 *
 * @author a22alejandrofc
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private Xogo xogo;
    private Timer tiempo;
    private int centesimas = 0;
    private int segundos = 0;
    private int minutos = 0;
    private int horas = 0;
    private int dificultad = 3;
    private int caidaFicha;
    private int aumento = 2;
    private ArrayList<Integer> nivelesAlcanzados = new ArrayList();

    /**
     * Creates new form VentanaPrincipal
     */
    public class Imagen extends javax.swing.JPanel {

        public Imagen() {
            this.setSize(xogo.getMaxX(), xogo.getMaxY());
        }

        public void paint(Graphics grafico) {
            ImageIcon Img = new ImageIcon(getClass().getResource("/Images/tetris4_transparente.png"));
            grafico.drawImage(Img.getImage(), 0, 0, 320, 640, null);

        }
    }

    private void tiempo() {
        String texto = (horas <= 9 ? "0" : "") + horas + ":" + (minutos <= 9 ? "0" : "") + minutos + ":"
                + (segundos <= 9 ? "0" : "") + segundos + ":" + (centesimas <= 9 ? "0" : "") + centesimas;

        Tiempo.setText(texto);
    }

    public VentanaPrincipal() {

        initComponents();
        jRadioButton2.setSelected(true);
        declararImagenes();
    }

    private void declararImagenes() {
        jRadioButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass()
                .getResource("/Images/facil_verde.png")));
        jRadioButton1.setIcon(new javax.swing.ImageIcon(getClass()
                .getResource("/Images/facil_negro.png")));
        jRadioButton2.setSelectedIcon(new javax.swing.ImageIcon(getClass()
                .getResource("/Images/medio_amarillo.png")));
        jRadioButton2.setIcon(new javax.swing.ImageIcon(getClass()
                .getResource("/Images/medio_negro.png")));
        jRadioButton3.setSelectedIcon(new javax.swing.ImageIcon(getClass()
                .getResource("/Images/dificil_rojo.png")));
        jRadioButton3.setIcon(new javax.swing.ImageIcon(getClass()
                .getResource("/Images/dificil_negro.png")));
    }

    public void mostrarNumeroLinas() {
        lblLblnumlinas.setText(xogo.getNumeroLineas() + "");
    }

    private ActionListener acciones = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            centesimas++;
            caidaFicha++;
            mostrarNumeroLinas();
            if (centesimas == 100) {
                segundos++;
                centesimas = 0;
            }
            if (comprobarCaida()) {
                xogo.moverFichaAbaixo();
                caidaFicha = 0;
                aumentarVelocidad();
            }
            if (segundos == 30 && centesimas == 0) {
                xogo.engadirLineas();
            }
            if (segundos == 60) {
                minutos++;
                segundos = 0;
            }
            if (minutos == 60) {
                horas++;
                minutos = 0;
            }
            if (horas == 24) {
                horas = 0;
            }
            tiempo();
        }
    };

    private boolean comprobarCaida() {
        return caidaFicha == 85 - 5 * dificultad;
    }

    private void aumentarVelocidad() {
        if (!nivelAlcanzado(xogo.getNumeroLineas())) {
            nuevosNivelesAlcanzados(xogo.getNumeroLineas());
        }
    }
    
    private void nuevosNivelesAlcanzados(int nivel){
        while(nivel>0 && dificultad<15){
            if (nivel % 5 == 0 && !nivelesAlcanzados.contains(nivel)) {
                dificultad += aumento;
            }
            if(!nivelesAlcanzados.contains(nivel)){
                nivelesAlcanzados.add(nivel);
            }
            nivel--;
        }
        if(dificultad>15){
            dificultad=15;
        }
    }

    private boolean nivelAlcanzado(int nivel) {
        Iterator<Integer> niveles = nivelesAlcanzados.iterator();
        while (niveles.hasNext()) {
            if (niveles.next() == nivel) {
                return true;
            }
        }
        return false;
    }

    public void pintarCadrado(JLabel lblCadrado) {
        panelXogo.add(lblCadrado);
        panelXogo.updateUI();
    }

    public void borrarCadrado(JLabel lblCadrado) {
        panelXogo.remove(lblCadrado);
        panelXogo.updateUI();
    }

    public void mostrarFinDoXogo() {
        jFrame2.setVisible(true);
        tiempo.stop();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        panelXogo = new javax.swing.JPanel();
        PanelLabels = new javax.swing.JPanel();
        Tiempo = new javax.swing.JLabel();
        CajaTiempo = new javax.swing.JLabel();
        lblLblnumlinas = new javax.swing.JLabel();
        CajaPuntuación = new javax.swing.JLabel();
        Pausa = new javax.swing.JToggleButton();
        botonesDificultad = new javax.swing.ButtonGroup();
        jFrame2 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();

        jFrame1.setLocation(new java.awt.Point(250, 0));
        jFrame1.setMinimumSize(new java.awt.Dimension(700, 950));
        jFrame1.setResizable(false);

        panelXogo.setBackground(new java.awt.Color(0, 0, 0));
        panelXogo.setMaximumSize(new java.awt.Dimension(320, 640));
        panelXogo.setMinimumSize(new java.awt.Dimension(320, 640));
        panelXogo.setPreferredSize(new java.awt.Dimension(320, 640));
        panelXogo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panelXogoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelXogoLayout = new javax.swing.GroupLayout(panelXogo);
        panelXogo.setLayout(panelXogoLayout);
        panelXogoLayout.setHorizontalGroup(
                panelXogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 320, Short.MAX_VALUE)
        );
        panelXogoLayout.setVerticalGroup(
                panelXogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 640, Short.MAX_VALUE)
        );

        PanelLabels.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tiempo.setFont(new java.awt.Font("Source Serif Pro Black", 1, 36)); // NOI18N
        Tiempo.setLabelFor(CajaTiempo);
        Tiempo.setText("00:00:00:00");
        PanelLabels.add(Tiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 210, 70));

        CajaTiempo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/scorre (3).png"))); // NOI18N
        PanelLabels.add(CajaTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 320, 202));

        lblLblnumlinas.setFont(new java.awt.Font("Source Serif Pro Black", 1, 36)); // NOI18N
        lblLblnumlinas.setText("0");
        PanelLabels.add(lblLblnumlinas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 120, 80));

        CajaPuntuación.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/scorre (2).1.png"))); // NOI18N
        PanelLabels.add(CajaPuntuación, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 320, 187));

        Pausa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/button (2).png"))); // NOI18N
        Pausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PausaActionPerformed(evt);
            }
        });
        PanelLabels.add(Pausa, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 194, 70));
        Pausa.getAccessibleContext().setAccessibleParent(PanelLabels);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
                jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jFrame1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelXogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(PanelLabels, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(98, Short.MAX_VALUE))
        );
        jFrame1Layout.setVerticalGroup(
                jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jFrame1Layout.createSequentialGroup()
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jFrame1Layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(panelXogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jFrame1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(PanelLabels, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(443, Short.MAX_VALUE))
        );

        jFrame2.setLocation(new java.awt.Point(350, 150));
        jFrame2.setMaximumSize(new java.awt.Dimension(360, 422));
        jFrame2.setMinimumSize(new java.awt.Dimension(360, 422));
        jFrame2.setPreferredSize(new java.awt.Dimension(360, 422));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/es.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 220, 110));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Diseño sin título.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, -1));

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
                jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jFrame2Layout.setVerticalGroup(
                jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 900));
        setResizable(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/button (1).png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tetris.png"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(300, 300));
        jLabel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel2KeyPressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/628a738ebc2ec7ad957f4072.png"))); // NOI18N

        botonesDificultad.add(jRadioButton1);
        jRadioButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/scorre (5).png"))); // NOI18N
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        botonesDificultad.add(jRadioButton2);
        jRadioButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/scorre (7).png"))); // NOI18N
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        botonesDificultad.add(jRadioButton3);
        jRadioButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/scorre (9).png"))); // NOI18N
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(81, 81, 81)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(121, 121, 121)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(110, 110, 110)
                                                .addComponent(jRadioButton2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(94, 94, 94)
                                                .addComponent(jRadioButton3)))
                                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(39, 39, 39)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36)
                                                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(518, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PausaActionPerformed

        if (tiempo.isRunning()) {
            tiempo.stop();
            xogo.setPausa(true);
        } else {
            tiempo.start();
            panelXogo.requestFocus();
            xogo.setPausa(false);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_PausaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        iniciarPartida();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void iniciarPartida() {
        panelXogo.removeAll();
        panelXogo.updateUI();
        jFrame1.setVisible(true);
        xogo = new Xogo(this);
        xogo.xenerarNovaFicha();
        xogo.setPausa(false);
        panelXogo.setFocusable(true);
        panelXogo.requestFocus();
        tiempo = new Timer(10, acciones);
        centesimas = 0;
        segundos = 0;
        minutos = 0;
        horas = 0;
        /*Imagen Imagen = new Imagen();
        panelXogo.add(Imagen);*/
        tiempo.start();
        nivelesAlcanzados.add(0);
    }

    private void jLabel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2KeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyPressed

    private void panelXogoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelXogoKeyPressed

        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_DOWN) {
            getXogo().moverFichaAbaixo();
        }
        if (key == KeyEvent.VK_RIGHT) {
            getXogo().moverFichaDereita();
        }
        if (key == KeyEvent.VK_LEFT) {
            getXogo().moverFichaEsquerda();
        }
        if (key == KeyEvent.VK_UP) {
            getXogo().rotarFicha();
        }
        repaint();

        // TODO add your handling code here:
    }//GEN-LAST:event_panelXogoKeyPressed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        dificultad = 1;
        aumento = 1;
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        dificultad = 3;
        aumento = 2;
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        dificultad = 5;
        aumento = 3;
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        xogo = null;

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CajaPuntuación;
    private javax.swing.JLabel CajaTiempo;
    private javax.swing.JPanel PanelLabels;
    private javax.swing.JToggleButton Pausa;
    private javax.swing.JLabel Tiempo;
    private javax.swing.ButtonGroup botonesDificultad;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JLabel lblLblnumlinas;
    private javax.swing.JPanel panelXogo;
    // End of variables declaration//GEN-END:variables

    public Xogo getXogo() {
        return xogo;
    }

    public void setXogo(Xogo xogo) {
        this.xogo = xogo;
    }

}
