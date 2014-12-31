package fr.ece.pfe_project.panel;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import fr.ece.pfe_project.model.Camera;
import fr.ece.pfe_project.model.Comptoir;
import fr.ece.pfe_project.model.Employee;
import fr.ece.pfe_project.model.ExcelRow;
import fr.ece.pfe_project.tablemodel.MyTableModel;
import fr.ece.pfe_project.utils.GlobalVariableUtils;

/**
 *
 * @author pierreghazal
 */
public class ListPanel extends javax.swing.JPanel implements ToolbarEntityPanel.ToolbarEntityListener, MouseMotionListener, MouseListener {

    private final Comptoir comptoirs[];
    private final Camera cameras[];
    private final Employee employees[];

    /**
     * Creates new form DrawingPanel
     */
    public ListPanel() {
        initComponents();

        // Graphics
        this.setLayout(new BorderLayout());
        this.add(this.itemsTable.getTableHeader(), BorderLayout.PAGE_START);
        this.add(this.itemsTable, BorderLayout.CENTER);

        // Listener
        addMouseListener(this);
        addMouseMotionListener(this);
        //this.itemsTable.getModel().addTableModelListener(this);

        // Data initialization
        comptoirs = new Comptoir[]{
            new Comptoir(1), new Comptoir(2),
            new Comptoir(3), new Comptoir(4),
            new Comptoir(5), new Comptoir(6)
        };

        cameras = new Camera[]{
            new Camera(10), new Camera(20),
            new Camera(30)
        };

        employees = new Employee[]{
            new Employee(), new Employee(),
            new Employee()
        };

        this.itemsTable.setModel(new MyTableModel());
    }

    @Override
    public void entityHasChange(ToolbarEntityPanel.ENTITY typeEntity) {
        System.out.println("List entityHasChange : " + typeEntity.toString());

        MyTableModel model = (MyTableModel) this.itemsTable.getModel();
        model.setEntity(typeEntity);

        // TODO : model.setData() avec les nouvelles données
        switch (typeEntity) {

            case COMPTOIR:
                model.setData(comptoirs, false);
                break;
            case CAMERA:
                model.setData(cameras, false);
                break;
            case EMPLOYEE:
                model.setData(employees, false);
                break;
            case EXCELROW:
                model.setData(GlobalVariableUtils.getExcelMap().values().toArray(new ExcelRow[0]), true);
                break;
            case NONE:
            default:
                break;
        }

        model.fireTableStructureChanged();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(0, 0));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        itemsTable.setAutoCreateRowSorter(true);
        itemsTable.setModel(new MyTableModel());
        itemsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemsTable.setFillsViewportHeight(true);
        itemsTable.setShowVerticalLines(false);
        itemsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(itemsTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable itemsTable;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

//    @Override
//    public void tableChanged(TableModelEvent e) {
//        
//        System.out.println("# Table Changed");
//        int row = e.getFirstRow();
//        int column = e.getColumn();
//        MyTableModel model = (MyTableModel) e.getSource();
//        String columnName = model.getColumnName(column);
//
//        Object data = model.getValueAt(row, column);
//
//    }
}
