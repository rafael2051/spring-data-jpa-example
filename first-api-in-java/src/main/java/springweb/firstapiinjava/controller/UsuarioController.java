package springweb.firstapiinjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import springweb.firstapiinjava.model.Usuario;
import springweb.firstapiinjava.repository.UsuarioRepository;
import springweb.firstapiinjava.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/db")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("")
    public List<Usuario> getUsers(){
        return repository.findAll();
    }
    @GetMapping("/{username}")
    public Usuario getOne(@PathVariable("username") String username){
        return repository.findByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }

    @PostMapping("")
    public void postUser(@RequestBody Usuario usuario){
        usuarioService.createUser(usuario);
    }

    @PutMapping("")
    public void putUser(@RequestBody Usuario usuario){
        repository.save(usuario);
    }

}
