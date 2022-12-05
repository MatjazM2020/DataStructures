package psa.naloga1;

public class Binarno {
	private NodeBinarno root;

	/*
	 * Metoda sprejme celo stevilo in ga vstavi v drevo. Ce element ze obstaja v drevesu, vrne false
	 * Metoda vrne true, ce je bil element uspesno vstavljen in false sicer.
	 */
	public boolean insert(int element) {
		if(root == null){
			root = new NodeBinarno(element);
			return true;
		}else{
			return root.insert(element);
		}
	}

	/*
	 * Metoda sprejme celo stevilo in izbrise element iz drevesa. 
	 * Metoda vrne true, ce je bil element uspesno izbrisan iz drevesa, in false sicer
	 */
	public boolean delete(int element) {
		NodeBinarno arw = new NodeBinarno(element);
		if(search(element) == false){
			return false;
		}else{
			if(root == null){
				return false;
			}else if(root.getKey() == element){
				if(root.getDesni() == null && root.getLevi() == null){
					root = null;
					return true;
				}else if(root.getDesni() == null && root.getLevi() != null){
					root = root.getLevi();
					return true;
				}else if(root.getDesni() != null && root.getLevi() == null){
					root = root.getDesni();
					return true;
				}else{
					if(root.desni.levi == null){
						NodeBinarno temp2 = root.desni;
						root.desni = null;
						root.setKey(temp2.getKey());
						return true;
					}else{
						root.setKey(root.desni.getMin());
						return true;
					}
				}
			}else{
				return root.delete(element);
			}
		}
	}

	/*
	 * Metoda sprejme celo stevilo in poisce element v drevesu. 
	 * Metoda vrne true, ce je bil element uspesno najden v drevesu, in false sicer
	 */
	public boolean search(int element) {
		if(root == null){
			return false;
		}else{
			return root.search(element);
		}
	}

	public int getCounter() {
		return root != null?root.getCounter():null;
	}
	
	public void resetCounter() {
		if(root!= null)
			root.resetCounter();
	}
}

