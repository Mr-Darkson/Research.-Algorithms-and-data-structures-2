package me.absolute.model;

public record Point(long x, long y) {
    public static Point of(long x, long y) {
        return new Point(x, y);
    }

    public boolean isInside(Rectangle r) {
        long lMinX = r.leftBottom().x;
        long lMinY = r.leftBottom().y;
        long rMaxX = r.rightTop().x;
        long rMaxY = r.rightTop().y;

        return (lMinX <= x && x < rMaxX) &&
                (lMinY <= y && y < rMaxY);
    }

}
