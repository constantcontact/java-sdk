package com.constantcontact.v2.library;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
 */
public class ThumbnailTest {
    private static final String URL = "http://constantcontact.com";

    private static final int HEIGHT = 50;

    private static final int WIDTH = 51;

    static Thumbnail createThumbnail() {
        Thumbnail thumbnail = new Thumbnail();
        thumbnail.setUrl(URL);
        thumbnail.setHeight(HEIGHT);
        thumbnail.setWidth(WIDTH);
        return thumbnail;
    }

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        Thumbnail thumbnail = new Thumbnail();

        thumbnail.setUrl(URL);
        thumbnail.setHeight(HEIGHT);
        thumbnail.setWidth(WIDTH);

        runAssertions(thumbnail);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        Thumbnail thumbnail = new Thumbnail();
        thumbnail.setUrl(URL);
        thumbnail.setHeight(HEIGHT);
        thumbnail.setWidth(WIDTH);

        Thumbnail out = SerializationUtils.roundtrip(thumbnail);

        runAssertions(out);
    }

    static void runAssertions(Thumbnail thumbnail) {
        assertThat(thumbnail.getUrl(), is(URL));
        assertThat(thumbnail.getHeight(), is(HEIGHT));
        assertThat(thumbnail.getWidth(), is(WIDTH));
    }
}
