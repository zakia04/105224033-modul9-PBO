import java.util.Scanner; // untuk input dari user
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Scanner untuk input user di console
        CustomerService CSNeo = new CustomerService("Zakia");

        Nasabah nasabahAktif = null;
        Rekening dataPusatRekening1 = null;

        boolean berjalan = true;
        while (berjalan) {
            System.out.println("\n== MENU UTAMA ==");
            System.out.println("1. Registrasi Profil Nasabah");
            System.out.println("2. Buka Rekening Baru");
            System.out.println("3. Simulasi Login & Transaksi");
            System.out.println("4. Hubungi Customer Service");
            System.out.println("5. Keluar & Simulasi Penghancuran Akun Paksa");
            System.out.print("Pilih opsi: ");
            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama Nasabah: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan NIK Nasabah: ");
                    String nik = input.nextLine();
                    nasabahAktif = new Nasabah(nik, nama, "");
                    System.out.println("Profil Nasabah Berhasil Dibuat!");
                    break;

                case 2:
                    if (nasabahAktif == null) {
                        System.out.println("Silakan registrasi nasabah terlebih dahulu di Menu 1.");
                        break;
                    }
                    System.out.print("Masukkan Nomor Rekening Baru: ");
                    String noRek = input.nextLine();
                    System.out.print("Masukkan PIN Akun: ");
                    String pin = input.nextLine();
                    System.out.print("Masukkan Setoran Awal: Rp");
                    double saldoAwal = input.nextDouble();
                    System.out.println("1. Reguler (Biaya Admin Rp2.500)");
                    System.out.println("2. Prioritas (Bebas Admin, Min Tarik Rp500.000)");
                    System.out.print("Pilih Jenis Rekening: ");
                    int jenis = input.nextInt();
                    input.nextLine();

                    Rekening rekBaru = null;
                    if (jenis == 1) {
                        rekBaru = new RekeningReguler(noRek, nasabahAktif.getNama(), saldoAwal, pin);
                    } else if (jenis == 2) {
                        rekBaru = new RekeningPrioritas(noRek, nasabahAktif.getNama(), saldoAwal, pin);
                    }

                    if (rekBaru != null) {
                        nasabahAktif.tambahRekening(rekBaru);
                        if (dataPusatRekening1 == null) {
                            dataPusatRekening1 = rekBaru;
                        }
                    }
                    break;

                case 3:
                    if (nasabahAktif == null) {
                        System.out.println("Silakan registrasi nasabah terlebih dahulu di Menu 1.");
                        break;
                    }
                    System.out.print("Masukkan Nomor Rekening Anda: ");
                    int cariNo = input.nextInt();
                    input.nextLine();
                    Rekening rekTujuan = nasabahAktif.getRekening(cariNo);

                    if (rekTujuan != null) {
                        System.out.print("Masukkan PIN Anda: ");
                        String inputPin = input.nextLine();

                        if (rekTujuan.verifikasiPIN(inputPin)) {
                            System.out.println("Login Rekening Berhasil!");
                            System.out.println("1. Setor Tunai");
                            System.out.println("2. Tarik Tunai");
                            int aksi = input.nextInt();
                            input.nextLine();

                            if (aksi == 1) {
                                System.out.print("Nominal Setor: Rp");
                                double nominal = input.nextDouble();
                                rekTujuan.setor(nominal);
                            } else if (aksi == 2) {
                                System.out.print("Nominal Tarik: Rp");
                                double nominal = input.nextDouble();
                                rekTujuan.tarik(nominal);
                            }
                            input.nextLine();
                        } else {
                            System.out.println("Otorisasi Gagal: PIN Salah!");
                        }
                    } else {
                        System.out.println("Rekening tidak ditemukan pada profil nasabah ini.");
                    }
                    break;

                case 4:
                    if (nasabahAktif == null) {
                        System.out.println("Silakan registrasi nasabah terlebih dahulu di Menu 1.");
                        break;
                    }
                    System.out.print("Tuliskan keluhan Anda ke CS: ");
                    String keluhan = input.nextLine();
                    CSNeo.terimaKeluhan(nasabahAktif, keluhan);
                    break;

                case 5:
                    berjalan = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        // Skenario Penutupan Akun Paksa
        nasabahAktif = null;
        System.out.println("Variabel 'nasabahAktif' telah di-set menjadi null.");

        if (dataPusatRekening1 != null) {
            System.out.println("Meskipun profil nasabah telah dihapus, rekening nomor "
                    + dataPusatRekening1.getNomorRekening() + " tetap eksis di bank data pusat!");
            System.out.println("Saldo aman tersimpan sebesar: Rp" + (long) dataPusatRekening1.getSaldo());
        }

        input.close();
    }
}