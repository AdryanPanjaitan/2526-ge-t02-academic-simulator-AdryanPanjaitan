/**
 * @author 12S24013-Adryan Julianto Panjaitan
 */
// src/academic/driver/Driver2.java
package academic.driver;

import academic.model.Student;
import java.util.Scanner;
import java.util.Arrays; // Untuk membantu menyalin array jika perlu memperbesar

public class Driver2 {

    public static void main(String[] args) {
        // Kita pakai Scanner untuk membaca input dari keyboard
        Scanner input = new Scanner(System.in);

        // Sama seperti sebelumnya, kita pakai array dan perbesar manual jika penuh
        int initialCapacity = 5; // Kapasitas awal array
        Student[] students = new Student[initialCapacity];
        int studentCount = 0; // Untuk melacak berapa banyak objek Student di dalam array

        System.out.println("Masukkan data mahasiswa (ketik '---' untuk berhenti):");

        while (true) {
            String line = input.nextLine();

            // Cek apakah inputnya '---' untuk berhenti
            if (line.equals("---")) {
                break; // Keluar dari loop
            }

            // Asumsi format input: NIM#Nama#TahunMasuk#Jurusan
            // Contoh: 12S20111#Jaka Sembung#2019#Information Systems
            String[] parts = line.split("#");

            // Pastikan ada 4 bagian setelah split
            if (parts.length == 4) {
                try {
                    // Ambil NIM, Nama, Tahun Masuk, dan Jurusan
                    String nim = parts[0];
                    String name = parts[1];
                    int entryYear = Integer.parseInt(parts[2]); // Tahun masuk harus angka
                    String major = parts[3];

                    // Buat objek Student baru
                    Student newStudent = new Student(nim, name, entryYear, major);

                    // Cek apakah array sudah penuh. Jika ya, kita perlu memperbesar array.
                    if (studentCount == students.length) {
                        int newCapacity = students.length * 2;
                        students = Arrays.copyOf(students, newCapacity);
                        System.out.println("DEBUG: Array mahasiswa diperbesar menjadi " + newCapacity); // Untuk mahasiswa, biar tahu prosesnya
                    }

                    // Tambahkan objek Student ke dalam array
                    students[studentCount] = newStudent;
                    studentCount++;
                } catch (NumberFormatException e) {
                    System.err.println("Error: Tahun masuk harus berupa angka. Baris dilewati: " + line);
                }
            } else {
                System.err.println("Error: Format input tidak sesuai. Baris dilewati: " + line);
            }
        }

        // Setelah semua input selesai, kita tampilkan hasilnya
        System.out.println("\n=== Hasil Data Mahasiswa ===");
        if (studentCount == 0) {
            System.out.println("Tidak ada data mahasiswa yang dimasukkan.");
        } else {
            // Kita cuma loop sebanyak data yang benar-benar ada (studentCount)
            for (int i = 0; i < studentCount; i++) {
                System.out.println(students[i].toString()); // toString() sudah disesuaikan dengan format '|'
            }
        }

        input.close(); // Jangan lupa tutup Scanner-nya
    }
}