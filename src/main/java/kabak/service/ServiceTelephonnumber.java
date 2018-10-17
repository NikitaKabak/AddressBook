package kabak.service;

import kabak.entity.Telephonnumber;
import kabak.entity.Users;

public interface ServiceTelephonnumber {
    public Telephonnumber create(Users user, String telephonnumber) throws Exception;
}
