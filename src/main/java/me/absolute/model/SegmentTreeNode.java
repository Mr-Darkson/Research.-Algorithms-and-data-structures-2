package me.absolute.model;

import java.util.Arrays;

public class SegmentTreeNode {
    private final long value;
    private long modifier;
    private final long leftBorder;

    private final long rightBorder;
    private SegmentTreeNode left;
    private SegmentTreeNode right;


    public SegmentTreeNode(long leftBound, long rightBound, long value) {
        this(leftBound, rightBound, value, null, null);
    }

    private SegmentTreeNode(long leftBound, long rightBound, long value, SegmentTreeNode left, SegmentTreeNode right) {
        this(leftBound, rightBound, value, left, right, 0);
    }

    private SegmentTreeNode(long leftBound, long rightBound, long value, SegmentTreeNode left, SegmentTreeNode right, long modifier) {
        this.left = left;
        this.right = right;
        this.leftBorder = leftBound;
        this.rightBorder = rightBound;
        this.value = value;
        this.modifier = modifier;
    }



    private SegmentTreeNode copyWith(long newValue, long newModifier) {
        return new SegmentTreeNode(leftBorder, rightBorder, newValue, left, right, newModifier);
    }

    public long get(long index) {
        if (index < leftBorder || index >= rightBorder) {
            return 0;
        }

        SegmentTreeNode current = this;
        while (current.left != null && current.right != null) {
            current.propagate();

            long mid = (current.rightBorder + current.leftBorder) / 2;
            if (index < mid) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return current.value;
    }

    private void propagate() {
        if (modifier == 0) return;

        left = left.addToAllChildren(modifier);
        right = right.addToAllChildren(modifier);

        modifier = 0;
    }



    private SegmentTreeNode addToAllChildren(long value) {
        return copyWith(
                this.value + value * amountOfChildren(),
                (left != null || right != null) ? modifier + value : modifier
        );
    }

    private long amountOfChildren() {
        return rightBorder - leftBorder;
    }

    private SegmentTreeNode addToForEachInIntersection(long value, long l, long r) {
        long amount = intersectionSize(l, r);

        return copyWith(this.value + value * amount, modifier);
    }

    private long intersectionSize(long l, long r) {
        l = Math.max(l, leftBorder);
        r = Math.min(r, rightBorder);

        if (l >= rightBorder || r <= leftBorder) return 0;

        return r - l;
    }


    public static SegmentTreeNode build(long[] values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("Array's size can not be zero!");
        }

        return build(values, 0);
    }

    private static SegmentTreeNode build(long[] values, long offset) {
        if (values.length == 1) {
            return new SegmentTreeNode(offset, offset + 1, values[0]);
        }
        long[] leftValues = Arrays.copyOfRange(values, 0, (int) values.length / 2);
        long[] rightValues = Arrays.copyOfRange(values, (int) values.length / 2, values.length);

        return new SegmentTreeNode(offset,
                values.length + offset,
                Arrays.stream(values).sum(),
                build(leftValues, offset),
                build(rightValues, values.length / 2 + offset)
        );
    }

    public SegmentTreeNode addToSegment(long value, long l, long r) {
        if (doesFullIntersect(l, r)) {
            return addToAllChildren(value);
        } else if (doesIntersect(l, r)) {
            SegmentTreeNode newNode = addToForEachInIntersection(value, l, r);
            newNode.left = newNode.left.addToSegment(value, l, r);
            newNode.right = newNode.right.addToSegment(value, l, r);
            return newNode;
        }

        return this;
    }

    private boolean doesFullIntersect(long l, long r) {
        return leftBorder >= l && rightBorder <= r;
    }

    private boolean doesIntersect(long l, long r) {
        l = Math.max(l, leftBorder);
        r = Math.min(r, rightBorder);

        return l < rightBorder && r > leftBorder;
    }

}
