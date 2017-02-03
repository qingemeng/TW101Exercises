import java.util.Scanner;

public class Exercises{
    public static void main(String[] args){
        String option = "";
        while(!option.equals("0")){
            printMenu();
            Scanner reader = new Scanner(System.in);
            option = reader.nextLine();
            Exerciser exerciser = Exerciser.getInstance();
            exerciser.doExercise(option, reader);
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("Enter exercise name: ");
        printTriangleMenu();
        printDiamondMenu();
        printFizzBuzzMenu();
        printPrimeFactorsMenu();
        System.out.println("0. Exit");
    }

    private static void printTriangleMenu() {
        System.out.println("Triangle Exercises");
        System.out.println("- Easiest exercise ever");
        System.out.println("- Draw a horizontal line");
        System.out.println("- Draw a vertical line");
        System.out.println("- Draw a right triangle");
    }

    private static void printDiamondMenu() {
        System.out.println("Diamond Exercises");
        System.out.println("- Isosceles Triangle");
        System.out.println("- Diamond");
        System.out.println("- Diamond with Name");
    }

    private static void printFizzBuzzMenu() {
        System.out.println("- FizzBuzz");
    }

    private static void printPrimeFactorsMenu() {
        System.out.println("- Prime Factors");
    }
}