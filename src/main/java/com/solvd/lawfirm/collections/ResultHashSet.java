package com.solvd.lawfirm.collections;

import com.solvd.lawfirm.entity.result.Result;

import java.util.HashSet;
import java.util.Set;

public class ResultHashSet {
    private Result result;

    public Set<Result> getResultHashSet(Result result) {
        Set<Result> resultHashSet = new HashSet<>();
        resultHashSet.add(result);
        resultHashSet.stream()
                .peek(System.out::print)
                .forEach(s -> System.out.println(" " + s.hashCode()));
        return resultHashSet;
    }
    @Override
    public String toString() {
        return "ResultHashSet{" +
                "result=" + result +
                '}';
    }
}


