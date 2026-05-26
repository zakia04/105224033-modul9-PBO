import java.util.Scanner; // untuk input dari user
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Scanner untuk input user di console
        CustomerService CSNeo = new CustomerService("Zakia");
        Nasabah nasabahAktif = null; // Variabel untuk menyimpan profil nasabah yang sedang aktif
        Rekening dataPusatRekening1 = null; // Variabel untuk menyimpan data rekening di pusat data bank

        boolean berjalan = true; // Flag untuk menjalankan loop menu utama
        //loop menu
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
                    System.out.print("Masukkan Nama Nasabah: "); // Input nama nasabah
                    String nama = input.nextLine();
                    System.out.print("Masukkan NIK Nasabah: "); // Input NIK nasabah
                    String nik = input.nextLine();
                    nasabahAktif = new Nasabah(nik, nama, ""); //buat objek nasabah 
                    System.out.println("Profil Nasabah Berhasil Dibuat!");
                    break;

                case 2:
                    if (nasabahAktif == null) { //cek apakah nasabah sudah terdaftar
                        System.out.println("Silakan registrasi nasabah terlebih dahulu di Menu 1.");
                        break;
                    }
                    System.out.print("Masukkan Nomor Rekening Baru: "); //input nomor rekening baru
                    String noRek = input.nextLine();
                    System.out.print("Masukkan PIN Akun: "); //input PIN untuk rekening baru
                    String pin = input.nextLine();
                    System.out.print("Masukkan Setoran Awal: Rp"); //input setoran awal untuk rekening baru
                    double saldoAwal = input.nextDouble();
                    System.out.println("1. Reguler (Biaya Admin Rp2.500)");
                    System.out.println("2. Prioritas (Bebas Admin, Min Tarik Rp500.000)");
                    System.out.print("Pilih Jenis Rekening: ");
                    int jenis = input.nextInt();
                    input.nextLine();

                    Rekening rekBaru = null; // Variabel untuk menyimpan objek rekening baru yang akan dibuat
                    if (jenis == 1) { //jika jenis rekening yang dipilih adalah reguler, maka buat objek RekeningReguler
                        rekBaru = new RekeningReguler(noRek, nasabahAktif.getNama(), saldoAwal, pin);
                    } else if (jenis == 2) { //jika jenis rekening yang dipilih adalah prioritas, maka buat objek RekeningPrioritas
                        rekBaru = new RekeningPrioritas(noRek, nasabahAktif.getNama(), saldoAwal, pin);
                    }

                    if (rekBaru != null) { //jika objek rekening baru berhasil dibuat, maka tambahkan ke profil nasabah aktif dan simpan di pusat data bank jika belum ada
                        nasabahAktif.tambahRekening(rekBaru);//tambahkan rekening baru ke profil nasabah aktif
                        if (dataPusatRekening1 == null) { //jika belum ada rekening yang disimpan di pusat data bank, maka simpan rekening baru ini sebagai data pusat
                            dataPusatRekening1 = rekBaru;
                        }
                    }
                    break;

                case 3:
                    if (nasabahAktif == null) { //cek apakah nasabah sudah terdaftar
                        System.out.println("Silakan registrasi nasabah terlebih dahulu di Menu 1.");
                        break;
                    }
                    System.out.print("Masukkan Nomor Rekening Anda: "); //input nomor rekening untuk login
                    int cariNo = input.nextInt();
                    input.nextLine();
                    Rekening rekTujuan = nasabahAktif.getRekening(cariNo); //cari objek rekening di profil nasabah aktif berdasarkan nomor rekening yang diinputkan

                    if (rekTujuan != null) { 
                        System.out.print("Masukkan PIN Anda: "); //input PIN untuk verifikasi login rekening
                        String inputPin = input.nextLine();

                        if (rekTujuan.verifikasiPIN(inputPin)) { //jika PIN yang diinputkan benar, maka login berhasil dan tampilkan menu transaksi
                            System.out.println("Login Rekening Berhasil!");
                            System.out.println("1. Setor Tunai");
                            System.out.println("2. Tarik Tunai");
                            int aksi = input.nextInt();
                            input.nextLine();

                            if (aksi == 1) { //jika memilih aksi setor tunai, maka input nominal setor dan panggil method setor pada objek rekening tujuan
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
                    if (nasabahAktif == null) { //cek apakah nasabah sudah terdaftar
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