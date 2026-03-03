/**
 * @author 12S24013-Adryan Julianto Panjaitan
 */
// src/academic/driver/Driver3.java
package academic.driver;

import academic.model.Enrollment;
import java.util.Scanner;
import java.util.Arrays; // Untuk membantu menyalin array jika perlu memperbesar

public class Driver3 {

    public static void main(String[] args) {
        // Kita pakai Scanner untuk membaca input dari keyboard
        Scanner input = new Scanner(System.in);

        // Sama seperti sebelumnya, kita pakai array dan perbesar manual jika penuh
        int initialCapacity = 5; // Kapasitas awal array
        Enrollment[] enrollments = new Enrollment[initialCapacity];
        int enrollmentCount = 0; // Untuk melacak berapa banyak objek Enrollment di dalam array

        System.out.println("Masukkan data pendaftaran mata kuliah (ketik '---' untuk berhenti):");

        while (true) {
            String line = input.nextLine();

            // Cek apakah inputnya '---' untuk berhenti
            if (line.equals("---")) {
                break; // Keluar dari loop
            }

            // Asumsi format input: CourseID#StudentID#TahunAkademik#Semester
            // Contoh: 12S2203#12S20999#2021/2022#even
            String[] parts = line.split("#");

            // Pastikan ada 4 bagian setelah split
            if (parts.length == 4) {
                // Ambil Course ID, Student ID, Tahun Akademik, dan Semester
                String courseId = parts[0];
                String studentId = parts[1];
                String academicYear = parts[2];
                String semester = parts[3];

                // Buat objek Enrollment baru (grade akan otomatis 'None')
                Enrollment newEnrollment = new Enrollment(courseId, studentId, academicYear, semester);

                // Cek apakah array sudah penuh. Jika ya, kita perlu memperbesar array.
                if (enrollmentCount == enrollments.length) {
                    int newCapacity = enrollments.length * 2;
                    enrollments = Arrays.copyOf(enrollments, newCapacity);
                    System.out.println("DEBUG: Array enrollment diperbesar menjadi " + newCapacity); // Untuk mahasiswa, biar tahu prosesnya
                }

                // Tambahkan objek Enrollment ke dalam array
                enrollments[enrollmentCount] = newEnrollment;
                enrollmentCount++;
            } else {
                System.err.println("Error: Format input tidak sesuai. Baris dilewati: " + line);
            }
        }

        // Setelah semua input selesai, kita tampilkan hasilnya
        System.out.println("\n=== Hasil Data Pendaftaran Mata Kuliah ===");
        if (enrollmentCount == 0) {
            System.out.println("Tidak ada data pendaftaran mata kuliah yang dimasukkan.");
        } else {
            // Kita cuma loop sebanyak data yang benar-benar ada (enrollmentCount)
            for (int i = 0; i < enrollmentCount; i++) {
                System.out.println(enrollments[i].toString()); // toString() sudah disesuaikan dengan format '|'
            }
        }

        input.close(); // Jangan lupa tutup Scanner-nya
    }
}