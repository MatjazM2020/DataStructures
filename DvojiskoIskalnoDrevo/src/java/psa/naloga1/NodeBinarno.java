package psa.naloga1;

public class NodeBinarno {
	private static int counter;
	private int key;
	NodeBinarno levi;
	NodeBinarno desni;

	public NodeBinarno(int key){
		this.key = key;
	}

	public boolean insert(int value){
		NodeBinarno arta = new NodeBinarno(value);
		int comparq = compare(arta);
		if(comparq == 0){
			return false;
		}else{
			if(comparq < 0){
				if(levi == null){
					levi = new NodeBinarno(value);
					return true;
				}else{
					return levi.insert(value);
				}
			}else{
				if(desni == null){
					desni = new NodeBinarno(value);
					return true;
				}else{
					return desni.insert(value);
				}


			}
		}

	}


	public boolean search(int element){
		NodeBinarno krip1 = new NodeBinarno(element);
		int compara = compare(krip1);

		if(compara == 0){
			return true;
		}else{
			if (compara < 0){
				if( levi!= null){
					return(levi.search(element));
				}else{
					return false;
				}

			}else{
				if( desni != null){
					return(desni.search(element));

				}else {
					return false;
				}
			}
		}
	}






	public NodeBinarno getLevi(){
		return levi;
	}
	public NodeBinarno getDesni(){
		return desni;
	}
	public int getKey(){
		return key;
	}
	public void setKey(int key){
		this.key = key;
	}

	public int getMin(){
		if(levi.levi == null){
			NodeBinarno temp = levi;
			levi = null;
			return temp.key;
		}else{
			return levi.getMin();
		}
	}

	public boolean delete(int key){
		NodeBinarno isla = new NodeBinarno(key);
		int isla2 = compare(isla);
		if(isla2 < 0){
			if(this.levi.key == isla.key){
				if(this.levi.levi == null && this.levi.desni == null){
					this.levi = null;
				}else if(this.levi.levi == null && this.levi.desni != null){
					this.levi = this.levi.desni;
				}else if(this.levi.desni == null && this.levi.levi != null){
					this.levi = this.levi.levi;
				}else{
					if(levi.desni.levi == null){
						NodeBinarno temp4 = this.levi.desni;
						this.levi.desni = null;
						this.levi.key = temp4.key;
					}
					this.levi.key = levi.desni.getMin();
				}
			}else{
				this.levi.delete(key);
			}

		}else{
			if( this.desni.key == isla.key){
				if(this.desni.desni == null && this.desni.levi == null){
					this.desni = null;
				}else if(this.desni.levi != null && this.desni.desni == null){
					this.desni = this.desni.levi;
				}else if(this.desni.desni != null && this.desni.levi == null){
					this.desni = this.desni.desni;
				}else{
					this.desni.key = desni.desni.getMin();
				}
			}else{
				this.desni.delete(key);
			}
		}return true;
	}

	
	public int compare(NodeBinarno node) {
		counter++;
		return node.key - this.key;
	}
	
	public int getCounter() {
		return counter;
	}
	
	public void resetCounter() {
		counter=0;
	}
}
