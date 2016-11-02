package com.constantcontact.v2.library;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * @author woogienoogie
 */
public enum FileType {
    JPG,
    GIF,
    PDF,
    PNG,
    DOC,
    XLS,
    PPT,
    DOCX,
    XLSX,
    PPTX;

    @JsonCreator
    public static FileType create(String str) {
        if (str.equalsIgnoreCase("jpeg") || str.equalsIgnoreCase("jpg")) {
            return JPG;
        }
        if (str.equalsIgnoreCase("gif")) {
            return GIF;
        }
        if (str.equalsIgnoreCase("pdf")) {
            return PDF;
        }
        if (str.equalsIgnoreCase("png")) {
            return PNG;
        }
        if (str.equalsIgnoreCase("doc")) {
            return DOC;
        }
        if (str.equalsIgnoreCase("xls")) {
            return XLS;
        }
        if (str.equalsIgnoreCase("ppt")) {
            return PPT;
        }
        if (str.equalsIgnoreCase("docx")) {
            return DOCX;
        }
        if (str.equalsIgnoreCase("xlsx")) {
            return XLSX;
        }
        if (str.equalsIgnoreCase("pptx")) {
            return PPTX;
        }


        throw new IllegalArgumentException("Invalid file type passed: " + str);
    }

    public static FileType createFromMimeType(String mimeType) {
        final String mimeTypeLower = mimeType.toLowerCase();
        if (mimeTypeLower.equals("image/jpeg")) {
            return JPG;
        }
        if (mimeTypeLower.equals("image/png")) {
            return PNG;
        }
        if (mimeTypeLower.equals("image/gif")) {
            return GIF;
        }
        if (mimeTypeLower.equals("application/vnd.ms-excel")) {
            return XLS;
        }
        if (mimeTypeLower.equals("application/vnd.ms-powerpoint")) {
            return PPT;
        }
        if (mimeTypeLower.equals("application/vnd.ms-word")) {
            return DOC;
        }
        if (mimeTypeLower.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return XLSX;
        }
        if (mimeTypeLower.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation")) {
            return PPTX;
        }
        if (mimeTypeLower.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
            return DOCX;
        }
        if (mimeTypeLower.equals("application/pdf")) {
            return PDF;
        }
        return PNG;
    }
}
