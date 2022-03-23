package com.gft.projetos.repostitories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.projetos.entities.Linguagem;

@Repository
public interface LinguagemRepostitory extends JpaRepository<Linguagem, Long> {
	List<Linguagem> findByNomeContains(String nome);
}
