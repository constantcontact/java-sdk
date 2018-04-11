package com.constantcontact.v2.converter.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class RemoveNonAsciiStringSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String value, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider)
        throws IOException, JsonProcessingException {
        String allAscii = removeNonASCIIChar(value);
        jsonGenerator.writeString(allAscii);
    }

    private String removeNonASCIIChar(String str) {

        StringBuffer buff = new StringBuffer();
        char chars[] = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (0 < chars[i] && chars[i] < 127) {

                buff.append(chars[i]);
            }
        }
        return buff.toString();
    }

}
