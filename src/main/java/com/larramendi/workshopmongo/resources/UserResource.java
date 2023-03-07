package com.larramendi.workshopmongo.resources;

import com.larramendi.workshopmongo.domain.User;
import com.larramendi.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController //Indica que a classe vai ser um recurso Rest
@RequestMapping(value = "/users") //Indica o caminho do endpoint
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET) //Método para o endpoint //Get pq é uma requisição de retornar os dados;
    public ResponseEntity<List<User>>  findAll() {

        List<User> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }
}
