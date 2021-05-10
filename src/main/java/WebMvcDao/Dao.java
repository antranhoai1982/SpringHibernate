package WebMvcDao;

import java.io.Serializable;
import java.util.List;

public abstract class Dao<T, K extends Serializable> {
	public abstract List<T> getAll();

	public abstract T get(K id);

	public abstract T add(T t);

	public abstract Boolean update(T t);

	public abstract Boolean delete(T t);
	
	public abstract Boolean delete(K id);
}
