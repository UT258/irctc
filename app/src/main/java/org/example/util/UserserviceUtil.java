package org.example.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class UserserviceUtil {
    public  String  hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    //now to decrypt the password
    public  boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
