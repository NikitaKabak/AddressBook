package kabak.service;

import kabak.entity.Email;
import kabak.entity.Users;

public interface ServiceEmail {

    public Email create(Users user, String email) throws Exception;
}
