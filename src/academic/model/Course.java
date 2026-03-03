//12S24013-Adryan Julianto Panjaitan
// src/academic/model/Course.java
package academic.model;

public class Course {
    private String nim; // Atribut untuk menyimpan NIM mahasiswa
    private String courseName; // Atribut untuk menyimpan nama mata kuliah
    private int sks; // Atribut untuk menyimpan jumlah SKS
    private String finalGrade; // Atribut untuk menyimpan hasil akhir (grade)

    // Ini adalah constructor untuk membuat objek Course baru dengan semua atribut yang diperlukan
    public Course(String nim, String courseName, int sks, String finalGrade) {
        this.nim = nim;
        this.courseName = courseName;
        this.sks = sks;
        this.finalGrade = finalGrade;
    }

    // Ini adalah metode getter untuk mendapatkan NIM
    public String getNim() {
        return nim;
    }

    // Ini adalah metode getter untuk mendapatkan nama mata kuliah
    public String getCourseName() {
        return courseName;
    }

    // Ini adalah metode getter untuk mendapatkan SKS
    public int getSks() {
        return sks;
    }

    // Ini adalah metode getter untuk mendapatkan hasil akhir (grade)
    public String getFinalGrade() {
        return finalGrade;
    }

    // Metode toString ini penting untuk menampilkan output sesuai format yang diminta
    @Override
    public String toString() {
        // Kita pakai pembatas '|' seperti yang sudah disepakati untuk output
        return nim + "|" + courseName + "|" + sks + "|" + finalGrade;
    }
}