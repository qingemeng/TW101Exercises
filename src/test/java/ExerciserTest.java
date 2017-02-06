import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class ExerciserTest {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    Exerciser exerciser = Exerciser.getInstance();

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

}