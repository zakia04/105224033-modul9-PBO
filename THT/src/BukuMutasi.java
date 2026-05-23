// komposisi: objek ini hidup dan mati bersama Rekening
public class BukuMutasi {
    private String nomorRekening; 
    // konstruktor untuk inisialisasi BukuMutasi baru
    public BukuMutasi(String nomorRekening) {
        this.nomorRekening = nomorRekening;
        System.out.println("[BukuMutasi] Dibuat untuk rekening " + nomorRekening); // info pembuatan BukuMutasi baru
    }
    // metode untuk mencatat mutasi transaksi
    public void catat(String keterangan, double nominal, double saldoAkhir) {
        System.out.println("[MUTASI " + nomorRekening + "] " + keterangan + " | Rp" + nominal + " | Saldo: Rp" + saldoAkhir);    
    }
    // metode untuk menutup BukuMutasi (ketika rekening ditutup)
    public void tutup() {
        System.out.println("[BukuMutasi] Rekening " + nomorRekening + " ditutup - BukuMutasi ikut hancur. (KOMPOSISI)");
    }
}