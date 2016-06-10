import java.util.Date;


public class Link extends FSElement{

	private FSElement target;

	Link(Directory parentDir, Date created, FSElement target) {
		super(parentDir, created);
		this.target = target;
		this.getName();
	}

	public FSElement getTarget() {
		return target;
	}

	public void setTarget(FSElement target) {
		this.target = target;
	}

	@Override
	boolean IsLeaf() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int getSize(){
		return target.getSize();
		
	}
	
		

}
