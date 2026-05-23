// asosiasi dengan nasabah, komposisi dengan buku mutasi
public class CustomerService {
    private String namaAgen;
    // konstruktor untuk inisialisasi CustomerService baru
    public CustomerService(String namaAgen) {
        this.namaAgen = namaAgen;
    }
    // asosiasi nasabah di-pass sementara, tidak disimpan sebagai field
    public void terimaKeluhan(Nasabah nasabah, String keluhan) {
        System.out.println("\n  --- TIKET KELUHAN ---");
        System.out.println("Agen    : " + namaAgen);
        System.out.println("Nasabah : " + nasabah.getNama() + " [" + nasabah.getId() + "]");
        System.out.println("Keluhan : " + keluhan);
        System.out.println("Status  : Diterima, diproses dalam 1x24 jam.");
    }
    // getter untuk nama agen
    public String getNamaAgen() { return namaAgen; }
}