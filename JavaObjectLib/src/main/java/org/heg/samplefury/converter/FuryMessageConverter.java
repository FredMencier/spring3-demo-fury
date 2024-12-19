package org.heg.samplefury.converter;

import com.google.common.collect.Lists;
import org.apache.fury.Fury;
import org.apache.fury.config.Language;
import org.apache.fury.io.FuryInputStream;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FuryMessageConverter extends AbstractHttpMessageConverter<Object> {

    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    private final Fury fury;

    private static List<MediaType> mimeTypeList = Lists.newArrayList();

    static {
        mimeTypeList.add(new MediaType("application", "json", DEFAULT_CHARSET));
        mimeTypeList.add(new MediaType("application", "*+json", DEFAULT_CHARSET));
    }

    public FuryMessageConverter() {
        this.fury = Fury.builder().withLanguage(Language.JAVA).withAsyncCompilation(true).build();
        this.setSupportedMediaTypes(mimeTypeList);
    }

    public FuryMessageConverter(Fury fury) {
        this.fury = fury;
        this.setSupportedMediaTypes(mimeTypeList);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        InputStream body = inputMessage.getBody();
        FuryInputStream furyInputStream = new FuryInputStream(body);
        return fury.deserialize(furyInputStream);
    }

    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        byte[] serialize = fury.serialize(object);
        StreamUtils.copy(serialize, outputMessage.getBody());
    }
}
