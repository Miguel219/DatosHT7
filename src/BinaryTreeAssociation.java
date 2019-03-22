//BinaryTree extendido para Association
public class BinaryTreeAssociation extends BinaryTree<Association<String, String>> {
	
	public BinaryTreeAssociation() {
		this.setValue(null);
		this.left=null;
		this.right=null;
	}
	
	public BinaryTreeAssociation(Association<String,String> assoc) {
		this.setValue(assoc);
		this.left=null;
		this.right=null;
		this.parent=null;
	}
	
	//Traduce la palabra si existe en el diccionario sino devuelve null;
	public String englishToSpanish(String english) {
		String spanish= searchWord(this, english);
		if(spanish.equals("")) {
			spanish="*"+english+"*";
		}
		return spanish;
		
	}
	
	//Busca inOrderAssociation la palabra en ingles;
	private String searchWord(BinaryTree<Association<String,String>> tree, String english) { 
		String translation="";
		if(tree!=null) {
			if (tree.value().getEnglish().toLowerCase().equals(english.toLowerCase())){ 
				return (tree.value().getSpanish());
			}
		}
	
		if(tree.left!=null && translation.equals("")) {
			translation=searchWord(tree.left,english);
		}
		if(tree.right!=null && translation.equals("")) {
			translation=searchWord(tree.right,english);
		}
			
		return translation;
		
		}
	
	//Guarda las palabras en orden;
	public  void newTranslation(BinaryTree<Association<String,String>> tree) {
		if(this.value()==null && this.isRoot()) {
			this.setValue(tree.value());
		} else if(this.value().getEnglish().compareTo((tree.value().getEnglish()))<0) {
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
		if (tree == null ) 
			{ return; } 
		
		inOrderAssociation((BinaryTreeAssociation)tree.left());
		System.out.println("("+tree.value().getEnglish()+","+tree.value().getSpanish()+")");
		inOrderAssociation((BinaryTreeAssociation)tree.right());
		
	}
		
}
