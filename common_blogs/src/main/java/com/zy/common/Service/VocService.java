package com.zy.common.Service;

import com.zy.common.entity.Voc;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VocService {
    List<Voc> getSonListByVocCode(String vocCode);
}
