package kabak.service;

import kabak.entity.Telephonnumber;
import kabak.entity.Users;
import kabak.repository.TelephonnumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTelephonnumberImpl implements ServiceTelephonnumber {

    @Autowired
    private TelephonnumberRepository telephonnumberRepository;

    @Override
    public Telephonnumber create(Users user, String telephonnumber) throws Exception {

        Telephonnumber telephonnumberEntity = new Telephonnumber();
        telephonnumberEntity.setUser(user);
        telephonnumberEntity.setTelephonnumber(telephonnumber);
        return telephonnumberEntity;
    }

    public void deleteByUser (Users user) throws Exception {
        telephonnumberRepository.deleteInBatch(findByUser(user));
    }

    public List<Telephonnumber> findByUser(Users user) throws Exception {
        List<Telephonnumber> telephonnumberList = telephonnumberRepository.findByUser(user);
        return telephonnumberList;
    }

}
