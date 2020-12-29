import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

public class DependencyCalculatorTest {

    @Test
    public void Test_Basic() {
        DependencyCalculator dc = new DependencyCalculator();
        dc.addDepenency("a", new HashSet<>(Arrays.asList(new String[]{"b", "c"})));
        dc.addDepenency("b", new HashSet<>(Arrays.asList(new String[]{"c", "e"})));
        dc.addDepenency("c", new HashSet<>(Arrays.asList(new String[]{"g"})));
        dc.addDepenency("d", new HashSet<>(Arrays.asList(new String[]{"a", "f"})));
        dc.addDepenency("e", new HashSet<>(Arrays.asList(new String[]{"f"})));
        dc.addDepenency("f", new HashSet<>(Arrays.asList(new String[]{"h"})));

        assertEquals(new HashSet<>(Arrays.asList(new String[]{"b", "c", "e", "f", "g", "h"})), dc.dependenciesFor("a"));
        assertEquals(new HashSet<>(Arrays.asList(new String[]{"c", "e", "f", "g", "h"})), dc.dependenciesFor("b"));
        assertEquals(new HashSet<>(Arrays.asList(new String[]{"g"})), dc.dependenciesFor("c"));
        assertEquals(new HashSet<>(Arrays.asList(new String[]{"a", "b", "c", "e", "f", "g", "h"})), dc.dependenciesFor("d"));
        assertEquals(new HashSet<>(Arrays.asList(new String[]{"f", "h"})), dc.dependenciesFor("e"));
        assertEquals(new HashSet<>(Arrays.asList(new String[]{"h"})), dc.dependenciesFor("f"));
    }

}