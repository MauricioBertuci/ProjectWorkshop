package com.maurciobertuci.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.maurciobertuci.workshopmongo.domain.User;
import com.maurciobertuci.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Limpar dados existentes (opcional - remova se quiser preservar)
        // userRepository.deleteAll();
        
        // Inserir usuários de teste
        // User user1 = new User(null, "Maria Silva", "maria@email.com");
        // User user2 = new User(null, "João Santos", "joao@email.com");
        // User user3 = new User(null, "Ana Costa", "ana@email.com");
        
        // userRepository.saveAll(Arrays.asList(user1, user2, user3));
        
        System.out.println("✓ Dados inicializados com sucesso!");
        System.out.println("✓ Total de usuários: " + userRepository.count());
    }
}
