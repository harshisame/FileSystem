import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;


public class Directory extends FSElement{
	
	ArrayList<FSElement> f = new ArrayList<FSElement>();
	int i;
	FSElement child;
	Directory(Directory parentDir, Date created) {
		super(parentDir, created);	
		this.getName();
		this.getOwner();
		this.getLastModified();
		this.getParent();
	}
	
	@Override
	boolean IsLeaf() {
      if(i == 0)
		{
			return false;
		}
		
		else
			return false;
	}
	
	public int getSize()
	{
		int total = 0;
		Iterator<FSElement> i = f.iterator();
		while (i.hasNext())
		{
			FSElement dir = (FSElement) i.next();
			int eleSize = dir.getSize();
			total = total + eleSize;
			
		}
		return total;
	}
	
	public ArrayList<FSElement> getChildren(){
		
		return f;
	}
		
	
	public FSElement appendChild(FSElement addElement){
		f.add(addElement);
		FSElement childName = addElement;
		return childName;
	}
	
	public FSElement addChild(FSElement child, int index){
		f.add(index, child);
		return child;
	}
		
}
