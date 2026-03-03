/**
 * @author 12S24013 Adryan Julianto Panjaitan
 */
// src/academic/driver/Driver4.java
package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.Scanner;
import java.util.Arrays; // Untuk membantu menyalin array jika perlu memperbesar

public class Driver4 {

    // Helper method untuk memperbesar array secara manual
    // Kita akan pakai generic array, tapi Java ada batasan dengan generic array creation.
    // Jadi, kita akan buat versi khusus untuk setiap tipe atau pakai cara sederhana di main.
    // Untuk contoh ini, kita akan lakukan di main method saja biar lebih sederhana dan sesuai batasan array biasa.

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Inisialisasi array untuk setiap entitas
        int initialCapacity = 5;

        Course[] courses = new Course[initialCapacity];
        int courseCount = 0;

        Student[] students = new Student[initialCapacity];
        int studentCount = 0;

        Enrollment[] enrollments = new Enrollment[initialCapacity];
        int enrollmentCount = 0;

        System.out.println("Masukkan data (course-add, student-add, enrollment-add, atau '---' untuk berhenti):");

        while (true) {
            String line = input.nextLine();

            // Cek apakah inputnya '---' untuk berhenti
            if (line.equals("---")) {
                break;
            }

            // Pisahkan perintah dari data
            String[] lineParts = line.split("#", 2); // Split hanya pada '#' pertama
            if (lineParts.length < 2) {
                System.err.println("Error: Format input tidak valid (tidak ada data setelah perintah). Baris dilewati: " + line);
                continue; // Lanjutkan ke input berikutnya
            }

            String command = lineParts[0];
            String data = lineParts[1];

            switch (command) {
                case "course-add":
                    // Proses untuk menambah Course
                    String[] courseData = data.split("#");
                    if (courseData.length == 4) { // KodeMataKuliah#Nama#SKS#Grade (4 bagian setelah command)
                        try {
                            // Ambil Kode Mata Kuliah, Nama, SKS, dan Grade
                            // Asumsi dari contoh sebelumnya, data course adalah: NIM, CourseName, SKS, Grade
                            // Untuk course-add#12S2203#Object-oriented Programming#3#C, kita ambil:
                            // parts[0] = 12S2203 (NIM/Course ID?) -- dari contoh output, 12S2203 adalah Course ID
                            // parts[1] = Object-oriented Programming
                            // parts[2] = 3
                            // parts[3] = C
                            // Kita pakai 'nim' untuk menyimpan Course ID di Course class
                            String courseIdForCourse = courseData[0]; // Dari contoh: 12S2203
                            String courseName = courseData[1];
                            int sks = Integer.parseInt(courseData[2]);
                            String finalGrade = courseData[3];

                            Course newCourse = new Course(courseIdForCourse, courseName, sks, finalGrade);

                            if (courseCount == courses.length) {
                                int newCapacity = courses.length * 2;
                                courses = Arrays.copyOf(courses, newCapacity);
                                System.out.println("DEBUG: Array courses diperbesar menjadi " + newCapacity);
                            }
                            courses[courseCount] = newCourse;
                            courseCount++;
                        } catch (NumberFormatException e) {
                            System.err.println("Error: SKS harus berupa angka pada 'course-add'. Baris dilewati: " + line);
                        }
                    } else {
                        System.err.println("Error: Format data 'course-add' tidak sesuai. Baris dilewati: " + line);
                    }
                    break;

                case "student-add":
                    // Proses untuk menambah Student
                    String[] studentData = data.split("#");
                    if (studentData.length == 4) { // NIM#Nama#TahunMasuk#Jurusan (4 bagian)
                        try {
                            String nim = studentData[0];
                            String name = studentData[1];
                            int entryYear = Integer.parseInt(studentData[2]);
                            String major = studentData[3];

                            Student newStudent = new Student(nim, name, entryYear, major);

                            if (studentCount == students.length) {
                                int newCapacity = students.length * 2;
                                students = Arrays.copyOf(students, newCapacity);
                                System.out.println("DEBUG: Array students diperbesar menjadi " + newCapacity);
                            }
                            students[studentCount] = newStudent;
                            studentCount++;
                        } catch (NumberFormatException e) {
                            System.err.println("Error: Tahun masuk harus berupa angka pada 'student-add'. Baris dilewati: " + line);
                        }
                    } else {
                        System.err.println("Error: Format data 'student-add' tidak sesuai. Baris dilewati: " + line);
                    }
                    break;

                case "enrollment-add":
                    // Proses untuk menambah Enrollment
                    String[] enrollmentData = data.split("#");
                    if (enrollmentData.length == 4) { // CourseID#StudentID#TahunAkademik#Semester (4 bagian)
                        String courseId = enrollmentData[0];
                        String studentId = enrollmentData[1];
                        String academicYear = enrollmentData[2];
                        String semester = enrollmentData[3];

                        // Grade default 'None' karena ini hanya pendaftaran awal
                        Enrollment newEnrollment = new Enrollment(courseId, studentId, academicYear, semester);

                        if (enrollmentCount == enrollments.length) {
                            int newCapacity = enrollments.length * 2;
                            enrollments = Arrays.copyOf(enrollments, newCapacity);
                            System.out.println("DEBUG: Array enrollments diperbesar menjadi " + newCapacity);
                        }
                        enrollments[enrollmentCount] = newEnrollment;
                        enrollmentCount++;
                    } else {
                        System.err.println("Error: Format data 'enrollment-add' tidak sesuai. Baris dilewati: " + line);
                    }
                    break;

                default:
                    System.err.println("Error: Perintah tidak dikenal. Baris dilewati: " + line);
                    break;
            }
        }

        // Setelah semua input selesai, kita tampilkan hasilnya
        System.out.println("\n=== Hasil Data Mata Kuliah ===");
        if (courseCount == 0) {
            System.out.println("Tidak ada data mata kuliah yang dimasukkan.");
        } else {
            for (int i = 0; i < courseCount; i++) {
                System.out.println(courses[i].toString());
            }
        }

        System.out.println("\n=== Hasil Data Mahasiswa ===");
        if (studentCount == 0) {
            System.out.println("Tidak ada data mahasiswa yang dimasukkan.");
        } else {
            for (int i = 0; i < studentCount; i++) {
                System.out.println(students[i].toString());
            }
        }

        System.out.println("\n=== Hasil Data Pendaftaran Mata Kuliah ===");
        if (enrollmentCount == 0) {
            System.out.println("Tidak ada data pendaftaran mata kuliah yang dimasukkan.");
        } else {
            for (int i = 0; i < enrollmentCount; i++) {
                System.out.println(enrollments[i].toString());
            }
        }

        input.close();
    }
}