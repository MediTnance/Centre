/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Home.java
 *
 * Created on 5 févr. 2011, 18:26:20
 */
package org.meditenance.centre.ui;

import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.meditenance.centre.DAO.ClientDAO;
import org.meditenance.centre.DAO.EmployeeDAO;
import org.meditenance.centre.DAO.model.DAO;
import org.meditenance.centre.DAO.model.FurnitureDAO;
import org.meditenance.centre.DAO.model.InterventionDAO;
import org.meditenance.centre.DAO.model.PieceDAO;
import org.meditenance.centre.domain.Client;
import org.meditenance.centre.domain.Employee;
import org.meditenance.centre.domain.Furniture;
import org.meditenance.centre.domain.Intervention;
import org.meditenance.centre.domain.Piece;
import org.meditenance.centre.util.ListenNetwork;

/**
 *
 * @author Talus
 */
public class Home extends javax.swing.JFrame {
    
    private GestionCentre centreManager = new GestionCentre();

    /** Creates new form Home */
    public Home(Integer role) {
        
        List<Client> lC = this.centreManager.getAllClients();
        List<Employee> lE = this.centreManager.getAllEmployees();
        List<Intervention> lI = this.centreManager.getAllInterventions();
        DefaultComboBoxModel clientModel = new DefaultComboBoxModel(lC.toArray());

        this.initComponents();

        if (role != 0) {
            this.PieceTab.setEnabledAt(5, false);
        }

        // -- Clients
        this.clientsList.setModel(new DefaultListModel());
        this.fillList(lC, this.clientsList);

        // -- Employés
        this.employeesList.setModel(new DefaultListModel());
        this.fillList(lE, this.employeesList);
        this.employeeRole.setModel(new DefaultComboBoxModel(Role.values()));
        this.employeeRole.setSelectedIndex(-1);

        // -- Matériel
        this.furnituresList.setModel(new DefaultListModel());
        this.fillList(this.centreManager.getAllFurnitures(), this.furnituresList);
        this.furnitureClient.setModel(clientModel);
        this.furnitureClient.setSelectedIndex(-1);

        // -- Interventions
        this.interventionsList.setModel(new DefaultListModel());
        this.fillList(lI, this.interventionsList);
        this.interventionClient.setModel(clientModel);
        this.interventionEmployee.setModel(new DefaultComboBoxModel(lE.toArray()));
        this.interventionType.setModel(new DefaultComboBoxModel(Type.values()));
        this.interventionClient.setSelectedIndex(-1);
        this.interventionEmployee.setSelectedIndex(-1);
        this.interventionType.setSelectedIndex(-1);

        // -- Pièces
        this.piecesList.setModel(new DefaultListModel());
        this.fillList(this.centreManager.getAllPieces(), this.piecesList);
        this.pieceIntervention.setModel(new DefaultComboBoxModel(lI.toArray()));
        this.pieceIntervention.setSelectedIndex(-1);

        // -- Planning
        DefaultTableModel modelL = (DefaultTableModel) this.lundiTable.getModel();
        DefaultTableModel modelMa = (DefaultTableModel) this.mardiTable.getModel();
        DefaultTableModel modelMe = (DefaultTableModel) this.mercrediTable.getModel();
        DefaultTableModel modelJ = (DefaultTableModel) this.jeudiTable.getModel();
        DefaultTableModel modelV = (DefaultTableModel) this.vendrediTable.getModel();
        List<List<Intervention>> semaineI = this.centreManager.calculerPlanning();
        List<Intervention> lundiList = semaineI.get(0);
        List<Intervention> mardiList = semaineI.get(1);
        List<Intervention> mercrediList = semaineI.get(2);
        List<Intervention> jeudiList = semaineI.get(3);
        List<Intervention> vendrediList = semaineI.get(4);

        for (Intervention j : lundiList) {
            modelL.addRow(new Object[]{j.getBegin().substring(11, 16), j.getEmployee(), j.getClient(), j.getNature()});
        }
        for (Intervention j : mardiList) {
            modelMa.addRow(new Object[]{j.getBegin().substring(11, 16), j.getEmployee(), j.getClient(), j.getNature()});
        }
        for (Intervention j : mercrediList) {
            modelMe.addRow(new Object[]{j.getBegin().substring(11, 16), j.getEmployee(), j.getClient(), j.getNature()});
        }
        for (Intervention j : jeudiList) {
            modelJ.addRow(new Object[]{j.getBegin().substring(11, 16), j.getEmployee(), j.getClient(), j.getNature()});
        }
        for (Intervention j : vendrediList) {
            modelV.addRow(new Object[]{j.getBegin().substring(11, 16), j.getEmployee(), j.getClient(), j.getNature()});
        }
        
        ListenNetwork t = new ListenNetwork(this);
        t.start();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PieceTab = new javax.swing.JTabbedPane();
        Table = new javax.swing.JTabbedPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        lundiTable = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        mardiTable = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        mercrediTable = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        jeudiTable = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        vendrediTable = new javax.swing.JTable();
        InterventionTab = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        interventionsList = new javax.swing.JList();
        interventionAction = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        interventionAnnotations = new javax.swing.JTextArea();
        interventionEmployee = new javax.swing.JComboBox();
        interventionClient = new javax.swing.JComboBox();
        interventionEnd = new com.toedter.calendar.JDateChooser();
        interventionType = new javax.swing.JComboBox();
        interventionCost = new javax.swing.JTextField();
        interventionCancel = new javax.swing.JButton();
        interventionButton = new javax.swing.JButton();
        interventionSuppr = new javax.swing.JButton();
        interventionBegin = new com.toedter.calendar.JDateChooser();
        heureDebutIntervention = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        heureFinIntervention = new javax.swing.JComboBox();
        EmployeeTab = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        employeesList = new javax.swing.JList();
        employeeAction = new javax.swing.JLabel();
        employeeBirthDate = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        employeeCancel = new javax.swing.JButton();
        employeeButton = new javax.swing.JButton();
        employeeSuppr = new javax.swing.JButton();
        employeeSpe = new javax.swing.JTextField();
        employeeRole = new javax.swing.JComboBox();
        employeeAddress = new javax.swing.JTextField();
        employeeName = new javax.swing.JTextField();
        employeeFirstName = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        employeePass = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        piecesList = new javax.swing.JList();
        pieceAction = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        pieceIntervention = new javax.swing.JComboBox();
        pieceProvider = new javax.swing.JTextField();
        pieceRef = new javax.swing.JTextField();
        pieceCancel = new javax.swing.JButton();
        pieceSuppr = new javax.swing.JButton();
        pieceButton = new javax.swing.JButton();
        FurnitureTab = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        furnituresList = new javax.swing.JList();
        furnitureAction = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        furnitureRef = new javax.swing.JTextField();
        furnitureBrand = new javax.swing.JTextField();
        furnitureClient = new javax.swing.JComboBox();
        furnitureLastIntervention = new com.toedter.calendar.JDateChooser();
        furnitureButton = new javax.swing.JButton();
        furnitureCancel = new javax.swing.JButton();
        furnitureSuppr = new javax.swing.JButton();
        ClientTab = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientsList = new javax.swing.JList();
        clientAction = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        clientLastName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        clientFirstName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        clientAddress = new javax.swing.JTextField();
        clientButton = new javax.swing.JButton();
        cancelClient = new javax.swing.JButton();
        clientSuppr = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(503, 458));
        setName("UI"); // NOI18N
        setResizable(false);

        PieceTab.setName("PieceTab"); // NOI18N

        Table.setName("PlanningTab"); // NOI18N

        jScrollPane7.setName("jScrollPane7"); // NOI18N

        lundiTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Heure", "Employé", "Client", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        lundiTable.setName("lundiTable"); // NOI18N
        jScrollPane7.setViewportView(lundiTable);

        Table.addTab("Lundi", jScrollPane7);

        jScrollPane8.setName("jScrollPane8"); // NOI18N

        mardiTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Heure", "Employé", "Client", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mardiTable.setName("mardiTable"); // NOI18N
        jScrollPane8.setViewportView(mardiTable);

        Table.addTab("Mardi", jScrollPane8);

        jScrollPane9.setName("jScrollPane9"); // NOI18N

        mercrediTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Heure", "Employé", "Client", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mercrediTable.setName("mercrediTable"); // NOI18N
        jScrollPane9.setViewportView(mercrediTable);

        Table.addTab("Mercredi", jScrollPane9);

        jScrollPane10.setName("jScrollPane10"); // NOI18N

        jeudiTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Heure", "Employé", "Client", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jeudiTable.setName("jeudiTable"); // NOI18N
        jScrollPane10.setViewportView(jeudiTable);

        Table.addTab("Jeudi", jScrollPane10);

        jScrollPane11.setName("jScrollPane11"); // NOI18N

        vendrediTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Heure", "Employé", "Client", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        vendrediTable.setName("vendrediTable"); // NOI18N
        jScrollPane11.setViewportView(vendrediTable);

        Table.addTab("Vendredi", jScrollPane11);

        PieceTab.addTab("Planning", Table);

        InterventionTab.setName("InterventionTab"); // NOI18N

        jLabel13.setText("Liste des Interventions");
        jLabel13.setName("jLabel13"); // NOI18N

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        interventionsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        interventionsList.setName("interventionsList"); // NOI18N
        interventionsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                interventionsListValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(interventionsList);

        interventionAction.setText("Ajout d'une Intervention");
        interventionAction.setName("interventionAction"); // NOI18N

        jLabel18.setText("Nature");
        jLabel18.setName("jLabel18"); // NOI18N

        jLabel19.setText("Date de Début");
        jLabel19.setName("jLabel19"); // NOI18N

        jLabel20.setText("Date de Fin");
        jLabel20.setName("jLabel20"); // NOI18N

        jLabel21.setText("Client");
        jLabel21.setName("jLabel21"); // NOI18N

        jLabel22.setText("Employé");
        jLabel22.setName("jLabel22"); // NOI18N

        jLabel23.setText("Coût");
        jLabel23.setName("jLabel23"); // NOI18N

        jLabel24.setText("Remarques");
        jLabel24.setName("jLabel24"); // NOI18N

        jScrollPane5.setName("jScrollPane5"); // NOI18N

        interventionAnnotations.setColumns(20);
        interventionAnnotations.setLineWrap(true);
        interventionAnnotations.setRows(5);
        interventionAnnotations.setName("interventionAnnotations"); // NOI18N
        jScrollPane5.setViewportView(interventionAnnotations);

        interventionEmployee.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        interventionEmployee.setName("interventionEmployee"); // NOI18N

        interventionClient.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        interventionClient.setName("interventionClient"); // NOI18N

        interventionEnd.setDateFormatString("dd/MM/yyyy");
        interventionEnd.setName("interventionEnd"); // NOI18N

        interventionType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        interventionType.setName("interventionType"); // NOI18N

        interventionCost.setName("interventionCost"); // NOI18N

        interventionCancel.setText("Annuler");
        interventionCancel.setName("interventionCancel"); // NOI18N
        interventionCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interventionCancelActionPerformed(evt);
            }
        });

        interventionButton.setText("Ajouter");
        interventionButton.setName("interventionButton"); // NOI18N
        interventionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interventionButtonActionPerformed(evt);
            }
        });

        interventionSuppr.setText("Supprimer");
        interventionSuppr.setEnabled(false);
        interventionSuppr.setName("interventionSuppr"); // NOI18N
        interventionSuppr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interventionSupprActionPerformed(evt);
            }
        });

        interventionBegin.setDateFormatString("dd/MM/yyyy");
        interventionBegin.setName("interventionBegin"); // NOI18N

        heureDebutIntervention.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "09", "10", "11", "12", "13", "14", "15", "16", "17", "18" }));
        heureDebutIntervention.setName("heureDebutIntervention"); // NOI18N

        jLabel29.setText("Heure début");
        jLabel29.setName("jLabel29"); // NOI18N

        jLabel30.setText("Heure fin");
        jLabel30.setName("jLabel30"); // NOI18N

        heureFinIntervention.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "09", "10", "11", "12", "13", "14", "15", "16", "17", "18" }));
        heureFinIntervention.setName("heureFinIntervention"); // NOI18N

        javax.swing.GroupLayout InterventionTabLayout = new javax.swing.GroupLayout(InterventionTab);
        InterventionTab.setLayout(InterventionTabLayout);
        InterventionTabLayout.setHorizontalGroup(
            InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InterventionTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InterventionTabLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(92, 92, 92)
                        .addComponent(interventionAction))
                    .addGroup(InterventionTabLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InterventionTabLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel23)))
                            .addGroup(InterventionTabLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel24)
                                    .addGroup(InterventionTabLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(interventionCancel))
                                    .addComponent(jLabel30)))
                            .addGroup(InterventionTabLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel20))))
                        .addGap(22, 22, 22)
                        .addGroup(InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InterventionTabLayout.createSequentialGroup()
                                .addComponent(interventionSuppr)
                                .addGap(50, 50, 50)
                                .addComponent(interventionButton))
                            .addGroup(InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                                .addComponent(interventionClient, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(interventionEmployee, javax.swing.GroupLayout.Alignment.LEADING, 0, 200, Short.MAX_VALUE))
                            .addComponent(heureFinIntervention, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(interventionEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(interventionType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(interventionBegin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(interventionCost, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(heureDebutIntervention, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        InterventionTabLayout.setVerticalGroup(
            InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InterventionTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(interventionAction))
                .addGap(18, 18, 18)
                .addGroup(InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InterventionTabLayout.createSequentialGroup()
                        .addGroup(InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(interventionType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(InterventionTabLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18))
                            .addGroup(InterventionTabLayout.createSequentialGroup()
                                .addComponent(interventionCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(interventionBegin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(heureDebutIntervention, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(interventionEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(heureFinIntervention, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(interventionClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(interventionEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGroup(InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InterventionTabLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel24))
                            .addGroup(InterventionTabLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(interventionButton)
                            .addComponent(interventionSuppr)
                            .addComponent(interventionCancel)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        PieceTab.addTab("Interventions", InterventionTab);

        EmployeeTab.setName("EmployeeTab"); // NOI18N

        jLabel2.setText("Liste des Employés");
        jLabel2.setName("jLabel2"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        employeesList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        employeesList.setName("employeesList"); // NOI18N
        employeesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                employeesListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(employeesList);

        employeeAction.setText("Ajout d'un employé");
        employeeAction.setName("employeeAction"); // NOI18N

        employeeBirthDate.setDateFormatString("dd/MM/yyyy");
        employeeBirthDate.setMaxSelectableDate(new java.util.Date(253370764864000L));
        employeeBirthDate.setName("employeeBirthDate"); // NOI18N

        jLabel7.setText("Prénom");
        jLabel7.setName("jLabel7"); // NOI18N

        jLabel8.setText("Nom");
        jLabel8.setName("jLabel8"); // NOI18N

        jLabel9.setText("Addresse");
        jLabel9.setName("jLabel9"); // NOI18N

        jLabel10.setText("Rôle");
        jLabel10.setName("jLabel10"); // NOI18N

        jLabel11.setText("Spécialisation");
        jLabel11.setName("jLabel11"); // NOI18N

        jLabel12.setText("Date de Naissance");
        jLabel12.setName("jLabel12"); // NOI18N

        employeeCancel.setText("Annuler");
        employeeCancel.setName("employeeCancel"); // NOI18N
        employeeCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeCancelActionPerformed(evt);
            }
        });

        employeeButton.setText("Ajouter");
        employeeButton.setName("employeeButton"); // NOI18N
        employeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeButtonActionPerformed(evt);
            }
        });

        employeeSuppr.setText("Supprimer");
        employeeSuppr.setEnabled(false);
        employeeSuppr.setName("employeeSuppr"); // NOI18N
        employeeSuppr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeSupprActionPerformed(evt);
            }
        });

        employeeSpe.setName("employeeSpe"); // NOI18N

        employeeRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        employeeRole.setName("employeeRole"); // NOI18N

        employeeAddress.setName("employeeAddress"); // NOI18N

        employeeName.setName("employeeName"); // NOI18N

        employeeFirstName.setName("employeeFirstName"); // NOI18N

        jLabel31.setText("Mot de passe");
        jLabel31.setName("jLabel31"); // NOI18N

        employeePass.setName("employeePass"); // NOI18N

        javax.swing.GroupLayout EmployeeTabLayout = new javax.swing.GroupLayout(EmployeeTab);
        EmployeeTab.setLayout(EmployeeTabLayout);
        EmployeeTabLayout.setHorizontalGroup(
            EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmployeeTabLayout.createSequentialGroup()
                .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(EmployeeTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(employeeAction)
                            .addGroup(EmployeeTabLayout.createSequentialGroup()
                                .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel31))
                                .addGap(21, 21, 21)
                                .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(employeePass, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(employeeBirthDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                        .addComponent(employeeSpe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                        .addComponent(employeeRole, javax.swing.GroupLayout.Alignment.TRAILING, 0, 221, Short.MAX_VALUE)
                                        .addComponent(employeeAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                        .addComponent(employeeName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                        .addComponent(employeeFirstName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))))))
                    .addGroup(EmployeeTabLayout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(employeeCancel)
                        .addGap(34, 34, 34)
                        .addComponent(employeeSuppr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(employeeButton)))
                .addGap(33, 33, 33))
        );
        EmployeeTabLayout.setVerticalGroup(
            EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmployeeTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(employeeAction))
                .addGap(18, 18, 18)
                .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EmployeeTabLayout.createSequentialGroup()
                        .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(employeeFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(employeeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(employeeAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(employeeRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(employeeSpe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(employeeBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(employeePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeCancel)
                    .addComponent(employeeSuppr)
                    .addComponent(employeeButton))
                .addGap(118, 118, 118))
        );

        PieceTab.addTab("Employés", EmployeeTab);

        jPanel1.setName("jPanel1"); // NOI18N

        jLabel25.setText("Liste des Pièces");
        jLabel25.setName("jLabel25"); // NOI18N

        jScrollPane6.setName("jScrollPane6"); // NOI18N

        piecesList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        piecesList.setName("piecesList"); // NOI18N
        piecesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                piecesListValueChanged(evt);
            }
        });
        jScrollPane6.setViewportView(piecesList);

        pieceAction.setText("Ajout d'une pièce");
        pieceAction.setName("pieceAction"); // NOI18N

        jLabel26.setText("Référence");
        jLabel26.setName("jLabel26"); // NOI18N

        jLabel27.setText("Fournisseur");
        jLabel27.setName("jLabel27"); // NOI18N

        jLabel28.setText("Intervention");
        jLabel28.setName("jLabel28"); // NOI18N

        pieceIntervention.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pieceIntervention.setName("pieceIntervention"); // NOI18N

        pieceProvider.setName("pieceProvider"); // NOI18N

        pieceRef.setName("pieceRef"); // NOI18N

        pieceCancel.setText("Annuler");
        pieceCancel.setName("pieceCancel"); // NOI18N
        pieceCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pieceCancelActionPerformed(evt);
            }
        });

        pieceSuppr.setText("Supprimer");
        pieceSuppr.setEnabled(false);
        pieceSuppr.setName("pieceSuppr"); // NOI18N
        pieceSuppr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pieceSupprActionPerformed(evt);
            }
        });

        pieceButton.setText("Ajouter");
        pieceButton.setName("pieceButton"); // NOI18N
        pieceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pieceButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel27)
                            .addComponent(jLabel26)
                            .addComponent(pieceCancel))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pieceSuppr)
                                .addGap(36, 36, 36)
                                .addComponent(pieceButton))
                            .addComponent(pieceProvider, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(pieceIntervention, 0, 249, Short.MAX_VALUE)
                            .addComponent(pieceRef, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(121, 121, 121)
                        .addComponent(pieceAction)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(pieceAction))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(pieceRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(pieceProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(pieceIntervention, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pieceButton)
                            .addComponent(pieceSuppr)
                            .addComponent(pieceCancel))))
                .addContainerGap(190, Short.MAX_VALUE))
        );

        PieceTab.addTab("Pièces", jPanel1);

        FurnitureTab.setName("FurnitureTab"); // NOI18N

        jLabel6.setText("Liste du Matériel");
        jLabel6.setName("jLabel6"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        furnituresList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        furnituresList.setName("furnituresList"); // NOI18N
        furnituresList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                furnituresListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(furnituresList);

        furnitureAction.setText("Ajout d'un matériel");
        furnitureAction.setName("furnitureAction"); // NOI18N

        jLabel14.setText("Référence");
        jLabel14.setName("jLabel14"); // NOI18N

        jLabel15.setText("Marque");
        jLabel15.setName("jLabel15"); // NOI18N

        jLabel16.setText("Client");
        jLabel16.setName("jLabel16"); // NOI18N

        jLabel17.setText("Dernière Intervention");
        jLabel17.setName("jLabel17"); // NOI18N

        furnitureRef.setName("furnitureRef"); // NOI18N

        furnitureBrand.setName("furnitureBrand"); // NOI18N

        furnitureClient.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        furnitureClient.setName("furnitureClient"); // NOI18N

        furnitureLastIntervention.setDateFormatString("dd/MM/yyyy");
        furnitureLastIntervention.setName("furnitureLastIntervention"); // NOI18N

        furnitureButton.setText("Ajouter");
        furnitureButton.setName("furnitureButton"); // NOI18N
        furnitureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                furnitureButtonActionPerformed(evt);
            }
        });

        furnitureCancel.setText("Annuler");
        furnitureCancel.setName("furnitureCancel"); // NOI18N
        furnitureCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                furnitureCancelActionPerformed(evt);
            }
        });

        furnitureSuppr.setText("Supprimer");
        furnitureSuppr.setEnabled(false);
        furnitureSuppr.setName("furnitureSuppr"); // NOI18N
        furnitureSuppr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                furnitureSupprActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FurnitureTabLayout = new javax.swing.GroupLayout(FurnitureTab);
        FurnitureTab.setLayout(FurnitureTabLayout);
        FurnitureTabLayout.setHorizontalGroup(
            FurnitureTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FurnitureTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FurnitureTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FurnitureTabLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(FurnitureTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FurnitureTabLayout.createSequentialGroup()
                                .addGroup(FurnitureTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))
                                .addGap(28, 28, 28)
                                .addGroup(FurnitureTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(furnitureLastIntervention, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(furnitureClient, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(furnitureBrand)
                                    .addComponent(furnitureRef, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FurnitureTabLayout.createSequentialGroup()
                                .addComponent(furnitureCancel)
                                .addGap(18, 18, 18)
                                .addComponent(furnitureSuppr)
                                .addGap(18, 18, 18)
                                .addComponent(furnitureButton)
                                .addGap(8, 8, 8))))
                    .addGroup(FurnitureTabLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(103, 103, 103)
                        .addComponent(furnitureAction)))
                .addContainerGap())
        );
        FurnitureTabLayout.setVerticalGroup(
            FurnitureTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FurnitureTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FurnitureTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(furnitureAction))
                .addGroup(FurnitureTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FurnitureTabLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(FurnitureTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(furnitureRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(FurnitureTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(furnitureBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(FurnitureTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(furnitureClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(FurnitureTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(furnitureLastIntervention, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(42, 42, 42)
                        .addGroup(FurnitureTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(furnitureCancel)
                            .addComponent(furnitureButton)
                            .addComponent(furnitureSuppr)))
                    .addGroup(FurnitureTabLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(206, Short.MAX_VALUE))
        );

        PieceTab.addTab("Matériel", FurnitureTab);

        ClientTab.setMinimumSize(new java.awt.Dimension(498, 430));
        ClientTab.setName("ClientTab"); // NOI18N

        jLabel1.setText("Clients");
        jLabel1.setName("jLabel1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        clientsList.setName("clientsList"); // NOI18N
        clientsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                clientsListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(clientsList);

        clientAction.setText("Ajout d'un client");
        clientAction.setName("clientAction"); // NOI18N

        jLabel3.setText("Nom");
        jLabel3.setName("jLabel3"); // NOI18N

        clientLastName.setName("clientLastName"); // NOI18N

        jLabel4.setText("Prénom");
        jLabel4.setName("jLabel4"); // NOI18N

        clientFirstName.setName("clientFirstName"); // NOI18N

        jLabel5.setText("Addresse");
        jLabel5.setName("jLabel5"); // NOI18N

        clientAddress.setName("clientAddress"); // NOI18N

        clientButton.setText("Ajouter");
        clientButton.setName("clientButton"); // NOI18N
        clientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientButtonActionPerformed(evt);
            }
        });

        cancelClient.setText("Annuler");
        cancelClient.setName("cancelClient"); // NOI18N
        cancelClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelClientActionPerformed(evt);
            }
        });

        clientSuppr.setText("Supprimer");
        clientSuppr.setEnabled(false);
        clientSuppr.setName("clientSuppr"); // NOI18N
        clientSuppr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientSupprActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ClientTabLayout = new javax.swing.GroupLayout(ClientTab);
        ClientTab.setLayout(ClientTabLayout);
        ClientTabLayout.setHorizontalGroup(
            ClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(ClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ClientTabLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(clientAction))
                    .addGroup(ClientTabLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(ClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ClientTabLayout.createSequentialGroup()
                                .addGroup(ClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(ClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(clientFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                                    .addComponent(clientLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                                    .addComponent(clientAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)))
                            .addGroup(ClientTabLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(cancelClient)
                                .addGap(46, 46, 46)
                                .addComponent(clientSuppr)
                                .addGap(30, 30, 30)
                                .addComponent(clientButton)))
                        .addContainerGap())))
        );
        ClientTabLayout.setVerticalGroup(
            ClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(clientAction))
                .addGap(18, 18, 18)
                .addGroup(ClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ClientTabLayout.createSequentialGroup()
                        .addGroup(ClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(clientLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(ClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(clientFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(ClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(clientAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(ClientTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelClient)
                            .addComponent(clientSuppr)
                            .addComponent(clientButton)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(403, 403, 403))
        );

        PieceTab.addTab("Clients", ClientTab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PieceTab, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PieceTab, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void cancelClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelClientActionPerformed
      this.clearClientSelection();
}//GEN-LAST:event_cancelClientActionPerformed

  private void clientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientButtonActionPerformed
      Client cli = new Client();

      if (this.clientLastName.getText().isEmpty() || this.clientFirstName.getText().isEmpty()) {
          JOptionPane.showMessageDialog(this, "Les champs pour le nom et le prénom du client sont obligatoires", "Erreur", JOptionPane.ERROR_MESSAGE);
          return;
      }

      if (this.clientSuppr.isEnabled()) {
          cli = (Client) this.clientsList.getSelectedValue();
      }

      cli.setFirstName(this.clientFirstName.getText());
      cli.setLastName(this.clientLastName.getText());
      cli.setAddress(this.clientAddress.getText());

      this.centreManager.saveClient(cli);

      List<Client> l = this.centreManager.getAllClients();
      DefaultComboBoxModel model = new DefaultComboBoxModel(l.toArray());

      this.interventionClient.setModel(model);
      this.furnitureClient.setModel(model);
      this.fillList(l, this.clientsList);
      this.clearClientSelection();

      return;
}//GEN-LAST:event_clientButtonActionPerformed

  private void clientsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_clientsListValueChanged
      Client c = (Client) this.clientsList.getSelectedValue();

      if (c != null) {
          this.clientSuppr.setEnabled(true);

          this.clientAddress.setText(c.getAddress());
          this.clientFirstName.setText(c.getFirstName());
          this.clientLastName.setText(c.getLastName());

          this.clientAction.setText("Edition du client n°" + c.getId());
          this.clientButton.setText("Editer");
      }
}//GEN-LAST:event_clientsListValueChanged

  private void employeeSupprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeSupprActionPerformed
      Employee emp = (Employee) this.employeesList.getSelectedValue();

      if (emp != null && JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer l'employé " + emp + " ?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
          List<Intervention> interventions = this.centreManager.getInterventionsByEmployee(emp);
          this.centreManager.removeEmployee(emp);
          this.clearEmployeeSelection();

          ((DefaultListModel) this.employeesList.getModel()).removeElement(emp);

          int taille = this.interventionsList.getModel().getSize();
          for (Intervention i : interventions) {
              for (int j = 0; j < taille; j++) {
                  Intervention intervention = (Intervention) this.interventionsList.getModel().getElementAt(j);
                  if (i.getId().equals(intervention.getId())) {
                      ((DefaultListModel) this.interventionsList.getModel()).removeElement(intervention);
                      taille--;
                  }
              }
              DefaultTableModel model = updatePlanning(i);
              if (model != null) {
                  for (int k = 0; k < model.getRowCount(); k++) {
                      Employee tabEmp = (Employee) model.getValueAt(k, 1);
                      String[] nom = tabEmp.toString().split(" ");
                      if (nom[1].equals(emp.getLastName()) && nom[0].equals(emp.getFirstName())) {
                          model.removeRow(k);
                      }
                  }
              }
          }
      }
  }//GEN-LAST:event_employeeSupprActionPerformed
  private void clientSupprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientSupprActionPerformed
      Client cli = (Client) this.clientsList.getSelectedValue();

      if (cli != null && JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer le client " + cli + " ?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
          List<Intervention> interventions = this.centreManager.getInterventionsByClient(cli);
          this.centreManager.removeClient(cli);
          this.clearClientSelection();

          ((DefaultListModel) this.clientsList.getModel()).removeElement(cli);
          ((DefaultComboBoxModel) this.furnitureClient.getModel()).removeElement(cli);

          int taille = this.interventionsList.getModel().getSize();
          for (Intervention i : interventions) {
              for (int j = 0; j < taille; j++) {
                  Intervention intervention = (Intervention) this.interventionsList.getModel().getElementAt(j);
                  if (i.getId().equals(intervention.getId())) {
                      ((DefaultListModel) this.interventionsList.getModel()).removeElement(intervention);
                      taille--;
                  }
              }
              DefaultTableModel model = updatePlanning(i);
              if (model != null) {
                  for (int k = 0; k < model.getRowCount(); k++) {
                      Client tabCli = (Client) model.getValueAt(k, 2);
                      String[] nom = tabCli.toString().split(" ");
                      if (nom[1].equals(cli.getLastName()) && nom[0].equals(cli.getFirstName())) {
                          model.removeRow(k);
                      }
                  }
              }
          }
      }
  }//GEN-LAST:event_clientSupprActionPerformed

  private void employeesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_employeesListValueChanged
      Employee emp = (Employee) this.employeesList.getSelectedValue();

      if (emp != null) {
          this.employeeAddress.setText(emp.getAddress());
          this.employeeBirthDate.setDate(emp.getBirthDate());
          this.employeeFirstName.setText(emp.getFirstName());
          this.employeeName.setText(emp.getLastName());
          this.employeeRole.setSelectedIndex(emp.getRole());
          this.employeeSpe.setText(emp.getSpecialization());

          this.employeeAction.setText("Edition de l'employé n°" + emp.getId());
          this.employeeButton.setText("Editer");
          this.employeeSuppr.setEnabled(true);
      }
  }//GEN-LAST:event_employeesListValueChanged

  private void employeeCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeCancelActionPerformed
      this.clearEmployeeSelection();
  }//GEN-LAST:event_employeeCancelActionPerformed

  private void employeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeButtonActionPerformed
      Employee emp = new Employee();

      if (this.employeePass.getText().isEmpty() || this.employeeName.getText().isEmpty() || this.employeeFirstName.getText().isEmpty() || this.employeeRole.getSelectedIndex() == -1) {
          JOptionPane.showMessageDialog(this, "Les champs pour le mot de passe, le nom, le prénom et le rôle de l'employé sont obligatoires", "Erreur", JOptionPane.ERROR_MESSAGE);
          return;
      }

      if (this.employeeSuppr.isEnabled()) {
          emp = (Employee) this.employeesList.getSelectedValue();
      }

      emp.setFirstName(this.employeeFirstName.getText());
      emp.setLastName(this.employeeName.getText());
      emp.setRole(this.employeeRole.getSelectedIndex());
      emp.setAddress(this.employeeAddress.getText());
      emp.setBirthDate(this.employeeBirthDate.getDate());
      emp.setSpecialization(this.employeeSpe.getText());
      emp.setPassword(this.employeePass.getText());

      this.centreManager.saveEmployee(emp);

      List<Employee> l = this.centreManager.getAllEmployees();

      this.interventionEmployee.setModel(new DefaultComboBoxModel(l.toArray()));
      this.fillList(l, this.employeesList);
      this.clearEmployeeSelection();

      return;
  }//GEN-LAST:event_employeeButtonActionPerformed

  private void furnituresListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_furnituresListValueChanged
      Furniture f = (Furniture) this.furnituresList.getSelectedValue();

      if (f != null) {
          this.furnitureSuppr.setEnabled(true);

          this.furnitureBrand.setText(f.getBrand());
          ((DefaultComboBoxModel) this.furnitureClient.getModel()).setSelectedItem(f.getClient());
          this.furnitureRef.setText(f.getRef());
          this.furnitureLastIntervention.setDate(f.getLastIntervention());

          this.furnitureAction.setText("Edition du matériel n°" + f.getId());
          this.furnitureButton.setText("Editer");
      }
  }//GEN-LAST:event_furnituresListValueChanged

  private void furnitureCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_furnitureCancelActionPerformed
      this.clearFurnitureSelection();
  }//GEN-LAST:event_furnitureCancelActionPerformed

  private void furnitureSupprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_furnitureSupprActionPerformed
      Furniture fur = (Furniture) this.furnituresList.getSelectedValue();

      if (fur != null && JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer le matériel " + fur + " ?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
          this.centreManager.removeFurniture(fur);
          this.clearFurnitureSelection();

          ((DefaultListModel) this.furnituresList.getModel()).removeElement(fur);
      }
  }//GEN-LAST:event_furnitureSupprActionPerformed

  private void furnitureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_furnitureButtonActionPerformed
      Furniture fur = null;

      if (this.furnitureRef.getText().isEmpty() || this.furnitureBrand.getText().isEmpty() || this.furnitureClient.getSelectedIndex() == -1) {
          JOptionPane.showMessageDialog(this, "Les champs pour la marque, la référence et le client pour ce matériel sont obligatoires", "Erreur", JOptionPane.ERROR_MESSAGE);
          return;
      }

      fur = this.furnitureSuppr.isEnabled() ? (Furniture) this.furnituresList.getSelectedValue() : new Furniture();

      fur.setBrand(this.furnitureBrand.getText());
      fur.setRef(this.furnitureRef.getText());
      fur.setClient((Client) this.furnitureClient.getSelectedItem());
      fur.setLastIntervention(this.furnitureLastIntervention.getDate());

      this.centreManager.saveFurniture(fur);
      this.clearFurnitureSelection();
      this.fillList(this.centreManager.getAllFurnitures(), this.furnituresList);
  }//GEN-LAST:event_furnitureButtonActionPerformed

  private void interventionCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interventionCancelActionPerformed
      this.clearInterventionSelection();
  }//GEN-LAST:event_interventionCancelActionPerformed

  private void interventionSupprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interventionSupprActionPerformed
      Intervention intervention = (Intervention) this.interventionsList.getSelectedValue();

      if (intervention != null && JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer " + intervention + " ?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
          this.centreManager.removeIntervention(intervention);
          this.clearInterventionSelection();

          ((DefaultListModel) this.interventionsList.getModel()).removeElement(intervention);
          DefaultTableModel model = updatePlanning(intervention);
          if (model != null) {
              for (int k = 0; k < model.getRowCount(); k++) {
                  Client client = (Client) model.getValueAt(k, 2);
                  Employee employe = (Employee) model.getValueAt(k, 1);
                  if (client.toString().equals(intervention.getClient().toString()) && employe.toString().equals(intervention.getEmployee().toString())) {
                      model.removeRow(k);
                  }
              }
          }
      }
  }//GEN-LAST:event_interventionSupprActionPerformed

  private void interventionsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_interventionsListValueChanged
      Intervention i = (Intervention) this.interventionsList.getSelectedValue();

      if (i != null) {
          try {
              this.interventionSuppr.setEnabled(true);

              this.interventionAnnotations.setText(i.getAnnotations());
              SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
              this.interventionBegin.setDate(dateFormat.parse(i.getBegin()));
              this.heureDebutIntervention.setSelectedItem(i.getBegin().substring(11, 13));
              if (i.getEnd() != null) {
                  this.interventionEnd.setDate(dateFormat.parse(i.getEnd()));
                  this.heureFinIntervention.setSelectedItem(i.getEnd().substring(11, 13));
              }
              this.interventionCost.setText(i.getCost().toString());

              ((DefaultComboBoxModel) this.interventionClient.getModel()).setSelectedItem(i.getClient());
              ((DefaultComboBoxModel) this.interventionEmployee.getModel()).setSelectedItem(i.getEmployee());
              this.interventionClient.setSelectedItem(i.getClient());
              this.interventionEmployee.setSelectedItem(i.getEmployee());
              this.interventionType.setSelectedIndex(i.getNature());

              this.interventionAction.setText("Edition de l'intervention n°" + i.getId());
              this.interventionButton.setText("Editer");


          } catch (ParseException ex) {
              Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
  }//GEN-LAST:event_interventionsListValueChanged

  private void interventionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interventionButtonActionPerformed
      Intervention intervention = null;

      if (this.interventionBegin.getDate() == null || this.interventionType.getSelectedItem() == null || this.interventionClient.getSelectedItem() == null) {
          JOptionPane.showMessageDialog(this, "Les champs pour la date / heure de début, le type, et le client pour une intervention sont obligatoires", "Erreur", JOptionPane.ERROR_MESSAGE);
          return;
      }

      if (!this.interventionCost.getText().isEmpty() && !this.isInt(this.interventionCost.getText())) {
          JOptionPane.showMessageDialog(this, "Entrez un coût valide pour une intervention donnée", "Erreur", JOptionPane.ERROR_MESSAGE);
          return;
      }

      intervention = this.interventionSuppr.isEnabled() ? (Intervention) this.interventionsList.getSelectedValue() : new Intervention();

      intervention.setAnnotations(this.interventionAnnotations.getText());
      intervention.setCost(this.interventionCost.getText().isEmpty() ? 0 : Integer.parseInt(this.interventionCost.getText()));

      Calendar calendar = this.interventionBegin.getCalendar();
      calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt((String) this.heureDebutIntervention.getSelectedItem()));
      calendar.set(Calendar.MINUTE, 0);
      calendar.set(Calendar.SECOND, 0);
      Date d = calendar.getTime();
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String t = dateFormat.format(d);

      intervention.setBegin(t);

      calendar = this.interventionEnd.getCalendar();
      if (calendar != null) {
          calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt((String) this.heureFinIntervention.getSelectedItem()));
          calendar.set(Calendar.MINUTE, 0);
          calendar.set(Calendar.SECOND, 0);
          d = calendar.getTime();
          t = dateFormat.format(d);
          intervention.setEnd(t);
      }
      intervention.setEmployee((Employee) this.interventionEmployee.getSelectedItem());
      intervention.setClient((Client) this.interventionClient.getSelectedItem());
      intervention.setNature(this.interventionType.getSelectedIndex());

      this.centreManager.saveIntervention(intervention);

      List<Intervention> lI = this.centreManager.getAllInterventions();

      this.pieceIntervention.setModel(new DefaultComboBoxModel(lI.toArray()));
      this.fillList(lI, this.interventionsList);
      this.clearInterventionSelection();

      DefaultTableModel model = updatePlanning(intervention);
      if (model != null) {
          model.addRow(new Object[]{intervention.getBegin().substring(11, 13), intervention.getEmployee(), intervention.getClient(), intervention.getNature()});
      }
  }//GEN-LAST:event_interventionButtonActionPerformed

    private DefaultTableModel updatePlanning(Intervention intervention) {

        Calendar interCal = Calendar.getInstance();
        DefaultTableModel model = null;
        boolean ok = this.centreManager.isInterventionInCurrentWeek(intervention, interCal);

        if (ok) {
            switch (interCal.get(Calendar.DAY_OF_WEEK)) {

                case Calendar.MONDAY:
                    model = (DefaultTableModel) this.lundiTable.getModel();
                    break;

                case Calendar.TUESDAY:
                    model = (DefaultTableModel) this.mardiTable.getModel();
                    break;

                case Calendar.WEDNESDAY:
                    model = (DefaultTableModel) this.mercrediTable.getModel();
                    break;

                case Calendar.THURSDAY:
                    model = (DefaultTableModel) this.jeudiTable.getModel();
                    break;

                case Calendar.FRIDAY:
                    model = (DefaultTableModel) this.vendrediTable.getModel();
                    break;
            }
        }
        return model;
    }

  private void pieceCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pieceCancelActionPerformed
      this.clearPieceSelection();
  }//GEN-LAST:event_pieceCancelActionPerformed

  private void pieceSupprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pieceSupprActionPerformed
      Piece piece = (Piece) this.piecesList.getSelectedValue();

      if (piece != null && JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer la pièce " + piece + " ?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
          this.centreManager.removePiece(piece);
          this.clearPieceSelection();

          ((DefaultListModel) this.piecesList.getModel()).removeElement(piece);
      }
  }//GEN-LAST:event_pieceSupprActionPerformed

  private void piecesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_piecesListValueChanged
      Piece p = (Piece) this.piecesList.getSelectedValue();

      if (p != null) {
          this.pieceProvider.setText(p.getProvider());
          this.pieceRef.setText(p.getReference());
          ((DefaultComboBoxModel) this.pieceIntervention.getModel()).setSelectedItem(p.getIntervention());

          this.pieceAction.setText("Editer la pièce n°" + p.getId());
          this.pieceButton.setText("Editer");
          this.pieceSuppr.setEnabled(true);
      }
  }//GEN-LAST:event_piecesListValueChanged

  private void pieceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pieceButtonActionPerformed
      Piece p = new Piece();

      // -- Tous les champs sont obligatoires
      if (this.pieceRef.getText().isEmpty() || this.pieceProvider.getText().isEmpty() || this.pieceIntervention.getSelectedItem() == null) {
          JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires...", "Erreur", JOptionPane.ERROR_MESSAGE);
          return;
      }

      if (this.pieceSuppr.isEnabled()) {
          p = (Piece) this.piecesList.getSelectedValue();
      }

      p.setIntervention((Intervention) this.pieceIntervention.getSelectedItem());
      p.setProvider(this.pieceProvider.getText());
      p.setReference(this.pieceRef.getText());

      this.centreManager.savePiece(p);
      this.fillList(this.centreManager.getAllPieces(), this.piecesList);
      this.clearPieceSelection();
  }//GEN-LAST:event_pieceButtonActionPerformed

    private void clearClientSelection() {
        this.clientAddress.setText("");
        this.clientLastName.setText("");
        this.clientFirstName.setText("");

        this.clientAction.setText("Ajout d'un client");
        this.clientButton.setText("Ajouter");
        this.clientSuppr.setEnabled(false);

        this.clientsList.clearSelection();
    }

    private void clearEmployeeSelection() {
        this.employeeAddress.setText("");
        this.employeeName.setText("");
        this.employeeFirstName.setText("");
        this.employeeSpe.setText("");
        this.employeePass.setText("");
        this.employeeBirthDate.setDate(null);

        this.employeeAction.setText("Ajout d'un employé");
        this.employeeButton.setText("Ajouter");
        this.employeeSuppr.setEnabled(false);

        this.employeeRole.setSelectedIndex(-1);
        this.employeesList.clearSelection();
    }

    private void clearFurnitureSelection() {
        this.furnitureBrand.setText("");
        this.furnitureRef.setText("");
        this.furnitureLastIntervention.setDate(null);

        this.furnitureAction.setText("Ajout d'un matériel");
        this.furnitureButton.setText("Ajouter");

        this.furnitureSuppr.setEnabled(false);

        this.furnitureClient.setSelectedIndex(-1);
        this.furnituresList.clearSelection();
    }

    private void clearInterventionSelection() {
        this.interventionAnnotations.setText("");
        this.interventionCost.setText("");

        this.interventionBegin.setDate(null);
        this.interventionEnd.setDate(null);

        this.interventionType.setSelectedIndex(-1);
        this.interventionEmployee.setSelectedIndex(-1);
        this.interventionClient.setSelectedIndex(-1);

        this.interventionAction.setText("Ajout d'une intervention");
        this.interventionButton.setText("Ajouter");
        this.interventionSuppr.setEnabled(false);

        this.interventionsList.clearSelection();
    }

    private void clearPieceSelection() {
        this.pieceIntervention.setSelectedIndex(-1);
        this.pieceProvider.setText("");
        this.pieceRef.setText("");

        this.pieceAction.setText("Ajout d'une pièce");
        this.pieceButton.setText("Ajouter");
        this.pieceSuppr.setEnabled(false);

        this.piecesList.clearSelection();
    }

    private void fillList(List list, JList jlist) {
        DefaultListModel model = (DefaultListModel) jlist.getModel();
        model.clear();

        for (Object o : list) {
            model.addElement(o);
        }
    }

    private Boolean isInt(String val) {
        try {
            Integer.parseInt(val);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * @param args the command line arguments
     */
    // main déplacé dans Auth.java
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable()      {

            public void run() {
                new Home(0).setVisible(true);
            }
        });
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ClientTab;
    private javax.swing.JPanel EmployeeTab;
    private javax.swing.JPanel FurnitureTab;
    private javax.swing.JPanel InterventionTab;
    private javax.swing.JTabbedPane PieceTab;
    private javax.swing.JTabbedPane Table;
    private javax.swing.JButton cancelClient;
    private javax.swing.JLabel clientAction;
    private javax.swing.JTextField clientAddress;
    private javax.swing.JButton clientButton;
    private javax.swing.JTextField clientFirstName;
    private javax.swing.JTextField clientLastName;
    private javax.swing.JButton clientSuppr;
    private javax.swing.JList clientsList;
    private javax.swing.JLabel employeeAction;
    private javax.swing.JTextField employeeAddress;
    private com.toedter.calendar.JDateChooser employeeBirthDate;
    private javax.swing.JButton employeeButton;
    private javax.swing.JButton employeeCancel;
    private javax.swing.JTextField employeeFirstName;
    private javax.swing.JTextField employeeName;
    private javax.swing.JTextField employeePass;
    private javax.swing.JComboBox employeeRole;
    private javax.swing.JTextField employeeSpe;
    private javax.swing.JButton employeeSuppr;
    private javax.swing.JList employeesList;
    private javax.swing.JLabel furnitureAction;
    private javax.swing.JTextField furnitureBrand;
    private javax.swing.JButton furnitureButton;
    private javax.swing.JButton furnitureCancel;
    private javax.swing.JComboBox furnitureClient;
    private com.toedter.calendar.JDateChooser furnitureLastIntervention;
    private javax.swing.JTextField furnitureRef;
    private javax.swing.JButton furnitureSuppr;
    private javax.swing.JList furnituresList;
    private javax.swing.JComboBox heureDebutIntervention;
    private javax.swing.JComboBox heureFinIntervention;
    private javax.swing.JLabel interventionAction;
    private javax.swing.JTextArea interventionAnnotations;
    private com.toedter.calendar.JDateChooser interventionBegin;
    private javax.swing.JButton interventionButton;
    private javax.swing.JButton interventionCancel;
    private javax.swing.JComboBox interventionClient;
    private javax.swing.JTextField interventionCost;
    private javax.swing.JComboBox interventionEmployee;
    private com.toedter.calendar.JDateChooser interventionEnd;
    private javax.swing.JButton interventionSuppr;
    private javax.swing.JComboBox interventionType;
    private javax.swing.JList interventionsList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jeudiTable;
    private javax.swing.JTable lundiTable;
    private javax.swing.JTable mardiTable;
    private javax.swing.JTable mercrediTable;
    private javax.swing.JLabel pieceAction;
    private javax.swing.JButton pieceButton;
    private javax.swing.JButton pieceCancel;
    private javax.swing.JComboBox pieceIntervention;
    private javax.swing.JTextField pieceProvider;
    private javax.swing.JTextField pieceRef;
    private javax.swing.JButton pieceSuppr;
    private javax.swing.JList piecesList;
    private javax.swing.JTable vendrediTable;
    // End of variables declaration//GEN-END:variables
}
