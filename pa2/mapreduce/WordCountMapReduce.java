package mapreduce;

import java.util.TreeMap;
import java.util.Vector;

public class WordCountMapReduce implements MapReduce {

	private int nMappers;
	private int nShufflers;
	private int nReducers;
	
	public WordCountMapReduce(int m, int s, int r) {
		nMappers = m;
		nShufflers = s;
		nReducers = r;
	}
	
	public int nMappers() {
		return nMappers;
	}

	public int nReducers() {
		return nReducers;
	}

	public int nShufflers() {
		return nShufflers;
	}

	public Vector map(Pair p) {
		Vector ret = new Vector();
		String s = (String)p.value;
		String[] words = s.split("\\s+");
		for (int i = 0; i < words.length; ++i) {
			ret.add(new Pair(words[i], new Pair(p.key, 1)));
		}
		return ret;
	}

	public Pair reduce(Pair p) {
		Vector v = (Vector)p.value;
		TreeMap map = new TreeMap();
		for (int i = 0; i < v.size(); ++i) {
			Pair pp = (Pair)v.get(i);
			if (!map.containsKey(pp.key)) {
				map.put(pp.key, pp.value);
			}
			else {
				map.put(pp.key, (int)pp.value + (int)map.get(pp.key));
			}
		}
		Vector ret = new Vector();
		Object[] keys = map.keySet().toArray();
		for (int i = 0; i < keys.length; i++) {
			ret.add(new Pair(keys[i], map.get(keys[i])));
		}
		return new Pair(p.key, ret);
	}

}

