package psa.naloga4;

import java.util.Vector;

public class BinomialNode {

	public Vector<BinomialNode> childs;
	public int key;
	
	public BinomialNode(int key) {
		this.key = key;
		childs = new Vector<BinomialNode>();
		}
		
	public boolean addChild(BinomialNode child) {
		return childs.add(child);
	}
	
	public Vector<BinomialNode> getChilds() {
		return this.childs;
	}
	
	public int getKey() {
		return this.key;
	}
	
}
