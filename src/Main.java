public class Main {
    public static void main(String[] args) {

        MyCustomList<String> str_Array = new MyCustomList(String.class);
        System.out.println("\nArray Length: " + str_Array.size());
        str_Array.add("elem11");
        str_Array.add("elem12");
        str_Array.arrWrite();
        str_Array.clear();
        System.out.println("post-clear length: " + str_Array.size());
        str_Array.arrWrite();
        System.out.println("post-clear get 0: " + str_Array.get(0));
        str_Array.add("elem0");
        System.out.println("post-add get 0: " + str_Array.get(0));
        str_Array.add("elem1");
        str_Array.add(0, "elem2");
        str_Array.arrWrite();
        System.out.println("pop! : " + str_Array.pop());
        str_Array.add("elem3");
        str_Array.arrWrite();
        System.out.println("pop! : " + str_Array.pop());
        System.out.println("pop! : " + str_Array.pop());
        str_Array.add("elem3");
        str_Array.add("elem4");
        str_Array.add("elem5");
        str_Array.arrWrite();
        str_Array.remove(2);
        str_Array.arrWrite();
    }
}