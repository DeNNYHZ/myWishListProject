package me.dennyhz;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Membuat Format Rupiah
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);

        // Pendapatan
        System.out.println("Masukkan Uang Mingguan anda: ");
        double uangMingguan = input.nextDouble();

        System.out.println("Masukkan Uang Koperasi anda perbulan: ");
        double uangKoperasiPerbulan = input.nextDouble();
        double uangKoperasiPerminggu = uangKoperasiPerbulan / 4;

        // Pengeluaran
        System.out.println("Masukkan Pengeluaran Permingguan anda: ");
        double pengeluaranMingguan = input.nextDouble();

        // Perhitungan Gaji Bersih Seminggu
        double gajiBersihSeminggu = (uangMingguan + uangKoperasiPerminggu) - pengeluaranMingguan;
        System.out.println("Jadi menurut perhitungan, Gaji bersih anda selama seminggu adalah " +kursIndonesia.format((int)gajiBersihSeminggu));

        // Perhitungan Gaji Bersih Sebulan
        double gajiBersihSebulan = gajiBersihSeminggu * 4;
        System.out.println("Sedangkan sebulan anda mendapatkan " +kursIndonesia.format((int)gajiBersihSebulan));
        System.out.println();

        // Perhitungan Berapa Lama Untuk Menabung Harga Barang
        System.out.println("Masukkan Harga Barang: ");
        double hargaBarang = input.nextDouble();

        final DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Anda membutuhkan waktu selama: ");
        double perhitunganWaktu = hargaBarang / gajiBersihSebulan;
        System.out.println("Kurang lebih " +df.format(perhitunganWaktu) +" Bulan" +" atau " +df.format(perhitunganWaktu * 31) +" Hari" +" untuk membeli barang dengan harga " +kursIndonesia.format(hargaBarang));

    }
}

/*
Example :
400.000
950.000
200.000

4.500.000

 */