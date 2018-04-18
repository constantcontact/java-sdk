package com.constantcontact.v2.converter.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class RemoveNonISO8859_1StringSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String value, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider)
        throws IOException, JsonProcessingException {
        String allAscii = removeNonASCIIChar(value);
        System.out.println("serialized string: " + allAscii);
        jsonGenerator.writeString(allAscii);
    }

    private String removeNonASCIIChar(String str) {

        StringBuffer buff = new StringBuffer();
        char chars[] = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (0 < chars[i] && chars[i] < 256) {

                buff.append(chars[i]);
            }
        }
        if (buff.length() == 0)
            return "X";
        return buff.toString();
    }

}
