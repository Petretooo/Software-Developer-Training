package app.service.word;

import java.util.List;

import app.model.Word;

public interface WordService {
  public Word randomWordGenerator();
  
  public Word saveWord(String word, int levelDif);
  public void deleteWord(String word);
  public List<Word> findAllWords();
  public List<Word> findByPage(int page);
  public long numberPages();
}