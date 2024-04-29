package me.absolute.model;

import java.util.ArrayList;
import java.util.List;

public class PersistSegmentTree {

    public static final PersistSegmentTree ZERO_TREE = new PersistSegmentTree(new long[]{0});
    private SegmentTreeNode root;
    private long x = -1;
    private final List<SegmentTreeNode> states = new ArrayList<>();

    public PersistSegmentTree(long[] values) {
        root = SegmentTreeNode.build(values);
    }

    public void switchState(int index) {
        if(states.size() <= index || index < 0) {
            root = ZERO_TREE.root;
        }
        else if (index < states.size() - 1) {
            root = states.get(index);
            states.add(root);
        }
    }

    public long get(int index) {
        return root.get(index);
    }

    public void addToSegment(long value, int left, int right, long x) {
        var newState = root.addToSegment(value, left, right);
        root = newState;

        if (this.x != x) {
            states.add(newState);
            this.x = x;
        }
    }
}
