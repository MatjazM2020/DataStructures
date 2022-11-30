package psa.naloga3;

public class NodeSkipList {
    int key;
    NodeSkipList [] naslednjiki;
    public NodeSkipList(int key, int level){
       this.key = key;
       this.naslednjiki = new NodeSkipList[level+1];
    }
}
