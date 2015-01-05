package fr.ece.pfe_project.panel;

import fr.ece.pfe_project.algo.Algorithm;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.Dimension;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import org.jdatepicker.ComponentManager;
import org.jdatepicker.DefaultComponentFactory;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilCalendarModel;

/**
 *
 * @author pierreghazal
 */
public class StatisticPanel extends javax.swing.JPanel {

    private JDatePickerImpl datePicker;

    public StatisticPanel() {
        initComponents();
        initDatePicker();

        setLayout(new FlowLayout());

        Box vBox = Box.createVerticalBox();
        Box vBox2 = Box.createVerticalBox();

        JLabel label = new JLabel("Nombre de passagers prévu", SwingConstants.CENTER);
        JLabel label1 = new JLabel("Personnels alloués", SwingConstants.CENTER);
        JLabel label2 = new JLabel("Autres", SwingConstants.CENTER);

        //vBox.add((JComponent) datePicker);
        vBox.add((JComponent) datePicker.getJDateInstantPanel());

        vBox2.add(Box.createRigidArea(new Dimension(0, 10)));

        vBox2.add(new JSeparator(SwingConstants.HORIZONTAL));
        vBox2.add(label);
        vBox2.add(new JSeparator(SwingConstants.HORIZONTAL));
        vBox2.add(label1);
        vBox2.add(new JSeparator(SwingConstants.HORIZONTAL));
        vBox2.add(label2);
        vBox2.add(new JSeparator(SwingConstants.HORIZONTAL));

        add(vBox);
        add(vBox2);
    }

    private void initDatePicker() {

        UtilCalendarModel model = new UtilCalendarModel();
        model.setSelected(true);
        DefaultComponentFactory componentFactory = new DefaultComponentFactory();//UtilCalendarModel.class, new DateLabelFormatter(), Locale.FRENCH);
        datePicker = (JDatePickerImpl) componentFactory.createJDatePicker();
        datePicker.setDoubleClickAction(false);
        datePicker.setButtonFocusable(false);

        datePicker.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Date date = getDate();

                if (date != null) {
                    // Do stuff
                    System.out.println("Action Valid : " + date);

                    Algorithm.process(date);
                }

                System.out.println("Action : " + date);
            }
        });

        datePicker.getModel().addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("Property : " + getStringDate());
            }
        });
    }

    public Date getDate() {
        Calendar cal = (Calendar) datePicker.getModel().getValue();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);

        return cal.getTime();
    }

    public String getStringDate() {
        try {
            Calendar selectedValue = (Calendar) datePicker.getModel().getValue();

            return (new DateComponentFormatter(
                    ComponentManager.getInstance().getComponentFormatDefaults().getSelectedDateFormat()))
                    .valueToString(selectedValue);

        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMaximumSize(new java.awt.Dimension(210, 32767));
        setMinimumSize(new java.awt.Dimension(210, 0));
        setPreferredSize(new java.awt.Dimension(210, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 283, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
