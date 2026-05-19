class RumahSakit {
    final Ruangan[] daftarRuangan;
    Dokter[] daftarDokter;

    public RumahSakit() {
        this.daftarRuangan = new Ruangan[2];
        this.daftarRuangan[0] = new Ruangan("R001", 10);
        this.daftarRuangan[1] = new Ruangan("R002", 15);
    }

    public void infoRuangan(){
        for (int i = 0; i < daftarRuangan.length; i++) {
            System.out.println("Ruangan " + daftarRuangan[i].noReg + " memiliki kapasitas " + daftarRuangan[i].kapasitas + " pasien.");
        }
    }

    public void addDokter(Dokter dr){
        this.daftarDokter = new Dokter[];
    }
    

}
