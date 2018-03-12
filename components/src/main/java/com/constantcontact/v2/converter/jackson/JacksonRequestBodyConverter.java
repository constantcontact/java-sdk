/*
 * Copyright (c) 2016 Constant Contact, Inc. All Rights Reserved.
 * Boston, MA 02451, USA
 * Phone: (781) 472-8100
 * Fax: (781) 472-8101
 * This software is the confidential and proprietary information
 * of Constant Contact, Inc. created for Constant Contact, Inc.
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Constant Contact, Inc.
 */

package com.constantcontact.v2.converter.jackson;

import com.fasterxml.jackson.databind.ObjectWriter;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

import java.io.IOException;

final class JacksonRequestBodyConverter<T> implements Converter<T, RequestBody> {
  private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");

  private final ObjectWriter adapter;

  JacksonRequestBodyConverter(ObjectWriter adapter) {
    this.adapter = adapter;
  }

  @Override public RequestBody convert(T value) throws IOException {
    byte[] bytes = adapter.writeValueAsBytes(value);
    return RequestBody.create(MEDIA_TYPE, bytes);
  }
}
