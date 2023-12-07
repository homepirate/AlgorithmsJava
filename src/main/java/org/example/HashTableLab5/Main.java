package org.example.HashTableLab5;


public class Main {
    public static void main(String[] args) {
//        Create a HashTable instance
        HashTable<String, Integer> table = new HashTable<>();

        table.add("A", 1);
        table.add("B", 2);
        table.add("C", 3);
        table.add("D", 4);

//        Test addOrReplace
        table.addOrReplace("B", 20);

//        This should replace the existing value Test get and find
        System.out.println("Value for key 'C': " + table.get("C"));
        System.out.println("Entry for key 'D': " + table.find("D"));

//        Test containsKey
        System.out.println("Contains key 'E': " + table.containsKey("E"));  // return false
//        Test remove
        System.out.println("Remove key 'B': " + table.remove("B")); // Should return true

        // Test clear
        table.clear();
        System.out.println("Size after clear: " + table.size());

//        Add more
        table.add("E", 5);
        table.add("F", 6);
//        Test keys and values
        Iterable<String> keys = table.keys();
        System.out.println("Keys: " + keys);
        Iterable<Integer> values = table.values();
        System.out.println("Values: " + values);

//        Test iterator
        System.out.println("Entries using iterator:");
        for (KeyValue<String, Integer> entry : table) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}