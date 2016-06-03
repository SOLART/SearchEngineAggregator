package aggregator;

import java.util.List;

public interface AggregationStrategy {

	public List<SearchResult> execute(String phrase, List<SearchProvider> providers) throws Exception;
	
}
