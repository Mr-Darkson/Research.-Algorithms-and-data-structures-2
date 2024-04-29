package me.absolute.model;

public record Rectangle(
        Point leftBottom,
        Point rightTop
        ) {

        public Pair<Long, Long> getYRange() {
                return Pair.of(leftBottom.y(), rightTop.y());
        }
}
