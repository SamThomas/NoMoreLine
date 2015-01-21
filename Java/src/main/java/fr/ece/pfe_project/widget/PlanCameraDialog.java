package fr.ece.pfe_project.widget;

import fr.ece.pfe_project.database.DatabaseHelper;
import fr.ece.pfe_project.model.Camera;
import fr.ece.pfe_project.tablemodel.CameraPlanTableModel;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author pierreghazal
 */
public class PlanCameraDialog extends javax.swing.JDialog {
    
    private CameraPlanTableModel model;

    public PlanCameraDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        ArrayList<Camera> list = new ArrayList<Camera>();
        
        for(int i = 1; i < 4; i++)
            list.add(new Camera(i));
        
        model = new CameraPlanTableModel(list);

        this.tableCameraPlan.getColumnModel().getColumn(1).setCellEditor(new PositionEditor());
        this.tableCameraPlan.setDefaultRenderer(String.class, new CameraRenderer());
        
        this.tableCameraPlan.setModel(model);
        model.fireTableDataChanged();
    }

    public class PositionEditor extends DefaultCellEditor {

        private JComboBox comboBox;

        public PositionEditor() {
            super(new JComboBox());

            this.comboBox = (JComboBox) super.getComponent();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

            for (String pos : DatabaseHelper.getListePositionsCamera()) {
                comboBox.addItem(pos);
            }

            return this.comboBox;
        }

        @Override
        public Object getCellEditorValue() {
            return (String) this.comboBox.getSelectedItem();
        }
    }

    public class CameraRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int col) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

            this.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);

            if (isSelected) {
                this.setBackground(Color.BLUE);
                this.setForeground(Color.WHITE);
            } else {
                this.setForeground(Color.BLACK);
            }

            return this;
        }
    }

//    public class PositionRenderer extends DefaultTableCellRenderer {
//
//        @Override
//        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//            // final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//            final JComboBox<String> c = new JComboBox<>(DatabaseHelper.getListePositionsCamera().toArray(new String[0]));
//
//            c.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
//
//            if (isSelected) {
//                c.setBackground(Color.BLUE);
//                c.setForeground(Color.WHITE);
//            } else {
//                c.setForeground(Color.BLACK);
//            }
//
//            return c;
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        annulerButton = new javax.swing.JButton();
        validateButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCameraPlan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        annulerButton.setText("Annuler");
        annulerButton.setSize(new java.awt.Dimension(93, 29));
        annulerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulerButtonActionPerformed(evt);
            }
        });

        validateButton.setText("OK");
        validateButton.setMaximumSize(new java.awt.Dimension(93, 29));
        validateButton.setMinimumSize(new java.awt.Dimension(93, 29));
        validateButton.setPreferredSize(new java.awt.Dimension(93, 29));
        validateButton.setSize(new java.awt.Dimension(93, 29));
        validateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validateButtonActionPerformed(evt);
            }
        });

        tableCameraPlan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Caméra", "Position"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCameraPlan.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(tableCameraPlan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 208, Short.MAX_VALUE)
                .addComponent(validateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(annulerButton))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(annulerButton)
                    .addComponent(validateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void annulerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annulerButtonActionPerformed
        dispose();
    }//GEN-LAST:event_annulerButtonActionPerformed

    private void validateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validateButtonActionPerformed
        // TODO : Ajouter/Update en base 

        dispose();
    }//GEN-LAST:event_validateButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annulerButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCameraPlan;
    private javax.swing.JButton validateButton;
    // End of variables declaration//GEN-END:variables
}
