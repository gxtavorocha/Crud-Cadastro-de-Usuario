package com.gustavorocha.cadastro_de_usuario.controller;


import com.gustavorocha.cadastro_de_usuario.bussiness.UsuarioService;
import com.gustavorocha.cadastro_de_usuario.dto.UsuarioRequestDto;
import com.gustavorocha.cadastro_de_usuario.dto.UsuarioResponseDto;
import com.gustavorocha.cadastro_de_usuario.infrastructure.entities.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> SalvarUsuario(@RequestBody Usuario usuario){

        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email){
       return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email){

        usuarioService.deleteUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestParam Long id, @RequestBody Usuario usuario){

        usuarioService.atualizarUsuarioPorId(id,usuario);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/login")
    public ModelAndView loginPage() {
        ModelAndView mv = new ModelAndView("Login/login");
        mv.addObject("usuario", new Usuario());
        return mv;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioRequestDto usuarioRequestDto){

        Usuario user = usuarioService.loginUser(usuarioRequestDto.email(), usuarioRequestDto.senha());

                if (user == null ){
                  return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais Invalidas. Verifique o email e a senha");
                }
                return ResponseEntity.ok(new UsuarioResponseDto(user).ToString());


    }
}
