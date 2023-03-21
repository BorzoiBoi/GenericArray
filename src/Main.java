public class Main {
    public static void main(String[] args) {

        MyCustomList<String> str_Array = new MyCustomList<>(String.class);

        //Checking add() functionality
        str_Array.add("elem11");
        str_Array.add("elem12");
        str_Array.add("elem14");
        str_Array.add(2, "elem13");
        System.out.println(str_Array);

        //Checking clear() functionality
        str_Array.clear();
        System.out.println("post-clear length: " + str_Array.size());
        System.out.println(str_Array);
        System.out.println("post-clear get 0: " + str_Array.get(0));
        str_Array.add("elem0");
        System.out.println("post-add get 0: " + str_Array.get(0));
        str_Array.add("elem1");
        str_Array.add(0, "elem2");
        System.out.println(str_Array);

        //Checking pop functionality
        System.out.println("pop! : " + str_Array.pop());
        str_Array.add("elem3");
        System.out.println(str_Array);
        System.out.println("pop! : " + str_Array.pop());
        System.out.println("pop! : " + str_Array.pop());

        //Checking remove functionality
        str_Array.add("elem3");
        str_Array.add("elem4");
        str_Array.add("elem5");
        System.out.println(str_Array);
        System.out.println("Removing: " + str_Array.remove(2));
        System.out.println(str_Array);
    }
}