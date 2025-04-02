package com.example.kafka.serdes;

import com.example.kafka.util.StaticUtils;
import io.apicurio.registry.serde.jsonschema.JsonSchemaKafkaDeserializer;

import java.util.Map;

public class CustomJsonSchemaKafkaDeserializer<T> extends JsonSchemaKafkaDeserializer<T> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        setObjectMapper(StaticUtils.getCustomizedObjectMapper());

        super.configure(configs, isKey);
    }

}
