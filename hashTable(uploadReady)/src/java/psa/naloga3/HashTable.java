package psa.naloga3;

/*
 * Razred mora imeplementirati podatkovno strukturo Razprsilne tabele (HashTable).
 * Za funkcijo uporabite: h(key) = key * 701 mod 2000
 * V primeru kolizij uporabite VERIZENJE in sicer kot Slovar uporabite podatkovno 
 * strukturo Razprsilne tabele, ki ga morate implementirati (razred HashTable2). 
 * Pazite, ker je lahko ključ tudi negativno število
 */

public class HashTable {
	HashTable2[] data;
    public HashTable(){
        this.data = new HashTable2[2000];  
    }; 
	public int zgoscanje(int key){       
        return ((((key%2000)+2000)%2000)*(701))%2000;    
    }; 
	/*
	 * Metoda sprejme število in ga vstavi v tabelo. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean insert(int key) {
		if(data[zgoscanje(key)] == null){
			data[zgoscanje(key)] = new HashTable2(); 
			return data[zgoscanje(key)].insert(key); 
		 }else{
		   return data[zgoscanje(key)].insert(key); 
		 }
	}

	/*
	 * Metoda sprejme število in ga poišče v tabeli. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean search(int key) {
		if(this.data[zgoscanje(key)] == null){
			return false; 
		   }else{
			return this.data[zgoscanje(key)].search(key); 
		   }
	}

	/*
	 * Metoda sprejme število in ga izbriše iz tabele. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean delete(int key) {
		if(this.data[zgoscanje(key)] == null){
            return false; 
          }else{
            return this.data[zgoscanje(key)].delete(key); 
          }
	}
}
