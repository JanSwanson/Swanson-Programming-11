import java.util.ArrayList;

public class School {
    /*
    In this class, a school object is constructed with fields for name, level of schooling and if it is private or
    secondary. each object also holds an arraylist of teachers and an arraylist of students. the dafault constructor gives
    the fields an empty value. the main constructor sets each field to the corresponding parameter for the object.
     */
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private String nameOfSchool;
    private String levelOfSchooling;
    private String privateOrPublic;

    School() {
        nameOfSchool = "";
        levelOfSchooling = "";
        privateOrPublic = "";
    }

    School(String nameOfSchool, String levelOfSchooling, String privateOrPublic) {
        this.nameOfSchool = nameOfSchool;
        this.levelOfSchooling = levelOfSchooling;
        this.privateOrPublic = privateOrPublic;
    }

    //this method adds a new teacher object with specified name and subject to the end of the teacher list
    public void addTeacher(String name, String subject) {
        teachers.add(new Teacher(name, subject));
    }

    //this method adds a new student object with specified name and grade to the end of the student list
    public void addStudent(String name, int grade) {
        students.add(new Student(name, grade));
    }

    //this method removes a teacher object from the end of the teacher list
    public void deleteTeacher() {
        teachers.remove(teachers.size() - 1);
    }

    //this method removes a student object from the end of the student list
    public void deleteStudent() {
        students.remove(students.size() - 1);
    }

    //this method, for each teacher on the teacher list, prints them to the console
    public void showTeachers() {
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println(teachers.get(i));
        }
    }

    //this method, for each student on the student list, prints them to the console
    public void showStudents() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public String getNameOfSchool() {
        return nameOfSchool;
    }

    public void setNameOfSchool(String nameOfSchool) {
        this.nameOfSchool = nameOfSchool;
    }

    public String getLevelOfSchooling() {
        return levelOfSchooling;
    }

    public void setLevelOfSchooling(String levelOfSchooling) {
        this.levelOfSchooling = levelOfSchooling;
    }

    public String getPrivateOrPublic() {
        return privateOrPublic;
    }

    public void setPrivateOrPublic(String privateOrPublic) {
        this.privateOrPublic = privateOrPublic;
    }
}