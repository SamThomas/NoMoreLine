/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.pfe_project.panel;

import java.awt.Dimension;
import javax.swing.Box;
import real_time_image_processing.FaceDetectorThread;

/**
 *
 * @author pierreghazal
 */
public class MainPanel extends javax.swing.JPanel {

    public class ToolbarsListener implements ToolbarEntityPanel.ToolbarEntityListener, 
            ListPanel.CameraStatusListener {

        @Override
        public void entityHasChange(ToolbarEntityPanel.ENTITY typeEntity) {
            listPanel.entityHasChange(typeEntity);
            toolbarActions.entityHasChange(typeEntity);
        }

        @Override
        public void changeCameraStatus(boolean cameraStatus) {
            toolbarActions.changeCameraStatus(cameraStatus);
        }
    }

    public class FaceDetectorListener implements FaceDetectorThread.FaceDetectorInterface {

        @Override
        public void getCountFaceDetected(int number_of_faces) {
            listPanel.getCountFaceDetected(number_of_faces);
        }

    }

    ToolbarsListener toolbarsListener;
    FaceDetectorListener faceDetectorListener;

    private ToolbarEntityPanel toolbarEntity;
    private ToolbarActionsPanel toolbarActions;
    private ListPanel listPanel;
    private StatisticPanel statisticPanel;

    /**
     * Creates new form MainPanel
     */
    public MainPanel() {
        initComponents();
//        GridBagConstraints c = new GridBagConstraints();

        toolbarsListener = new ToolbarsListener();
        faceDetectorListener = new FaceDetectorListener();

        statisticPanel = new StatisticPanel();
        listPanel = new ListPanel(faceDetectorListener, toolbarsListener);
        toolbarEntity = new ToolbarEntityPanel(toolbarsListener);
        toolbarActions = new ToolbarActionsPanel();

//        c.fill = GridBagConstraints.VERTICAL;
//        c.gridx = 0;
//        c.gridy = 0;
//        c.gridheight = GridBagConstraints.REMAINDER;
        Box hMainBox = Box.createHorizontalBox();
        Box vLeftBox = Box.createVerticalBox();
        Box hLeftBox = Box.createHorizontalBox();

        hMainBox.add(statisticPanel);
        vLeftBox.add(toolbarActions);
        hLeftBox.add(listPanel);
        hLeftBox.add(toolbarEntity);
        vLeftBox.add(hLeftBox);
        vLeftBox.add(Box.createRigidArea(new Dimension(0, 20)));
        hMainBox.add(vLeftBox);

        add(hMainBox);

//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.gridx = 1;
//        c.gridy = 0;
//        c.gridheight = 0;
//        c.gridwidth = GridBagConstraints.REMAINDER;
//        c.fill = GridBagConstraints.BOTH;
//        c.gridx = 1;
//        c.gridy = 1;
//        c.fill = GridBagConstraints.VERTICAL;
//        c.gridx = 2;
//        c.gridy = 1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMinimumSize(new java.awt.Dimension(800, 0));
        setPreferredSize(new java.awt.Dimension(800, 0));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
