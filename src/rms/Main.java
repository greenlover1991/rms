/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rms;

import rms.views.LoginView;
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
        LoginView.getInstance().setVisible(true);
    }

}