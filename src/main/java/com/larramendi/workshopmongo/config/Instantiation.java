package com.larramendi.workshopmongo.config;

import com.larramendi.workshopmongo.domain.Post;
import com.larramendi.workshopmongo.domain.User;
import com.larramendi.workshopmongo.dto.AuthorDTO;
import com.larramendi.workshopmongo.repository.PostRepository;
import com.larramendi.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration //Configuração
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository; //Instancia pra poder fazer a operação com o banco de dados;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll(); //Limpa a coleção do banco de dados antes de testar tudo;
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob)); //Adiciona na coleção de usuarios;

        Post post1 = new Post(null, sdf.parse("21/03/2023"), "Partiu viagem", "vou viajar para SP. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2023"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);

    }
}
