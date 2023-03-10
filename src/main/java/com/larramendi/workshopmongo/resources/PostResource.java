package com.larramendi.workshopmongo.resources;

import com.larramendi.workshopmongo.domain.Post;
import com.larramendi.workshopmongo.resources.util.URL;
import com.larramendi.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value=("/titlesearch"), method = RequestMethod.GET)
    public ResponseEntity<List<Post>>  findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);

        return ResponseEntity.ok().body(list);
    }
}
