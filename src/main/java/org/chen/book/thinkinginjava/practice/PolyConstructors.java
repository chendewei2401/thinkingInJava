package org.chen.book.thinkinginjava.practice;

/**
 * 功能点：方法是运行时绑定的，覆盖后，即使是父类调用该方法，也会调用覆盖后的方法，即子类的方法
 */

class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }
    Glyph() {
        System.out.println("Glyph before draw");
        draw();
        System.out.println("Glyph after draw");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;
    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph.radius=" + radius);
    }
    void draw() {
        System.out.println("RoundGlyph.draw.radius=" + radius);
    }
}

public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
