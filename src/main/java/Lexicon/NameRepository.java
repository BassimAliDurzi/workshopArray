package Lexicon;

import java.util.Arrays;

public class NameRepository {

    public static void main(String[] args) {
        getSize();
        setNames(names);
        clear();
        findAll();


    }

    private static String[] names = new String[0];
    public static String[] newNames = {"Bassim Durzi", "Shubha Dhang", "Negar Baharmand", "Juan Oliver"};

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


}