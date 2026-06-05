package com.maurciobertuci.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.maurciobertuci.workshopmongo.dto.AuthorDTO;
import com.maurciobertuci.workshopmongo.domain.User;
import com.maurciobertuci.workshopmongo.domain.Post;
import com.maurciobertuci.workshopmongo.repository.PostRepository;
import com.maurciobertuci.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));


        // Limpar dados existentes (opcional - remova se quiser preservar)
        userRepository.deleteAll();
        postRepository.deleteAll();
        
        // Inserir usuários de teste
        User user1 = new User(null, "Maria Silva", "maria@email.com");
        User user2 = new User(null, "João Santos", "joao@email.com");
        User user3 = new User(null, "Ana Costa", "ana@email.com");
        
        userRepository.saveAll(Arrays.asList(user1, user2, user3));
        
        Post post1 = new Post(null, sdf.parse("01/01/2023"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(user1));
        Post post2 = new Post(null, sdf.parse("01/01/2023"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(user1));
        
        postRepository.saveAll(Arrays.asList(post1, post2));

        user1.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(user1);

        System.out.println("✓ Dados inicializados com sucesso!");
        System.out.println("✓ Total de usuários: " + userRepository.count());

        System.out.println("✓ Usuários e posts inseridos:");
        System.out.println("✓ Total de posts: " + postRepository.count());
    }
}
