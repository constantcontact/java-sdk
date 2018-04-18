package com.constantcontact.v2.converter.jackson;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class RemoveNonISO8859_1StringSerializerTests {

    private static final String JUST_EMOTICONS = "😉😉";
    private static final String EMOTICONS_AND_TEXT = "😉😉 \u00F0 Other Text";
    private static final String PLAIN_TEXT = "Hello There";
    private static Map<String, String> TESTS = new HashMap<>();

    static {
        // The serializer serializes the double quotes as well, so
        // they have to be included in the resulting string to be tested for
        TESTS.put(JUST_EMOTICONS, "\"X\"");
        TESTS.put(EMOTICONS_AND_TEXT, "\" \u00F0 Other Text\"");
        TESTS.put(PLAIN_TEXT, "\"" + PLAIN_TEXT + "\"");
    }

    @Test
    public void testISO8859_1Serialization() throws IOException {
        for (Map.Entry entry : TESTS.entrySet()) {
            Writer jsonWriter = new StringWriter();
            JsonGenerator jsonGenerator = new JsonFactory().createGenerator(jsonWriter);
            SerializerProvider serializerProvider = new ObjectMapper().getSerializerProvider();
            RemoveNonISO8859_1StringSerializer serializer = new RemoveNonISO8859_1StringSerializer();
            serializer.serialize((String)entry.getKey(), jsonGenerator, serializerProvider);
            jsonGenerator.flush();
            assertThat(jsonWriter.toString(), is(equalTo(entry.getValue())));
        }

    }

}
