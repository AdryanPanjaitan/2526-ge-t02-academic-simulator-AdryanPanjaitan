package academic.model;

/**
 * @author 12S24013 Adryan Julianto Panjaitan
 * @author 12S24013 Adryan Julianto Panjaitan
 */

public class Course {
    private String code;
    private String name;
    private int credits;
    private String grade; // grade bisa berupa A, B, C, D, E, atau F

    // Constructor untuk inisialisasi objek Course
    public Course(String code, String name, int credits, String grade) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    // --- Getters untuk mengakses data Course ---
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getGrade() {
        return grade;
    }

    // Method untuk mengubah representasi objek Course menjadi string sesuai format output
    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + grade;
    }
}