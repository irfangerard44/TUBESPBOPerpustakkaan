/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaanapp.tubes.GUI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import perpustakaanapp.tubes.Model.AnggotaModel;
import perpustakaanapp.tubes.Model.BukuModel;
import perpustakaanapp.tubes.Model.PeminjamanDetailModel;
import perpustakaanapp.tubes.Model.PeminjamanModel;
import perpustakaanapp.tubes.Model.SettingModel;
/**
 *
 * @author Irfan Gerard W M
 */
public class TambahPeminjaman extends javax.swing.JFrame {
    String anggota_id, buku_id;
    int max_buku, batas_pinjam;
    PeminjamanModel pm = new PeminjamanModel();
    DefaultTableModel tabel, tabelPinjam;
    AnggotaModel am = new AnggotaModel();
    List<AnggotaModel> dataAnggota = new ArrayList<>();
    BukuModel bm = new BukuModel();
    List<BukuModel> dataBuku = new ArrayList<>();
    /**
     * Creates new form TambahPeminjaman
     */
    public TambahPeminjaman() {
        initComponents();
        bersih();
        ambilDataSetting();
        tampilTanggal();
        txtNoPinjam.setText(pm.buatNoPinjam());
        setLocationRelativeTo(null);
    }

    private void buatTabelDetailBuku() {
        tabelPinjam = new DefaultTableModel();
        tabelPinjam.addColumn("Buku ID");
        tabelPinjam.addColumn("Kode");
        tabelPinjam.addColumn("Judul");
        tblBuku.setModel(tabelPinjam);
    }
    private void buatTabelAnggota() {
        tabel = new DefaultTableModel();
        tabel.addColumn("ID");
        tabel.addColumn("NO");
        tabel.addColumn("Nama Anggota");
        tabel.addColumn("Jenis Kelamin");
        tabel.addColumn("Telpon");
        tabel.addColumn("Alamat");
        tblAnggota.setModel(tabel);
        //Untuk mengatur lebar kolom
        tblAnggota.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblAnggota.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblAnggota.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblAnggota.getColumnModel().getColumn(2).setPreferredWidth(80);
        tblAnggota.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblAnggota.getColumnModel().getColumn(4).setPreferredWidth(120);
    }
    private void tampilTanggal() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        // menampilkan tanggal hari ini
        Calendar cal = Calendar.getInstance();
        txtTglPinjam.setText(df.format(cal.getTime()));
        // tgl hari ini ditambah dengan batas pinjam
        cal.add(Calendar.DAY_OF_MONTH, batas_pinjam);
        txtTglKembali.setText(df.format(cal.getTime()));
    }
    
    private void ambilDataSetting() {
        SettingModel sm = new SettingModel();
        List<SettingModel> data = new ArrayList<>();
        data = sm.tampil();
        if (data != null) {
            max_buku = Integer.parseInt(data.get(0).getMax_buku());
            batas_pinjam = Integer.parseInt(data.get(0).getBatas_pinjam());
        }
    }
    private void bersih() {
        txtNoPinjam.setText(null);
        txtNoAnggota.setText(null);
        txtNamaAnggota.setText(null);
        txtTglPinjam.setText(null);
        txtTglKembali.setText(null);
        txtKodeBuku.setText(null);
        txtNmBuku.setText(null);
    }
    private void tampilAnggota() {
        tabel.getDataVector().removeAllElements();
        tabel.fireTableDataChanged();
        dataAnggota.clear();
        dataAnggota = am.tampil();
        if (dataAnggota != null) {
            for (int x = 0; x < dataAnggota.size(); x++) {
                Object[] data = new Object[6];
                data[0] = dataAnggota.get(x).getId();
                data[1] = dataAnggota.get(x).getNo();
                data[2] = dataAnggota.get(x).getNama();
                data[3] = dataAnggota.get(x).getJk();
                data[4] = dataAnggota.get(x).getTelp();
                data[5] = dataAnggota.get(x).getAlamat();
                tabel.addRow(data);
            }
        }
    }
    private void buatTabelBuku() {
        tabel = new DefaultTableModel();
        tabel.addColumn("ID");
        tabel.addColumn("Kode");
        tabel.addColumn("Judul");
        tabel.addColumn("Pengarang");
        tabel.addColumn("Penerbit");
        tabel.addColumn("ISBN");
        tabel.addColumn("Stok");

        tblCariBuku.setModel(tabel);
        //Untuk mengatur lebar kolom
        tblCariBuku.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblCariBuku.getColumnModel().getColumn(0).setMinWidth(0);
        tblCariBuku.getColumnModel().getColumn(0).setMaxWidth(0);
        tblCariBuku.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblCariBuku.getColumnModel().getColumn(2).setPreferredWidth(200);
        tblCariBuku.getColumnModel().getColumn(3).setPreferredWidth(150);
        tblCariBuku.getColumnModel().getColumn(4).setPreferredWidth(150);
        tblCariBuku.getColumnModel().getColumn(5).setPreferredWidth(100);
        tblCariBuku.getColumnModel().getColumn(6).setPreferredWidth(100);
    }
    private void tampilTabelBuku() {
        tabel.getDataVector().removeAllElements();
        tabel.fireTableDataChanged();
        dataBuku.clear();
        dataBuku = bm.tampil();
        for (int x = 0; x < dataBuku.size(); x++) {
            Object[] data = new Object[7];
            data[0] = dataBuku.get(x).getId();
            data[1] = dataBuku.get(x).getKode();
            data[2] = dataBuku.get(x).getJudul();
            data[3] = dataBuku.get(x).getPengarang();
            data[4] = dataBuku.get(x).getPenerbit();
            data[5] = dataBuku.get(x).getIsbn();
            data[6] = dataBuku.get(x).getStok();
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

        relasiAnggota = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnPilih = new javax.swing.JButton();
        btnBatalAnggota = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAnggota = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        relasiBuku = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnPilihBuku = new javax.swing.JButton();
        btnBatalBuku = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        txtCariBuku = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCariBuku = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNoPinjam = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNoAnggota = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNamaAnggota = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtKodeBuku = new javax.swing.JTextField();
        btnCariBuku = new javax.swing.JButton();
        txtNmBuku = new javax.swing.JTextField();
        btnTambahBuku = new javax.swing.JButton();
        btnHapusBuku = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTglPinjam = new javax.swing.JTextField();
        txtTglKembali = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuku = new javax.swing.JTable();
        btnCariAnggota = new javax.swing.JButton();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(0, 102, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DATA ANGGOTA");

        btnPilih.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPilih.setText("PILIH ANGGOTA");
        btnPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihActionPerformed(evt);
            }
        });

        btnBatalAnggota.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBatalAnggota.setText("BATAL");
        btnBatalAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalAnggotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPilih)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBatalAnggota)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addComponent(btnPilih)
                .addComponent(btnBatalAnggota))
        );

        tblAnggota.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAnggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAnggotaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblAnggota);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cari Anggota", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel9.setText("No atau Nama Anggota");

        txtCari.setText("jTextField1");
        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(txtCari)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout relasiAnggotaLayout = new javax.swing.GroupLayout(relasiAnggota.getContentPane());
        relasiAnggota.getContentPane().setLayout(relasiAnggotaLayout);
        relasiAnggotaLayout.setHorizontalGroup(
            relasiAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        relasiAnggotaLayout.setVerticalGroup(
            relasiAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(0, 102, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("DATA BUKU");

        btnPilihBuku.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPilihBuku.setText("PLIH BUKU");
        btnPilihBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihBukuActionPerformed(evt);
            }
        });

        btnBatalBuku.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBatalBuku.setText("BATAL");
        btnBatalBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalBukuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPilihBuku)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBatalBuku)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPilihBuku)
                    .addComponent(btnBatalBuku))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cari Buku", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        txtCariBuku.setText("jTextField1");
        txtCariBuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariBukuKeyTyped(evt);
            }
        });

        jLabel11.setText("Kode atau Judul Buku");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(txtCariBuku)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCariBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        tblCariBuku.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCariBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCariBukuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCariBuku);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout relasiBukuLayout = new javax.swing.GroupLayout(relasiBuku.getContentPane());
        relasiBuku.getContentPane().setLayout(relasiBukuLayout);
        relasiBukuLayout.setHorizontalGroup(
            relasiBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        relasiBukuLayout.setVerticalGroup(
            relasiBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("Tambah Peminjaman");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSimpan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBatal)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnSimpan)
                    .addComponent(btnBatal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("No Pinjam");

        jLabel3.setText("No. Anggota");

        jLabel4.setText("Nama Anggota");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buku yang Dipinjam", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel7.setText("Kode Buku");

        txtKodeBuku.setText("jTextField6");

        btnCariBuku.setText(":::");
        btnCariBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariBukuActionPerformed(evt);
            }
        });

        txtNmBuku.setText("jTextField7");

        btnTambahBuku.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTambahBuku.setText("+");
        btnTambahBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahBukuActionPerformed(evt);
            }
        });

        btnHapusBuku.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnHapusBuku.setText("-");
        btnHapusBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusBukuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addComponent(txtKodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btnCariBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNmBuku, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTambahBuku)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHapusBuku)
                .addGap(9, 9, 9))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtKodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCariBuku)
                    .addComponent(txtNmBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambahBuku)
                    .addComponent(btnHapusBuku))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("Tanggal Pinjam");

        jLabel6.setText("Tanggal Harus Kembali");

        txtTglPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTglPinjamActionPerformed(evt);
            }
        });

        txtTglKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTglKembaliActionPerformed(evt);
            }
        });

        tblBuku.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblBuku);

        btnCariAnggota.setText(":::");
        btnCariAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariAnggotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNoPinjam)
                            .addComponent(txtNoAnggota, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCariAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTglKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTglPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtNamaAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNoPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtTglPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCariAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtNoAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(txtTglKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtNamaAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariBukuActionPerformed
        buatTabelBuku();
        tampilTabelBuku();
        txtCari.setText(null);
        relasiBuku.setSize(537, 461);
        relasiBuku.setLocationRelativeTo(this);
        relasiBuku.setVisible(true);
        txtCariBuku.setText(null);
        txtCariBuku.requestFocus();
    }//GEN-LAST:event_btnCariBukuActionPerformed

    private void btnTambahBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahBukuActionPerformed
        JOptionPane.showMessageDialog(null, max_buku);
        if (txtKodeBuku.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Anda belum memilih Buku");
        } else {
            //untuk validasi jml pinjam
            if (tblBuku.getRowCount() + 1 > max_buku) {
                JOptionPane.showMessageDialog(null, tblBuku.getRowCount()+1);
                JOptionPane.showMessageDialog(null, "Maksimal pinjam buku adalah " + max_buku);
            } else {
                //validasi untuk buku yg sama
                for(int x=0;x<tblBuku.getRowCount();x++){
                    if(txtKodeBuku.getText().equals(tblBuku.getValueAt(x, 1))){
                        JOptionPane.showMessageDialog(null, "Buku yang dipinjam tidak boleh sama");
                        return;
                    }
                }
                if (tblBuku.getRowCount() == 0) {
                    buatTabelDetailBuku();
                }
                Object[] data = new Object[3];
                data[0] = buku_id;
                data[1] = txtKodeBuku.getText();
                data[2] = txtNmBuku.getText();
                tabelPinjam.addRow(data);

                buku_id = null;
                txtKodeBuku.setText(null);
                txtNmBuku.setText(null);
            }
        }
    }//GEN-LAST:event_btnTambahBukuActionPerformed

    private void btnHapusBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusBukuActionPerformed
        if(tblBuku.getRowCount()!=0){
            tabelPinjam.removeRow(tblBuku.getSelectedRow());
        }
    }//GEN-LAST:event_btnHapusBukuActionPerformed

    private void txtTglPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTglPinjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTglPinjamActionPerformed

    private void txtTglKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTglKembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTglKembaliActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(txtNoAnggota.getText().isEmpty() || tblBuku.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "Lengkapi inputan peminjaman");
        }else{
            //simpan ke tabel peminjaman
            pm.setNo_pinjam(txtNoPinjam.getText());
            pm.setTgl_pinjam(txtTglPinjam.getText());
            pm.setTgl_kembali(txtTglKembali.getText());
            pm.setAnggota_id(anggota_id);                        
            pm.tambah();
            //simpan ke tabel peminjaman detail
            PeminjamanDetailModel pdm=new PeminjamanDetailModel();
            for(int x=0;x<tblBuku.getRowCount();x++){
                pdm.setId_pinjam(pm.ambilIdTerakhir());
                pdm.setId_buku(tblBuku.getValueAt(x, 0).toString());
                pdm.tambah();
                bm.updateStokBuku(tblBuku.getValueAt(x, 0).toString(), 1);
            }
            JOptionPane.showMessageDialog(null, "Simpan peminjaman Berhasil");
            dispose();
        } 
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihActionPerformed
        // TODO add your handling code here:
        int baris = tblAnggota.getSelectedRow();
        anggota_id = tblAnggota.getValueAt(baris, 0).toString();
        txtNoAnggota.setText(tblAnggota.getValueAt(baris, 1).toString());
        txtNamaAnggota.setText(tblAnggota.getValueAt(baris, 2).toString());
        relasiAnggota.setVisible(false);
    }//GEN-LAST:event_btnPilihActionPerformed

    private void btnBatalAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalAnggotaActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnBatalAnggotaActionPerformed

    private void tblAnggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAnggotaMouseClicked
        // TODO add your handling code here:
        btnPilihActionPerformed(null);
    }//GEN-LAST:event_tblAnggotaMouseClicked

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
        tabel.getDataVector().removeAllElements();
        tabel.fireTableDataChanged();
        dataAnggota.clear();
        dataAnggota = am.cariAnggota(txtCari.getText());
        if (dataAnggota != null) {
            for (int x = 0; x < dataAnggota.size(); x++) {
                Object[] data = new Object[6];
                data[0] = dataAnggota.get(x).getId();
                data[1] = dataAnggota.get(x).getNo();
                data[2] = dataAnggota.get(x).getNama();
                data[3] = dataAnggota.get(x).getJk();
                data[4] = dataAnggota.get(x).getTelp();
                data[5] = dataAnggota.get(x).getAlamat();
                tabel.addRow(data);
            }
        }
    }//GEN-LAST:event_txtCariKeyTyped

    private void btnPilihBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihBukuActionPerformed
        int baris = tblCariBuku.getSelectedRow();
        buku_id = tblCariBuku.getValueAt(baris, 0).toString();
        txtKodeBuku.setText(tblCariBuku.getValueAt(baris, 1).toString());
        txtNmBuku.setText(tblCariBuku.getValueAt(baris, 2).toString());
        relasiBuku.setVisible(false);
    }//GEN-LAST:event_btnPilihBukuActionPerformed

    private void btnBatalBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalBukuActionPerformed
        relasiBuku.setVisible(false);
    }//GEN-LAST:event_btnBatalBukuActionPerformed

    private void txtCariBukuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariBukuKeyTyped
        tabel.getDataVector().removeAllElements();
        tabel.fireTableDataChanged();
        dataBuku.clear();
        dataBuku = bm.cariBuku(txtCariBuku.getText());
        for (int x = 0; x < dataBuku.size(); x++) {
            Object[] data = new Object[7];
            data[0] = dataBuku.get(x).getId();
            data[1] = dataBuku.get(x).getKode();
            data[2] = dataBuku.get(x).getJudul();
            data[3] = dataBuku.get(x).getPengarang();
            data[4] = dataBuku.get(x).getPenerbit();
            data[5] = dataBuku.get(x).getIsbn();
            data[6] = dataBuku.get(x).getStok();
            tabel.addRow(data);
        }
    }//GEN-LAST:event_txtCariBukuKeyTyped

    private void tblCariBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCariBukuMouseClicked
        int baris = tblCariBuku.getSelectedRow();
        buku_id = tblCariBuku.getValueAt(baris, 0).toString();
        txtKodeBuku.setText(tblCariBuku.getValueAt(baris, 1).toString());
        txtNmBuku.setText(tblCariBuku.getValueAt(baris, 2).toString());
        relasiBuku.setVisible(false);
    }//GEN-LAST:event_tblCariBukuMouseClicked

    private void btnCariAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariAnggotaActionPerformed
        buatTabelAnggota();
        tampilAnggota();
        txtCari.setText(null);
        relasiAnggota.setSize(537, 461);
        relasiAnggota.setLocationRelativeTo(this);
        relasiAnggota.setVisible(true);
        txtCari.requestFocus();
    }//GEN-LAST:event_btnCariAnggotaActionPerformed

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
            java.util.logging.Logger.getLogger(TambahPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TambahPeminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnBatalAnggota;
    private javax.swing.JButton btnBatalBuku;
    private javax.swing.JButton btnCariAnggota;
    private javax.swing.JButton btnCariBuku;
    private javax.swing.JButton btnHapusBuku;
    private javax.swing.JButton btnPilih;
    private javax.swing.JButton btnPilihBuku;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambahBuku;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JDialog relasiAnggota;
    private javax.swing.JDialog relasiBuku;
    private javax.swing.JTable tblAnggota;
    private javax.swing.JTable tblBuku;
    private javax.swing.JTable tblCariBuku;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtCariBuku;
    private javax.swing.JTextField txtKodeBuku;
    private javax.swing.JTextField txtNamaAnggota;
    private javax.swing.JTextField txtNmBuku;
    private javax.swing.JTextField txtNoAnggota;
    private javax.swing.JTextField txtNoPinjam;
    private javax.swing.JTextField txtTglKembali;
    private javax.swing.JTextField txtTglPinjam;
    // End of variables declaration//GEN-END:variables
}
