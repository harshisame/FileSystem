import java.util.Date;


public class File extends FSElement{
	
	private int size;

	File(Directory parentDir, Date created) {
		super(parentDir, created);
		this.getName();
		this.getOwner();
		this.getLastModified();	
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	boolean IsLeaf() {
		return true;
	}
	
}
