package aggregator;

import java.util.ArrayList;
import java.util.List;

public class Example {
	public static void main(String[] args) throws Exception {
		
		/*
		 * Adds a list of SearchProviders 
		 * only BingSearchProvider is available for now
		 */
		
		List<SearchProvider> providers = new ArrayList<SearchProvider>();
		providers.add(new BingSearchProvider());
		MultiSearcher ms = new MultiSearcher(providers);
		
		/*
		 * calls the perfromSearch method and adds the results to list
		 * DefaultAggregationStrategy and UniqueAggregationStrategy are available
		 */
		
		List <SearchResult> result = ms.performSearch("bekitzur", new DefaultAggregationStrategy());
		
		
		/*
		 * prints results
		 */
		
		int i = 0;
		for (SearchResult res : result) {
			System.out.println(++i);
			System.out.println(res.Title);			
			System.out.println(res.Description);
			System.out.println(res.Url);
			System.out.println("----------");
		}
	}
}
