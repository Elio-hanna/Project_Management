/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import DTO.Project;
import DTO.Task;
import DTO.User;
import Repositories.RepoProject;
import Repositories.RepoTask;
import Repositories.RepoUser;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class TaskEdit extends javax.swing.JFrame {
    
    RepoTask repotask;
    RepoProject repopoject;
    RepoUser repouser;
    Task task;
    Project project;
    User user;
    int createdby;

    public TaskEdit(Task t) {
        
        
                        //window position
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width)/2;
        int y = (dim.height)/2;
        
        this.setLocation(x-400, y-483);
        
        
        initComponents();
        this.setTitle("Edit Task");
        repotask = new RepoTask();
        repouser = new RepoUser();
        repopoject = new RepoProject();
        task = new Task();
        project = new Project();
        user = new User();
        task = repotask.Get2(t);
        this.createdby = task.getIdUser();
        projectcombo();
        
        this.jdescription.setText(task.getDescription());
        this.jname.setText(task.getName());
        this.jdatein.setText(task.getstartdate());
        this.jdateout.setText(task.getenddate());
        this.jpriority.setSelectedItem(task.getPriority());
        this.jstatus.setSelectedItem(task.getstatus());
        project = repopoject.Getname(task.getIdProject());
        this.jproject.setSelectedItem(project.getname());
        assignedto();
        if(task.getidassignedto() == 0){
            
        }else{
        user = repouser.Get(task.getidassignedto());        
        this.jassigned.setSelectedItem(user.getEmail());
        }
        
    }
        public void projectcombo(){

       JComboBox prj = new JComboBox();
        for (Project project : repopoject.GetAll(this.createdby)) {
            prj.addItem(project.getname());
        }
       this.jproject.setModel(prj.getModel());  
    }
        
        public void assignedto (){
                    Project project2;
        project2 = new Project();
        
        project2.setname(String.valueOf(this.jproject.getSelectedItem()));
        project2.setcreatedby(this.createdby);        
        Project p = new Project();
        p = repopoject.Get(project2);

        JComboBox assign = new JComboBox();
        for (User user : repouser.GetAllnames(p.getId())) {
            assign.addItem(user.getEmail());
        }
       this.jassigned.setModel(assign.getModel());
        }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jdescription = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jdatein = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jdateout = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jpriority = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jstatus = new javax.swing.JComboBox<>();
        jsave = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jassigned = new javax.swing.JComboBox<>();
        jproject = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Description");

        jdescription.setColumns(20);
        jdescription.setRows(5);
        jScrollPane1.setViewportView(jdescription);

        jLabel3.setText("Start Date");

        jdatein.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/mm/yyyy"))));

        jLabel4.setText("Due Date");

        jdateout.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/mm/yyyy"))));

        jLabel1.setText("Name");

        jpriority.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "high", "medium", "low" }));

        jLabel5.setText("Priority");

        jLabel6.setText("Status");

        jstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "open", "closed" }));

        jsave.setText("Save");
        jsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsaveActionPerformed(evt);
            }
        });

        jLabel7.setText("Assigned to");

        jassigned.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jproject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jproject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jprojectProjectUpdate(evt);
            }
        });

        jLabel8.setText("Project");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jname)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(154, 154, 154)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(170, 170, 170)
                                        .addComponent(jLabel1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jdatein, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jdateout, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(31, 31, 31)
                                            .addComponent(jpriority, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel6)
                                            .addGap(18, 18, 18)
                                            .addComponent(jstatus, 0, 108, Short.MAX_VALUE))))
                                .addGap(0, 19, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(jsave))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jproject, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jassigned, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jdatein, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jdateout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpriority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jproject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jassigned, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jsave)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jprojectProjectUpdate(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jprojectProjectUpdate

 
    }//GEN-LAST:event_jprojectProjectUpdate

    private void jsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsaveActionPerformed
       
        Task taskedit = new Task();
        User u = new User();
        Project p = new Project();
        boolean update;
        
        taskedit.setId(this.task.getId());
        taskedit.setName(this.jname.getText());
        taskedit.setDescription(this.jdescription.getText());
        taskedit.setstartdate(this.jdatein.getText());
        taskedit.setenddate(this.jdateout.getText());
        taskedit.setPriority(String.valueOf(this.jpriority.getSelectedItem()).toLowerCase());
        taskedit.setstatus(String.valueOf(this.jstatus.getSelectedItem()).toLowerCase());
        
        //Getid user and project
        u = repouser.Getid(String.valueOf(this.jassigned.getSelectedItem()));
        p = repopoject.Getid(String.valueOf(this.jproject.getSelectedItem()));
        
        taskedit.setIdProject(p.getId());
        taskedit.setidassignedto(u.getId());
        
        update = repotask.Edit(taskedit);
        
        if(update){
            JOptionPane.showMessageDialog(null, "Done");
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Error");
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jsaveActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TaskEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaskEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaskEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaskEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new TaskEdit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jassigned;
    private javax.swing.JFormattedTextField jdatein;
    private javax.swing.JFormattedTextField jdateout;
    private javax.swing.JTextArea jdescription;
    private javax.swing.JTextField jname;
    private javax.swing.JComboBox<String> jpriority;
    private javax.swing.JComboBox<String> jproject;
    private javax.swing.JButton jsave;
    private javax.swing.JComboBox<String> jstatus;
    // End of variables declaration//GEN-END:variables
}
