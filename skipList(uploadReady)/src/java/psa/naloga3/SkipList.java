package psa.naloga3;

public class SkipList {

	private NodeSkipList head; 
	int maxHeight;
    NodeSkipList sentinel1;
     NodeSkipList sentinel2; 
	/*
	 * Tvoritelj sprejme kot parameter stevilo elementov, ki jih je sposoben obdelati
	 */
	public SkipList(long maxNodes) {
		this.maxHeight = (int) Math.log((double)maxNodes);
		this.sentinel1 = new NodeSkipList(-2147483647, this.maxHeight); 
		this.sentinel2 = new NodeSkipList(2147483647, this.maxHeight); 
		/* prevezi strazarja */
		for(int i = 0; i<maxHeight+1; i++){
			sentinel1.naslednjiki[i] = this.sentinel2; 
		}
	}
	public int coinAux(int x){
        double z = Math.random(); 
         if(z < 0.5 && x < this.maxHeight){
           return coinAux(x+1);
          }else{
          return (x); 
          }
        }
     public int coinToss(){
      return coinAux(0);
     }  

	/*
	 * Metoda sprejme stevilo in ga vstavi v preskocni seznam. Ce element ze
	 * obstaja v podatkovni strukturi, vrne false. Metoda vrne true, ce je bil
	 * element uspesno vstavljen in false sicer.
	 */
	 /*insert function with 2 auxiliary functions first */
/*v naslNode shranim drugi elt, ker prvo spremenim pointer na ta nou elt in pol na ta nou pointer */
public void auxTraverseInsert(NodeSkipList node, NodeSkipList insertNode,int lvl){
	if(insertNode.key < node.naslednjiki[lvl].key){
		 /*ce je manjsi, pol prvo shranis ref in pol prevezes */
		 NodeSkipList holder = node.naslednjiki[lvl]; 
		 node.naslednjiki[lvl] = insertNode;
		insertNode.naslednjiki[lvl] = holder;
	}else{
	  auxTraverseInsert(node.naslednjiki[lvl], insertNode, lvl);
	}
 }
/*main insert auxiliary function*/
public boolean auxInsert(int x, NodeSkipList node, int lvl){
 if(x < node.naslednjiki[lvl].key){
   if(lvl>0){
	  return auxInsert(x,node,lvl-1);
	}else{
	  /*treba se assignat visino in prevezat vse glede na visino */
		int height = coinToss();              
		NodeSkipList holdr = node.naslednjiki[0]; 
		NodeSkipList newList = new NodeSkipList(x,height);
		node.naslednjiki[0] = newList; 
		newList.naslednjiki[0] = holdr; 
	  for(int i = 1; i < height+1; i++){
		auxTraverseInsert(sentinel1, newList, (i)); 
	  }
	  }
   return true; 
  }else if(x == node.naslednjiki[lvl].key){
   return false; 
  }else{
  return auxInsert(x, node.naslednjiki[lvl], lvl); 
 }
}
public boolean insert(int searchKey){
  return auxInsert(searchKey,this.sentinel1, this.maxHeight); 
}
	

	/*
	 * Metoda sprejme stevilo in poisce element v preskocnem seznamu. Metoda
	 * vrne true, ce je bil element uspesno najden v podatkovni strukturi, in
	 * false sicer
	 */
	/*search function with the auxiliary function first */
	public boolean searchAux(int x, NodeSkipList node, int lvl){
		if(node.key == x){
			 return true; 
		   }else if(x == node.naslednjiki[lvl].key){
			return true; 
		   }else if(x < node.naslednjiki[lvl].key){
			  if(lvl>0){
				return searchAux(x,node,lvl-1);
			  }else{
			   return false; 
			  }
			  }else {  
				  return searchAux(x,node.naslednjiki[lvl],lvl);     
			}}; 
		
		 public boolean search(int searchKey){
		 return searchAux(searchKey,sentinel1,this.maxHeight); 
		}; 

	/*
	 * Metoda sprejme stevilo in izbrise element iz preskocnega seznama. Metoda
	 * vrne true, ce je bil element uspesno izbrisan iz podatkovne strukture, in
	 * false sicer
	 */
	public void deleteAux(int x, NodeSkipList node, int lvl){
		if(x == node.naslednjiki[lvl].key){
		   node.naslednjiki[lvl] = node.naslednjiki[lvl].naslednjiki[lvl]; 
		   if(lvl > 0){
			deleteAux(x,node,(lvl-1)); 
		   }
		  }else if(x < node.naslednjiki[lvl].key){
			 if(lvl>0){
				deleteAux(x,node,lvl-1);
			 }
		  }else{
			deleteAux(x, node.naslednjiki[lvl],lvl); 
		  }
		}; 
  
	   public boolean delete(int key){
		if(search(key) == false){
		  return false; 
		}else{
		 deleteAux(key, sentinel1, this.maxHeight);
		 return true;  
		}
	   }
}
