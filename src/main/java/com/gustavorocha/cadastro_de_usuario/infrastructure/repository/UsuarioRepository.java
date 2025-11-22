package com.gustavorocha.cadastro_de_usuario.infrastructure.repository;

import com.gustavorocha.cadastro_de_usuario.infrastructure.entities.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    @Query("select i from Usuario i where i.email = :email") // Com ponto
    Optional<Usuario> findByEmail(@Param("email") String email);

    @Transactional
    void deleteByEmail(String email);

    boolean existsByEmail(String email);


    public Usuario findByEmailAndSenha(String user, String senha);
}
