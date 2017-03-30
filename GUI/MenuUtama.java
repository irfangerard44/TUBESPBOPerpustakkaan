/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaanapp.tubes.GUI;

/**
 *
 * @author Irfan Gerard W M
 */
public class MenuUtama extends javax.swing.JFrame {

    /**
     * Creates new form MenuUtama
     */
    public MenuUtama() {
        initComponents();
    }
    public void hakAksesAdmin(){
        mAdmin.setVisible(true);
        mTransaksi.setVisible(true);
        mLaporan.setVisible(true);
        mSetting.setVisible(true);
    }
    
    @SuppressWarnings("empty-statement")
    public void hakAksesOperator(){
        mAdmin.setVisible(false);
        mTransaksi.setVisible(true);
        mLaporan.setVisible(false);
        mSetting.setVisible(false);;        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        mAdmin = new javax.swing.JMenu();
        Anggota = new javax.swing.JMenuItem();
        Kategori = new javax.swing.JMenuItem();
        Buku = new javax.swing.JMenuItem();
        mTransaksi = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        mLaporan = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        mSetting = new javax.swing.JMenu();
        setting = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        Keluar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mAdmin.setText("Admin");

        Anggota.setText("Anggota");
        Anggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnggotaActionPerformed(evt);
            }
        });
        mAdmin.add(Anggota);

        Kategori.setText("Kategori");
        Kategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KategoriActionPerformed(evt);
            }
        });
        mAdmin.add(Kategori);

        Buku.setText("Buku");
        Buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BukuActionPerformed(evt);
            }
        });
        mAdmin.add(Buku);

        jMenuBar1.add(mAdmin);

        mTransaksi.setText("Transaksi");

        jMenuItem4.setText("Peminjaman Buku");
        mTransaksi.add(jMenuItem4);

        jMenuItem5.setText("Pengembalian Buku");
        mTransaksi.add(jMenuItem5);

        jMenuBar1.add(mTransaksi);

        mLaporan.setText("Laporan");

        jMenuItem7.setText("Buku");
        mLaporan.add(jMenuItem7);

        jMenuItem8.setText("Peminjaman");
        mLaporan.add(jMenuItem8);

        jMenuItem9.setText("Pengembalian");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        mLaporan.add(jMenuItem9);

        jMenuBar1.add(mLaporan);

        mSetting.setText("Setting");

        setting.setText("Setting App");
        setting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingActionPerformed(evt);
            }
        });
        mSetting.add(setting);

        jMenuItem11.setText("Data Penggunaan");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        mSetting.add(jMenuItem11);

        jMenuBar1.add(mSetting);

        Keluar.setText("Keluar");
        jMenuBar1.add(Keluar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        new Admin().setVisible(true);
    }                                          

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        new Admin().setVisible(true);
    }                                          

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        new MBuku().setVisible(true);
    }                                          

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        //new Peminjaman().setVisible(true);
    }                                          
    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        //new MasterSetting().setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void settingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingActionPerformed
        // TODO add your handling code here:
        new Setting().setVisible(true);
    }//GEN-LAST:event_settingActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void AnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnggotaActionPerformed
        // TODO add your handling code here:
        new Admin().setVisible(true);
    }//GEN-LAST:event_AnggotaActionPerformed

    private void BukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BukuActionPerformed
        // TODO add your handling code here:
        new MBuku().setVisible(true);
    }//GEN-LAST:event_BukuActionPerformed

    private void KategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KategoriActionPerformed
        // TODO add your handling code here:
        new DataKategori().setVisible(true);
    }//GEN-LAST:event_KategoriActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MenuUtama().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Anggota;
    private javax.swing.JMenuItem Buku;
    private javax.swing.JMenuItem Kategori;
    private javax.swing.JMenu Keluar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenu mAdmin;
    private javax.swing.JMenu mLaporan;
    private javax.swing.JMenu mSetting;
    private javax.swing.JMenu mTransaksi;
    private javax.swing.JMenuItem setting;
    // End of variables declaration//GEN-END:variables
}