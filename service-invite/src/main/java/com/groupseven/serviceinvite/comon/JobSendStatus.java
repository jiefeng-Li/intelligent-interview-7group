package com.groupseven.serviceinvite.comon;

import lombok.Data;

@Data
public class JobSendStatus {
    public static class status {
        public static final String PASS = "1";
        public static final String NOT_PASS = "0";

        public static final String DELETED = "2";
    }

    public static class viewed{
        public static final String VIEWED = "1";
        public static final String NOT_VIEWED = "0";
    }
}
