package dev.eeasee.player_tracker.utils;

public class Pair<A, B> extends net.minecraft.util.Pair<A, B> {
    public Pair(A left, B right) {
        super(left, right);
    }

    @Override
    public String toString() {
        return "A: {" + this.getLeft() + "}" + "B: {" + this.getRight() + "}";
    }
}
