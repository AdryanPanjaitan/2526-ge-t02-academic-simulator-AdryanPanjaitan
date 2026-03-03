//12S24013 Adryan Julianto Panjaitan
// src/academic/model/Student.java
package academic.model;

public class Student {
    private String nim;
    private String name;
    private int entryYear; // Tahun masuk
    private String major;  // Jurusan

    // Constructor untuk membuat objek Student baru
    public Student(String nim, String name, int entryYear, String major) {
        this.nim = nim;
        this.name = name;
        this.entryYear = entryYear;
        this.major = major;
    }

    // Metode getter untuk mendapatkan NIM
    public String getNim() {
        return nim;
    }

    // Metode getter untuk mendapatkan nama
    public String getName() {
        return name;
    }

    // Metode getter untuk mendapatkan tahun masuk
    public int getEntryYear() {
        return entryYear;
    }

    // Metode getter untuk mendapatkan jurusan
    public String getMajor() {
        return major;
    }

    // Metode toString untuk format output seperti yang diminta
    @Override
    public String toString() {
        // Kita pakai pembatas '|' seperti contoh output
        return nim + "|" + name + "|" + entryYear + "|" + major;
    }
}