package com.larramendi.workshopmongo.resources;

import com.larramendi.workshopmongo.domain.User;
import com.larramendi.workshopmongo.dto.UserDto;
import com.larramendi.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDto objDto) {
        User obj = service.fromDTO(objDto);
        obj = service.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
