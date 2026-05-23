//subclass dari Rekening
public class RekeningReguler extends Rekening {
    private static final double BIAYA_ADMIN   = 2_500;
    private static final double SALDO_MINIMUM = 50_000;
    // konstruktor untuk inisialisasi rekening reguler baru
    public RekeningReguler(String nomorRekening, String namaPemilik, double setorAwal, String pin) {
        super(nomorRekening, namaPemilik, setorAwal, pin);
    }
    // implementasi metode tarik dengan aturan khusus untuk rekening reguler
    @Override
    public void tarik(double jumlah) {
        double total = jumlah + BIAYA_ADMIN;
        if (getSaldo() - total < SALDO_MINIMUM) { // cek saldo setelah ditarik + biaya admin
            System.out.println("[GAGAL] Saldo tidak cukup"); // saldo tidak cukup untuk tarik + biaya admin
            return; // batal tarik jika saldo tidak mencukupi
        }
        setSaldo(getSaldo() - total); // update saldo setelah tarik + biaya admin
        System.out.println("[INFO] Biaya admin Rp" + BIAYA_ADMIN + " dikenakan."); // info biaya admin
        getBukuMutasi().catat("TARIK", jumlah, getSaldo()); // catat mutasi tarik (jumlah tanpa biaya admin)
    }
    // implementasi metode getJenis untuk mengembalikan jenis rekening
    @Override
    public String getJenis() { return "Reguler"; }
}