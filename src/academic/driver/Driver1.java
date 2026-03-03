// src/academic/driver/Driver1.java
package academic.driver;

import academic.model.Course;
import java.util.Scanner;
import java.util.Arrays; // Untuk membantu menyalin array jika kita perlu memperbesar

public class Driver1 {

    public static void main(String[] args) {
        // Kita pakai Scanner untuk membaca input dari keyboard
        Scanner input = new Scanner(System.in);

        // Karena harus pakai array dan kita tidak tahu berapa banyak data,
        // kita mulai dengan array ukuran kecil dan akan memperbesar jika penuh.
        // Ini mirip konsep ArrayList tapi kita implementasi manual.
        int initialCapacity = 5; // Kapasitas awal array
        Course[] courses = new Course[initialCapacity];
        int courseCount = 0; // Untuk melacak berapa banyak objek Course di dalam array

        System.out.println("Masukkan data mata kuliah (ketik '---' untuk berhenti):");

        while (true) {
            String line = input.nextLine();

            // Cek apakah inputnya '---' untuk berhenti
            if (line.equals("---")) {
                break; // Keluar dari loop
            }

            // Asumsi format input: Course#NIM#NamaMataKuliah#SKS#Grade
            // Contoh: Course#Kode001#Dasar Pemrograman#3#A
            if (line.startsWith("Course#")) {
                String[] parts = line.split("#");

                // Kita harus pastikan ada cukup bagian setelah split
                if (parts.length == 5) {
                    try {
                        // Ambil NIM, Nama Mata Kuliah, SKS, dan Grade
                        String nim = parts[1]; // Kode001 diasumsikan NIM
                        String courseName = parts[2];
                        int sks = Integer.parseInt(parts[3]);
                        String finalGrade = parts[4];

                        // Buat objek Course baru
                        Course newCourse = new Course(nim, courseName, sks, finalGrade);

                        // Cek apakah array sudah penuh. Jika ya, kita perlu memperbesar array.
                        if (courseCount == courses.length) {
                            // Ini cara manual memperbesar array
                            int newCapacity = courses.length * 2;
                            courses = Arrays.copyOf(courses, newCapacity);
                            System.out.println("DEBUG: Array diperbesar menjadi " + newCapacity); // Untuk mahasiswa, biar tahu prosesnya
                        }

                        // Tambahkan objek Course ke dalam array
                        courses[courseCount] = newCourse;
                        courseCount++;
                    } catch (NumberFormatException e) {
                        System.err.println("Error: SKS harus berupa angka. Baris dilewati: " + line);
                    }
                } else {
                    System.err.println("Error: Format input tidak sesuai. Baris dilewati: " + line);
                }
            } else {
                System.err.println("Error: Input tidak diawali 'Course#'. Baris dilewati: " + line);
            }
        }

        // Setelah semua input selesai, kita tampilkan hasilnya
        System.out.println("\n=== Hasil Data Mata Kuliah ===");
        if (courseCount == 0) {
            System.out.println("Tidak ada data mata kuliah yang dimasukkan.");
        } else {
            // Kita cuma loop sebanyak data yang benar-benar ada (courseCount)
            for (int i = 0; i < courseCount; i++) {
                System.out.println(courses[i].toString()); // toString() sudah disesuaikan dengan format '|'
            }
        }

        input.close(); // Penting: Jangan lupa tutup Scanner-nya
    }
}