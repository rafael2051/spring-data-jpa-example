package db.jpa.springdatajpa.repository;

import db.jpa.springdatajpa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Usuario, Integer> {
    //Query method
    List<Usuario> findAll();

    Usuario findById(int id);

    List<Usuario> findByName(String name);

    void deleteById(int id);
}
