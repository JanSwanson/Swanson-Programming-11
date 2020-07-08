public class Main {
    public static void main(String[] args) {
        School brooks = new School("Brooks", "Secondary", "Private");
        for (int i = 0; i < 10; i++) {
            brooks.addStudent("John Doe", 5);
        }
        brooks.addTeacher("Bob Alice", "Science");
        brooks.addTeacher("Abby Swan", "Math");
        brooks.addTeacher("Juan Rodriguez", "Spanish");

        brooks.showStudents();
        brooks.showTeachers();

        brooks.deleteStudent();
        brooks.deleteStudent();
        brooks.deleteTeacher();

        brooks.showStudents();
        brooks.showTeachers();
    }
}