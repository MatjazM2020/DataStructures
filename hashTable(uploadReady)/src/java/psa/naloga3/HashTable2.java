package psa.naloga3;

/*
 * Razred mora imeplementirati podatkovno strukturo Razprsilne tabele.
 * Za funkcijo uporabite: h(key) = key * 53 mod 100
 * V primeru kolizij uporabite LINEARNO NASLAVLJANJE.
 */
public class HashTable2 {

	int[] data;
    boolean[] available;
    boolean[] deleted;
	//**************************************************
    public HashTable2(){
		this.data = new int[100];
		// true := full slot, false := empty slot (* default is false for all*)
		this.available = new boolean[100]; 
		// true := deleted element, false := not deleted
		this.deleted = new boolean[100]; 
		  
	  }
	  //************************************************* 
	  public int zgoscanje(int key){
		  System.out.println(((((key%100)+100)%100)*53)%100);
		  return ((((key%100)+100)%100)*53)%100; 
		 
	  }
	  //************************************************** 
	  public boolean insert(int key){
			int holder = zgoscanje(key); 
			int counter = 0;
  
			while (available[holder] == true && counter < 101){
				if(this.data[holder] == key){
					return false;}; 

			  if(holder == 99){
				holder = 0;
			  }else{
				holder ++; 
			  }
			  counter++; 
			}

			 if(counter == 101){
			  return false;
			 }else{
			  this.data[holder] = key; 
			  this.available[holder] = true; 
			  return true; 
			 }
			
		}; 
	  /* -------------------------------------------- */
		public boolean search(int key){        
		  int k = zgoscanje(key); 
		  int counter = 0; 
  
		  while((this.available[k] == true || this.deleted[k] == true) && counter<101){
			if(this.available[k] == true){
				if(this.data[k] == key){
				return true; 
			  }else{
				
				if(k == 99){
				  k = 0; 
				}else{
				  k++; 
				}
				counter++; 
			  }
			}else{
			  if(k == 99){
				k = 0; 
			  }else{
				k++; 
			  }
			  counter++; 
			}
			} 
		  return false; 
		  }
  
		public boolean delete(int key){
		  int k = zgoscanje(key); 
		  int counter = 0; 
		  while((this.available[k] == true || this.deleted[k] == true) && counter < 101){
			if(this.available[k] == true){
				if(this.data[k] == key){
				this.deleted[k] = true; 
				this.available[k] = false; 
				return true; 
			  }else{
				//pazi na out of bounds
				if(k == 99){
				  k = 0; 
				}else{
				  k++; 
				}
				counter++; 
			  }
			
			}else{
			  if(k == 99){
				k = 0; 
			  }else{
				k++; 
			  }
			  counter++; 
			}
			} 
		  return false; 
		  }}