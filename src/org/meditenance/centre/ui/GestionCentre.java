/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meditenance.centre.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.meditenance.centre.DAO.ClientDAO;
import org.meditenance.centre.DAO.EmployeeDAO;
import org.meditenance.centre.DAO.FurnitureDAO;
import org.meditenance.centre.DAO.InterventionDAO;
import org.meditenance.centre.DAO.PieceDAO;
import org.meditenance.centre.DAO.model.DAO;
import org.meditenance.centre.domain.Client;
import org.meditenance.centre.domain.Employee;
import org.meditenance.centre.domain.Furniture;
import org.meditenance.centre.domain.Intervention;
import org.meditenance.centre.domain.Piece;

/**
 *
 * @author jeremie
 */
public class GestionCentre {

    // -- DAOs
    private InterventionDAO interventionDAO = new InterventionDAO();
    private DAO clientDAO = new ClientDAO();
    private DAO employeeDAO = new EmployeeDAO();
    private FurnitureDAO furnitureDAO = new FurnitureDAO();
    private PieceDAO pieceDAO = new PieceDAO();

    public void saveClient(Client client) {
        this.clientDAO.save(client);
    }

    public void saveEmployee(Employee employee) {
        this.employeeDAO.save(employee);
    }

    public void saveIntervention(Intervention intervention) {
        this.interventionDAO.save(intervention);
    }

    public void saveFurniture(Furniture furniture) {
        this.furnitureDAO.save(furniture);
    }

    public void savePiece(Piece piece) {
        this.pieceDAO.save(piece);
    }
    
    public void removeClient(Client client) {
        this.clientDAO.remove(client);
    }

    public void removeEmployee(Employee employee) {
        this.employeeDAO.remove(employee);
    }

    public void removeIntervention(Intervention intervention) {
        this.interventionDAO.remove(intervention);
    }

    public void removeFurniture(Furniture furniture) {
        this.furnitureDAO.remove(furniture);
    }

    public void removePiece(Piece piece) {
        this.pieceDAO.remove(piece);
    }

    public List<Client> getAllClients() {
        return this.clientDAO.getAll();
    }

    public List<Employee> getAllEmployees() {
        return this.employeeDAO.getAll();
    }

    public List<Intervention> getAllInterventions() {
        return this.interventionDAO.getAll();
    }

    public List<Furniture> getAllFurnitures() {
        return this.furnitureDAO.getAll();
    }

    public List<Piece> getAllPieces() {
        return this.pieceDAO.getAll();
    }
    
    public List<Intervention> getInterventionsByEmployee(Employee employee)
    {
        return this.interventionDAO.getByEmployee(employee);
    }
    
    public List<Intervention> getInterventionsByClient(Client client)
    {
        return this.interventionDAO.getByClient(client);
    }
    
    public List<Intervention> getInterventionsByClientAndEmployee(Client client, Employee employee)
    {
        return this.interventionDAO.getByClientAndEmployee(client, employee);
    }

    public List<List<Intervention>> calculerPlanning() {
        Calendar calendar = Calendar.getInstance();
        List<List<Intervention>> semaine = new Vector<List<Intervention>>();

        switch (calendar.get(Calendar.DAY_OF_WEEK)) {

            case Calendar.SUNDAY:
                calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 1);
                break;

            case Calendar.TUESDAY:
                calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 1);
                break;

            case Calendar.WEDNESDAY:
                calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 2);
                break;

            case Calendar.THURSDAY:
                calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 3);
                break;

            case Calendar.FRIDAY:
                calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 4);
                break;
                
           case Calendar.SATURDAY:
                calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 5);
                break;
        }
        for (int i = 0; i < 5; i++) {
            semaine.add(this.interventionDAO.getByDate(calendar.getTime()));
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 1);
        }
        return semaine;
    }

    public boolean isInterventionInCurrentWeek(Intervention intervention) {
        Calendar interCal = Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        boolean ok = false;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(intervention.getBegin());
        } catch (ParseException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        interCal.setTime(date);

        switch (calendar.get(Calendar.DAY_OF_WEEK)) {

            case Calendar.MONDAY:
                if ((interCal.get(Calendar.DAY_OF_YEAR) >= calendar.get(Calendar.DAY_OF_YEAR)) && (interCal.get(Calendar.DAY_OF_YEAR) <= (calendar.get(Calendar.DAY_OF_YEAR) + 4))) {
                    ok = true;
                }
                break;

            case Calendar.TUESDAY:
                if ((interCal.get(Calendar.DAY_OF_YEAR) >= calendar.get(Calendar.DAY_OF_YEAR)) && (interCal.get(Calendar.DAY_OF_YEAR) <= (calendar.get(Calendar.DAY_OF_YEAR) + 3))) {
                    ok = true;
                }
                break;

            case Calendar.WEDNESDAY:
                if ((interCal.get(Calendar.DAY_OF_YEAR) >= calendar.get(Calendar.DAY_OF_YEAR)) && (interCal.get(Calendar.DAY_OF_YEAR) <= (calendar.get(Calendar.DAY_OF_YEAR) + 2))) {
                    ok = true;
                }
                break;

            case Calendar.THURSDAY:
                if ((interCal.get(Calendar.DAY_OF_YEAR) == calendar.get(Calendar.DAY_OF_YEAR)) || (interCal.get(Calendar.DAY_OF_YEAR) == (calendar.get(Calendar.DAY_OF_YEAR) + 1))) {
                    ok = true;
                }
                break;

            case Calendar.FRIDAY:
                if (interCal.get(Calendar.DAY_OF_YEAR) == calendar.get(Calendar.DAY_OF_YEAR)) {
                    ok = true;
                }
                break;
        }
        return ok;
    }

    public boolean isInterventionInCurrentWeek(Intervention intervention, Calendar interCal) {
        Calendar calendar = Calendar.getInstance();
        boolean ok = false;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(intervention.getBegin());
        } catch (ParseException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        interCal.setTime(date);

        switch (calendar.get(Calendar.DAY_OF_WEEK)) {

            case Calendar.MONDAY:
                if ((interCal.get(Calendar.DAY_OF_YEAR) >= calendar.get(Calendar.DAY_OF_YEAR)) && (interCal.get(Calendar.DAY_OF_YEAR) <= (calendar.get(Calendar.DAY_OF_YEAR) + 4))) {
                    ok = true;
                }
                break;

            case Calendar.TUESDAY:
                if ((interCal.get(Calendar.DAY_OF_YEAR) >= calendar.get(Calendar.DAY_OF_YEAR)) && (interCal.get(Calendar.DAY_OF_YEAR) <= (calendar.get(Calendar.DAY_OF_YEAR) + 3))) {
                    ok = true;
                }
                break;

            case Calendar.WEDNESDAY:
                if ((interCal.get(Calendar.DAY_OF_YEAR) >= calendar.get(Calendar.DAY_OF_YEAR)) && (interCal.get(Calendar.DAY_OF_YEAR) <= (calendar.get(Calendar.DAY_OF_YEAR) + 2))) {
                    ok = true;
                }
                break;

            case Calendar.THURSDAY:
                if ((interCal.get(Calendar.DAY_OF_YEAR) == calendar.get(Calendar.DAY_OF_YEAR)) || (interCal.get(Calendar.DAY_OF_YEAR) == (calendar.get(Calendar.DAY_OF_YEAR) + 1))) {
                    ok = true;
                }
                break;

            case Calendar.FRIDAY:
                if (interCal.get(Calendar.DAY_OF_YEAR) == calendar.get(Calendar.DAY_OF_YEAR)) {
                    ok = true;
                }
                break;
        }
        return ok;
    }
}
