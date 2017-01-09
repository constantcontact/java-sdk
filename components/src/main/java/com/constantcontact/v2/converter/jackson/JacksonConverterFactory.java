package com.constantcontact.v2.converter.jackson;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * The converter factory used for Jackson JSON conversion
 */
public class JacksonConverterFactory extends Converter.Factory {
    private static String[] CAMPAIGN_CREATE_UPDATE_FIELDS = {
            "name",
            "subject",
            "from_name",
            "sent_to_contact_lists",
            "from_name",
            "from_email",
            "reply_to_email",
            "email_content",
            "text_content",
            "is_permission_reminder_enabled",
            "permission_reminder_text",
            "message_footer"
    };

    /**
     * Create an instance using a default {@link ObjectMapper} instance for conversion.
     *
     * @return A new instance of the converter factory with default {@link ObjectMapper}
     */
    public static JacksonConverterFactory create() {
        return create(new ObjectMapper());
    }

    /**
     * Create an instance using {@code mapper} for conversion.
     *
     * @param mapper the mapper that will be used by the factory when creating converters
     * @return a new instance of the converter facotyr
     */
    public static JacksonConverterFactory create(ObjectMapper mapper) {
        return new JacksonConverterFactory(mapper);
    }

    private final ObjectMapper mapper;
    private final SimpleFilterProvider writerFilterProvider;

    /**
     * Creates a new instance.
     *
     * @param mapper the object mapper used when creating converter instances.
     */
    private JacksonConverterFactory(ObjectMapper mapper) {
        if (mapper == null) {
            throw new NullPointerException("mapper == null");
        }
        this.mapper = mapper;

        final SimpleBeanPropertyFilter campaignCreateUpdateFilter = SimpleBeanPropertyFilter.filterOutAllExcept(CAMPAIGN_CREATE_UPDATE_FIELDS);
        this.writerFilterProvider = new SimpleFilterProvider().addFilter("CampaignCreateUpdateFilter", campaignCreateUpdateFilter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type,
                                                            Annotation[] annotations,
                                                            Retrofit retrofit) {
        JavaType javaType = mapper.getTypeFactory().constructType(type);
        ObjectReader reader = mapper.readerFor(javaType);
        return new JacksonResponseBodyConverter<>(reader);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                          Annotation[] parameterAnnotations,
                                                          Annotation[] methodAnnotations,
                                                          Retrofit retrofit) {
        JavaType javaType = mapper.getTypeFactory().constructType(type);
        ObjectWriter writer = mapper.writerFor(javaType).with(writerFilterProvider);
        return new JacksonRequestBodyConverter<>(writer);
    }
}
