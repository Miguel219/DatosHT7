//BinaryTree extendido para Association
public class BinaryTreeAssociation extends BinaryTree<Association<String, String>> {
	
	public BinaryTreeAssociation() {
		
	}
	
	public BinaryTreeAssociation(Association<String,String> assoc) {
		this.setValue(assoc);
		this.setLeft(null);
		this.setRight(null);
		this.setParent(null);
	}
	
	//Traduce la palabra si existe en el diccionario sino devuelve null;
	public String englishToSpanish(String english) {
		String spanish= inOrderAssociation(this, english);
		return spanish;
		
	}
	
	//Busca inOrderAssociation la palabra en ingles;
	private String inOrderAssociation(BinaryTree<Association<String,String>> tree, String english) { 
		if (tree.value().getEnglish().equals(english)){ 
				return (tree.value().getSpanish());
		}
		inOrderAssociation(tree.left,english);
		inOrderAssociation(tree.right,english);
		return ("*"+english+"*");
		}
	
	//Guarda las palabras en orden;
	public  void newTranslation(BinaryTree<Association<String,String>> tree) {
		if(this.value()==null && this.isRoot()) {
			this.setValue(tree.value());
		} else if(this.value().getEnglish().compareTo((tree.value().getEnglish()))>0) {
			if(this.right()==null && tree.value()!=null) {
				this.setRight(tree);
			}else{
				((BinaryTreeAssociation) this.right).newTranslation(tree);
			}
		}else {
	
			if(this.left()==null && tree!=null) {
				this.setLeft(tree);
			}else {
				((BinaryTreeAssociation) this.left).newTranslation(tree);
			}
		}
			
	}
	
	public void inOrderAssociation() {
		inOrderAssociation(this);
	  }
	 private void inOrderAssociation(BinaryTreeAssociation tree) { 
		if (tree.value() == null || tree==null) 
			{ return; } 
		
		inOrderAssociation((BinaryTreeAssociation)tree.left());
		System.out.println("("+tree.value().getEnglish()+","+tree.value().getSpanish()+")");
		inOrderAssociation((BinaryTreeAssociation)tree.right());
		System.out.println("("+tree.value().getEnglish()+","+tree.value().getSpanish()+")");
	}
		
}
