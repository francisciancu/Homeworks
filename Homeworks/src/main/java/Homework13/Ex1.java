package Homework13;

public class Ex1 {

    private static void countAppearanceOfNulla(String string, String subString) {
        int count = 0;
        StringBuilder builder = new StringBuilder(string);
        int startIndex, stopIndex;
        while (builder.indexOf(subString) != -1) {
            count++;
            startIndex = builder.indexOf(subString);
            stopIndex = startIndex + subString.length();
            builder.delete(startIndex, stopIndex);
        }
        System.out.println("The number of times '" + subString + "' appears in your text is " + count);
    }

    private static void splitIntoSentences(String string) {
        String[] processed = string.split("(?<=\\.)");
        for (String sentence : processed) {
            System.out.println(sentence);
        }
    }

    private static void deleteCharAtWithStringBuilder(String string) {
        StringBuilder builder = new StringBuilder(string);

        while (builder.indexOf("a") != -1) {
            builder.deleteCharAt(builder.indexOf("a"));
        }
        System.out.println(builder);
    }

    private static void replaceOWithA(String string) {
        StringBuilder builder = new StringBuilder(string);
        int indexOf;
        while (builder.indexOf("o") != -1) {
            indexOf = builder.indexOf("o");
            builder.replace(indexOf, indexOf + 1, "#");
        }
        System.out.println(builder);
    }

    public static void main(String[] args) {
        String string = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam consectetur odio ac quam commodo, eu eleifend felis imperdiet. Integer bibendum nunc quis sem faucibus, vitae laoreet mi dignissim. Praesent eget ligula nec lorem varius malesuada. Nulla neque lacus, euismod quis erat nec, convallis vestibulum augue. Nullam et aliquet justo. Aliquam erat volutpat. Nulla elementum urna in dolor viverra, in efficitur lectus mattis.";
        System.out.println("Ex1");
        countAppearanceOfNulla(string, "Nulla");
        System.out.println("\nEx2");
        splitIntoSentences(string);
        System.out.println("\nEx3");
        deleteCharAtWithStringBuilder(string);
        System.out.println("\nEx4");
        replaceOWithA(string);

    }
}
