package kabak.repository;

import kabak.entity.Telephonnumber;
import kabak.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelephonnumberRepository extends JpaRepository<Telephonnumber,Integer> {

    @Query("DELETE  FROM Telephonnumber s WHERE s.user = :user")
    void deleteByIduser(@Param("user") Users user);

    @Query("SELECT s FROM Telephonnumber s WHERE s.user = :user")
    List<Telephonnumber> findByUser(@Param("user") Users user);
}
