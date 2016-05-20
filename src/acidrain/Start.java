/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acidrain;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

/**
 *
 * @author Administrator
 * 
 */


public class Start extends javax.swing.JFrame {

    ImageIcon icon;
    /**
     * Creates new form Start
     */
    
    public Start() {
        icon = new ImageIcon("D:\\Eclipse\\bg\\start_bg.jpg");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainFrame = new javax.swing.JPanel() {
            public void paintComponent(Graphics g) {
                // Approach 1: Dispaly image at at full size
                g.drawImage(icon.getImage(), 0, 0, null);
                // Approach 2: Scale image to size of component
                // Dimension d = getSize();
                // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                // Approach 3: Fix the image position in the scroll pane
                // Point p = scrollPane.getViewport().getViewPosition();
                // g.drawImage(icon.getImage(), p.x, p.y, null);
                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
                super.paintComponent(g);
            }
        };
        ID_F = new javax.swing.JTextField();
        PW_F = new javax.swing.JTextField();
        ID = new javax.swing.JFormattedTextField();
        Password = new javax.swing.JPasswordField();
        Login = new javax.swing.JButton();
        Sign_up = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));
        setResizable(false);

        MainFrame.setPreferredSize(new java.awt.Dimension(600, 400));
        MainFrame.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                MainFrameComponentAdded(evt);
            }
        });
        MainFrame.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                MainFrameComponentShown(evt);
            }
        });
        MainFrame.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MainFrameKeyPressed(evt);
            }
        });

        ID_F.setEditable(false);
        ID_F.setText("ID");
        ID_F.setToolTipText("");
        ID_F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_FActionPerformed(evt);
            }
        });

        PW_F.setEditable(false);
        PW_F.setText("PW");
        PW_F.setToolTipText("");
        PW_F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PW_FActionPerformed(evt);
            }
        });

        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });
        ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IDKeyPressed(evt);
            }
        });

        Password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PasswordKeyPressed(evt);
            }
        });

        Login.setText("로그인");
        Login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginMouseClicked(evt);
            }
        });
        Login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LoginKeyPressed(evt);
            }
        });

        Sign_up.setText("회원가입");
        Sign_up.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Sign_upMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MainFrameLayout = new javax.swing.GroupLayout(MainFrame);
        MainFrame.setLayout(MainFrameLayout);
        MainFrameLayout.setHorizontalGroup(
            MainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainFrameLayout.createSequentialGroup()
                .addContainerGap(187, Short.MAX_VALUE)
                .addGroup(MainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ID_F)
                    .addComponent(PW_F, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addGroup(MainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Sign_up, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(141, 141, 141))
        );
        MainFrameLayout.setVerticalGroup(
            MainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainFrameLayout.createSequentialGroup()
                .addContainerGap(242, Short.MAX_VALUE)
                .addGroup(MainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ID_F, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PW_F, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Sign_up, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    private void clearText(){
      ID_F.setText("");
      PW_F.setText("");
   }
     protected void loginCheck(String id, String pw) {
      /*
       * 로그인 체크하는 메소드
       * 연동된 DB에 있는 자료와 비교하여 체크한다.
       */
      try {
         //드라이버 로딩
         Class.forName("oracle.jdbc.driver.OracleDriver");
         String url = "jdbc:oracle:thin:@localhost:1521:orcl";
         Connection con = DriverManager.getConnection(url,"scott","root");
         Statement stat = con.createStatement();
         PreparedStatement pstmt = null;
                  
         String query, chkID;
         String test = String.valueOf(pw);
         
         int result = 0;
         Statement stmt1 = null;
         // 로그인창의 텍스트필드에 쓴값을 가져오기

         query = "SELECT * FROM MEMBERLIST"; 
         ResultSet rs1 = stat.executeQuery(query); 
         
   
         while(rs1.next()){ 
            if(id.equals(rs1.getString("ID"))){
               //System.out.println(rs1.getString(2));
               if(pw.equals(rs1.getString(2))){
                  // 아이디와 비밀번호 모두 일치하는 경우
                  result = 1;
                  clearText();
                  break;
               }else{
                  // 아이디는 일치하나 비밀번호가 잘못된 경우
                  result = 2;                  
               }
               break;
            }else{
               // 아이디부터 틀린경우
               result = 0;               
            }
         }
         if(result ==0 ){
            String infoText = "로그인 정보가 틀렸습니다.";
            JOptionPane.showMessageDialog(null, infoText, "알림창", JOptionPane.INFORMATION_MESSAGE);
         }else if(result == 2){
            String infoText = "비밀번호가 틀렸습니다.";
            JOptionPane.showMessageDialog(null, infoText, "알림창", JOptionPane.INFORMATION_MESSAGE);
         }else if(result ==1){
             dispose();
             Lobby L = new Lobby();
             L.setSize(1050, 800);
             Dimension frameSize = L.getSize();
             Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
             L.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
             Container contentPane = L.getContentPane();
             L.setVisible(true);
         }
         stat.close();
         con.close();
      } catch (ClassNotFoundException | SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
    
    
    private void ID_FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_FActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_FActionPerformed

    private void PW_FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PW_FActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PW_FActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void LoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginMouseClicked
        // TODO add your handling code here:
        
       String InputID = ID.getText();
       String PW = Password.getText();
       loginCheck(InputID,PW);
        
    }//GEN-LAST:event_LoginMouseClicked

    private void Sign_upMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Sign_upMouseClicked
        // TODO add your handling code here:
        dispose();
        NewAccountFrame NewA = new NewAccountFrame();
        Dimension frameSize = NewA.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        NewA.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
        Container contentPane = NewA.getContentPane();
        NewA.setVisible(true);
        
    }//GEN-LAST:event_Sign_upMouseClicked

    private void MainFrameComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_MainFrameComponentShown

    }//GEN-LAST:event_MainFrameComponentShown

    private void MainFrameComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_MainFrameComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_MainFrameComponentAdded

    private void LoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LoginKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginKeyPressed

    private void MainFrameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MainFrameKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			//...동작을 실행한다.
            String InputID = ID.getText();
            String PW = Password.getText();
            loginCheck(InputID,PW);
        }
    }//GEN-LAST:event_MainFrameKeyPressed

    private void PasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			//...동작을 실행한다.
            String InputID = ID.getText();
            String PW = Password.getText();
            loginCheck(InputID,PW);
        }
    }//GEN-LAST:event_PasswordKeyPressed

    private void IDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_IDKeyPressed

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
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField ID;
    private javax.swing.JTextField ID_F;
    private javax.swing.JButton Login;
    private javax.swing.JPanel MainFrame;
    private javax.swing.JTextField PW_F;
    private javax.swing.JPasswordField Password;
    private javax.swing.JButton Sign_up;
    // End of variables declaration//GEN-END:variables
}
