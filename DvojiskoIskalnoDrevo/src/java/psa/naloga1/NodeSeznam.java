package psa.naloga1;

public class NodeSeznam {
	private static int counter;
	private int key;
	NodeSeznam rep;

	public NodeSeznam(int key){
		this.key = key;
	}

	public boolean insert(int key){
		NodeSeznam aron = new NodeSeznam(key);
		int aron1 = compare(aron);
		if(aron1 == 0){
			return false;
		}else{
			if(rep == null){
				rep = new NodeSeznam(key);
				return true;
			}else{
				return rep.insert(key);
			}

		}
	}
	public boolean search(int key){
		NodeSeznam aron2 = new NodeSeznam(key);
		int aron3 = compare(aron2);
		if(aron3 == 0){
			return true;
		}else{
			if(rep != null){
				return rep.search(key);
			}else{
				return false;
			}

		}
	}

	public boolean delete(int key){
		if(rep.key == key){
			if(rep.rep == null){
				rep = null;
				return true;
			}else{
				rep = rep.rep;
				return true;
			}
		}else{
			return rep.delete(key);
		}
	}



	public int getKey(){
		return this.key;
	}




	public int compare(NodeSeznam node) {
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
