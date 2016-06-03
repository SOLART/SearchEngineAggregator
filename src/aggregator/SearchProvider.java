package aggregator;

import java.util.List;

public interface SearchProvider {

	public List<SearchResult> search(String phrase) throws Exception;

}
