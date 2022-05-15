package dio.challenge.designpatterns.service;

import dio.challenge.designpatterns.model.Client;
import org.springframework.stereotype.Service;

/* Singleton: injects Spring components using @Autowired.
      Strategy: implements interface methods.
      Facade: integrations with subsystems, providing a simple interface.
    */

@Service
public class ClientServiceImpl implements ClientService{
    @Override
    public Iterable<Client> findAll() {
        return null;
    }

    @Override
    public Client findById(Long id) {
        return null;
    }

    @Override
    public void insert(Client client) {

    }

    @Override
    public void update(Long id, Client client) {

    }

    @Override
    public void delete(Long id) {

    }

}
