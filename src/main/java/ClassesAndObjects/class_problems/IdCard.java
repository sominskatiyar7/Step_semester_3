class Card {
    String name;
    int booksIssued;

    Card(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}

public class IdCard {
    public static void main(String[] args) {

        Card ravi = new Card("Ravi", 0);

        Card duplicate = ravi;

        duplicate.booksIssued = 3;

        Card separate = new Card("Ravi", 3);

        System.out.println(
            "Ravi's booksIssued (via first variable): " +
            ravi.booksIssued
        );

        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        System.out.println("separate == ravi: " + (separate == ravi));
    }
}