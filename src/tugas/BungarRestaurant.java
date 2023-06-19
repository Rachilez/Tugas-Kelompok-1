package tugas;

import java.time.LocalDateTime;
import java.text.DecimalFormat;
import java.util.Scanner;

public class BungarRestaurant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        // Menampilkan salam sesuai waktu
        LocalDateTime currentTime = LocalDateTime.now();
        String greeting = getGreeting(currentTime);
        System.out.println("\nSelamat " + greeting);

        System.out.println();
        System.out.print("Pesanan untuk berapa orang: ");
        int numberOfPeople = scanner.nextInt();

        System.out.print("Pesanan atas nama: ");
        scanner.nextLine(); // Membuang karakter newline setelah input angka
        scanner.nextLine();

        System.out.println();
        System.out.println("Menu spesial hari ini");
        System.out.println("=====================\n");

        // Menampilkan menu makanan
        showMenu();

        System.out.println();
        System.out.println("Pesanan Anda [Batas pesanan 0 - 10 porsi]:\n");

        // Mengambil pesanan untuk setiap menu
        int[] quantities = new int[5]; // Array untuk menyimpan jumlah pesanan masing-masing menu

        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + ".\t" + getMenuName(i) + "\t\t= ");
            quantities[i] = scanner.nextInt();
            quantities[i] = Math.min(quantities[i], numberOfPeople); // Membatasi pesanan maksimal sesuai jumlah orang
        }

        // Menampilkan ringkasan pesanan
        System.out.println();
        System.out.println("Selamat meniktmati makanan anda...\n");
        System.out.println("Pembelian : \n");

        double totalSemuaHarga = 0.0; // Variabel untuk menyimpan total harga semua pesanan

        double totalHarga = 0;
        for (int i = 0; i < 5; i++) {
            if (quantities[i] > 0) {
                totalHarga = quantities[i] * getMenuPrice(i);
                totalSemuaHarga += totalHarga; // Menambahkan total harga pesanan saat ini ke totalSemuaHarga
                System.out.println((i + 1) + ".\t" + getMenuName(i) + "\t" + quantities[i] + " Porsi * Rp. "
                        + getMenuPrice(i) + "\t= Rp. " + decimalFormat.format(totalHarga));
            }
        }

        System.out.println("============================================================================= +");

        System.out.println("Total Pembelian \t\t\t\t\t= Rp. " + decimalFormat.format(totalSemuaHarga));
        System.out.println("Disc.10% <masa promosi>\t\t\t\t\t= Rp. " + decimalFormat.format(totalSemuaHarga * 0.1));

        System.out.println("============================================================================= -");
        System.out.println("Total Pembelian setelah disc.10%\t\t\t= Rp. " + decimalFormat.format(totalSemuaHarga - (totalSemuaHarga * 0.1)));
        System.out.println("Pembelian per orang (untuk " + numberOfPeople + " orang)\t\t\t= Rp. " + decimalFormat.format((totalSemuaHarga - (totalSemuaHarga * 0.1))/numberOfPeople));
        System.out.println("\n");
        System.out.println("\t\t\t" + "Terima kasih atas kunjungan anda...");
        System.out.println("\t\t\t" + "....tekan ENTER untuk keluar...");
        scanner.nextLine(); // Menunggu pengguna menekan tombol ENTER untuk keluar
        scanner.close();

    }

    // Mendapatkan salam berdasarkan waktu saat ini
    public static String getGreeting(LocalDateTime time) {
        int hour = time.getHour();

        if (hour >= 5 && hour < 12) {
            return "Pagi";
        } else if (hour >= 12 && hour < 15) {
            return "Siang";
        } else if (hour >= 15 && hour < 18) {
            return "Sore";
        } else {
            return "Malam";
        }
    }

    // Menampilkan menu makanan
    public static void showMenu() {
        System.out.println("1.\tNasi Goreng Spesial\t\t@ Rp. 9999.99");
        System.out.println("2.\tAyam Bakar Spesial\t\t@ Rp. 12345.67");
        System.out.println("3.\tSteak Sirloin Spesial\t\t@ Rp. 21108.40");
        System.out.println("4.\tKwetiaw Siram Spesial\t\t@ Rp. 13579.13");
        System.out.println("5.\tKambing Guling Spesial\t\t@ Rp. 98765.43");
    }

    // Mendapatkan nama menu berdasarkan indeks
    public static String getMenuName(int index) {
        String[] menuNames = {
                "Nasi Goreng Spesial",
                "Ayam Bakar Spesial",
                "Steak Sirloin Spesial",
                "Kwetiaw Siram Spesial",
                "Kambing Guling Spesial"
        };

        return menuNames[index];
    }

    // Mendapatkan harga menu berdasarkan indeks
    public static double getMenuPrice(int index) {

        double[] menuPrices = {
                9999.99,
                12345.67,
                21108.40,
                13579.13,
                98765.43,
        };

        return menuPrices[index];
    }
}