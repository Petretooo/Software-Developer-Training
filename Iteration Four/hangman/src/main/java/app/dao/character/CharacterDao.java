package app.dao.character;

import java.util.List;
import app.model.Character;

public interface CharacterDao {
	public Character get(String id);
	public void remove(String id);
	public List<Character> getAll();
	public void save(Character entity);
}
