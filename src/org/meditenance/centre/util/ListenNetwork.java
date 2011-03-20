/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meditenance.centre.util;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
        URL url = null;
        URLConnection urlConn = null;
        long oldDate = 0;
        long newDate = 0;
        try {
            url = new URL("http://localhost/smartphone/pieceDataManager/sendPiece.php");
            urlConn = url.openConnection();
            oldDate = urlConn.getLastModified();
        } catch (MalformedURLException ex) {
            Logger.getLogger(ListenNetwork.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ListenNetwork.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (true) {
            newDate = urlConn.getLastModified();
            if (oldDate != newDate) {
                String result = Reseau.webServiceResponse(null, "http://localhost/smartphone/pieceDataManager/sendPiece.php");
                JSONArray array = new JSONArray();
                array.add(result);
                JSONObject json_data = array.getJSONObject(0);
                String piece = json_data.getString("piece");
                JOptionPane.showMessageDialog(this.parent, "Demande de commande : " + piece, "Commande", JOptionPane.INFORMATION_MESSAGE);
                oldDate = newDate;
            }
        }
    }
}
