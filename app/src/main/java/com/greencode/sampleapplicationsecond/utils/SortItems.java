package com.greencode.sampleapplicationsecond.utils;

import com.greencode.sampleapplicationsecond.model.Products;

import java.util.Comparator;

public class SortItems implements Comparator<Products> {
    public int compare(Products a, Products b) {
        return b.getCategory().compareTo(a.getCategory());
        //TODO Update here date wise
    }
}
