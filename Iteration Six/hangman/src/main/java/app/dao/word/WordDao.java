package app.dao.word;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.Word;

@Repository
public interface WordDao extends JpaRepository<Word, String> {
	
	Word findBywordName(String name);
	
}
