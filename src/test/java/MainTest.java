import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

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
        if (result != expected) {
            throw new RuntimeException("Что-то пошло не так");
        }
    }

    @MethodSource("methodSourse")
    @ParameterizedTest
    public void parameterizedTax15Test(int a, int b, int expected) {

        var result = main.tax15(a, b);
        if (result != expected) {
            throw new RuntimeException("Что-то пошло не так");
        }
    }

    public static Stream<Arguments> methodSourse() {
        return Stream.of(Arguments.of(300, 100, 30),
                Arguments.of(400, 100, 45)
        );
    }

}
