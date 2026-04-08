//package project20280.hashtable;
//
//import project20280.interfaces.Entry;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.Scanner;
//
//public class WordFrequency {
//    public static void main(String[] args) throws FileNotFoundException {
//        File f = new File("sample_text.txt");   // make sure this path is correct
//        ChainHashMap<String, Integer> counter = new ChainHashMap<>();
//
//        Scanner scanner = new Scanner(f);
//
//        while (scanner.hasNext()) {
//            String word = scanner.next();
//
//            // optional cleanup:
//            word = word.toLowerCase().replaceAll("[^a-z]", "");
//
//            if (word.length() == 0) {
//                continue;
//            }
//
//            Integer count = counter.get(word);
//
//            if (count == null) {
//                counter.put(word, 1);
//            } else {
//                counter.put(word, count + 1);
//            }
//        }
//
//        scanner.close();
//
//        ArrayList<Entry<String, Integer>> entries = new ArrayList<>();
//        for (Entry<String, Integer> e : counter.entrySet()) {
//            entries.add(e);
//        }
//
//        entries.sort(new Comparator<Entry<String, Integer>>() {
//            @Override
//            public int compare(Entry<String, Integer> a, Entry<String, Integer> b) {
//                return b.getValue().compareTo(a.getValue()); // descending
//            }
//        });
//
//        System.out.println("Top 10 most frequent words:");
//        int limit = Math.min(10, entries.size());
//        for (int i = 0; i < limit; i++) {
//            Entry<String, Integer> e = entries.get(i);
//            System.out.println((i + 1) + ". " + e.getKey() + " -> " + e.getValue());
//        }
//    }
//}