public class Mobil {
    String merkMobil;
    String warna;
    Mesin daftarMesin;
    Ban[] daftarBan;


    public Mobil(String merkMobil, String warna, String nomorSeri, int kapasitasCC) {
        this.merkMobil = merkMobil;
        this.warna = warna;
        this.daftarMesin = new Mesin(nomorSeri, kapasitasCC);
        this.daftarBan = new Ban[4];
    }
    public void pasangSetBan(Ban[] ban){
            if(ban.length <= 4){
                for(int i = 0; i < ban.length; i++){
                    this.daftarBan[i] = ban[i];
                }
            } else {
                System.out.println("Jumlah ban yang dipasang harus 4.");
            }

    }
    public void tampilkanSpesifikasi(){
        System.out.println("Merk Mobil: " + this.merkMobil);
        System.out.println("Warna: " + this.warna);
        System.out.println("Nomor Seri Mesin " + this.daftarMesin.nomorSeri + ", Kapasitas CC " + this.daftarMesin.kapasitasCC);
        for(int i = 0; i < this.daftarBan.length; i++){
            if(this.daftarBan[i] != null){
                System.out.println("Ban " + (i+1) + ": Merk " + this.daftarBan[i].merk + ", Ukuran Ring " + this.daftarBan[i].ukuranRing);
            }
        }
    }

}
