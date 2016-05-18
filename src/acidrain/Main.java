package acidrain;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;


/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
    	Start S = new Start();
        S.setSize(600, 400);
        
        Dimension frameSize = S.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        S.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
        Container contentPane = S.getContentPane();
         
        S.setVisible(true);
        
    }
}