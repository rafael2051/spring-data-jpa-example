package springweb.firstapiinjava.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import springweb.firstapiinjava.model.Usuario;
import springweb.firstapiinjava.repository.UsuarioRepository;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private UsuarioRepository repository;
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Usuario user = repository.findByUsername("admin");
        if(user==null){
            user = new Usuario();
            user.setName("ADMIN");
            user.setUsername("admin");
            user.setPassword("master123");
            user.getRoles().add("MANAGERS");
            repository.save(user);
        }
        user = repository.findByUsername("user");
        if(user ==null){
            user = new Usuario();
            user.setName("USER");
            user.setUsername("user");
            user.setPassword("user123");
            user.getRoles().add("USERS");
            repository.save(user);
        }
    }
}
