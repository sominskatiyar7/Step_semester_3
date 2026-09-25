class Password {
    private final String password;

    Password(String password) {
        this.password = password;
    }

    String getStrength() {
        if (password.length() < 6) {
            return "Weak";
        } else if (password.length() <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}

public class PasswordChecker {
    public static void main(String[] args) {

        Password pc = new Password("abcd");
        Password pc2 = new Password("abcdefghij");

        System.out.println("Password 1: " + pc.getStrength());
        System.out.println("Password 2: " + pc2.getStrength());
    }
}