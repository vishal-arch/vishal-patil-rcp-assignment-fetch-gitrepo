package com.rcp.gitrepo.configuration;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import net.logstash.logback.decorate.JsonFactoryDecorator;

public class LogstashJavaTimeModuleDecorator implements JsonFactoryDecorator {

    public LogstashJavaTimeModuleDecorator() {
    }

    public JsonFactory decorate(JsonFactory factory) {
        ObjectMapper codec = (ObjectMapper)factory.getCodec();
        codec.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return factory;
    }
}
