package Lexicon;

import java.util.Arrays;
import java.util.Scanner;

public class NameRepository {

    public static void main(String[] args) {
        //getSize();

        //setNames(names);

        //clear();

        //findAll();

        //String fullName = "";
        //find(fullName);

        //add(fullName);

        String firstName = "";
        findByFirstName(firstName);


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
        System.out.println(Arrays.toString(names));
    }

    public static String[] findAll() {
        String[] returnNamesNewArray = Arrays.copyOf(newNames, newNames.length);
        System.out.println(Arrays.toString(returnNamesNewArray));
        return returnNamesNewArray;
    }

    //part2
    public static String find(final String fullName) {
        Scanner scanner = new Scanner(System.in);
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
    public static void findByFirstName(final String firstName) {

        String[] firstSplitName = new String[newNames.length];
        String[] lastSplitName = new String[newNames.length];
        String[] firstNameArray = Arrays.copyOf(firstSplitName, firstSplitName.length);
        String[] lastNameArray = Arrays.copyOf(lastSplitName, lastSplitName.length);


        for (int i = 0; i < newNames.length; i++) {
            String fullNameElement = newNames[i];

            String[] splitName = fullNameElement.split(" ", 2);
            //System.out.println(Arrays.toString(splitName));

            firstNameArray[i] = splitName[0];
            //System.out.println(Arrays.toString(firstNameArray));

            lastNameArray[i] = splitName[1];
            //System.out.println(Arrays.toString(updatedLastSplitName));
        }

        Arrays.sort(firstNameArray,String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(firstNameArray));
        Scanner scanner = new Scanner(System.in);
        String firstNameOfTheFullName = scanner.nextLine();


        for (int j = 0; j < firstNameArray.length; j++) {
            if (firstNameOfTheFullName.equalsIgnoreCase(firstNameArray[j])) {
                int position = Arrays.binarySearch(firstNameArray, firstNameOfTheFullName);
                System.out.println("First name's index: " + (position - 1));
            }
        }


    }


}



