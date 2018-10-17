package kabak.service;

import kabak.entity.Email;
import kabak.entity.Telephonnumber;
import kabak.entity.Users;
import kabak.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ServiceUsersImpl<T,PK> implements ServiceUsers<T,PK> {

    @Autowired
    private UsersRepository usersRepository; // it is for repository

    @Autowired
    private ServiceEmailImpl serviceEmailImpl;
    @Autowired
    private ServiceTelephonnumberImpl serviceTelephonnumberImpl;

    @Override
    public Users create(String name, String address,
                        String comments, String firstname,
                        String lastname, String position,
                        String email, String telephonnumber) throws Exception {

        Users user = new Users();
        List<Email> emailList = new ArrayList<>();
        List<Telephonnumber> telephonnumberList = new ArrayList<>();

        user.setName(name);
        user.setAddress(address);
        user.setComments(comments);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setPosition(position);
        Email emaill = serviceEmailImpl.create(user,email);
        emailList.add(emaill);
        user.setEmailList(emailList);
        Telephonnumber telephonnumber1 = serviceTelephonnumberImpl.create(user,telephonnumber);
        telephonnumberList.add(telephonnumber1);
        user.setTelephonnumberList(telephonnumberList);

        Users userEntity = usersRepository.saveAndFlush(user);
        return userEntity;
    }

    @Override
    public Users read(Integer id) throws Exception {
        Users user = usersRepository.getOne(id);
        return user;
    }

    @Override
    public Users update(Users user) throws Exception {
        Users userEntity = usersRepository.saveAndFlush(user);
        return userEntity;

    }

    @Override
    public void delete(Users user) throws Exception {

    }

    public Users show(String name)throws Exception{
        Users user = new Users();
        user = usersRepository.findByName(name);
        return user;
    }

    public List<Users> showAll()throws Exception{
        List<Users> usersList = new ArrayList<>();
        usersList = usersRepository.findAll();
        return usersList;
    }


    public void edit(Integer iduser, String name, String address, String comments, String firstname, String lastname, String position, String[] email, String[] telephonnumber) throws Exception {
        Users user = usersRepository.getOne(iduser);
        user.setName(name);
        user.setAddress(address);
        user.setComments(comments);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setPosition(position);
        List<Email> emailList = new ArrayList<>();

        int i = 0;
            for(Email email1 : user.getEmailList()){

                email1.setEmail(email[i]);
                i++;
                emailList.add(email1);
            }
            user.setEmailList(emailList);

        List<Telephonnumber> telephonnumberList = new ArrayList<>();
        int j = 0;
        for(Telephonnumber telephonnumber1 :  user.getTelephonnumberList()){

            telephonnumber1.setTelephonnumber(telephonnumber[j]);
            j++;
            telephonnumberList.add(telephonnumber1);
        }

        Users userEntity = usersRepository.saveAndFlush(user);

    }
}
