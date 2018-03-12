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

package com.constantcontact.v2.library;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 */
public enum FileStatus {
    ACTIVE,
    PROCESSING,
    UPLOADED,
    VIRUS_FOUND,
    FAILED,
    DELETED;

    @JsonValue
    @Override
    public String toString() {
        switch (this) {
            default:
            case ACTIVE:
                return "Active";

            case PROCESSING:
                return "Processing";

            case UPLOADED:
                return "Uploaded";

            case VIRUS_FOUND:
                return "VirusFound";

            case FAILED:
                return "Failed";

            case DELETED:
                return "Deleted";
        }
    }

    @JsonCreator
    public static FileStatus create(String str) {
        if (str.equalsIgnoreCase("active")) {
            return ACTIVE;
        }
        if (str.equalsIgnoreCase("processing")) {
            return PROCESSING;
        }
        if (str.equalsIgnoreCase("uploaded")) {
            return UPLOADED;
        }
        if (str.equalsIgnoreCase("virusfound")) {
            return VIRUS_FOUND;
        }
        if (str.equalsIgnoreCase("failed")) {
            return FAILED;
        }
        if (str.equalsIgnoreCase("deleted")) {
            return DELETED;
        }

        throw new IllegalArgumentException("Invalid file status passed: " + str);
    }
}
