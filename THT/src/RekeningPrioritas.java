//subclass dari rekening untuk nasabah prioritas
public class RekeningPrioritas extends Rekening {
    private static final double MIN_TARIK     = 500_000;
    private static final double SALDO_MINIMUM = 10_000_000;
    // konstruktor untuk inisialisasi rekening prioritas baru
    public RekeningPrioritas(String nomorRekening, String namaPemilik, double setorAwal, String pin) {
        super(nomorRekening, namaPemilik, setorAwal, pin);
    }
    // implementasi metode tarik dengan aturan khusus untuk rekening prioritas
    @Override
    public void tarik(double jumlah) {
        if (jumlah < MIN_TARIK) { // cek jumlah tarik minimal untuk nasabah prioritas
            System.out.println("[GAGAL] Minimum penarikan prioritas Rp" + MIN_TARIK); // info kegagalan tarik karena jumlah di bawah minimum
            return; // batal tarik jika jumlah di bawah minimum
        }
        if (getSaldo() - jumlah < SALDO_MINIMUM) { // cek saldo setelah ditarik tidak boleh di bawah saldo minimum
            System.out.println("[GAGAL] Saldo tidak boleh di bawah Rp" + SALDO_MINIMUM); // info kegagalan tarik karena saldo setelah tarik di bawah minimum
            return;
        }
        setSaldo(getSaldo() - jumlah); // update saldo setelah tarik (bebas biaya admin untuk nasabah prioritas)
        System.out.println("[INFO] Bebas biaya admin (nasabah prioritas)."); // info bebas biaya admin
        getBukuMutasi().catat("TARIK", jumlah, getSaldo()); // catat mutasi tarik
    }
    // implementasi metode getJenis untuk mengembalikan jenis rekening
    @Override
    public String getJenis() { return "Prioritas"; }
}