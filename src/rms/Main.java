/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rms;

import java.awt.Toolkit;
import rms.views.MainApplicationView;
import supports.DataSupport;

/**
 *
 * @author squeekyclean
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataSupport.loadSettings();
        //LoginView.getInstance().setVisible(true);
        MainApplicationView main = new MainApplicationView();
        Toolkit tk = Toolkit.getDefaultToolkit();
        main.setSize(tk.getScreenSize().width, tk.getScreenSize().height);
        main.setVisible(true);
    }

}