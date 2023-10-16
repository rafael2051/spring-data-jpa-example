package db.jpa.springdatajpa;

import db.jpa.springdatajpa.model.Usuario;
import db.jpa.springdatajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    private UserRepository repository;
    @Autowired
    private ListaUsuarios listaUsuarios;
    @Override
    public void run(String... args) throws Exception {
        //Insere os usuários definidos em properties
        for(int i = 0;i < listaUsuarios.getUsers().size();i++){
            Usuario user = new Usuario();
            user.setName(listaUsuarios.getUsers().get(i));
            user.setUsername(listaUsuarios.getUsernames().get(i));
            user.setPassword(listaUsuarios.getPasswords().get(i));
            repository.save(user);
        }

        //Garante que não haverão usuários repetidos
        for(int i = 1;i <= repository.findAll().size();i++){
            System.out.println("id = " + i);
            Usuario u;
            u = repository.findById(i);
            if(!(u == null)) {
                List<Usuario> listaUsuarios = repository.findByName(u.getName());
                for(Usuario us: listaUsuarios){
                    if(us.getId().intValue() != u.getId().intValue()){
                        repository.deleteById(us.getId().intValue());
                    }
                }
            }
            else{
                System.out.println("null");
            }
        }

        //Printa os dados que persistiram no banco de dados
        for(Usuario u: repository.findAll()){
            System.out.println(u.getName() +
                                ", " + u.getPassword() +
                                ", " + u.getUsername());
        }
    }
}
