package app.dao.word;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Word;

public interface WordDao extends JpaRepository<Word, String> {
	
	Word findBywordName(String name);
	
}
