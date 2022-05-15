package dio.challenge.designpatterns.service;

import dio.challenge.designpatterns.model.Address;
import dio.challenge.designpatterns.model.AddressRepository;
import dio.challenge.designpatterns.model.Client;
import dio.challenge.designpatterns.model.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/* Singleton: injects Spring components using @Autowired.
   Strategy: implements interface methods.
   Facade: integrations with subsystems, providing a simple interface.
*/

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void insert(Client client) {
        saveClientByCep(client);
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> clientBD = clientRepository.findById(id);
        if (clientBD.isPresent()) {
            saveClientByCep(client);
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private void saveClientByCep(Client client) {
        String cep = client.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = viaCepService.consultCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);
        clientRepository.save(client);
    }

}
