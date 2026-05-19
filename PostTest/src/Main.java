public class Main {
    public static void main(String[] args){
        Mobil unit = new Mobil("Honda", "Merah", "MSN001", 3000);
        Ban[] banSet = new Ban[4];
        banSet[0] = new Ban("Bridgestone", 16);
        banSet[1] = new Ban("Bridgestone", 16);
        banSet[2] = new Ban("Bridgestone", 16);
        banSet[3] = new Ban("Bridgestone", 16);

        unit.pasangSetBan(banSet);
        unit.tampilkanSpesifikasi();

        Montir montir = new Montir("M001", "Budi");

        montir.lakukanQualityControl(unit);

        // unit = null;
    }
}
