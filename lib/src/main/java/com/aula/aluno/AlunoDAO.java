package com.aula.aluno; 

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
 

@Repository
public class AlunoDAO{
    @Autowired 
    DataSource dataSource;
    
    JdbcTemplate jdbc;
    
    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }
    
    public void insert(Aluno aluno) {
        String sql = "INSERT INTO aluno " +
    "(nome,ra) VALUES (?,?)" ;
        jdbc.update(sql, new Object[]{
                aluno.getNome(), aluno.getRa()
        });
    }
    
    public Map<String, Object> getAluno(int id){
    	String sql = "SELECT * FROM aluno WHERE aluno.id = ?";
    	return jdbc.queryForMap(sql, new Object[] {id});
    }
    
}