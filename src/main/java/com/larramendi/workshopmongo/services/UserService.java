package com.larramendi.workshopmongo.services;

import com.larramendi.workshopmongo.domain.User;
import com.larramendi.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//A classe de serviço tem que conversar com a classe repositório

@Service //Serviço responsavel para tratar com a classe de dominio "Usuarios"
public class UserService {

    @Autowired //Instancia automaticamente um objeto. Mecanismo de injeção de dependência automática do Spring;
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

}
