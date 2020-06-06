/**
 * Title: Student Directory App.
 * @author Xi Chen
 * Andrew ID: xc4
 * Lecturer's Name: Terry Lee
 * Lab Section: HW5
 */
public class Student {
    /**
     * the string of student ID.
     */
    private String andrewId;
    /**
     * the string of student first name.
     */
    private String firstName;
    /**
     * the string of student last name.
     */
    private String lastName;
    /**
     * the string of student phoneNumber.
     */
    private String phoneNumber;
    /**
     * the constructor of student class.
     * @param andrewID student ID.
     */
    public Student(String andrewID) {
        this.andrewId = andrewID;
    }
    /**
     * return student ID.
     * @return student ID.
     */
    public String getAndrewId() {
        return andrewId;
    }
    /**
     * return student first name.
     * @return student first name.
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * return student last name.
     * @return student last name.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * return student phone number.
     * @return student phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * Set student first Name.
     * @param s first name.
     */
    public void setFirstName(String s) {
        checkString(s);
        firstName = s;
    }
    /**
     * Set student last Name.
     * @param s last name.
     */
    public void setLastName(String s) {
        checkString(s);
        this.lastName = s;
    }
    /**
     * Set student phone number.
     * @param s phone number.
     */
    public void setPhoneNumber(String s) {
        this.phoneNumber = s;
    }
    /**
     * check the string if legal.
     * @param s String input
     * @return
     */
    private static String checkString(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        if (s.trim().equals("")) {
            throw new IllegalArgumentException();
        }
        return s;
    }
    /**
     * Returns String representation of Student object.
     * @return String representation of Student object
     */
    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " " + "(Andrew ID: "
                + this.andrewId + ", Phone Number: " + this.phoneNumber + ")";
    }
}
