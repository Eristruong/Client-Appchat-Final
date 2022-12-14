/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

import java.awt.Cursor;
import javax.swing.ImageIcon;
import service.Service;

/**
 *
 * @author Admin
 */
public class Chat_Sound extends javax.swing.JPanel {
    private byte[] sound;
    private boolean over = false;
    private boolean p = false;
    /**
     * Creates new form Chat_Sound
     */
    public Chat_Sound() {
        initComponents();
        play.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    public void set(byte[] sound, String time){
    this.sound = sound;
    lbTime.setText(time.split("!")[0]);
    process.setMaximum(Integer.valueOf(time.split("!")[1])+0);
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new swing.Panel();
        panel3 = new swing.Panel();
        lbTime = new javax.swing.JLabel();
        process = new javax.swing.JProgressBar();
        play = new swing.PictureBox();

        setBackground(new java.awt.Color(255, 255, 255));

        panel1.setBackground(new java.awt.Color(51, 51, 51));

        panel3.setBackground(new java.awt.Color(0, 0, 0));
        panel3.setForeground(new java.awt.Color(0, 0, 0));
        panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTime.setBackground(new java.awt.Color(255, 255, 255));
        lbTime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTime.setForeground(new java.awt.Color(255, 255, 255));
        lbTime.setText("0:02");
        panel3.add(lbTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 30, 30));

        panel1.add(panel3);
        panel3.setBounds(220, 0, 60, 30);

        process.setBackground(new java.awt.Color(51, 51, 51));
        process.setForeground(new java.awt.Color(255, 255, 255));
        process.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        process.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                processStateChanged(evt);
            }
        });
        panel1.add(process);
        process.setBounds(30, 0, 240, 30);

        play.setImage(new javax.swing.ImageIcon(getClass().getResource("/icon/play.png"))); // NOI18N
        play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                playMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                playMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                playMouseReleased(evt);
            }
        });
        panel1.add(play);
        play.setBounds(0, 0, 30, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void playMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseEntered
        over = true;
        play.setImage(new ImageIcon(getClass().getResource("/icon/pause.png")));
       
    }//GEN-LAST:event_playMouseEntered

    private void playMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseExited
        over = false;
    }//GEN-LAST:event_playMouseExited

    private void playMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseReleased
        if(over){
          if (!p) {
                process.setValue(0);
                Service.getInstance().getRecoder().playAudio(sound, process);
                p = true;
            } else {
             
                Service.getInstance().getRecoder().stopPlay();              
                p = false;
            }
        
        }
    }//GEN-LAST:event_playMouseReleased

    private void processStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_processStateChanged
         if (process.getValue() >= process.getMaximum()) {
            play.setImage(new ImageIcon(getClass().getResource("/icon/play.png"))); 
            p = false;
        }
    }//GEN-LAST:event_processStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbTime;
    private swing.Panel panel1;
    private swing.Panel panel3;
    private swing.PictureBox play;
    private javax.swing.JProgressBar process;
    // End of variables declaration//GEN-END:variables
}
