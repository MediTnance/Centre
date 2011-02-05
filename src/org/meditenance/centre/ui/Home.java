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

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.meditenance.centre.DAO.ClientDAO;
import org.meditenance.centre.DAO.EmployeeDAO;
import org.meditenance.centre.DAO.model.DAO;
import org.meditenance.centre.DAO.model.FurnitureDAO;
import org.meditenance.centre.DAO.model.InterventionDAO;
import org.meditenance.centre.DAO.model.PieceDAO;
import org.meditenance.centre.domain.Client;
import org.meditenance.centre.domain.Employee;

/**
 *
 * @author Talus
 */
public class Home extends javax.swing.JFrame {
  // -- DAOs
  private DAO clientDAO = new ClientDAO();
  private DAO employeeDAO = new EmployeeDAO();
  private InterventionDAO interventionDAO = new org.meditenance.centre.DAO.InterventionDAO();
  private FurnitureDAO furnitureDAO = new org.meditenance.centre.DAO.FurnitureDAO();
  private PieceDAO pieceDAO = new org.meditenance.centre.DAO.PieceDAO();

  /** Creates new form Home */
  public Home() {
    this.initComponents();

    this.clientsList.setModel(new DefaultListModel());
    this.fillClientList(this.clientDAO.getAll());
    
    this.employeesList.setModel(new DefaultListModel());
    this.employeeRole.setModel(new DefaultComboBoxModel(Role.values()));
    this.employeeRole.setSelectedIndex(-1);
    
    this.fillEmployeeList(this.employeeDAO.getAll());
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    TabbedPane = new javax.swing.JTabbedPane();
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
    FurnitureTab = new javax.swing.JPanel();
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
    InterventionTab = new javax.swing.JPanel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setMinimumSize(new java.awt.Dimension(503, 458));
    setName("UI"); // NOI18N
    setResizable(false);

    TabbedPane.setName("TabbedPane"); // NOI18N

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
                    .addComponent(clientFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(clientLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(clientAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
                .addGroup(ClientTabLayout.createSequentialGroup()
                  .addComponent(cancelClient)
                  .addGap(31, 31, 31)
                  .addComponent(clientSuppr)))
              .addContainerGap()))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ClientTabLayout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(clientButton)
            .addGap(21, 21, 21))))
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
              .addComponent(clientButton)
              .addComponent(cancelClient)
              .addComponent(clientSuppr)))
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(174, 174, 174))
    );

    TabbedPane.addTab("Clients", ClientTab);

    FurnitureTab.setName("FurnitureTab"); // NOI18N

    javax.swing.GroupLayout FurnitureTabLayout = new javax.swing.GroupLayout(FurnitureTab);
    FurnitureTab.setLayout(FurnitureTabLayout);
    FurnitureTabLayout.setHorizontalGroup(
      FurnitureTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 498, Short.MAX_VALUE)
    );
    FurnitureTabLayout.setVerticalGroup(
      FurnitureTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 430, Short.MAX_VALUE)
    );

    TabbedPane.addTab("Matériel", FurnitureTab);

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

    javax.swing.GroupLayout EmployeeTabLayout = new javax.swing.GroupLayout(EmployeeTab);
    EmployeeTab.setLayout(EmployeeTabLayout);
    EmployeeTabLayout.setHorizontalGroup(
      EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(EmployeeTabLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(EmployeeTabLayout.createSequentialGroup()
            .addComponent(jLabel2)
            .addGap(101, 101, 101)
            .addComponent(employeeAction))
          .addGroup(EmployeeTabLayout.createSequentialGroup()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(40, 40, 40)
            .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(EmployeeTabLayout.createSequentialGroup()
                .addComponent(employeeCancel)
                .addGap(18, 18, 18)
                .addComponent(employeeSuppr)
                .addGap(18, 18, 18)
                .addComponent(employeeButton))
              .addGroup(EmployeeTabLayout.createSequentialGroup()
                .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel12)
                  .addComponent(jLabel11)
                  .addComponent(jLabel10)
                  .addComponent(jLabel9)
                  .addComponent(jLabel8)
                  .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(employeeFirstName)
                  .addComponent(employeeName)
                  .addComponent(employeeAddress)
                  .addComponent(employeeRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(employeeSpe)
                  .addComponent(employeeBirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))))
        .addContainerGap(25, Short.MAX_VALUE))
    );
    EmployeeTabLayout.setVerticalGroup(
      EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(EmployeeTabLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(employeeAction))
        .addGap(18, 18, 18)
        .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(EmployeeTabLayout.createSequentialGroup()
            .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel7)
              .addComponent(employeeFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel8)
              .addComponent(employeeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel9)
              .addComponent(employeeAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel10)
              .addComponent(employeeRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel11)
              .addComponent(employeeSpe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(employeeBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel12))
            .addGap(33, 33, 33)
            .addGroup(EmployeeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(employeeCancel)
              .addComponent(employeeSuppr)
              .addComponent(employeeButton)))
          .addComponent(jScrollPane2))
        .addContainerGap(121, Short.MAX_VALUE))
    );

    TabbedPane.addTab("Employés", EmployeeTab);

    InterventionTab.setName("InterventionTab"); // NOI18N

    javax.swing.GroupLayout InterventionTabLayout = new javax.swing.GroupLayout(InterventionTab);
    InterventionTab.setLayout(InterventionTabLayout);
    InterventionTabLayout.setHorizontalGroup(
      InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 498, Short.MAX_VALUE)
    );
    InterventionTabLayout.setVerticalGroup(
      InterventionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 430, Short.MAX_VALUE)
    );

    TabbedPane.addTab("Interventions", InterventionTab);

    TabbedPane.setSelectedComponent(ClientTab);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(TabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(TabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void cancelClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelClientActionPerformed
    this.clearClientSelection();
}//GEN-LAST:event_cancelClientActionPerformed

  private void clientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientButtonActionPerformed
    Client cli = null;

    if (this.clientLastName.getText().isEmpty() || this.clientFirstName.getText().isEmpty()) {
      JOptionPane.showMessageDialog(this, "Les champs pour le nom et le prénom du client sont obligatoires", "Erreur", JOptionPane.ERROR_MESSAGE);
      return;
    }

    cli = this.clientSuppr.isEnabled() ? (Client) this.clientsList.getSelectedValue() : new Client();

    cli.setFirstName(this.clientFirstName.getText());
    cli.setLastName(this.clientLastName.getText());
    cli.setAddress(this.clientAddress.getText());

    this.clientDAO.save(cli);
    this.clearClientSelection();
    this.fillClientList(this.clientDAO.getAll());

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
      this.employeeDAO.remove(emp);
      this.clearEmployeeSelection();
      this.fillEmployeeList(this.employeeDAO.getAll());
    }
  }//GEN-LAST:event_employeeSupprActionPerformed

  private void clientSupprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientSupprActionPerformed
    Client cli = (Client) this.clientsList.getSelectedValue();

    if (cli != null && JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer le client " + cli + " ?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
      this.clientDAO.remove(cli);
      this.clearClientSelection();
      this.fillClientList(this.clientDAO.getAll());
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
    Employee emp = null;

    if (this.employeeName.getText().isEmpty() || this.employeeFirstName.getText().isEmpty() || this.employeeRole.getSelectedIndex() == -1) {
      JOptionPane.showMessageDialog(this, "Les champs pour le nom, le prénom et le rôle de l'employé sont obligatoires", "Erreur", JOptionPane.ERROR_MESSAGE);
      return;
    }

    emp = this.employeeSuppr.isEnabled() ? (Employee) this.employeesList.getSelectedValue() : new Employee();

    emp.setFirstName(this.employeeFirstName.getText());
    emp.setLastName(this.employeeName.getText());
    emp.setRole(this.employeeRole.getSelectedIndex());
    emp.setAddress(this.employeeAddress.getText());
    emp.setBirthDate(this.employeeBirthDate.getDate());
    emp.setSpecialization(this.employeeSpe.getText());

    this.employeeDAO.save(emp);
    this.clearEmployeeSelection();
    this.fillEmployeeList(this.employeeDAO.getAll());

    return;
  }//GEN-LAST:event_employeeButtonActionPerformed

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
    this.employeeBirthDate.setDate(null);

    this.employeeAction.setText("Ajout d'un employé");
    this.employeeButton.setText("Ajouter");
    this.employeeSuppr.setEnabled(false);

    this.employeeRole.setSelectedIndex(-1);
    this.employeesList.clearSelection();
  }

  private void fillClientList(List<Client> list) {
    DefaultListModel model = (DefaultListModel) this.clientsList.getModel();
    model.clear();

    for (Client cli : list) {
      model.addElement(cli);
    }
  }

  private void fillEmployeeList(List<Employee> list) {
    DefaultListModel model = (DefaultListModel) this.employeesList.getModel();
    model.clear();

    for (Employee emp : list) {
      model.addElement(emp);
    }
  }

  /**
  * @param args the command line arguments
  */
  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Home().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel ClientTab;
  private javax.swing.JPanel EmployeeTab;
  private javax.swing.JPanel FurnitureTab;
  private javax.swing.JPanel InterventionTab;
  private javax.swing.JTabbedPane TabbedPane;
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
  private javax.swing.JComboBox employeeRole;
  private javax.swing.JTextField employeeSpe;
  private javax.swing.JButton employeeSuppr;
  private javax.swing.JList employeesList;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  // End of variables declaration//GEN-END:variables

}
