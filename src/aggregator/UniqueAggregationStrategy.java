package aggregator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import aggregator.AggregationStrategy;
import aggregator.SearchProvider;
import aggregator.SearchResult;

public class UniqueAggregationStrategy implements AggregationStrategy {

	@Override
	public List<SearchResult> execute(String phrase, List<SearchProvider> providers) throws Exception {

		List<SearchResult> searchResults = new ArrayList<SearchResult>();

		for (SearchProvider provider : providers) {
			searchResults.addAll(provider.search(phrase));
		}
		
		List<SearchResult> searchResultsUnique = new ArrayList<SearchResult>();
		HashSet<String> set = new HashSet<>();
		
		for (SearchResult item : searchResults) {
			if (!set.contains(item.Url)) {
				searchResultsUnique.add(item);
				set.add(item.Url);
			}
		}

		return searchResultsUnique;
	}
}
