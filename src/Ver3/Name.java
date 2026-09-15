
package Ver3;

import java.util.Objects;

public class Name implements Cloneable {

    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() {
        this("N/A", "N/A", "N/A", "");
    }

    public Name(String firstName, String lastName) {
        this(firstName, "", lastName, "");
    }

    public Name(String firstName, String middleName, String lastName) {
        this(firstName, middleName, lastName, "");
    }

    public Name(String firstName, String middleName,
                String lastName, String suffix) {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setSuffix(suffix);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? "" : firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName == null ? "" : middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? "" : lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix == null ? "" : suffix;
    }

    @Override
    public String toString() {
        String result = lastName + ", " + firstName;

        if (!middleName.isEmpty()) {
            result += " " + middleName.charAt(0) + ".";
        }

        if (!suffix.isEmpty()) {
            result += " " + suffix;
        }

        return result;
    }

    public void displayName() {
        System.out.println("Name: " + this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Name)) return false;

        Name other = (Name) obj;

        return firstName.equalsIgnoreCase(other.firstName)
                && middleName.equalsIgnoreCase(other.middleName)
                && lastName.equalsIgnoreCase(other.lastName)
                && suffix.equalsIgnoreCase(other.suffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                firstName.toLowerCase(),
                middleName.toLowerCase(),
                lastName.toLowerCase(),
                suffix.toLowerCase()
        );
    }

    @Override
    public Name clone() {
        try {
            return (Name) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}