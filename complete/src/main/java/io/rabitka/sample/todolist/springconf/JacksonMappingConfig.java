/*
 *
 * Copyright (c) 2017 Rabitka Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.rabitka.sample.todolist.springconf;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.rabitka.core.ddd.Validatable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author Wassim ABID wassim.abid@rabitka.io
 */
@Configuration
public class JacksonMappingConfig {


    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter() {
            @Override
            public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException {
                return super.read(type, contextClass, inputMessage);
            }
        };
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule jsonModule = new SimpleModule();
        jsonModule.setDeserializerModifier(new BeanDeserializerModifier() {
            @Override
            public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
                if (Validatable.class.isAssignableFrom(beanDesc.getType().getRawClass())) {
                    return new CustomBeanDeserializer((BeanDeserializerBase) deserializer);
                }

                return super.modifyDeserializer(config, beanDesc, deserializer);
            }
        });
        objectMapper.registerModule(jsonModule);
        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        jsonConverter.setObjectMapper(objectMapper);
        return jsonConverter;
    }
}
