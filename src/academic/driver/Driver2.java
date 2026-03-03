package academic.driver;

/**
 * @author 12S24013 Adryan Julianto Panjaitan
 * @author 12S24013 Adryan Julianto Panjaitan
 */


import academic.model.Student;   // Mengimpor kelas Student dari paket academic.model
import java.util.Scanner;       // Mengimpor kelas Scanner untuk membaca input pengguna
import java.util.ArrayList;     // Mengimpor kelas ArrayList karena jumlah mahasiswa tidak pasti

public class Driver2 {
    // Menggunakan ArrayList untuk menyimpan objek-objek Student
    // ArrayList lebih fleksibel daripada array statis karena ukurannya bisa bertambah otomatis.
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk membaca input dari konsol
        String line; // Variabel untuk menyimpan setiap baris input

        // Loop untuk membaca input baris demi baris hingga pengguna mengetik "---"
        while (scanner.hasNextLine()) { // Memeriksa apakah ada baris input berikutnya
            line = scanner.nextLine(); // Membaca satu baris input

            if (line.equals("---")) { // Jika baris input adalah "---", hentikan proses input
                break;
            }

            // Memisahkan string input berdasarkan karakter "#"
            // Contoh input: 12S20999#Wiro Sableng#2020#Information Systems
            String[] parts = line.split("#"); 

            // Memastikan input memiliki 4 bagian yang diharapkan (nim, name, entranceYear, studyProgram)
            if (parts.length == 4) {
                String nim = parts[0];
                String name = parts[1];
                int entranceYear = Integer.parseInt(parts[2]); // Mengubah string angkatan menjadi integer
                String studyProgram = parts[3];

                // Membuat objek Student baru dan menambahkannya ke ArrayList
                students.add(new Student(nim, name, entranceYear, studyProgram));
            } else {
                System.err.println("Format input tidak valid: " + line);
            }
        }

        // Setelah semua input diproses, tampilkan semua student yang telah disimpan
        for (Student student : students) { // Menggunakan enhanced for loop untuk iterasi ArrayList
            System.out.println(student.toString()); // Memanggil toString() untuk format output yang diinginkan
        }

        scanner.close(); // Menutup objek Scanner untuk mencegah kebocoran sumber daya
    }
}