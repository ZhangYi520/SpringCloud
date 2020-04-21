package com.zy.common.Service;

import com.zy.common.base.util.ReturnResult;

public interface MyBlogsListService {
    ReturnResult getList(Integer page, Integer pageSize);
}
