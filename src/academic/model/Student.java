package academic.model;

/**
 * @author 12S24013 Adryan Julianto Panjaitan
 * @author 12S24013 Adryan Julianto Panjaitan
 */

public class Student {
    private String nim;
    private String name;
    private int entranceYear; // Angkatan
    private String studyProgram; // Program Studi

    // Constructor untuk inisialisasi objek Student
    public Student(String nim, String name, int entranceYear, String studyProgram) {
        this.nim = nim;
        this.name = name;
        this.entranceYear = entranceYear;
        this.studyProgram = studyProgram;
    }

    // --- Getters untuk mengakses data Student ---
    public String getNim() {
        return nim;
    }

    public String getName() {
        return name;
    }

    public int getEntranceYear() {
        return entranceYear;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    // Method untuk mengubah representasi objek Student menjadi string sesuai format output
    @Override
    public String toString() {
        return nim + "|" + name + "|" + entranceYear + "|" + studyProgram;
    }
}