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
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import perpustakaanapp.tubes.Model.KategoriModel;

public class DataKategori extends javax.swing.JFrame {
    DefaultTableModel tabel;
    KategoriModel km=new KategoriModel();
    List<KategoriModel> dataKategori=new ArrayList<>();
    /**
     * Creates new form DataKategori
     */
    public DataKategori() {
        initComponents();
        bersihText();
        buatTabel();
        tampilTabel();
    }
    public void bersihText(){
        txtNama.setText(null);        
    }
    private void buatTabel(){
        tabel=new DefaultTableModel();
        tabel.addColumn("ID");
        tabel.addColumn("Nama Kategori");
        tblKategori.setModel(tabel);          
        
        tblKategori.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);                
        tblKategori.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblKategori.getColumnModel().getColumn(1).setPreferredWidth(300);
        
    }
    private void tampilTabel(){
        tabel.getDataVector().removeAllElements();
        tabel.fireTableDataChanged();
        dataKategori.clear();
        dataKategori=km.tampil();
        for(int x=0;x<dataKategori.size();x++){
            Object[] data=new Object[2];
            data[0]=dataKategori.get(x).getId();
            data[1]=dataKategori.get(x).getNama();
            tabel.addRow(data);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKategori = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        Simpan = new javax.swing.JButton();
        Hapus = new javax.swing.JButton();
        Keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel2.setText("Kategori Buku");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel1.setText("Nama Kategori");

        txtNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaKeyPressed(evt);
            }
        });

        tblKategori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKategoriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKategori);

        Simpan.setText("Simpan");
        Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanActionPerformed(evt);
            }
        });

        Hapus.setText("Hapus");
        Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusActionPerformed(evt);
            }
        });

        Keluar.setText("Keluar");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Simpan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Hapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Keluar)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Simpan)
                    .addComponent(Hapus)
                    .addComponent(Keluar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusActionPerformed
        // TODO add your handling code here:
        int baris=tblKategori.getSelectedRow();  
        km.setId(tblKategori.getModel().getValueAt(baris, 0).toString());
        km.hapus();
        bersihText();
        tampilTabel();
    }//GEN-LAST:event_HapusActionPerformed

    private void SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanActionPerformed
        // TODO add your handling code here:
        if(txtNama.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Nama kategori belum Terisi");
            txtNama.requestFocus();
        }else{            
            km.setNama(txtNama.getText());
            km.tambah();
            bersihText();
            tampilTabel();
            txtNama.requestFocus();
        }
    }//GEN-LAST:event_SimpanActionPerformed

    private void tblKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKategoriMouseClicked
        // TODO add your handling code here:
        int baris=tblKategori.getSelectedRow();        
        txtNama.setText(tblKategori.getModel().getValueAt(baris, 1).toString());
    }//GEN-LAST:event_tblKategoriMouseClicked

    private void txtNamaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10){
            SimpanActionPerformed(null);
        }
    }//GEN-LAST:event_txtNamaKeyPressed

    
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
            java.util.logging.Logger.getLogger(DataKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new DataKategori().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Hapus;
    private javax.swing.JButton Keluar;
    private javax.swing.JButton Simpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKategori;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}
