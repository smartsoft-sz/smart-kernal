package com.smart.dao;


import com.smart.core.Mapper;
import com.smart.model.KeySeq;

public interface KeySeqMapper extends Mapper<KeySeq> {

    void resetSeq();
}