package academic.driver;

/**
 * @author 12S24013 Adryan Julianto Panjaitan
 * @author 12S24012 Adryan Julianto Panjaitan
 */


import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver4 {
    // Menggunakan ArrayList untuk menyimpan setiap jenis entitas
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Enrollment> enrollments = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        // --- Bagian 1: Memproses Input ---
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();

            if (line.equals("---")) {
                break; // Hentikan input jika bertemu "---"
            }

            // Pisahkan perintah dari sisa data
            String[] segments = line.split("#");
            if (segments.length < 1) {
                System.err.println("Input tidak valid: " + line);
                continue; // Lanjutkan ke baris berikutnya
            }

            String command = segments[0]; // Perintah seperti "course-add", "student-add", "enrollment-add"
            
            // Mengambil sisa data setelah perintah
            String[] dataParts = new String[segments.length - 1];
            System.arraycopy(segments, 1, dataParts, 0, segments.length - 1);

            switch (command) {
                case "course-add":
                    // Format: course-add#CODE#NAME#CREDITS#GRADE
                    if (dataParts.length == 4) {
                        String code = dataParts[0];
                        String name = dataParts[1];
                        int credits = Integer.parseInt(dataParts[2]);
                        String grade = dataParts[3];
                        courses.add(new Course(code, name, credits, grade));
                    } else {
                        System.err.println("Format input course-add tidak valid: " + line);
                    }
                    break;
                case "student-add":
                    // Format: student-add#NIM#NAME#ENTRANCE_YEAR#STUDY_PROGRAM
                    if (dataParts.length == 4) {
                        String nim = dataParts[0];
                        String name = dataParts[1];
                        int entranceYear = Integer.parseInt(dataParts[2]);
                        String studyProgram = dataParts[3];
                        students.add(new Student(nim, name, entranceYear, studyProgram));
                    } else {
                        System.err.println("Format input student-add tidak valid: " + line);
                    }
                    break;
                case "enrollment-add":
                    // Format: enrollment-add#COURSE_CODE#STUDENT_NIM#ACADEMIC_YEAR#SEMESTER
                    // Grade akan default "None" oleh konstruktor Enrollment
                    if (dataParts.length == 4) {
                        String courseCode = dataParts[0];
                        String studentNim = dataParts[1];
                        String academicYear = dataParts[2];
                        String semester = dataParts[3];
                        enrollments.add(new Enrollment(courseCode, studentNim, academicYear, semester));
                    } else {
                        System.err.println("Format input enrollment-add tidak valid: " + line);
                    }
                    break;
                default:
                    System.err.println("Perintah tidak dikenal: " + command);
                    break;
            }
        }

        // --- Bagian 2: Menampilkan Output sesuai Urutan ---
        // 1. Tampilkan Course
        for (Course course : courses) {
            System.out.println(course.toString());
        }

        // 2. Tampilkan Student
        for (Student student : students) {
            System.out.println(student.toString());
        }

        // 3. Tampilkan Enrollment
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString());
        }

        scanner.close(); // Tutup scanner
    }
}