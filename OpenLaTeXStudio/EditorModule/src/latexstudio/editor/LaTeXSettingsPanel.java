/* 
 * Copyright (c) 2015 Sebastian Brudzinski
 * 
 * See the file LICENSE for copying permission.
 */
package latexstudio.editor;

import java.io.File;
import javax.swing.JOptionPane;
import latexstudio.editor.files.FileChooserService;
import latexstudio.editor.util.ApplicationUtils;
import org.openide.util.NbPreferences;

final class LaTeXSettingsPanel extends javax.swing.JPanel {

    private final LaTeXSettingsOptionsPanelController controller;

    LaTeXSettingsPanel(LaTeXSettingsOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
        // TODO listen to changes in form fields and call controller.changed()
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(LaTeXSettingsPanel.class, "LaTeXSettingsPanel.jPanel1.border.title"))); // NOI18N
        jPanel1.setToolTipText(org.openide.util.NbBundle.getMessage(LaTeXSettingsPanel.class, "LaTeXSettingsPanel.toolTipText")); // NOI18N
        jPanel1.setName(""); // NOI18N

        jTextField1.setText(org.openide.util.NbBundle.getMessage(LaTeXSettingsPanel.class, "LaTeXSettingsPanel.jTextField1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(LaTeXSettingsPanel.class, "LaTeXSettingsPanel.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(LaTeXSettingsPanel.class, "LaTeXSettingsPanel.jPanel1.AccessibleContext.accessibleName")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        File directory = FileChooserService.getSelectedDirectory("Choose");
        File pdflatex_exe;
        String fname = (ApplicationUtils.isWindows()? "/pdflatex.exe" : "/pdflatex");
        if (directory != null) {
            pdflatex_exe = new File(directory.toString() + fname);
            int reply = JOptionPane.NO_OPTION;
            while (!(pdflatex_exe.exists()) && reply == JOptionPane.NO_OPTION) {
                reply = JOptionPane.showConfirmDialog(null,
                        "We could not find the pdflatex in the selected path. Do you confirm the selection?",
                        "Pdflatex not found",
                        JOptionPane.YES_NO_OPTION);

                if (reply == JOptionPane.NO_OPTION) {
                    directory = FileChooserService.getSelectedDirectory("Choose");
                    if (directory != null) pdflatex_exe = new File(directory.toString() + fname);
                }
            }
            if (directory != null) jTextField1.setText(directory.getAbsolutePath());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    void load() {
        jTextField1.setText(NbPreferences.forModule(LaTeXSettingsPanel.class).get("latexPath", ""));
    }

    void store() {
        NbPreferences.forModule(LaTeXSettingsPanel.class).put("latexPath", jTextField1.getText());
    }

    boolean valid() {
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
