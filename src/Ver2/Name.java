package Ver2;

public class Name {

    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() {
        firstName = "N/A";
        middleName = "N/A";
        lastName = "N/A";
        suffix = "";
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.middleName = "";
        this.lastName = lastName;
        this.suffix = "";
    }

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = "";
    }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public String toString() {

        String result = lastName + ", " + firstName;

        if (middleName != null && !middleName.isEmpty()) {
            result += " " + middleName.charAt(0) + ".";
        }

        if (suffix != null && !suffix.isEmpty()) {
            result += " " + suffix;
        }

        return result;
    }

    public void displayName() {
        System.out.println("Name: " + toString());
    }
}
