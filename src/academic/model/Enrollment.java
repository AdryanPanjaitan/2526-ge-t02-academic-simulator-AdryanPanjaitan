// src/academic/model/Enrollment.java
package academic.model;

public class Enrollment {
    private String courseId;
    private String studentId;
    private String academicYear;
    private String semester;
    private String grade; // Nilai/Grade, default 'None' saat pendaftaran awal

    // Constructor untuk membuat objek Enrollment baru
    public Enrollment(String courseId, String studentId, String academicYear, String semester) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None"; // Secara default, grade adalah 'None' saat pendaftaran
    }

    // Constructor tambahan jika grade ingin langsung di-set (walaupun untuk 'enrollment' biasanya belum ada)
    public Enrollment(String courseId, String studentId, String academicYear, String semester, String grade) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = grade;
    }

    // Metode getter untuk mendapatkan Kode Mata Kuliah
    public String getCourseId() {
        return courseId;
    }

    // Metode getter untuk mendapatkan NIM Mahasiswa
    public String getStudentId() {
        return studentId;
    }

    // Metode getter untuk mendapatkan Tahun Akademik
    public String getAcademicYear() {
        return academicYear;
    }

    // Metode getter untuk mendapatkan Semester
    public String getSemester() {
        return semester;
    }

    // Metode getter untuk mendapatkan Grade
    public String getGrade() {
        return grade;
    }

    // Metode setter untuk mengubah Grade (jika nanti ada update nilai)
    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Metode toString untuk format output seperti yang diminta
    @Override
    public String toString() {
        // Kita pakai pembatas '|' seperti contoh output
        return courseId + "|" + studentId + "|" + academicYear + "|" + semester + "|" + grade;
    }
}