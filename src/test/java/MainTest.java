import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
public class MainTest {
    Main main;

    @BeforeAll
    public static void setUpAll() {
        System.out.println("All test started");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("All test ended");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Test started");
        main = new Main();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Test ended");
        main = null;
    }


    @Test
    public void tax6Test() {
        int a = 600, b = 0, expected = 36;
        var main = new Main();
        var result = main.tax6(600, 0);
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void sum() {
        int a = 5, b = 3, expected = 8;
        var main = new Main();
        var result = main.sum(5, 3);
        Assertions.assertEquals(expected, result);

    }

    @MethodSource("methodSourse")
    @ParameterizedTest
    public void parameterizedTax15Test(int a, int b, int expected) {

        var result = main.tax15(a, b);
        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> methodSourse() {
        return Stream.of(Arguments.of(300, 100, 30),
                Arguments.of(400, 100, 45)
        );
    }

}
