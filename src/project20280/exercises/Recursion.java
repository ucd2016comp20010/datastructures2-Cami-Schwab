//package project20280.exercises;
//
//public class Recursion {
//    public int fibonacci(int i) {
//        if(i == 1) {
//            return 0;
//        }
//        if(i == 2) {
//            return 1;
//        }
//        return fibonacci(i-1) + fibonacci(i-2);
//    }
//    //largest number computed within a minute depends on device
//
//    public int tribonacci(int i) {
//        if(i == 1) {
//            return 0;
//        }
//        if(i == 2) {
//            return 0;
//        }
//        if(i == 3) {
//            return 1;
//        }
//        return tribonacci(i-1) + tribonacci(i-2) + tribonacci(i-3);
//    }
//
//    public int ninetyOne(int n) {
//        if(n == 91) {
//            return 91;
//        }
//        if(n > 100) {
//            n = n - 10;
//            ninetyOne(n);
//        }
//        if(n <= 100) {
//            n += 11;
//            ninetyOne(ninetyOne(n));
//        }
//    }
//    //this is nested recursion
//}
