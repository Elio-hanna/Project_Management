/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import DTO.User;
import DTO.Task;
import Repositories.RepoTask;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Dashboard extends javax.swing.JFrame {

User user;
Task task;
RepoTask repotask;
public int Createdby;

    public Dashboard(User user) {
        
        
                        //window position
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width)/2;
        int y = (dim.height)/2;
        
        this.setLocation(x-393, y-392);
        
        
        initComponents();
        this.setTitle("Dashboard");
        task = new Task();
        repotask = new RepoTask();
        this.user = user;
        Createdby = this.user.getId();
        dashboard();
        
      
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTasks = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jCTasks = new javax.swing.JTable();
        Check = new javax.swing.JButton();
        Review = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        JMRefresh = new javax.swing.JMenuItem();
        JMChange_Password = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        JMNew_Project = new javax.swing.JMenuItem();
        JMMy_Projects = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        JMNew_Task = new javax.swing.JMenuItem();
        JMMy_Tasks = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Tasks assigned to me"
            }
        ));
        jScrollPane1.setViewportView(jTasks);

        jCTasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Closed tasks"
            }
        ));
        jScrollPane2.setViewportView(jCTasks);

        Check.setText("Check");
        Check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckActionPerformed(evt);
            }
        });

        Review.setText("Check");
        Review.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReviewActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        JMRefresh.setText("Refresh");
        JMRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMRefreshActionPerformed(evt);
            }
        });
        jMenu1.add(JMRefresh);

        JMChange_Password.setText("Change Password");
        JMChange_Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMChange_PasswordActionPerformed(evt);
            }
        });
        jMenu1.add(JMChange_Password);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Project");

        JMNew_Project.setText("New Project");
        JMNew_Project.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMNew_ProjectActionPerformed(evt);
            }
        });
        jMenu2.add(JMNew_Project);

        JMMy_Projects.setText("My Projects");
        JMMy_Projects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMMy_ProjectsActionPerformed(evt);
            }
        });
        jMenu2.add(JMMy_Projects);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("task");

        JMNew_Task.setText("New Task");
        JMNew_Task.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMNew_TaskActionPerformed(evt);
            }
        });
        jMenu4.add(JMNew_Task);

        JMMy_Tasks.setText("My Tasks");
        JMMy_Tasks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMMy_TasksActionPerformed(evt);
            }
        });
        jMenu4.add(JMMy_Tasks);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(Check)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Review)
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Check)
                    .addComponent(Review))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void dashboard(){
       
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Active Tasks",}, 0);
        for (Task task : repotask.getallopen(this.Createdby)) {
            model.addRow(new Object[]{task.getName()});
        }
        this.jTasks.setModel(model);
        
        
        DefaultTableModel model2 = new DefaultTableModel(new Object[]{"Closed Tasks"}, 0);
        for (Task task : repotask.getallclosed(this.Createdby)) {
            model2.addRow(new Object[]{task.getName()});
        }
 	this.jCTasks.setModel(model2);

    }
    
    
    private void JMChange_PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMChange_PasswordActionPerformed
        Change_Password frmchangepswd = new Change_Password();
        frmchangepswd.setVisible(true);
    }//GEN-LAST:event_JMChange_PasswordActionPerformed

    private void JMNew_ProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMNew_ProjectActionPerformed
        New_Project frmnewproject = new New_Project(this.Createdby);
        frmnewproject.setVisible(true);
    }//GEN-LAST:event_JMNew_ProjectActionPerformed

    private void JMMy_ProjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMMy_ProjectsActionPerformed
        My_Project frmmyproject = new My_Project(this.Createdby);
        frmmyproject.setVisible(true);
    }//GEN-LAST:event_JMMy_ProjectsActionPerformed

    private void JMNew_TaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMNew_TaskActionPerformed
        New_Task frmnewtask = new New_Task(this.Createdby);
        frmnewtask.setVisible(true);
    }//GEN-LAST:event_JMNew_TaskActionPerformed

    private void JMMy_TasksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMMy_TasksActionPerformed
        My_task frmmytask = new My_task(this.Createdby);
        frmmytask.setVisible(true);
    }//GEN-LAST:event_JMMy_TasksActionPerformed

    private void JMRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMRefreshActionPerformed
        dashboard();
    }//GEN-LAST:event_JMRefreshActionPerformed

    private void CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckActionPerformed
    
        Task task = new Task();
        int row = jTasks.getSelectedRow();
        if(row>=0){
            task.setName(jTasks.getModel().getValueAt(row, 0).toString());
            TaskEdit tskedit = new TaskEdit(task);
            
            tskedit.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent){
                    dashboard();
                }
            });
            
            tskedit.setVisible(true);            
        }else{
            JOptionPane.showMessageDialog(null, "No Task selected");
        }
    }//GEN-LAST:event_CheckActionPerformed

    
    
    
    private void ReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReviewActionPerformed

        Task task = new Task();
        int row = jCTasks.getSelectedRow();
        if(row>=0){
            task.setName(jCTasks.getModel().getValueAt(row, 0).toString());
            TaskEdit tskedit = new TaskEdit(task);

            tskedit.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent){
                    dashboard();
                }
            });

            tskedit.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "No Task selected");
        }
    }//GEN-LAST:event_ReviewActionPerformed


    
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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
               // new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Check;
    private javax.swing.JMenuItem JMChange_Password;
    private javax.swing.JMenuItem JMMy_Projects;
    private javax.swing.JMenuItem JMMy_Tasks;
    private javax.swing.JMenuItem JMNew_Project;
    private javax.swing.JMenuItem JMNew_Task;
    private javax.swing.JMenuItem JMRefresh;
    private javax.swing.JButton Review;
    private javax.swing.JTable jCTasks;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTasks;
    // End of variables declaration//GEN-END:variables
}
