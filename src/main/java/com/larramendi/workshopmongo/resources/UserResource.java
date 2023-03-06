package com.larramendi.workshopmongo.resources;

import com.larramendi.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController //Indica que a classe vai ser um recusto Rest
@RequestMapping(value = "/users") //Indica o caminho do endpoint
public class UserResource {

    @RequestMapping(method = RequestMethod.GET) //Método para o endpoint //Get pq é uma requisição de retornar os dados;
    public ResponseEntity<List<User>>  findAll() {
        User maria = new User("1", "Maria Brown", "maria@gmail.com");
        User alex = new User("2", "Alex Green", "alex@gmail.com");

        List<User> list = new ArrayList<>(Arrays.asList(maria, alex));

        return ResponseEntity.ok().body(list);
    }
}
