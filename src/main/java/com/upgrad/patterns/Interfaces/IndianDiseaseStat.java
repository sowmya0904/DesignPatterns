package com.upgrad.patterns.Interfaces;


import com.upgrad.patterns.Constants.SourceType;

public interface IndianDiseaseStat {

    String GetActiveCount();

    IndianDiseaseStat GetInstance(SourceType sourceEnum);
}
