public class Dokter {
    String nama;
    String spesialis;

    public Dokter(String nama, String spesialis) {
        this.nama = nama;
        this.spesialis = spesialis;
    }

    public void rekamJejak(Pasien pasien){
        System.out.println("Dokter " + nama + " adalah seorang spesialis " + spesialis + " yang memeriksa pasien " + pasien.nama + " yang berumur " + pasien.umur + " tahun.");
    }
}
