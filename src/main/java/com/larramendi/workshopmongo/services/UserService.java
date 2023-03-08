package com.larramendi.workshopmongo.services;

import com.larramendi.workshopmongo.domain.User;
import com.larramendi.workshopmongo.dto.UserDto;
import com.larramendi.workshopmongo.repository.UserRepository;
import com.larramendi.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//A classe de serviço tem que conversar com a classe repositório

@Service //Serviço responsavel para tratar com a classe de dominio "Usuarios"
public class UserService {

    @Autowired //Instancia automaticamente um objeto. Mecanismo de injeção de dependência automática do Spring;
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    } //Retorna todos os users

    public User findById(String id) { //Retorna apenas o user desejado
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public User fromDTO(UserDto objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

}
