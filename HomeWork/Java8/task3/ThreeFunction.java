package io.harmed;

@FunctionalInterface
public interface ThreeFunction<A, B, C, D> {

    public D apply(A first, B second, C third);

    static Integer getPercentage(){
        return 10;
    }
}
