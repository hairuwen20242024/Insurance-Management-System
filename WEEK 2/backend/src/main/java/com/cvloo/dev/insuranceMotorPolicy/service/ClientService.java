package com.cvloo.dev.insuranceMotorPolicy.service;


import com.cvloo.dev.insuranceMotorPolicy.domain.Client;
import com.cvloo.dev.insuranceMotorPolicy.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client clientDetails) {
        Client client = getClientById(id);
        client.setName(clientDetails.getName());
        client.setEmail(clientDetails.getEmail());
        client.setMailingAddress(clientDetails.getMailingAddress());
        client.setPermanentAddress(clientDetails.getPermanentAddress());
        client.setTelephoneNumber(clientDetails.getTelephoneNumber());
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
