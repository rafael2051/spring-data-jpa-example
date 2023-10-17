package springweb.firstapiinjava.repository;

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
    Usuario findByUsername(String username);
}