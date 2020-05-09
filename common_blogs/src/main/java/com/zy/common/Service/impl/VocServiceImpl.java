package com.zy.common.Service.impl;

import com.netflix.discovery.converters.Auto;
import com.sun.istack.internal.NotNull;
import com.zy.common.Service.VocService;
import com.zy.common.dao.VocMapper;
import com.zy.common.entity.Voc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VocServiceImpl implements VocService {

    @Autowired
    private VocMapper vocMapper;
    @Override
    public List<Voc> getSonListByVocCode(@NotNull String vocCode) {
        return vocMapper.getSonListByVocCode(vocCode);
    }
}
