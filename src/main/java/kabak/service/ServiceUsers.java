package kabak.service;

import kabak.entity.Users;

public interface ServiceUsers<T,PK> {

    public Users create(String name, String address,
                        String comments, String firstname,
                        String lastname, String position,
                        String email,String telephonnumber) throws Exception;



    public Users read(Integer id) throws Exception;
    public Users  update(Users user) throws Exception;
    public void delete(Users user) throws Exception;
}

