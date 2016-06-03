package aggregator;

import java.util.List;

public class MultiSearcher {
	List<SearchProvider> providers;

	public MultiSearcher(List<SearchProvider> providers) {
        this.providers = providers;
    }

	public List<SearchResult> performSearch(String phrase, AggregationStrategy strategy) throws Exception {
        return strategy.execute(phrase, providers);
    }
}
