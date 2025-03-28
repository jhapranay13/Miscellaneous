package elementsOfProgramming.ParallelComputing;

import java.util.LinkedHashMap;
import java.util.Map;

/*
static class UnsafeSpellCheckService extends SpellCheckService {
	private static final int MAX_ENTRIES = 3;
	private static LinkedHashMap<String , String []> cachedClosestStrings
	= new LinkedHashMap<String , String []>() {
		protected boolean removeEldestEntry ( Map.Entry eldest) {
			return size() > MAX_ENTRIES ;
		}
	};

	public static void service (ServiceRequest req, ServiceResponse resp) {
		String w = req . extractWordToCheckFromRequest () ;
		
		if ( cachedClosestStrings . containsKey (w) ) {
			resp . encodeIntoResponse (cachedClosestStrings . get (w) ) ;
			return ;
		}
		String [] closestToLastWord = Spell . closestlnDictionary (w) ;
		cachedClosestStrings .put(w, closestToLastWord) ;
	}
}
 */
/*
 * Solution
public static class SafeSpellCheckService extends SpellCheckService {
	private static final int MAX_ENTRIES = 3;
	private static LinkedHashMap<String , String[]> cachedClosestStrings
	= new LinkedHashMap<String , String[]>() {
		protected boolean removeEldestEntry(Map.Entry eldest) {
			return size() > MAX_ENTRIES ;
		}
	};
	
	public static void service(ServiceRequest req, ServiceResponse resp) {
		String w = req.extractWordToCheckFromRequest();
		
		synchronized (S2Alternative.class) {
			
			if (cachedClosestStrings.containsKey(w)){
				resp.encodeIntoResponse(cachedClosestStrings.get(w));
				return ;
			}
		}
		String[] closestToLastWord = Spell.closestlnDictionary(w);
		synchronized (S2Alternative.class) {
			cachedClosestStrings.put(w, closestToLastWord);
		}
	}
}
*/
public class CachingForMultiThreadedDictionary {

}
