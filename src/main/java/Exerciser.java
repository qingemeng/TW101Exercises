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

    public void doExercise(String option) {
        switch (option.trim().toLowerCase()){
            case "easiest exercise ever":
                printStar();
                break;
            case "draw a horizontal line":
                break;
            case "draw a vertical line":
                break;
            case "draw a right triangle":
                break;
            case "isosceles triangle":
                break;
            case "diamond":
                break;
            case "diamond with name":
                break;
            case "fizzbuzz exercises":
                break;
            case "prime factors exercises":
                break;
        }
    }

    private void printStar() {
        System.out.println("*");
    }
}
