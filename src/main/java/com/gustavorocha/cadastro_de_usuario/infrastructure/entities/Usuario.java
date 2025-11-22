package com.gustavorocha.cadastro_de_usuario.infrastructure.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GeneratedColumn;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "usuario")
@Entity
public class Usuario  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false,unique = true)
    private String senha;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "nome")
    private String nome;












}
