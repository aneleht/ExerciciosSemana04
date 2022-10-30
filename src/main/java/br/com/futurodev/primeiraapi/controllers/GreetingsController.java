package br.com.futurodev.primeiraapi.controllers;

import br.com.futurodev.primeiraapi.model.ProdutoModel;
import br.com.futurodev.primeiraapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {

    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * @param name the name to greet
     * @return greeting text
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "Hello " + name + "!";
    }


    @GetMapping(value = "/mostrarnome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public String mostrarnome(@PathVariable String nome) {
        return "Olá" + nome;
    }

    @RequestMapping(value = "/produto/{descricao}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String salvar(@PathVariable String descricao){
        ProdutoModel produto = new ProdutoModel();
        produto.setDescricao(descricao);
        produtoRepository.save(produto); // grava no banco de dados

        return "Produto " + descricao+ " salvo com sucesso!";
    }

    @GetMapping(value = "/produtos")
    @ResponseBody // retorna os dados no corpo da resposta
    public ResponseEntity<List<ProdutoModel>> listarProdutos(){

        List<ProdutoModel> produtos = produtoRepository.findAll(); // consulta no banco de dados os prods
        return new ResponseEntity<List<ProdutoModel>>(produtos, HttpStatus.OK); // retorna lista em JSON

    }
    @PostMapping(value ="/produto/salvar") //Mapeia a URL
    @ResponseBody // Descreve a resposta informand que o retorno será no corpo da requisição
    public ResponseEntity<ProdutoModel> salvar(@RequestBody ProdutoModel produto){ // recebe os dados p salvar

        ProdutoModel prod = produtoRepository.save(produto);
        return new ResponseEntity<ProdutoModel>(prod, HttpStatus.CREATED);

    }
    @DeleteMapping(value = "/produto/delete") // Mapeia a URL
    @ResponseBody // Descrição da resposta
    public ResponseEntity<String> delete(@RequestParam Long idProduto){ // Recebe da requisi o parâmetro

        produtoRepository.deleteById(idProduto);

        return new ResponseEntity<String>("Produto deletado com sucesso!", HttpStatus.OK);

    }

}























