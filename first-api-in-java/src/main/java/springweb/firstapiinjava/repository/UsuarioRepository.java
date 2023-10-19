package springweb.firstapiinjava.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springweb.firstapiinjava.handler.BusinessException;
import springweb.firstapiinjava.handler.CampoObrigatorioException;
import springweb.firstapiinjava.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    @Query("SELECT e FROM Usuario e JOIN FETCH e.roles WHERE e.username= (:username)")
    public Usuario findByUsername(@Param("username") String username);
}