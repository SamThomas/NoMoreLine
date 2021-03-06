/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.pfe_project.panel;

import fr.ece.pfe_project.interfaces.CameraListener;
import fr.ece.pfe_project.interfaces.ToolbarActionsListener;
import fr.ece.pfe_project.interfaces.ToolbarEntityListener;
import org.jdatepicker.ComponentManager;

/**
 *
 * @author pierreghazal
 */
public class ToolbarActionsPanel extends javax.swing.JPanel implements
        ToolbarEntityListener, CameraListener {

    private final MainPanel.ToolbarsListener toolbarsListener;

    /**
     * Creates new form ToolbarTop
     *
     * @param toolbarsListener
     */
    public ToolbarActionsPanel(MainPanel.ToolbarsListener toolbarsListener) {
        initComponents();

        this.toolbarsListener = toolbarsListener;
    }

    @Override
    public void changeCameraStatus(boolean cameraStatus) {
        if (cameraStatus == true) {
            System.out.println("LED ON");
            cameraState.setText("Caméras activées");
            cameraState.setIcon(ComponentManager.getInstance().getComponentIconDefaults().getonLedIcon());
        } else {
            System.out.println("LED OFF");
            cameraState.setText("Caméras désactivées");
            cameraState.setIcon(ComponentManager.getInstance().getComponentIconDefaults().getoffLedIcon());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        buttonAdd = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        cameraState = new javax.swing.JLabel();
        buttonEdit = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(32767, 50));
        setPreferredSize(new java.awt.Dimension(600, 50));

        buttonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nomoreline/img/add-icon.png"))); // NOI18N
        buttonAdd.setToolTipText("Ajouter un élément");
        buttonAdd.setBorderPainted(false);
        buttonAdd.setContentAreaFilled(false);
        buttonAdd.setEnabled(false);
        buttonAdd.setFocusPainted(false);
        buttonAdd.setFocusTraversalKeysEnabled(false);
        buttonAdd.setFocusable(false);
        buttonAdd.setIgnoreRepaint(true);
        buttonAdd.setSize(new java.awt.Dimension(48, 44));
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nomoreline/img/trash-icon.png"))); // NOI18N
        buttonDelete.setToolTipText("Supprimer un élément");
        buttonDelete.setBorderPainted(false);
        buttonDelete.setContentAreaFilled(false);
        buttonDelete.setEnabled(false);
        buttonDelete.setFocusPainted(false);
        buttonDelete.setFocusTraversalKeysEnabled(false);
        buttonDelete.setFocusable(false);
        buttonDelete.setIgnoreRepaint(true);
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        cameraState.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nomoreline/img/off_led_icon.png"))); // NOI18N
        cameraState.setText("Caméras désactivées");
        cameraState.setIconTextGap(5);

        buttonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nomoreline/img/edit-icon.png"))); // NOI18N
        buttonEdit.setToolTipText("Modifier un élément");
        buttonEdit.setBorderPainted(false);
        buttonEdit.setContentAreaFilled(false);
        buttonEdit.setEnabled(false);
        buttonEdit.setFocusPainted(false);
        buttonEdit.setFocusTraversalKeysEnabled(false);
        buttonEdit.setFocusable(false);
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                .addComponent(cameraState)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonAdd)
            .addComponent(buttonDelete)
            .addComponent(buttonEdit)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cameraState)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        this.toolbarsListener.performAction(ToolbarActionsListener.ACTION_ADD);
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        this.toolbarsListener.performAction(ToolbarActionsListener.ACTION_DELETE);
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        this.toolbarsListener.performAction(ToolbarActionsListener.ACTION_EDIT);
    }//GEN-LAST:event_buttonEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JLabel cameraState;
    private javax.swing.JOptionPane jOptionPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void entityHasChange(ToolbarEntityListener.ENTITY typeEntity) {
        System.out.println("TBAction entityHasChange : " + typeEntity.toString());

        switch (typeEntity) {

            case CAMERA:
            case EXCELROW:
            case CARNETADRESSE:
                buttonAdd.setEnabled(true);
                buttonDelete.setEnabled(true);
                buttonEdit.setEnabled(true);
                break;
            case LISTINGVOLS:
            case PLAN:
            case NONE:
            default:
                buttonAdd.setEnabled(false);
                buttonDelete.setEnabled(false);
                buttonEdit.setEnabled(false);
                break;
        }
    }
}
