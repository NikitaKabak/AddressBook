package kabak.repository;

import kabak.entity.Telephonnumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelephonnumberRepository extends JpaRepository<Telephonnumber,Integer> {
}
