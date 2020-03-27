package com.zy.rabbitmq.service;

import java.util.Map;

public interface Strategy {

    public void doJob(Map<String, Object> params) throws Exception;
}
