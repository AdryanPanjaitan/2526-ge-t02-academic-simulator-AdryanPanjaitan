package academic.model;

/**
 * @author 12S24013 Adryan Julianto Panjaitan
 * @author 12S24013 Adryan Julianto Panjaitan
 */

public class Enrollment {
    private String courseCode;
    private String studentNim;
    private String academicYear; // Tahun Ajaran, contoh: 2021/2022
    private String semester;     // Semester, contoh: even, odd
    private String grade;        // Grade, default "None" jika belum ada

    // Constructor untuk inisialisasi objek Enrollment
    // Grade diinisialisasi sebagai "None" secara default
    public Enrollment(String courseCode, String studentNim, String academicYear, String semester) {
        this.courseCode = courseCode;
        this.studentNim = studentNim;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None"; // Grade default sesuai permintaan output
    }

    // --- Getters untuk mengakses data Enrollment ---
    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentNim() {
        return studentNim;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getSemester() {
        return semester;
    }

    public String getGrade() {
        return grade;
    }

    // Method untuk mengubah representasi objek Enrollment menjadi string sesuai format output
    @Override
    public String toString() {
        return courseCode + "|" + studentNim + "|" + academicYear + "|" + semester + "|" + grade;
    }
}