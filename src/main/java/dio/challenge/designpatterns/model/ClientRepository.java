package dio.challenge.designpatterns.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository  //optional
public interface ClientRepository extends CrudRepository<Client, Long> {
}
