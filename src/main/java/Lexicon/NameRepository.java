package Lexicon;

import java.util.Arrays;

public class NameRepository {
    private static String [] names = new String[0];
    public static int getSize(){
        int arraySize = names.length;
        return arraySize;
    }
    public static void setNames(String[] names) {
        String[] newNames = Arrays.copyOf(names, names.length);
    }

    public static void clear(){
        names = new String[0];
    }
    public static String[] findAll() {
        String[] newArray = Arrays.copyOf(names, names.length);
        return newArray;
    }



}
