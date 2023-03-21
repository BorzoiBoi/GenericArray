public class Main {
    public static void main(String[] args) {

        MyCustomList<String> str_Array = new MyCustomList<>(String.class);
        str_Array.add("elem11");
        str_Array.add("elem12");
        str_Array.add("elem14");
        str_Array.add(2, "elem13");
        System.out.println(str_Array);
    }
}