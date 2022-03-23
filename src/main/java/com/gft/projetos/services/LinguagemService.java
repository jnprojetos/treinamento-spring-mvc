package com.gft.projetos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.projetos.entities.Linguagem;
import com.gft.projetos.repostitories.LinguagemRepostitory;

@Service
public class LinguagemService {
	
	@Autowired
	private LinguagemRepostitory linguagemRepostitory;
	
	public Linguagem salvarLinguagem(Linguagem linguagem) {
		return linguagemRepostitory.save(linguagem);
	}
	
	public List<Linguagem> listarLinguagens(String nome){
		if(nome != null) {
			 return listarPorNome(nome);
		}
		return listarTodasLinguagens();
	}
	
	 private List<Linguagem> listarPorNome(String nome){ 
		return linguagemRepostitory.findByNomeContains(nome);
	}
	
	public List<Linguagem> listarTodasLinguagens(){
		return linguagemRepostitory.findAll();
	}
	
	public Linguagem obterLinguagem(Long id) {
		return linguagemRepostitory.findById(id)
				.orElseThrow(() -> new RuntimeException("Linguagem não encontrada."));
	}

	public void excluirLinguagem(Long id) {
		Linguagem linguagem = linguagemRepostitory.findById(id)
		.orElseThrow(() -> new RuntimeException("Linguagem não encontrada."));
		
		if(linguagem != null) {
			linguagemRepostitory.delete(linguagem);
		}
		
	}

}
