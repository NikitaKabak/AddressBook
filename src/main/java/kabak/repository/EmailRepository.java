package kabak.repository;

import kabak.entity.Email;
import kabak.entity.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmailRepository  extends JpaRepository<Email,Integer> {


    @Query("DELETE  FROM Email s WHERE  s.user = :user")
    void deleteByIduser(@Param("user") Users user);

    @Query("SELECT s FROM Email s WHERE s.user = :user")
    List<Email> findByUser(@Param("user") Users user);
}
