/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaanapp.tubes.Model;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Irfan Gerard W M
 */
public class PengembalianModel {
    String id,no_pinjam,tgl_pinjam,tgl_kembali,anggota_id,nama_anggota,id_buku,stock;
    KoneksiDB db=null;
    
    public PengembalianModel (){
        db= new KoneksiDB();
    }
    public String getID(){
        return id;
    }
    public void setStock(String Stock){
        this.stock=Stock;
    }
    public void setID (String id){
        this.id = id;
    }
    public void setid_buku(String idbuku){
        this.id_buku= idbuku;
    }
      public void setId(String id) {
        this.id = id;
    }

    public String getNo_pinjam() {
        return no_pinjam;
    }

    public void setNo_pinjam(String no_pinjam) {
        this.no_pinjam = no_pinjam;
    }

    public String getTgl_pinjam() {
        return tgl_pinjam;
    }

    public void setTgl_pinjam(String tgl_pinjam) {
        this.tgl_pinjam = tgl_pinjam;
    }

    public String getTgl_kembali() {
        return tgl_kembali;
    }

    public void setTgl_kembali(String tgl_kembali) {
        this.tgl_kembali = tgl_kembali;
    }

    public String getAnggota_id() {
        return anggota_id;
    }

    public void setAnggota_id(String anggota_id) {
        this.anggota_id = anggota_id;
    }

    public String getNama_anggota() {
        return nama_anggota;
    }

    public void setNama_anggota(String nama_anggota) {
        this.nama_anggota = nama_anggota;
    }
    public List carinopinjam(String noPinjam){
        List<PengembalianModel> data=new ArrayList<>();
        ResultSet rs=null;
        try{
            String sql="SELECT * from peminjaman where no_pinjam='"+noPinjam+"'";
            rs=db.ambilData(sql);
                        
            while(rs.next()){                   
                PengembalianModel pdm=new PengembalianModel();
                pdm.setID(rs.getString("id"));
                pdm.setNo_pinjam(rs.getString("no_pinjam"));
                pdm.setTgl_pinjam(rs.getString("tgl_pinjam"));
                pdm.setTgl_kembali(rs.getString("tgl_kembali"));
                pdm.setAnggota_id(rs.getString("anggota_id"));
                data.add(pdm);
            }               
            db.tutupKoneksi(rs);
        }catch(Exception x){
            JOptionPane.showMessageDialog(null, "Tampil data gagal, Pesan Error : \n"+x);
        }
        
        return data;
    }
    public void hapus(){
        String sql="DELETE FROM PEMINJAMAN WHERE ID_PINJAM='"+id+"'";
        db.simpanData(sql);
        db.tutupKoneksi(null);        
    }
    public List caribuku(String idPinjam){
        List<PengembalianModel> data=new ArrayList<>();
        ResultSet rs=null;
        try{
            String sql="SELECT * from peminjaman_detail where id_pinjam ='"+idPinjam+"'";
            rs=db.ambilData(sql);
                        
            while(rs.next()){                   
                PengembalianModel pdm=new PengembalianModel();
                pdm.setid_buku(rs.getString("id_buku"));
                data.add(pdm);
            }               
            db.tutupKoneksi(rs);
        }catch(Exception x){
            JOptionPane.showMessageDialog(null, "Tampil data gagal, Pesan Error : \n"+x);
        }
        
        return data;
    }
    public List tampilBuku(String noPinjam){
        List<PeminjamanDetailModel> data=new ArrayList<>();
        ResultSet rs=null;
        try{
            String sql="SELECT buku.kode,buku.judul,buku.pengarang,buku.penerbit "
                    + "FROM peminjaman_detail INNER JOIN peminjaman ON "
                    + "peminjaman.id=peminjaman_detail.id_pinjam INNER JOIN buku ON "
                    + "peminjaman_detail.id_buku=buku.id where peminjaman.no_pinjam='"+noPinjam+"'";
            rs=db.ambilData(sql);
                        
            while(rs.next()){                   
                PeminjamanDetailModel pdm=new PeminjamanDetailModel();
                pdm.setKode(rs.getString("kode"));
                pdm.setJudul(rs.getString("judul"));
                pdm.setPengarang(rs.getString("pengarang"));
                pdm.setPenerbit(rs.getString("penerbit"));
                data.add(pdm);
            }               
            db.tutupKoneksi(rs);
        }catch(Exception x){
            JOptionPane.showMessageDialog(null, "Tampil data gagal, Pesan Error : \n"+x);
        }
        
        return data;
    }
    
    public void tambahstock(String idbuku){
        
    }
}
