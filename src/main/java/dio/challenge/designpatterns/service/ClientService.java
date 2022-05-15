package dio.challenge.designpatterns.service;

import dio.challenge.designpatterns.model.Client;

// Strategy pattern.
public interface ClientService {

    Iterable<Client> findAll();

    Client findById(Long id);

    void insert(Client client);

    void update(Long id, Client client);

    void delete(Long id);

}
