package db.jpa.springdatajpa;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListaUsuarios implements CommandLineRunner {
    @Value("${dba.users}")
    private List<String> users;
    @Value("${dba.usernames}")
    private List<String> usernames;
    @Value("${dba.passwords}")
    private List<String> passwords;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Inicializando lista de usuários");
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public List<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(List<String> usernames) {
        this.usernames = usernames;
    }

    public List<String> getPasswords() {
        return passwords;
    }

    public void setPasswords(List<String> passwords) {
        this.passwords = passwords;
    }
}
