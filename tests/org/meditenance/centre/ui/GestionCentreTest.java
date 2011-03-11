/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meditenance.centre.ui;

import java.util.Calendar;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.meditenance.centre.domain.Client;
import org.meditenance.centre.domain.Employee;
import org.meditenance.centre.domain.Furniture;
import org.meditenance.centre.domain.Intervention;
import org.meditenance.centre.domain.Piece;

/**
 *
 * @author jeremie
 */
public class GestionCentreTest {

    public GestionCentreTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of saveClient method, of class GestionCentre.
     */
    @Test
    public void testSaveClient() {
        System.out.println("saveClient");
        Client client = new Client("Foo","Bar","12 rue des Marguerites");
        GestionCentre instance = new GestionCentre();
        instance.saveClient(client);
        assertFalse(System.err.checkError());
    }

    /**
     * Test of saveEmployee method, of class GestionCentre.
     */
    @Test
    public void testSaveEmployee() {
        System.out.println("saveEmployee");
        Employee employee = new Employee("admin", "admin", 0);
        GestionCentre instance = new GestionCentre();
        instance.saveEmployee(employee);
        assertFalse(System.err.checkError());
    }

    /**
     * Test of saveIntervention method, of class GestionCentre.
     */
    @Test
    public void testSaveIntervention() {
        System.out.println("saveIntervention");
        Intervention intervention = new Intervention(new Client("test","test",null), new Employee("test","test",1), 1, 1, "");
        GestionCentre instance = new GestionCentre();
        instance.saveIntervention(intervention);
        assertFalse(System.err.checkError());

    }

    /**
     * Test of saveFurniture method, of class GestionCentre.
     */
    @Test
    public void testSaveFurniture() {
        System.out.println("saveFurniture");
        Furniture furniture = new Furniture();
        GestionCentre instance = new GestionCentre();
        instance.saveFurniture(furniture);
        assertFalse(System.err.checkError());
    }

    /**
     * Test of savePiece method, of class GestionCentre.
     */
    @Test
    public void testSavePiece() {
        System.out.println("savePiece");
        Piece piece = new Piece();
        GestionCentre instance = new GestionCentre();
        instance.savePiece(piece);
        assertFalse(System.err.checkError());
    }

    /**
     * Test of removeClient method, of class GestionCentre.
     */
    @Test
    public void testRemoveClient() {
        System.out.println("removeClient");
        Client client = new Client("Foo","Bar","12 rue des Marguerites");
        GestionCentre instance = new GestionCentre();
        instance.removeClient(client);
        assertFalse(System.err.checkError());
    }

    /**
     * Test of removeEmployee method, of class GestionCentre.
     */
    @Test
    public void testRemoveEmployee() {
        System.out.println("removeEmployee");
        Employee employee = null;
        GestionCentre instance = new GestionCentre();
        instance.removeEmployee(employee);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeIntervention method, of class GestionCentre.
     */
    @Test
    public void testRemoveIntervention() {
        System.out.println("removeIntervention");
        Intervention intervention = null;
        GestionCentre instance = new GestionCentre();
        instance.removeIntervention(intervention);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeFurniture method, of class GestionCentre.
     */
    @Test
    public void testRemoveFurniture() {
        System.out.println("removeFurniture");
        Furniture furniture = null;
        GestionCentre instance = new GestionCentre();
        instance.removeFurniture(furniture);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removePiece method, of class GestionCentre.
     */
    @Test
    public void testRemovePiece() {
        System.out.println("removePiece");
        Piece piece = null;
        GestionCentre instance = new GestionCentre();
        instance.removePiece(piece);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllClients method, of class GestionCentre.
     */
    @Test
    public void testGetAllClients() {
        System.out.println("getAllClients");
        GestionCentre instance = new GestionCentre();
        List expResult = null;
        List result = instance.getAllClients();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllEmployees method, of class GestionCentre.
     */
    @Test
    public void testGetAllEmployees() {
        System.out.println("getAllEmployees");
        GestionCentre instance = new GestionCentre();
        List expResult = null;
        List result = instance.getAllEmployees();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllInterventions method, of class GestionCentre.
     */
    @Test
    public void testGetAllInterventions() {
        System.out.println("getAllInterventions");
        GestionCentre instance = new GestionCentre();
        List expResult = null;
        List result = instance.getAllInterventions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllFurnitures method, of class GestionCentre.
     */
    @Test
    public void testGetAllFurnitures() {
        System.out.println("getAllFurnitures");
        GestionCentre instance = new GestionCentre();
        List expResult = null;
        List result = instance.getAllFurnitures();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllPieces method, of class GestionCentre.
     */
    @Test
    public void testGetAllPieces() {
        System.out.println("getAllPieces");
        GestionCentre instance = new GestionCentre();
        List expResult = null;
        List result = instance.getAllPieces();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInterventionsByEmployee method, of class GestionCentre.
     */
    @Test
    public void testGetInterventionsByEmployee() {
        System.out.println("getInterventionsByEmployee");
        Employee employee = null;
        GestionCentre instance = new GestionCentre();
        List expResult = null;
        List result = instance.getInterventionsByEmployee(employee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInterventionsByClient method, of class GestionCentre.
     */
    @Test
    public void testGetInterventionsByClient() {
        System.out.println("getInterventionsByClient");
        Client client = null;
        GestionCentre instance = new GestionCentre();
        List expResult = null;
        List result = instance.getInterventionsByClient(client);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInterventionsByClientAndEmployee method, of class GestionCentre.
     */
    @Test
    public void testGetInterventionsByClientAndEmployee() {
        System.out.println("getInterventionsByClientAndEmployee");
        Client client = null;
        Employee employee = null;
        GestionCentre instance = new GestionCentre();
        List expResult = null;
        List result = instance.getInterventionsByClientAndEmployee(client, employee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculerPlanning method, of class GestionCentre.
     */
    @Test
    public void testCalculerPlanning() {
        System.out.println("calculerPlanning");
        GestionCentre instance = new GestionCentre();
        List expResult = null;
        List result = instance.calculerPlanning();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isInterventionInCurrentWeek method, of class GestionCentre.
     */
    @Test
    public void testIsInterventionInCurrentWeek_Intervention() {
        System.out.println("isInterventionInCurrentWeek");
        Intervention intervention = null;
        GestionCentre instance = new GestionCentre();
        boolean expResult = false;
        boolean result = instance.isInterventionInCurrentWeek(intervention);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isInterventionInCurrentWeek method, of class GestionCentre.
     */
    @Test
    public void testIsInterventionInCurrentWeek_Intervention_Calendar() {
        System.out.println("isInterventionInCurrentWeek");
        Intervention intervention = null;
        Calendar interCal = null;
        GestionCentre instance = new GestionCentre();
        boolean expResult = false;
        boolean result = instance.isInterventionInCurrentWeek(intervention, interCal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}