package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class TriangleTest {
    @Test
    void whenA00B03C20Then3() {
        Point  a = new Point(0, 0);
        Point  b = new Point(0, 3);
        Point  c = new Point(2, 0);
        Triangle trig = new Triangle(a, b, c);
        double expected = 3;
        double result = trig.area();
        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void whenA05B48C96Then11dec5() {
        Point  a = new Point(0, 5);
        Point  b = new Point(4, 8);
        Point  c = new Point(9, 6);
        Triangle trig = new Triangle(a, b, c);
        double expected = 11.5;
        double result = trig.area();
        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void whenA30B70Cx11y0ThenMinus1() {
        Point  a = new Point(3, 0);
        Point  b = new Point(7, 0);
        Point  c = new Point(11, 0);
        Triangle trig = new Triangle(a, b, c);
        double expected = -1;
        double result = trig.area();
        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }
}