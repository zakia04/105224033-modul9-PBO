//agregasi Rekening eksis mandiri di luar Nasabah, bisa dibuat tanpa Nasabah
public class Nasabah {
    private String id;
    private String nama;
    private String telepon;
    // AGREGASI: maks 3 rekening, rekening eksis mandiri di luar Nasabah
    private Rekening[] rekening = new Rekening[3];
    private int jumlah = 0;
    // konstruktor untuk inisialisasi Nasabah baru
    public Nasabah(String id, String nama, String telepon) {
        this.id       = id;
        this.nama     = nama;
        this.telepon  = telepon;
    }
    // metode untuk menambahkan rekening ke profil nasabah, maksimal 3 rekening
    public boolean tambahRekening(Rekening rek) {
        if (jumlah >= 3) { // cek batas maksimal rekening per nasabah
            System.out.println("[GAGAL] Maksimal 3 rekening per nasabah.");
            return false; // gagal tambah rekening jika sudah mencapai batas maksimal
        }
        rekening[jumlah++] = rek; // tambahkan rekening ke array dan update jumlah
        System.out.println("[OK] Rekening " + rek.getNomorRekening() + " ditambahkan ke profil " + nama);
        return true; // berhasil tambah rekening
    }
    public Rekening getRekening(int index) { // metode untuk mendapatkan rekening berdasarkan index (1-3)
        if (index < 0 || index >= jumlah){ 
            return null; 
        } 
        return rekening[index]; // kembalikan rekening pada index yang valid
    }

    public void info() {
        System.out.println("ID      : " + id);
        System.out.println("Nama    : " + nama);
        System.out.println("Telepon : " + telepon);
        System.out.println("Rekening: " + jumlah + "/3");
        for (int i = 0; i < jumlah; i++) {
            System.out.println("[" + (i+1) + "] " + rekening[i].getNomorRekening() + " (" + rekening[i].getJenis() + ")");
        }
    }
    //getter
    public String getId()    { return id; }
    public String getNama()  { return nama; }
    public int getJumlah()   { return jumlah; }
}