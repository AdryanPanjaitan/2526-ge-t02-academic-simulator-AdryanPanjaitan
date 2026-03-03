package academic.driver;

/**
 * @author 12S24013 Adryan Julianto Panjaitan
 * @author 12S24013 Adryan Julianto Panjaitan
 */

import academic.model.Enrollment; // Mengimpor kelas Enrollment dari paket academic.model
import java.util.Scanner;        // Mengimpor kelas Scanner untuk membaca input pengguna
import java.util.ArrayList;      // Mengimpor kelas ArrayList karena jumlah enrollment tidak pasti

public class Driver3 {
    // Menggunakan ArrayList untuk menyimpan objek-objek Enrollment.
    private static ArrayList<Enrollment> enrollments = new ArrayList<>();

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
            // Contoh input: 12S2203#12S20999#2021/2022#even
            String[] parts = line.split("#"); 

            // Memastikan input memiliki 4 bagian yang diharapkan (courseCode, studentNim, academicYear, semester)
            if (parts.length == 4) {
                String courseCode = parts[0];
                String studentNim = parts[1];
                String academicYear = parts[2];
                String semester = parts[3];

                // Membuat objek Enrollment baru dan menambahkannya ke ArrayList
                // Grade secara otomatis akan menjadi "None" karena default di konstruktor Enrollment
                enrollments.add(new Enrollment(courseCode, studentNim, academicYear, semester));
            } else {
                System.err.println("Format input tidak valid: " + line);
            }
        }

        // Setelah semua input diproses, tampilkan semua enrollment yang telah disimpan
        for (Enrollment enrollment : enrollments) { // Menggunakan enhanced for loop untuk iterasi ArrayList
            System.out.println(enrollment.toString()); // Memanggil toString() untuk format output yang diinginkan
        }

        scanner.close(); // Menutup objek Scanner untuk mencegah kebocoran sumber daya
    }
}