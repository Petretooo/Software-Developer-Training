package app.service.word;

import java.util.List;
import java.util.Random;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.word.WordDao;
import app.model.Word;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class WordServiceImpl implements WordService {

//  private static final String[] WORDS =
//      {"JAVA", "SPRING", "HIBERNATE", "SWING", "MAVEN", "GRADLE", "PLAY", "QUARKUS", "STRUTS",
//          "SPARK", "SONAR", "JUNIT", "TOMCAT", "ECLIPSE", "ANDROID", "SERVLET", "JSP", "GRAILS",
//          "JENKINS", "DOCKER", "GWT", "JSF", "VAADIN", "BLADE", "VERTX", "WICKET", "MICRONAUT", "HTML", "CSS",
//          "JAVASCRIPT", "SQL", "PYTHON", "CSHARP", "PHP", "TYPESCRIPT", "RUBY", "GOLANG", "ASSEMBLY", "SWIFT", "KOTLIN","OBJECTIVEC","ELIXIR",
//          "DART", "CLOJURE", "JQUERY","REACT", "ANGULAR", "ASP", "EXPRESS", "VUE", "DJANGO", "FLASH", "LARAVEL", "DRUPAL", "TENSORFLOW",
//          "CORDOVA", "XAMARIN", "HADOOP", "JPA", "PYTORCH", "MYSQL", "POSTGRESQL", "MONGODB","MARIADB", "CASSANDRA", "FIREBASE",
//          "LINUX", "WINDOWS", "AWS", "ANDROID", "MACOS", "IOS", "ARDUINO", "HEROKU", "KUBERNATES", "SCALA", "ERLANG",
//          "REDIS", "INTELLIJ", "VISUALSTUDIO", "BSD"};

	private WordDao wordDao;
	private static final int PAGE_SIZE = 10;

	@Override
	public Word randomWordGenerator() {
		Random random = new Random();
		Word[] WORDSARR = new Word[findAllWords().size()];
		WORDSARR = findAllWords().toArray(WORDSARR);
		return WORDSARR[random.nextInt(findAllWords().size())];
	}

	@Override
	public Word saveWord(String word, int levelDif) {
		Word w = new Word();
		w.setWordName(word);
		w.setLevelDifficulty(levelDif);
		return wordDao.save(w);
	}

	@Override
	public void deleteWord(String word) {
		Word w = wordDao.findBywordName(word);
		wordDao.delete(w);
	}

	@Override
	public List<Word> findAllWords() {
		return  wordDao.findAll();
	}

	@Override
	public List<Word> findByPage(int page) {
		Pageable pageWords = PageRequest.of(page-1, PAGE_SIZE, Sort.by("wordName"));
		
		return wordDao.findAll(pageWords).toList();
	}

	@Override
	public long numberPages() {
		long wordCount = wordDao.count();
		return wordCount % PAGE_SIZE == 0 ? wordCount / PAGE_SIZE : wordCount / PAGE_SIZE + 1;
	}

}
