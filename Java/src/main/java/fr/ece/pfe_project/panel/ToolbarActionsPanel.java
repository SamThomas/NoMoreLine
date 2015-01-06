/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.pfe_project.panel;

/**
 *
 * @author pierreghazal
 */
public class ToolbarActionsPanel extends javax.swing.JPanel implements ToolbarEntityPanel.ToolbarEntityListener {

    /**
     * Creates new form ToolbarTop
     *
     */
    public ToolbarActionsPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonAdd = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(32767, 50));
        setPreferredSize(new java.awt.Dimension(600, 50));

        buttonAdd.setText("+");
        buttonAdd.setEnabled(false);

        buttonDelete.setText("Delete");
        buttonDelete.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDelete)
                .addContainerGap(420, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAdd)
                    .addComponent(buttonDelete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonDelete;
    // End of variables declaration//GEN-END:variables

    @Override
    public void entityHasChange(ToolbarEntityPanel.ENTITY typeEntity) {
        System.out.println("TBAction entityHasChange : " + typeEntity.toString());

        switch (typeEntity) {

            case CAMERA:
            case COMPTOIR:
            case EXCELROW:
                buttonAdd.setEnabled(true);
                buttonDelete.setEnabled(true);
                break;
            case NONE:
            default:
                buttonAdd.setEnabled(false);
                buttonDelete.setEnabled(false);
                break;
        }
    }
}
