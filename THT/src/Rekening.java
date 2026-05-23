// abstract class Rekening yang mengimplementasikan Otorisasi
public abstract class Rekening implements Otorisasi {
    private String nomorRekening;
    private String namaPemilik;
    private double saldo; // enkapsulasi: tidak bisa diakses langsung
    private String pin;
    private BukuMutasi bukuMutasi; // komposisi: BukuMutasi dibuat otomatis di konstruktor
    //konstruktor untuk inisialisasi rekening baru
    public Rekening(String nomorRekening, String namaPemilik, double setorAwal, String pin) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik   = namaPemilik;
        this.saldo         = setorAwal;
        this.pin           = pin;
        this.bukuMutasi    = new BukuMutasi(nomorRekening); // komposisi
        bukuMutasi.catat("BUKA REKENING", setorAwal, saldo); //
    }    
    @Override
    public boolean verifikasiPIN(String pin) { // implementasi metode dari interface Otorisasi
        return this.pin.equals(pin);
    }    
    //getter & setter
    public String getNomorRekening() { return nomorRekening; }
    public String getNamaPemilik()   { return namaPemilik; }
    public double getSaldo()         { return saldo; }
    protected void setSaldo(double saldo) { this.saldo = saldo; }
    protected BukuMutasi getBukuMutasi()  { return bukuMutasi; }
    
    public void setor(double jumlah) {
        saldo += jumlah; // update saldo
        bukuMutasi.catat("SETOR", jumlah, saldo); // catat mutasi setor
    }    
    // metode abstrak yang harus diimplementasi oleh subclass
    public abstract void tarik(double jumlah);
    public abstract String getJenis();

    public void tutupRekening() {
        bukuMutasi.tutup(); // BukuMutasi ikut hancur (KOMPOSISI)
    }    
    // metode untuk menampilkan info rekening
    public void info() {
        System.out.println("No. Rekening : " + getNomorRekening());
        System.out.println("Nama         : " + getNamaPemilik());
        System.out.println("Jenis        : " + getJenis());
        System.out.println("Saldo       : " + getSaldo());
    }    
}