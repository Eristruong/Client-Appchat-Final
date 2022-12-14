/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

import event.PublicEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import model.Model_User_Account;

/**
 *
 * @author Admin
 */
public class Item_people extends javax.swing.JPanel {
    private final String PATH_FILE = "client_data/";
    private ImageIcon imAvatar;
    /**
     * @return the user
     */
    public Model_User_Account getUser() {
        return user;
    }

    private final Model_User_Account user;
    private boolean mouseOver;
    
    public Item_people(Model_User_Account user){
        initComponents();
        this.user = user;
         ByteArrayInputStream bis = new ByteArrayInputStream(user.getImage());
         BufferedImage bImage;
        try {
            bImage = ImageIO.read(bis);
            imAvatar = new ImageIcon(bImage);
            imageAvatar1.setImage(imAvatar);
            imageAvatar1.repaint();
            imageAvatar1.revalidate();
        
        
            this.user.setImAvatar(imAvatar);
            lb.setText(user.getUserName());
        if(user.getStatus()){
            activeStatus.setActive(user.getStatus());
            lbStatus.setText("Đang hoạt động");
        }else{
            activeStatus.setActive(user.getStatus());
            lbStatus.setText("Đang Offline");
        }
        } catch (IOException ex) {
            Logger.getLogger(Item_people.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        init();
    }
    public void updateStatus(){
        
        if (user.getStatus()) {
            activeStatus.setActive(this.user.getStatus());
            lbStatus.setText("Đang hoạt động");
        }else{
            activeStatus.setActive(this.user.getStatus());
            lbStatus.setText("Đang Offline");
        }
    }
    
   
    private void init(){
     addMouseListener(new MouseAdapter() { //set màu khi hover chuột vào ô user
            @Override 
            public void mouseEntered(MouseEvent me) {
                setBackground(new Color(230, 230, 230));
                mouseOver = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(new Color(242, 242, 242));
                mouseOver = false;
            }

         @Override
         public void mouseReleased(MouseEvent e) { //event nhấn chuột vào từng component của list item
             if(mouseOver){
                 PublicEvent.getInstance().getEventMain().selectUser(user);
             }
            }
            
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new swing.ImageAvatar();
        lb = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        activeStatus = new swing.ActiveStatus();

        setBackground(new java.awt.Color(242, 242, 242));

        imageAvatar1.setBorderColor(new java.awt.Color(107, 13, 158));
        imageAvatar1.setBorderSize(1);
        imageAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("/icon/profile2.png"))); // NOI18N

        lb.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lb.setText("Tên");

        lbStatus.setFont(new java.awt.Font("JetBrains Mono", 0, 11)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(117, 117, 117));
        lbStatus.setPreferredSize(new java.awt.Dimension(98, 17));

        activeStatus.setActive(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(activeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(activeStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ActiveStatus activeStatus;
    private swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lbStatus;
    // End of variables declaration//GEN-END:variables
}
