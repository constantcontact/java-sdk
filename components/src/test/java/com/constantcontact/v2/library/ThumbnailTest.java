package com.constantcontact.v2.library;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
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

    @Test
    public void testEqualsAndHash() {
        Thumbnail thumbnail1 = new Thumbnail();
        thumbnail1.setUrl(URL);
        thumbnail1.setHeight(HEIGHT);
        thumbnail1.setWidth(WIDTH);
        Thumbnail thumbnail2 = new Thumbnail();
        thumbnail2.setUrl(URL);
        thumbnail2.setHeight(HEIGHT);
        thumbnail2.setWidth(WIDTH);

        int hash1 = thumbnail1.hashCode();
        int hash2 = thumbnail2.hashCode();

        assertThat(thumbnail1.equals(thumbnail2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertions(Thumbnail thumbnail) {
        assertThat(thumbnail.getUrl(), is(URL));
        assertThat(thumbnail.getHeight(), is(HEIGHT));
        assertThat(thumbnail.getWidth(), is(WIDTH));
    }
}
