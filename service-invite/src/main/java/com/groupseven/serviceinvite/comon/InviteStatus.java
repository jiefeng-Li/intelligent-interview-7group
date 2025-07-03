package com.groupseven.serviceinvite.comon;


import lombok.Data;

@Data
public class InviteStatus {
    public static class reply {
        public static final String PENDING = "0"; // default 待定
        public static final String ACCEPTED = "1"; // 接受
        public static final String REFUSE = "2";   // 拒绝
    }
}
