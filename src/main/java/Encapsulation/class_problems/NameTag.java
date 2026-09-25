class PersonName {
    private final String firstName;
    private final String lastName;

    PersonName(String fullName) {
        String[] parts = fullName.split(" ");

        firstName = parts[0];
        lastName = parts[1];
    }

    String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }
}

public class NameTag {
    public static void main(String[] args) {

        PersonName tag = new PersonName("Maria Gomez");

        System.out.println(tag.getNickname());
    }
}