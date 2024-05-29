package com.example.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.usuario.dto.mudarSenha;
import com.example.usuario.model.Usuario;
import com.example.usuario.service.UsuarioService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService userService;

    @PostMapping("/")
    public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody Usuario user) {
        Usuario usuario = userService.criarUsuario(user.getUsuario(), user.getSenha());
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/")
    public ResponseEntity<Usuario> logarUsuario(@Valid @RequestBody Usuario user) {
        Usuario usuario = userService.logar(user.getUsuario(), user.getSenha());
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/mudarSenha")
    public ResponseEntity<Usuario> mudarSenha(@Valid @RequestBody mudarSenha user) {
        Usuario usuario = userService.mudarSenha(user.getUsuario(), user.getSenhaAntiga(), user.getSenhaNova());
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/bloqueados")
    public ResponseEntity<List<Usuario>> getBloqueados() {
        List<Usuario> blockedUsers = userService.getBloqueados();
        return ResponseEntity.ok(blockedUsers);
    }
}
