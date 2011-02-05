/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditenance.centre.main;

import org.hibernate.Session;
import org.meditenance.centre.util.HibernateUtil;

/**
 *
 * @author Talus
 */
public class home {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.close();
    }

}
