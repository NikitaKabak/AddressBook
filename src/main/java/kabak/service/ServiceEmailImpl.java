package kabak.service;

import kabak.entity.Email;
import kabak.entity.Telephonnumber;
import kabak.entity.Users;
import kabak.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEmailImpl implements ServiceEmail {

    @Autowired
    private EmailRepository emailRepository;

    @Override
    public Email create(Users user, String email) throws Exception {

        Email email1Entity = new Email();
        email1Entity.setUser(user);
        email1Entity.setEmail(email);
        return email1Entity;
    }

    public void deleteByUser (Users user)throws Exception {
        emailRepository.deleteInBatch(findByUser(user));
    }

    public List<Email> findByUser(Users user)throws Exception{
        List<Email> emailList = emailRepository.findByUser(user);
        return emailList;
    }
}
