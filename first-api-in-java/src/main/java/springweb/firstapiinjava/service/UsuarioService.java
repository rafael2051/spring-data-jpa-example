package springweb.firstapiinjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import springweb.firstapiinjava.model.Usuario;
import springweb.firstapiinjava.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;
    public void createUser(Usuario user){
        String pass = user.getPassword();
        //criptografando antes de salvar no banco
        user.setPassword(new BCryptPasswordEncoder().encode(pass));
        repository.save(user);
    }
}