package com.larramendi.workshopmongo.resources;

import com.larramendi.workshopmongo.domain.User;
import com.larramendi.workshopmongo.dto.UserDto;
import com.larramendi.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController //Indica que a classe vai ser um recurso Rest
@RequestMapping(value = "/users") //Indica o caminho do endpoint
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET) //Método para o endpoint //Get pq é uma requisição de retornar os dados;
    public ResponseEntity<List<UserDto>>  findAll() {

        List<User> list = service.findAll();
        List<UserDto> listDto = list.stream().map(UserDto::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value=("/{id}"), method = RequestMethod.GET) //Value id para retornar apenas o user desejado
    public ResponseEntity<UserDto>  findById(@PathVariable String id) { //Annotation diz que o parametro Id tem que ser o mesmo da url
        User obj = service.findById(id);

        return ResponseEntity.ok().body(new UserDto(obj));
    }


}
