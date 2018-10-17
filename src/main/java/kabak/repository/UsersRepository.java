package kabak.repository;

import kabak.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

    @Query("SELECT s FROM Users s WHERE s.name = :name")
    Users findByName(@Param("name") String name);
}
