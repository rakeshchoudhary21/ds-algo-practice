package com.ds.graphs.algos.util;

import lombok.Data;

@Data
public class Pair<K> {

    private K left;
    private K right;

    private Pair(){}

    private Pair(K left, K right){
        this.left = left;
        this.right = right;
    }

    public static Pair of(Object left,Object right){
        return new Pair(left,right);
    }
}
