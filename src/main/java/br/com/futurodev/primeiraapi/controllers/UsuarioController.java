package br.com.futurodev.primeiraapi.controllers;

import br.com.futurodev.primeiraapi.model.UsuarioModel;
import br.com.futurodev.primeiraapi.repository.UsuarioRepository;
import br.com.futurodev.primeiraapi.service.CadastroUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

//    @PostMapping(value = "/", produces = "application/json")
//    public ResponseEntity<UsuarioModel>cadastrar(@RequestBody UsuarioModel usuario){
//        UsuarioModel usu = usuarioRepository.save(usuario);
//        return new ResponseEntity<UsuarioModel>(usu, HttpStatus.OK);
//
//    }

    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<UsuarioModel>cadastrar(@RequestBody UsuarioModel usuario){
        UsuarioModel usu = cadastroUsuarioService.salvar(usuario);
        return new ResponseEntity<UsuarioModel>(usu, HttpStatus.OK);

    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<UsuarioModel> atualizar(@RequestBody UsuarioModel usuario){
        UsuarioModel usu = cadastroUsuarioService.salvar(usuario);
        return new ResponseEntity<UsuarioModel>(usu, HttpStatus.OK);

    }

    @DeleteMapping(value = "/")
    @ResponseBody
    public  ResponseEntity<String> deletar(@RequestParam Long idUsuario){
         cadastroUsuarioService.delete(idUsuario);
         return new ResponseEntity<String>("Usuário deletado com sucesso!", HttpStatus.OK);
    }

    @GetMapping(value = "/{idUsuario}", produces = "application/json")
    public ResponseEntity<UsuarioModel> getUserById(@PathVariable(value = "idUsuario") Long idUsuario){
        UsuarioModel usu = cadastroUsuarioService.getUserById(idUsuario);
        return new ResponseEntity<UsuarioModel>(usu,HttpStatus.OK);
    }

//    @GetMapping(value = "/buscarPorNome", produces = "application/json")
//    @ResponseBody
//    public ResponseEntity<List<UsuarioModel>> getUserByName(@RequestParam (name = "nome") String nome){
//        List<UsuarioModel> usuarios = cadastroUsuarioService.getUserByName(nome);
//        return new ResponseEntity<List<UsuarioModel>>(usuarios, HttpStatus.OK);
//    }
}
