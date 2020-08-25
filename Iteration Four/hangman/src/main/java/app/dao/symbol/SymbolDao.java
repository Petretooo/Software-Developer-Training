package app.dao.symbol;

import java.util.List;
import app.model.Symbol;

public interface SymbolDao {
	public Symbol get(String id);
	public void remove(String id);
	public List<Symbol> getAll();
	public void save(Symbol entity);
}
