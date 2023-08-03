package Lexicon;

public class App {

    public static void main(String[] args) {
        fullName();

    }

    public static void fullName() {
        String[] fullNameArray = {"Bassim Durzi", "Justin Mora", "Wassim Abbas", "Omer Merza", "Bassim Durzi", "Justin Mora", "Wassim Abbas"};

        for (int i = 0; i < fullNameArray.length; i++) {
            System.out.println(fullNameArray[i]);

        }
    }
}
