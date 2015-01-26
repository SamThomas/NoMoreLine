package fr.ece.pfe_project.widget;

import fr.ece.pfe_project.model.Camera;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JTable;

/**
 *
 * @author pierreghazal
 */
public class CameraCellComponent extends javax.swing.JPanel {

    private Camera camera;

    public CameraCellComponent() {
        initComponents();

        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        this.panelCameraState.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
    }

    public void updateData(Camera cam, boolean isSelected, JTable table) {
        this.camera = cam;

        this.labelID.setText("Camera # " + this.camera.getId());
        if (camera.getPosition() == null || camera.getPosition().equals(" - ")) {
            this.labelPosition.setText("Position : Non renseignée");
        } else {
            this.labelPosition.setText("Position : " + this.camera.getPosition());
        }

        if (isSelected) {
            setBackground(Color.BLUE);
            setForeground(Color.WHITE);
            this.labelPosition.setForeground(Color.WHITE);
            this.labelID.setForeground(Color.WHITE);
        } else {
            setForeground(Color.BLACK);
            this.labelPosition.setForeground(Color.BLACK);
            this.labelID.setForeground(Color.BLACK);
        }

        switch (camera.getState()) {

            case ALERT:
                this.panelCameraState.setBackground(Color.RED);
                this.panelCameraState.setVisible(true);
                break;

            case NONE:
            case NORMAL:
            default:
                this.panelCameraState.setVisible(false);
                this.panelCameraState.setBackground(new Color(238, 238, 238));
                break;
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

        labelID = new javax.swing.JLabel();
        panelCameraState = new javax.swing.JPanel();
        labelPosition = new javax.swing.JLabel();

        labelID.setText("Camera #");

        panelCameraState.setMinimumSize(new java.awt.Dimension(50, 50));
        panelCameraState.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout panelCameraStateLayout = new javax.swing.GroupLayout(panelCameraState);
        panelCameraState.setLayout(panelCameraStateLayout);
        panelCameraStateLayout.setHorizontalGroup(
            panelCameraStateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        panelCameraStateLayout.setVerticalGroup(
            panelCameraStateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        labelPosition.setText("Position : Non renseignée");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelID)
                    .addComponent(labelPosition))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addComponent(panelCameraState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCameraState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelPosition)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelPosition;
    private javax.swing.JPanel panelCameraState;
    // End of variables declaration//GEN-END:variables
}
