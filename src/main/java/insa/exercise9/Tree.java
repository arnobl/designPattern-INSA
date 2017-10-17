package insa.exercise9;


public class Tree {
    public final Node root;
    public final String name;
    
    public Tree(final Node rootNode, final String treeName) {
    	super();
    	
    	if(rootNode==null || treeName==null)
    		throw new IllegalArgumentException("Null parameter");
    	
    	root = rootNode;
    	name = treeName;
    }
}
