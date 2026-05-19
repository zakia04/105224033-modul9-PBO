public class Main {
    public static void main(String[] args) {
        Dokter dr1 = new Dokter("Tirta", "Cardiologist");
        Dokter dr2 = new Dokter("Gia", "Umum");
        Pasien ps1 = new Pasien("Budi", 30);
        Pasien ps2 = new Pasien("Siti", 25);

        dr1.rekamJejak(ps1);

        RumahSakit rsSehatSelalu = new RumahSakit();
        rsSehatSelalu.addDokter(dr1);
        rsSehatSelalu.addDokter(dr2);
        rsSehatSelalu.infoRuangan();
        rsSehatSelalu.infoDokter();

        rsSehatSelalu = null;

    
    }
}
