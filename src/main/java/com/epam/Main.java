package com.epam;

import com.epam.client.Client;
import com.epam.client.Clients;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File("./src/main/resources/clients.json");

        Clients clientWrapper = objectMapper.readValue(file, Clients.class);

        List<Client> clients = clientWrapper.getClients();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        clients.stream().map(Thread::new).forEach(executorService::submit);

        executorService.shutdown();

    }
}
