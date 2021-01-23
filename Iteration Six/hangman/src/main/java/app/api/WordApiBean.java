package app.api;

import java.util.List;

import app.model.Word;
import lombok.Data;

@Data
public class WordApiBean {
	
	private List<Word> words;
	private long pageCount;

}
