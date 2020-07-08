public class Student {
    /*
    In this class, a student object is constructed with the fields for first name, last name and grade, as well as an
    individual student number which can later be used to identify specific students in the ArrayList. the default constructor
    sets each field to an empty value, gives the student a student number and increments the student id. the actual constructor
    splits the two-worded name into first and last name, makes the grade equal to the grade specified in the object's parameters
    and assigns each student a student number, incrementing the student id.
     */
    private String firstName;
    private String lastName;
    private int grade;
    private static int studentId = 0;
    private int studentNumber;

    Student() {
        firstName = "";
        lastName = "";
        grade = 0;
        studentNumber = studentId;
        studentId++;
    }

    Student(String name, int grade) {
        int spacePosition;
        try {
            spacePosition = name.indexOf(" ");
            firstName = name.substring(0, spacePosition);
            lastName = name.substring(spacePosition + 1, name.length());
        } catch (Exception e) {
            firstName = name;
        }
        this.grade = grade;
        this.studentNumber = studentId;
        this.studentId++;
    }

    //this method makes the printing of the object into the console changed to my specifications
    public String toString() {
        return "Name: " + this.lastName + ", " + this.firstName + "\t Grade: " + this.grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }
}
