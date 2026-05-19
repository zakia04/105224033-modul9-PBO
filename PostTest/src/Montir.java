public class Montir {
    String idMontir;
    String nama;
    public Montir(String idMontir, String nama) {
        this.idMontir = idMontir;
        this.nama = nama;
    }
    public void lakukanQualityControl(Mobil m){
        System.out.println("Montir " + this.nama + " sedang melakukan quality control pada mobil " + m.merkMobil);
    }    



}
