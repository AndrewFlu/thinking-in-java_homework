package chapters.eight.polyconstructor;

public class RectangularGlyph extends Glyph {
    private int width = 5;
    private int height = 7;

    public RectangularGlyph(int width, int height) {
        this.width = width;
        this.height = height;
        System.out.println(String.format("RectangularGlyph(int width, int height), width = %s, height = %s", width, height));
    }

    @Override
    void draw() {
        System.out.println("RectangularGlyph.draw(), width = " + width + " height = " + height);
    }
}
