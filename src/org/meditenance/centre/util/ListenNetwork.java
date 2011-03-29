/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meditenance.centre.util;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jeremie
 */
public class ListenNetwork extends Thread {

    private Component parent;

    public ListenNetwork(Component parent) {
        this.parent = parent;
    }

    public void run() {

        String oldresult = "";
        String newresult = "";
        oldresult = Reseau.webServiceResponse(null, "http://localhost/smartphone/pieceDataManager/pieces.php");
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ListenNetwork.class.getName()).log(Level.SEVERE, null, ex);
            }
            newresult = Reseau.webServiceResponse(null, "http://localhost/smartphone/pieceDataManager/pieces.php");

            if (!oldresult.equals(newresult)) {
                String[] split = newresult.split(":");
                JOptionPane.showMessageDialog(this.parent, "Demande de commande : " + split[1].substring(3,split[1].length()-3), "Commande", JOptionPane.INFORMATION_MESSAGE);
                oldresult = newresult;
            }
        }
    }
}
