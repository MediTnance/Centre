/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meditenance.centre.ui;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import org.meditenance.centre.DAO.ClientDAO;
import org.meditenance.centre.DAO.EmployeeDAO;
import org.meditenance.centre.DAO.FurnitureDAO;
import org.meditenance.centre.DAO.InterventionDAO;
import org.meditenance.centre.DAO.PieceDAO;
import org.meditenance.centre.DAO.model.DAO;
import org.meditenance.centre.domain.Intervention;

/**
 *
 * @author jeremie
 */
public class GestionCentre {

    private InterventionDAO interventionDAO = new InterventionDAO();
    private DAO clientDAO = new ClientDAO();
    private DAO employeeDAO = new EmployeeDAO();
    private FurnitureDAO furnitureDAO = new FurnitureDAO();
    private PieceDAO pieceDAO = new PieceDAO();

    public List<List<Intervention>> calculerPlanning() {
        Calendar calendar = Calendar.getInstance();
        List<List<Intervention>> semaine = new Vector<List<Intervention>>();

        switch (calendar.get(Calendar.DAY_OF_WEEK)) {

            case Calendar.TUESDAY: calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 1);
                break;
                
            case Calendar.WEDNESDAY: calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 2);
                break;
                
            case Calendar.THURSDAY: calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 3);
                break;
                
            case Calendar.FRIDAY: calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 4);
                break;
        }
        for (int i = 0; i < 5; i++) {
            semaine.add(this.interventionDAO.getByDate(calendar.getTime()));
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 1);
        }
        return semaine;
    }
}
