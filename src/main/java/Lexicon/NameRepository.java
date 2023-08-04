package Lexicon;

import java.util.Arrays;
import java.util.Scanner;

public class NameRepository {

    public static void main(String[] args) {
        getSize();

        setNames(names);

        clear();

        findAll();

        String fullName = "";
        find(fullName);

        add(fullName);

        String firstName = "";
        findByFirstName(firstName);


        String lastName = "";
        findByLastName(lastName);

        String original = "";
        String updatedName = "";
        update(original, updatedName);

        String removeFullName = "";
        remove(removeFullName);


    }

    //Part 1
    private static String[] names = new String[0];
    public static String[] newNames = {"Bassim Durzi", "Justin Mora", "Wassim Abbas", "Omer Merza", "Bassim Durzi", "Justin Mora", "Wassim Abbas", "Maya Merza"};

    public static int getSize() {
        int arraySize = names.length;
        System.out.println("Number of elements " + arraySize);
        return arraySize;
    }

    public static void setNames(String[] Names) {
        names = Arrays.copyOf(newNames, newNames.length);
        System.out.println(Arrays.toString(names));
    }

    public static void clear() {
        names = Arrays.copyOf(names, 0);
        System.out.println( "The empty array:  "+ Arrays.toString(names));
    }

    public static String[] findAll() {
        String[] returnNamesNewArray = Arrays.copyOf(newNames, newNames.length);
        System.out.println("\"Returns all names in a new array \"");
        System.out.println(Arrays.toString(returnNamesNewArray));
        return returnNamesNewArray;
    }

    //part2
    public static String find(final String fullName) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Arrays.toString(newNames));
        System.out.println("Please write the name to check if it is found or not:");
        String checkFullName = scanner.nextLine();

        Arrays.sort(newNames);
        int elementIndex = Arrays.binarySearch(newNames, checkFullName);

        if (elementIndex >= 0) {
            System.out.println(newNames[elementIndex]);
        } else {
            System.out.println("null");
        }
        return String.valueOf(elementIndex);
    }

    public static boolean add(final String fullName) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Arrays.toString(newNames));
        System.out.println("Please add a full name to the array:");
        String addNewName = scanner.nextLine();

        Arrays.sort(newNames);
        int elementIndex = Arrays.binarySearch(newNames, addNewName);

        if (elementIndex >= 0) {
            System.out.println(false);
            return false;
        } else {
            String[] updatedNewNames = Arrays.copyOf(newNames, newNames.length + 1);
            updatedNewNames[updatedNewNames.length - 1] = addNewName;
            System.out.println(Arrays.toString(updatedNewNames));
            return true;
        }


    }

    //Part 3
    public static String[] findByFirstName(final String firstName) {

        String[] firstSplitName = new String[newNames.length];
        String[] firstNameArray = Arrays.copyOf(firstSplitName, firstSplitName.length);

        for (int i = 0; i < newNames.length; i++) {
            String fullNameElement = newNames[i];
            String[] splitName = fullNameElement.split(" ", 2);
            firstNameArray[i] = splitName[0];
        }

        //Arrays.sort(firstNameArray,String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(firstNameArray));
        System.out.println("Type the first name which you to find it: ");
        Scanner scanner = new Scanner(System.in);
        String firstNameOfTheFullName = scanner.nextLine();

        String[] matchesNamesArray = new String[firstNameArray.length];

        for (int j = 0; j < firstNameArray.length; j++) {
            if (firstNameArray[j].equalsIgnoreCase(firstNameOfTheFullName)) {
                matchesNamesArray[j] = firstNameArray[j];
                //System.out.println("First name's index: " + (j));
            }
        }
        System.out.println(Arrays.toString(matchesNamesArray));

        return matchesNamesArray;
    }

    public static String[] findByLastName(final String lastName) {
        String[] lastSplitName = new String[newNames.length];
        String[] lastNameArray = Arrays.copyOf(lastSplitName, lastSplitName.length);

        for (int i = 0; i < newNames.length; i++) {
            String fullNameElement = newNames[i];
            String[] splitName = fullNameElement.split(" ", 2);
            lastNameArray[i] = splitName[1];
        }

        //Arrays.sort(firstNameArray,String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(lastNameArray));
        System.out.println("Type the last name which you want to find it: ");
        Scanner scanner = new Scanner(System.in);
        String firstNameOfTheFullName = scanner.nextLine();

        String[] matchesNamesArray = new String[lastNameArray.length];

        for (int j = 0; j < lastNameArray.length; j++) {
            if (lastNameArray[j].equalsIgnoreCase(firstNameOfTheFullName)) {
                matchesNamesArray[j] = lastNameArray[j];
                //System.out.println("First name's index: " + (j));
            }
        }
        System.out.println(Arrays.toString(matchesNamesArray));

        return matchesNamesArray;

    }

    public static boolean update(final String original, final String updatedName) {

        String[] updateNameArray = Arrays.copyOf(newNames, newNames.length);
        System.out.println(Arrays.toString(updateNameArray));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write the name which you want to find:");
        String findName = scanner.nextLine();

        Arrays.sort(updateNameArray);
        int findNameIndex = Arrays.binarySearch(updateNameArray, findName);
        //System.out.println(findNameIndex);

        if (findNameIndex < 0) {
            System.out.println("The name which you wrote is not found");
        }

        if (findNameIndex > 0) {
            for (int i = 0; i < updateNameArray.length; i++) {
                if (findName.equalsIgnoreCase(updateNameArray[i])) {
                    System.out.println("Index " + i);
                    System.out.println("Please write the new full name which you want to replace the old one:");
                    String newFullName = scanner.nextLine();

                    if (newFullName.equalsIgnoreCase(updateNameArray[i]))
                        return false;

                    updateNameArray[i] = newFullName;
                    System.out.println(Arrays.toString(updateNameArray));
                }
            }
        }
        return true;
    }

    //Part 4:
    public static boolean remove(final String fullName) {

        String[] removeNameArray = Arrays.copyOf(newNames, newNames.length);
        System.out.println(Arrays.toString(removeNameArray));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write the name which you want to remove:");
        String findName = scanner.nextLine();

        Arrays.sort(removeNameArray);
        int findNameIndex = Arrays.binarySearch(removeNameArray, findName);

        if (findNameIndex < 0) {
            System.out.println("The name is not found");
            return false;
        }

        for (int i = 0; i < removeNameArray.length; i++) {
            if (removeNameArray[i].equalsIgnoreCase(findName)) {
                removeNameArray[i] = "null";
                System.out.println(Arrays.toString(removeNameArray));
            }

        }

        return true;
    }

}




