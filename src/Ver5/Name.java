package Ver5;

public class Name implements Cloneable {
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String suffix;

    public Name() {
        this("", "", "", "");
    }

    public Name(String firstName, String lastName, String middleInitial, String suffix) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.suffix = suffix;
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

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public String toString() {
        String result = lastName + ", " + firstName;

        if (middleInitial != null && !middleInitial.isEmpty()) {
            result += " " + middleInitial + ".";
        }

        if (suffix != null && !suffix.isEmpty()) {
            result += " " + suffix;
        }

        return result;
    }

    public void displayName() {
        System.out.println(toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Name))
            return false;

        Name other = (Name) obj;

        return firstName.equals(other.firstName) && lastName.equals(other.lastName) && middleInitial.equals(other.middleInitial) && suffix.equals(other.suffix);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + middleInitial.hashCode();
        result = 31 * result + suffix.hashCode();
        return result;
    }

    @Override
    public Name clone() {
        try {
            return (Name) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}