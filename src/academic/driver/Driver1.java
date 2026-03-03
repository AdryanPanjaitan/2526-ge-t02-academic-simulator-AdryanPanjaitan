package academic.driver;

/**
 * @author 12s24013 Adryan Julianto Panjaitan
 * @author 12S24013 Adryan Julianto Panjaitan
 */  

// File: academic/driver/Driver1.java

import academic.model.Course; // Mengimpor kelas Course dari paket academic.model
import java.util.Scanner;    // Mengimpor kelas Scanner untuk membaca input pengguna

public class Driver1 {
    // Array untuk menyimpan objek-objek Course.
    // Ukuran awal bisa diperkirakan atau menggunakan ArrayList jika jumlahnya tidak pasti.
    // Untuk contoh ini, kita asumsikan maksimal 100 course, Anda bisa menyesuaikannya.
    private static Course[] courses = new Course[100];
    private static int courseCount = 0; // Menghitung jumlah course yang sudah disimpan

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk membaca input dari konsol
        String line; // Variabel untuk menyimpan setiap baris input

        // Loop untuk membaca input baris demi baris hingga pengguna mengetik "---"
        while (scanner.hasNextLine()) { // Memeriksa apakah ada baris input berikutnya
            line = scanner.nextLine(); // Membaca satu baris input

            if (line.equals("---")) { // Jika baris input adalah "---", hentikan proses input
                break;
            }

            // Memisahkan string input berdasarkan karakter "#"
            // Contoh input: 12S2203#Object-oriented Programming#3#C
            String[] parts = line.split("#"); 

            // Memastikan input memiliki 4 bagian yang diharapkan (code, name, credits, grade)
            if (parts.length == 4) {
                String code = parts[0];
                String name = parts[1];
                int credits = Integer.parseInt(parts[2]); // Mengubah string SKS menjadi integer
                String grade = parts[3];

                // Membuat objek Course baru dan menyimpannya ke dalam array
                if (courseCount < courses.length) { // Memastikan array tidak penuh
                    courses[courseCount] = new Course(code, name, credits, grade);
                    courseCount++; // Menambah hitungan course
                } else {
                    System.err.println("Penyimpanan penuh, tidak bisa menambah course baru.");
                }
            } else {
                System.err.println("Format input tidak valid: " + line);
            }
        }

        // Setelah semua input diproses, tampilkan semua course yang telah disimpan
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i].toString()); // Memanggil toString() untuk format output yang diinginkan
        }

        scanner.close(); // Menutup objek Scanner untuk mencegah kebocoran sumber daya
    }
}