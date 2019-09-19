package com.keith.security.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;
@Data
@Component
public class UserInfo {
        private String username;
        private String password;
        private String phone;

}
