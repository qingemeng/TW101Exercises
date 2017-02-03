import java.util.Scanner;

public class Exerciser {
    private static Exerciser ourInstance ;
    public static synchronized Exerciser getInstance() {
        if (ourInstance == null){
            ourInstance = new Exerciser();
        }
        return ourInstance;
    }

    private Exerciser() {
    }

    public void doExercise(String option, Scanner reader) {
        String n = "";
        switch (option.trim().toLowerCase()){
            case "easiest exercise ever":
                printStar();
                break;
            case "draw a horizontal line":
                System.out.println("Number of asterisks :");
                n = reader.nextLine();
                printHorizontalLine(Integer.parseInt(n));
                break;
            case "draw a vertical line":
                System.out.println("Number of asterisks :");
                n = reader.nextLine();
                printVerticalLine(Integer.parseInt(n));
                break;
            case "draw a right triangle":
                System.out.println("Number of Lines :");
                n = reader.nextLine();
                printRightTriangle(Integer.parseInt(n));
                break;
            case "isosceles triangle":
                System.out.println("Number of Lines :");
                n = reader.nextLine();
                printIsoscelesTriangle(Integer.parseInt(n));
                break;
            case "diamond":
                System.out.println("Number of Lines :");
                n = reader.nextLine();
                printDiamond(Integer.parseInt(n));
                break;
            case "diamond with name":
                System.out.println("Number of Lines :");
                n = reader.nextLine();
                printDiamondWithName(Integer.parseInt(n));
                break;
            case "fizzbuzz exercises":
                break;
            case "prime factors exercises":
                break;
        }
    }

    private void printDiamondWithName(int n) {
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
        System.out.println();
    }

    private void printDiamond(int n) {
        int nRow = n * 2 -1;
        int nColumn = n * 2 - 1;
        int middle = (nColumn - 1)/2;
        for (int i = 0; i < nRow ; i++){
            int lowerBound = Math.abs(i - middle);
            int upperBound = middle * 2 - Math.abs(i - middle);
            fillDiamondByRow(nColumn, lowerBound, upperBound);
            System.out.println();
        }
        System.out.println();
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

    private void printIsoscelesTriangle(int nRow) {
        int nColumn = nRow * 2 - 1;
        int middle = (nColumn - 1)/2;
        for (int i = 0; i < nRow ; i++){
            fillDiamondByRow(nColumn, middle - i, middle + i);
            System.out.println();
        }
        System.out.println();
    }

    private void printRightTriangle(int n) {
        for (int i = 0; i < n ; i++){
            for(int j = 0; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void printHorizontalLine(int n) {
        while(n > 0){
            System.out.print("*");
            n--;
        }
        System.out.println();
    }


    private void printVerticalLine(int n) {
        while(n > 0){
            System.out.print("*");
            System.out.println();
            n--;
        }
        System.out.println();
    }

    private void printStar() {
        System.out.println("*");
    }
}
