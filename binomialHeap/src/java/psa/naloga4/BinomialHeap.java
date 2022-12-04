package psa.naloga4;
import java.util.Vector;
// Binomial heap definition: 
// 1. each binomial tree obeys the minimum heap property 
// 2. there can be either 0 or 1 binomial trees for deg. k
//************************************************************************************
public class BinomialHeap {
	BinomialNode[] data;
	BinomialHeap(){
		data = new BinomialNode[1];
	}
//************************************************************************************
	public boolean insert(int key){
		if(this.data[0] == null){
			this.data[0] = new BinomialNode(key); 
			return true; 
		}else{
           return mergeInsert(new BinomialNode(key), this.data[0]); 
		}
	}
//************************************************************************************
	public int getMin(){
		int curMin = 0; 
		boolean king = false; 
		int i = 0; 
		while(i < this.data.length){
          if(this.data[i] != null){
			curMin = this.data[i].getKey(); 
			king = true; 
			break; 
		  }
		  i++; 
		}
		if(king == true){
			for(int j = 0; j < this.data.length; j++){
			if(this.data[j] != null){

				if(this.data[j].getKey() < curMin){
              				curMin = this.data[j].getKey(); 
              			 }
			}
		}
		}else{
			return Integer.MAX_VALUE; 
		}
		return curMin; 
	}
//************************************************************************************
	public boolean delMin(){
    if(getMin() == Integer.MAX_VALUE){
		return false; 
	}else{
		for(int i= 0; i<this.data.length; i++){
			if(this.data[i] != null){
				if(this.data[i].getKey() == getMin()){
					Vector<BinomialNode> holder = this.data[i].getChilds(); 
                    this.data[i] = null; 
					for(int j = 0; j < holder.size(); j++){
						if(this.data[j] != null){
							 mergeInsert(holder.elementAt(j),this.data[j]); 
						}else{
                            this.data[j] = holder.elementAt(j); 
						}
			  }
			}
		  }
		}
	  } 
	  return true; 
	}
//************************************************************************************
	private void resizeArray(){
		BinomialNode[] resized= new BinomialNode[2*(this.data.length)]; 
	    System.arraycopy(this.data, 0, resized, 0, this.data.length);
		this.data = resized; 
	} 
//****************************************************************************
	private BinomialNode merge(BinomialNode t1, BinomialNode t2){
		if(t1.getKey() < t2.getKey()){
			t1.addChild(t2); 
			return t1; 
		}else{
            t2.addChild(t1); 
			return t2; 
		}
	}
	// **********************************************************************

	// **********************************************************************
	private boolean mergeInsert(BinomialNode t1, BinomialNode t2){
		int index = t1.getChilds().size(); 
		if(index+1 > this.data.length-1){
			resizeArray(); 
		}
		if(t1.getKey() < t2.getKey()){
			t1.addChild(t2); 
            if(this.data[index+1] == null){
				this.data[index+1] = t1; 
				this.data[index] = null; 
			}else{
				this.data[index] = null; 
				mergeInsert(t1, this.data[index+1]); 
			}
		}else{
            t2.addChild(t1); 
			if(this.data[index+1] == null){
				this.data[index+1] = t2; 
				this.data[index] = null; 
			}else{
				this.data[index] = null; 
				mergeInsert(t2, this.data[index+1]); 
			}
		}
		return true; 
	}

}

