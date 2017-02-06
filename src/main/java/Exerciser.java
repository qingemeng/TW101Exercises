import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Exerciser {
    private static Exerciser ourInstance ;
    static synchronized Exerciser getInstance() {
        if (ourInstance == null){
            ourInstance = new Exerciser();
        }
        return ourInstance;
    }

    private Exerciser() {
    }

    void doExercise(String option, Scanner reader) {
        String n;
        switch (option.trim().toLowerCase()){
            case "easiest exercise ever":
                printStar();
                System.out.println();
                break;
            case "draw a horizontal line":
                System.out.println("Number of asterisks :");
                n = reader.nextLine();
                printHorizontalLine(Integer.parseInt(n));
                System.out.println();
                break;
            case "draw a vertical line":
                System.out.println("Number of asterisks :");
                n = reader.nextLine();
                printVerticalLine(Integer.parseInt(n));
                System.out.println();
                break;
            case "draw a right triangle":
                System.out.println("Number of Lines :");
                n = reader.nextLine();
                printRightTriangle(Integer.parseInt(n));
                System.out.println();
                break;
            case "isosceles triangle":
                System.out.println("Number of Lines :");
                n = reader.nextLine();
                printIsoscelesTriangle(Integer.parseInt(n));
                System.out.println();
                break;
            case "diamond":
                System.out.println("Number of Lines :");
                n = reader.nextLine();
                printDiamond(Integer.parseInt(n));
                System.out.println();
                break;
            case "diamond with name":
                System.out.println("Number of Lines :");
                n = reader.nextLine();
                printDiamondWithName(Integer.parseInt(n));
                System.out.println();
                break;
            case "fizzbuzz":
                printFizzbuzz(1, 100);
                System.out.println();
                break;
            case "prime factors":
                System.out.println("Enter a number :");
                n = reader.nextLine();
                List<Integer> factors = generate(Integer.parseInt(n));
                printFactors(factors);
                break;
        }
    }

    private void printFactors(List<Integer> factors) {
        for (int factor: factors) {
            System.out.print(factor + " ");
        }
    }

    List<Integer> generate(int n) {
        List<Integer> factors = new ArrayList<>();
        while(n > 1){
            int factor = findPrimeFactor(n);
            factors.add(factor);
            n = eliminateDuplicateFactor(n, factor);
        }
        return factors;
    }

    private int eliminateDuplicateFactor(int n, int factor) {
        while (n % factor == 0){
            n = n / factor;
        }
        return n;
    }

    private int findPrimeFactor(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0){
                return i;
            }
        }
        return n;
    }

    void printFizzbuzz(int start, int end) {
        String output;
        for (int i = start; i <= end; i++){
            if (i % 15 == 0){
                output = "FizzBuzz";
            }
            else if (i % 3 == 0){
                output = "Fizz";
            }
            else if (i % 5 == 0){
                output = "Buzz";
            }
            else {
                output = String.valueOf(i);
            }
            System.out.println(output);
        }
    }

    void printDiamondWithName(int n) {
        int nRow = n * 2 -1;
        int nColumn = n * 2 - 1;
        int middle = (nColumn - 1)/2;
        for (int i = 0; i < nRow ; i++){
            if (i == middle){
                System.out.println("Gemeng");
                continue;
            }
            int lowerBound = Math.abs(i - middle);
            int upperBound = middle * 2 - Math.abs(i - middle);
            fillDiamondByRow(nColumn, lowerBound, upperBound);
            System.out.println();
        }
    }

    void printDiamond(int n) {
        int nRow = n * 2 -1;
        int nColumn = n * 2 - 1;
        int middle = (nColumn - 1)/2;
        for (int i = 0; i < nRow ; i++){
            int lowerBound = Math.abs(i - middle);
            int upperBound = middle * 2 - Math.abs(i - middle);
            fillDiamondByRow(nColumn, lowerBound, upperBound);
            System.out.println();
        }
    }

    private void fillDiamondByRow(int nColumn, int lowerBound, int upperBound) {
        for(int j = 0; j < nColumn; j++){
            if (j >= lowerBound && j <= upperBound){
                System.out.print("*");
                continue;
            }
            System.out.print(" ");
        }
    }

    void printIsoscelesTriangle(int nRow) {
        int nColumn = nRow * 2 - 1;
        int middle = (nColumn - 1)/2;
        for (int i = 0; i < nRow ; i++){
            fillDiamondByRow(nColumn, middle - i, middle + i);
            System.out.println();
        }
    }

    void printRightTriangle(int n) {
        for (int i = 0; i < n ; i++){
            for(int j = 0; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    void printHorizontalLine(int n) {
        while(n > 0){
            System.out.print("*");
            n--;
        }
    }


    void printVerticalLine(int n) {
        while(n > 0){
            System.out.print("*");
            System.out.println();
            n--;
        }
    }

    void printStar() {
        System.out.print("*");
    }
}
