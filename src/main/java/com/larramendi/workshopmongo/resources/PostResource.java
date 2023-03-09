package com.larramendi.workshopmongo.resources;

import com.larramendi.workshopmongo.domain.Post;
import com.larramendi.workshopmongo.domain.User;
import com.larramendi.workshopmongo.dto.UserDto;
import com.larramendi.workshopmongo.services.PostService;
import com.larramendi.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController //Indica que a classe vai ser um recurso Rest
@RequestMapping(value = "/posts") //Indica o caminho do endpoint
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value=("/{id}"), method = RequestMethod.GET) //Value id para retornar apenas o post desejado
    public ResponseEntity<Post>  findById(@PathVariable String id) { //Annotation diz que o parametro Id tem que ser o mesmo da url
        Post obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }
}
