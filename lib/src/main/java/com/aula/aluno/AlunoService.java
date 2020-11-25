package com.aula.aluno;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
	@Autowired
	AlunoDAO adao;
	
	public void insert(Aluno aluno) {
		adao.insert(aluno);
	}
	
	public Map<String, Object> getAluno(int id){
		return adao.getAluno(id);
	}
}
