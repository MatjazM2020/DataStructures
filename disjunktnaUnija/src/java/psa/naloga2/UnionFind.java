package psa.naloga2;


public class UnionFind {
	public int[] id;

	public UnionFind(int N){
	 id = new int[N]; 
     for(int i = 0; i<N;i++){
		this.id[i] = i; 
	 }
	}

	/*
	 * Metoda sprejme index in vrne predstavnika mnozice, katere clan je index.
	 */
	public int find(int i){
	  if(this.id[i] == i){
		return i;
	  }else{
		return find(this.id[i]); 
	  }
	}

	/*
	 * Metoda sprejme da indexa in naredi unijo
	 */

	public void unite(int p, int q) {
		if(find(p) != find(q)){
			this.id[find(q)] = find(p);  
		}
	}
	
	/*
	 * Metoda vrne true, ce sta p in q v isti mnozici
	 */
	public boolean isInSameSet(int p, int q) {
		if(find(p) == find(q)){
			return true; 
		}else{
			 return false; 
		}
	}
}
