package psa.naloga1;

public class Seznam {
	private NodeSeznam head;


	/*
	 * Metoda sprejme celo stevilo in ga vstavi v seznam. Ce element ze obstaja v seznamu, vrne false
	 * Metoda vrne true, ce je bil element uspesno vstavljen in false sicer.
	 */
	public boolean insert(int element) {
		if(head == null){
			head = new NodeSeznam(element);
			return true;
		}else{
			head.insert(element);
			return true;
		}

	}

	/*
	 * Metoda sprejme celo stevilo in izbrise element iz seznama. 
	 * Metoda vrne true, ce je bil element uspesno izbrisan iz seznama, in false sicer
	 */
	public boolean delete(int element) {
		if (head == null) {
			return false;
		} else if (head.getKey() == element) {
			if (head.rep == null) {
				head = null;
				return true;
			} else {
				head = head.rep;
				return true;
			}
		}else{
			return head.delete(element);
		}
	}

	/*
	 * Metoda sprejme celo stevilo in poisce element v seznamu. 
	 * Metoda vrne true, ce je bil element uspesno najden v seznamu, in false sicer
	 */
	public boolean search(int element) {
		if(head == null){
			return false;
		}else{
			if(head.rep == null){
				return false;
			}else{
				return head.search(element);
			}
		}
	}
	
	public int getCounter() {
		return head != null?head.getCounter():null;
	}
	
	public void resetCounter() {
		if(head!= null)
			head.resetCounter();
	}
}
