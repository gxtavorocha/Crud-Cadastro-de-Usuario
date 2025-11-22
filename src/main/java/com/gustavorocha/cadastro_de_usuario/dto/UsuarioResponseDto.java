package com.gustavorocha.cadastro_de_usuario.dto;

import com.gustavorocha.cadastro_de_usuario.infrastructure.entities.Usuario;
import lombok.ToString;

public record UsuarioResponseDto(
        Long id,
        String nome,
        String email

)  {

    public UsuarioResponseDto(Usuario user){
        this(user.getId(), user.getNome(), user.getEmail());
    }


    public String ToString(){
        return "Usuario logado com sucesso!";
    }

}
