import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ExerciserTest {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private Exerciser exerciser = Exerciser.getInstance();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void cleanUpStreams() throws Exception {
        System.setOut(null);
    }

    @Test
    public void printStarShouldPrintAsterisk() throws Exception {
        exerciser.printStar();
        assertEquals("*", outputStream.toString());
    }

    @Test
    public void printHorizontalLineShouldPrintCorrectly() throws Exception {
        exerciser.printHorizontalLine(3);
        assertEquals("***", outputStream.toString());
    }

    @Test
    public void printVerticalLineShouldPrintCorrectly() throws Exception {
        exerciser.printVerticalLine(3);
        assertEquals("*\n*\n*\n", outputStream.toString());
    }

    @Test
    public void printRightTriangleWithEvenInputShouldPrintCorrectly() throws Exception {
        exerciser.printRightTriangle(4);
        assertEquals("*\n**\n***\n****\n", outputStream.toString());
    }

    @Test
    public void printRightTriangleWithOddInputShouldPrintCorrectly() throws Exception {
        exerciser.printRightTriangle(3);
        assertEquals("*\n**\n***\n", outputStream.toString());
    }

    @Test
    public void printIsoscelesTriangleWithEvenInputShouldPrintCorrectly() throws Exception {
        exerciser.printIsoscelesTriangle(4);
        assertEquals("   *   \n  ***  \n ***** \n*******\n", outputStream.toString());
    }

    @Test
    public void printIsoscelesTriangleWithOddInputShouldPrintCorrectly() throws Exception {
        exerciser.printIsoscelesTriangle(3);
        assertEquals("  *  \n *** \n*****\n", outputStream.toString());
    }

    @Test
    public void printDiamondWithEvenInputShouldPrintCorrectly() throws Exception {
        exerciser.printDiamond(4);
        assertEquals("   *   \n  ***  \n ***** \n*******\n ***** \n  ***  \n   *   \n", outputStream.toString());
    }

    @Test
    public void printDiamondWithOddInputShouldPrintCorrectly() throws Exception {
        exerciser.printDiamond(3);
        assertEquals("  *  \n *** \n*****\n *** \n  *  \n", outputStream.toString());
    }

    @Test
    public void printDiamondWithNameWithEvenInputShouldPrintCorrectly() throws Exception {
        exerciser.printDiamondWithName(4);
        assertEquals("   *   \n  ***  \n ***** \nGemeng\n ***** \n  ***  \n   *   \n", outputStream.toString());
    }

    @Test
    public void printDiamondWithNameWithOddInputShouldPrintCorrectly() throws Exception {
        exerciser.printDiamondWithName(3);
        assertEquals("  *  \n *** \nGemeng\n *** \n  *  \n", outputStream.toString());
    }

    @Test
    public void printFizzBussInterval() throws Exception {
        exerciser.printFizzbuzz(1, 15);
        assertEquals(
                "1\n" +
                        "2\n" +
                        "Fizz\n" +
                        "4\n" +
                        "Buzz\n" +
                        "Fizz\n" +
                        "7\n" +
                        "8\n" +
                        "Fizz\n" +
                        "Buzz\n" +
                        "11\n" +
                        "Fizz\n" +
                        "13\n" +
                        "14\n" +
                        "FizzBuzz\n", outputStream.toString());

    }

    @Test
    public void generateFactorsWithoutDuplicatedFactors() throws Exception {
        List<Integer> factors = exerciser.generate(30);
        assertEquals(3, factors.size());
        assertEquals(2, factors.get(0).intValue());
        assertEquals(3, factors.get(1).intValue());
        assertEquals(5, factors.get(2).intValue());
    }

    @Test
    public void generateFactorsWithDuplicatedFactors() throws Exception {
        List<Integer> factors = exerciser.generate(36);
        assertEquals(2, factors.size());
        assertEquals(2, factors.get(0).intValue());
        assertEquals(3, factors.get(1).intValue());
    }

    @Test
    public void generateFactorsForOneShouldReturnEmptyList() throws Exception {
        List<Integer> factors = exerciser.generate(1);
        assertEquals(0, factors.size());
    }

    @Test
    public void generateFactorsForPrimeShouldReturnItself() throws Exception {
        List<Integer> factors = exerciser.generate(13);
        assertEquals(1, factors.size());
        assertEquals(13, factors.get(0).intValue());
    }
}