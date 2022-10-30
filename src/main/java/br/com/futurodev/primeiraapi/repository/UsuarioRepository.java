package br.com.futurodev.primeiraapi.repository;

import br.com.futurodev.primeiraapi.model.UsuarioModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {

//   @Query(value = "select c from usuario c where c.nome like %?1%")
//   List<UsuarioModel> getUserByName(String nome);

//    @Query(value = "select c from usuario c where c.nome like %?1%")
//    ArrayList<UsuarioModel> getUserByName(String nome);
}
