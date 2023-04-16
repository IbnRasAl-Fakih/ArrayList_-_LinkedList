public class Main {

    public static void main(String[] args) {
        MyArrayList<String> arr = new MyArrayList<>();
        arr.add("Almaty");
        arr.add("Astana");
        arr.add("Shymkent");
        arr.add("Aktobe");
        arr.add("Taraz");
        arr.add("Almaty");
        arr.add("Pavlodar",2);
        System.out.print("Array: ");
        printer_str(arr);
        System.out.println("Size of array: " + arr.size());
        System.out.println("Does the array contain 'London'? " + arr.contains("London"));
        System.out.println("The index of 'Shymkent': " + arr.indexOf("Shymkent"));
        System.out.println("The last index of 'Almaty': " + arr.lastIndexOf("Almaty"));
        System.out.println("Removing some elements");
        arr.remove("Astana");
        arr.remove(1);
        System.out.print("Array: ");
        printer_str(arr);
        System.out.println("Clear the array");
        arr.clear();
        printer_str(arr);

        System.out.println("-------------------------------------------------");

        MyLinkedList<Integer> mas = new MyLinkedList<>();
        mas.add(14);
        mas.add(6);
        mas.add(12);
        mas.add(22);
        mas.add(46);
        mas.add(6);
        mas.add(70,0);
        System.out.print("Array: ");
        printer_int(mas);
        System.out.println("Size of array: " + mas.size());
        System.out.println("Does the array contain '77'? " + mas.contains(77));
        System.out.println("The index of '14': " + mas.indexOf(14));
        System.out.println("The last index of '6': " + mas.lastIndexOf(6));
        System.out.println("Removing some elements");
        mas.remove(4);
        System.out.print("Array: ");
        printer_int(mas);
        System.out.println("Clear the array");
        mas.clear();
        printer_int(mas);
    }


    public static void printer_str (MyList<String> list) {
        for (var elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void printer_int (MyList<Integer> list) {
        for (var elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

}