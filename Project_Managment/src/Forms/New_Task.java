package Forms;

import DTO.Project;
import DTO.Task;
import DTO.User;
import Repositories.RepoProject;
import Repositories.RepoTask;
import Repositories.RepoUser;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Set;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class New_Task extends javax.swing.JFrame {

RepoTask repotask;
RepoProject repopoject;
RepoUser repouser;
Task task;
Project project;
User user;
private int Createdby;

    public New_Task(int Createdby) {
        
                        //window position
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width)/2;
        int y = (dim.height)/2;
        
        this.setLocation(x-416, y-456);
        
        
        initComponents();
        this.setTitle("Create Task");
        this.Createdby = Createdby;
        task = new Task();
        task.setIdUser(this.Createdby);
        repopoject = new RepoProject();
        project = new Project();
        user = new User();
        repotask = new RepoTask();
        repouser = new RepoUser();
        start();
    }

    public void start(){

       JComboBox prj = new JComboBox();
        for (Project project : repopoject.GetAllOpen(Createdby)) {
            prj.addItem(project.getname());
        }
       this.jproject.setModel(prj.getModel());
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jdescription = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jdateout = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jpriority = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jstatus = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jassigned = new javax.swing.JComboBox<>();
        jproject = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jcancel = new javax.swing.JButton();
        jdatein = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name");

        jLabel2.setText("Description");

        jdescription.setColumns(20);
        jdescription.setRows(5);
        jScrollPane1.setViewportView(jdescription);

        jLabel3.setText("Start Date");

        jLabel4.setText("Due Date");

        jdateout.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/mm/yyyy"))));

        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jpriority.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "High", "Medium", "Low" }));

        jLabel5.setText("Priority");

        jLabel6.setText("Status");

        jstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Open", "Closed" }));

        jLabel7.setText("Assigned to");

        jproject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jproject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProjectUpdate(evt);
            }
        });

        jLabel8.setText("Project");

        jcancel.setText("Cancel");
        jcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcancelActionPerformed(evt);
            }
        });

        jdatein.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/mm/yyyy"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jpriority, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(jstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(91, 91, 91)
                                        .addComponent(jButton1)
                                        .addGap(31, 31, 31)
                                        .addComponent(jcancel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jproject, 0, 230, Short.MAX_VALUE)
                                            .addComponent(jassigned, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdatein, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jdateout, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
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
                    .addComponent(jLabel4)
                    .addComponent(jdateout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdatein, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpriority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jproject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jassigned, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jcancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(this.jname.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Name is Empty");
        }else{
         boolean check ;
         Task test = new Task();
         test.setName(this.jname.getText());
         check = repotask.checkname(test);
         
         if(check){
             JOptionPane.showMessageDialog(null, "Task Name exist");
         }else{
            
            
        this.task.setName(this.jname.getText());
        this.task.setPriority(String.valueOf(this.jpriority.getSelectedItem()).toLowerCase());
        this.task.setstatus(String.valueOf(this.jstatus.getSelectedItem()).toLowerCase());
        this.task.setDescription(this.jdescription.getText());
        this.task.setenddate(this.jdateout.getText());
        this.task.setstartdate(this.jdatein.getText());
        
        //get project number
        this.project.setname(String.valueOf(this.jproject.getSelectedItem()));
        this.project.setcreatedby(Createdby);
        Project p = new Project();
        p = repopoject.Get(project);
        if(p== null){
            JOptionPane.showMessageDialog(null, "You must have at least 1 open project");
            this.dispose();            
        }else{
            this.task.setIdProject(p.getId());
            //get assigned to number
            String assign = String.valueOf(this.jassigned.getSelectedItem());
            if ( "null".equals(assign)){
                JOptionPane.showMessageDialog(null, "Project must have a team");
                //this.dispose();
            }else{
            this.user.setEmail(String.valueOf(this.jassigned.getSelectedItem()));
            User u = new User();
            u = repouser.Getid(this.user.getEmail());
            this.task.setidassignedto(u.getId());

            boolean create;

            create = repotask.Create(task);

            if(create){
                JOptionPane.showMessageDialog(null, "Task created");
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Error");
            }
            }
        }
        }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ProjectUpdate(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProjectUpdate
        
        Project project2;
        project2 = new Project();
        
        project2.setname(String.valueOf(this.jproject.getSelectedItem()));
        project2.setcreatedby(Createdby);        
        Project p = new Project();
        p = repopoject.Get(project2);

        JComboBox assign = new JComboBox();
        for (User user : repouser.GetAllnames(p.getId())) {
            assign.addItem(user.getEmail());
        }
       this.jassigned.setModel(assign.getModel());
    }//GEN-LAST:event_ProjectUpdate

    private void jcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jcancelActionPerformed

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
            java.util.logging.Logger.getLogger(New_Task.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(New_Task.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(New_Task.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(New_Task.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new New_Task().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
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
    private javax.swing.JButton jcancel;
    private javax.swing.JFormattedTextField jdatein;
    private javax.swing.JFormattedTextField jdateout;
    private javax.swing.JTextArea jdescription;
    private javax.swing.JTextField jname;
    private javax.swing.JComboBox<String> jpriority;
    private javax.swing.JComboBox<String> jproject;
    private javax.swing.JComboBox<String> jstatus;
    // End of variables declaration//GEN-END:variables
}
