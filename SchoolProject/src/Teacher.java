public class Teacher {
    /*
    In this class, a teacher object is constructed with fields for first name, last name and subject. the default
    constructor gives each field an empty value. the actual constructor splits one two-word name into first and
    last names. the subject is equal to the information given in the constructor's parameters.
     */
    private String firstName;
    private String lastName;
    private String subject;

    Teacher() {
        firstName = "";
        lastName = "";
        subject = "";
    }

    Teacher(String name, String subject) {
        int spacePosition;
        try {
            spacePosition = name.indexOf(" ");
            firstName = name.substring(0, spacePosition);
            lastName = name.substring(spacePosition + 1, name.length());
        } catch (Exception e) {
            firstName = name;
        }
        this.subject = subject;
    }

    //this method makes the printing of the object into the console changed to my specifications
    public String toString() {
        return "Name: " + this.lastName + ", " + this.firstName + "\t Subject: " + this.subject;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
