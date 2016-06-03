package aggregator;

import java.util.ArrayList;
import java.util.List;

import aggregator.AggregationStrategy;
import aggregator.SearchProvider;
import aggregator.SearchResult;

public class DefaultAggregationStrategy implements AggregationStrategy {

	@Override
	public List<SearchResult> execute(String phrase, List<SearchProvider> providers) throws Exception {
		
		List <SearchResult> searchResults = new ArrayList<SearchResult>();
		
		for(SearchProvider provider : providers) {
			searchResults.addAll(provider.search(phrase));
		} 
				
		return searchResults;
	}

}
