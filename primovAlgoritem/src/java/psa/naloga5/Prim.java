package psa.naloga5;


public class Prim {
	int[][] data;
	int n;

	public Prim(int n) {
		data = new int[n][n];
		this.n = n;
	}

	public Prim(int[][] d) {
		this.data = d; 
		this.n = d.length; 
	}

	public void addEdge(int i, int j, int d) {
		this.data[i][j] = d; 
		this.data[j][i] = d; 
	}

	public int auxMST(boolean[][] edgesChecked, boolean[] check, int cost){
		int counter = 0; 
		int curi = 0; 
		int curj = 0; 
		int min = 0; 
		for(int i = 0; i<this.n; i++){
           if(check[i] == true){
              for(int j = 0; j<this.n; j++){
               if(edgesChecked[i][j] == false && this.data[i][j] != 0){
                  if(counter == 0){
					 curi = i; 
					 curj = j; 
					 min = this.data[i][j]; 
					 counter++; 
				  }else{
					if(min > this.data[i][j]){
						curi = i; 
						curj = j; 
						min = this.data[i][j]; 
					}
				  }
				  
			   }
			  }
		   }
		}
		edgesChecked[curi][curj] = true; 
		edgesChecked[curj][curi] = true; 
		check[curj] = true; 
		cost += min; 
		 
        //for loopi za upostevanje tranzitivnosti že obiskanih node-ou 
		// (če lahko prepotujemo od )
		for(int i = 0; i<this.n; i++){
			for(int j = 0; j<this.n; j++){
             if(edgesChecked[i][j] == true){
			 	for(int z = j+1; z<this.n; z++){
				  if(edgesChecked[i][z] == true){
					if(this.data[i][z] != 0){
						edgesChecked[z][j] = true; 
						edgesChecked[j][z] = true; 
					}
				  }
				}
				int o = i+1; 
				for(int k = j+1; k<this.n; k++){
					if(o < this.n){
						if(edgesChecked[o][k] == true){
							if(this.data[i][k] != 0){
								edgesChecked[i][k] = true;
								edgesChecked[k][i] = true; 
							}
						}
					} 
				}
			 }
			}
		}

		for(int i = 0; i<this.n; i++){
			if(check[i] == false){
				return auxMST(edgesChecked, check, cost); 
			}
		}
		return cost; 
	}

	public int MSTcost(){
		boolean[][] edgesChecked = new boolean[this.n][this.n]; 
	    boolean[] check = new boolean[this.n]; 
        check[0] = true; //PAZI- CE JE ERROR JE MOGOCE KER MORE BIT TLE s-1
        int cost = 0; 
		return auxMST(edgesChecked, check, cost); 

	}
 
	
	/* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
	public int[] auxPrim(boolean[][] edgesChecked, boolean[] check, int[] tree){
		int counter = 0; 
		int curi = 0; 
		int curj = 0; 
		int min = 0; 
		for(int i = 0; i<this.n; i++){
           if(check[i] == true){
              for(int j = 0; j<this.n; j++){
               if(edgesChecked[i][j] == false && this.data[i][j] != 0){
                  if(counter == 0){
					 curi = i; 
					 curj = j; 
					 min = this.data[i][j]; 
					 counter++; 
				  }else{
					if(min > this.data[i][j]){
						curi = i; 
						curj = j; 
						min = this.data[i][j]; 
					}
				  }
			   }
			  }
		   }
		}
		edgesChecked[curi][curj] = true; 
		edgesChecked[curj][curi] = true; 
		check[curj] = true; 
		if(curj != curi){
			tree[curj] = curi; 
		}

         //for loopi za upostevanje tranzitivnosti že obiskanih node-ou 
		// (če lahko prepotujemo od )
		for(int i = 0; i<this.n; i++){
			for(int j = 0; j<this.n; j++){
             if(edgesChecked[i][j] == true){
			 	for(int z = j+1; z<this.n; z++){
				  if(edgesChecked[i][z] == true){
					if(this.data[i][z] != 0){
						edgesChecked[z][j] = true; 
						edgesChecked[j][z] = true; 
					}
				  }
				}
				int o = i+1; 
				for(int k = j+1; k<this.n; k++){
					if(o < this.n){
						if(edgesChecked[o][k] == true){
							if(this.data[i][k] != 0){
								edgesChecked[i][k] = true;
								edgesChecked[k][i] = true; 
							}
						}
					} 
				}
			 }
			}
		}
		for(int i = 0; i<this.n; i++){
			if(check[i] == false){
				return auxPrim(edgesChecked, check, tree); 
			}
		}
		return tree; 
	}
   //* +++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
    public int[] prim(int s){
	   boolean[][] edgesChecked = new boolean[this.n][this.n]; 
	   boolean[] check = new boolean[this.n]; 
       check[s] = true; //PAZI- CE JE ERROR JE MOGOCE KER MORE BIT TLE s-1
	   int[] tree = new int[this.n]; 
	   tree[s] = 0; //PAZI- CE JE ERROR JE MOGOCE KER MORE BIT TLE s-1
	   return auxPrim(edgesChecked, check, tree); 
	}

}
