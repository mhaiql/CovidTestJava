/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidtestrs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class CovidTestRS {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<Data> list = new ArrayList<>();

    public static void email(String email) {

        if (email.equals("admin")) {
        } else if (!email.equals("admin")) {
            System.out.println("Gagal login");
            System.exit(0);
        }

    }

    public static void password(String pass) {

        if (pass.equals("RSmedika")) {
            System.out.println("");
            System.out.println("--Berhasil login--");
        } else if (!pass.equals("Rsmedika")) {
            System.out.println("Gagal login");
            System.exit(0);
        }

    }

    public static void inputData() {
        String type, booking, pasien, nama, tanggal, day, month, year;
        int pilihan, harga;

        Scanner sc = new Scanner(System.in);

        System.out.println("##############################################");
        System.out.println("Menu Masukan Data");
        System.out.println("Tipe Test");
        System.out.println("1. Rapid Test (Rp 200.000)");
        System.out.println("2. Swab Test (Rp 1.000.000)");
        System.out.println("Masukan Angka Tipe Test :");
        pilihan = sc.nextInt();
        sc.nextLine();

        harga = 0;
        type = "error";
        switch (pilihan) {
            case 1:
                type = "Rapid Test";
                harga = 200000;
                break;
            case 2:
                type = "Swab Test";
                harga = 1000000;
                break;
            default:
                System.out.println("Mohon Masukan Pilihan Yang Benar");
                inputData();
                break;

        }

        System.out.println("Masukan Nomer Booking");
        booking = "BK" + sc.nextLine();

        System.out.println("Masukan Nomer Pasien");
        pasien = "PS" + sc.nextLine();

        System.out.println("Masukan Nama Pasien : ");
        nama = sc.nextLine();

        System.out.println("Masukan Tanggal Test (1 - 31)");
        day = sc.nextLine();

        System.out.println("Masukan Bulan Test (1 - 12)");
        month = sc.nextLine();

        System.out.println("Masukan Tahun Test (20xx)");
        year = sc.nextLine();

        tanggal = day + "/" + month + "/" + year;

        CovidTestRS ct = new CovidTestRS();

        ct.addValues(type, booking, pasien, nama, tanggal, harga);

    }

    class Data {

        String typeTest;
        String noBooking;
        String noPasien;
        String nama;
        String tanggal;
        int harga;

        public Data(String typeTest, String noBooking, String noPasien, String nama, String tanggal, int harga) {
            this.typeTest = typeTest;
            this.noBooking = noBooking;
            this.noPasien = noPasien;
            this.nama = nama;
            this.tanggal = tanggal;
            this.harga = harga;
        }

    }

    public void addValues(String typeTest, String noBooking, String noPasien, String nama, String tanggal, int harga) {
        list.add(new Data(typeTest, noBooking, noPasien, nama, tanggal, harga));
        printValues(list);

    }

    public void printValues(ArrayList<Data> list) {

        

            
            System.out.println("##############################################");
            System.out.println("Menu Lihat Data");

            System.out.println("No.Booking  / No.Pasien / Tipe Test / Nama  / Tanggal Test   / Harga Test (Rp)");
            
        for (int i = 0; i < list.size(); i++) {
            Data data = list.get(i);
            System.out.println(data.noBooking + "    /" + data.noPasien + "    /" + data.typeTest + "    /" + data.nama + "    /" + data.tanggal + "    /" + data.harga);

        }
            System.out.println("");
            System.out.println("");
            System.out.println("Klik Enter Untuk Kembali Ke Menu");
            String pilihan;

            Scanner sc = new Scanner(System.in);
            pilihan = sc.nextLine();

            switch (pilihan) {
                case "":
                    menuAwal();
                    break;
                default:
                    printValues(list);
            }
        
    }

    public static void menuAwal() {

        int pilihan;

        CovidTestRS ct = new CovidTestRS();
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("");
        System.out.println("#####################################################");
        System.out.println("Selamat Datang di Data Covid Test Rs Medika");
        System.out.println("Silahkan Pilih Menu Yang Tersedia");
        System.out.println("1. Masukan Data");
        System.out.println("2. Lihat Data");
        System.out.println("3. Keluar ");
        System.out.println("Masukan Angka Menu Untuk Memilih:");
        pilihan = sc.nextInt();

        switch (pilihan) {
            case 1:

                inputData();
                break;
            case 2:

                ct.printValues(list);
                break;
            case 3:
                System.exit(0);
                break;
        }
    }

    public static void main(String[] args) {
        String username, pass;

        CovidTestRS ct = new CovidTestRS();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        username = sc.nextLine();
        ct.email(username);

        System.out.print("Enter Password: ");
        pass = sc.nextLine();
        ct.password(pass);

        menuAwal();

    }

}
