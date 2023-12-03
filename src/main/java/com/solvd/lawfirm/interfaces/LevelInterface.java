package com.solvd.lawfirm.interfaces;

@FunctionalInterface
public interface LevelInterface<T> {
    int getLevel(T t);
}
