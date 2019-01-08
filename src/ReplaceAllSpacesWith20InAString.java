public class ReplaceAllSpacesWith20InAString {

    public static void main(String[] args) {

        String str = " Mr John Smith";
        System.out.println(replaceSpaces(str));
    }

    private static String replaceSpaces(String str) {

        String finalString = str.trim().replaceAll("\\s","%20");

        return finalString;
    }
}
