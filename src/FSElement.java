import java.util.Date;


public abstract class FSElement {
	
	protected String name;
	private String owner;
	private Date created;
	private Date lastModified;
	private int size = 0;
	public Directory parentDir;
	
	
	FSElement(Directory parentDir, Date created){
		this.parentDir = parentDir;
		/*if(parentDir != null){
			parentDir.appendChild(this);
		}*/
		this.created = created;
	}
		
	
	public Directory getParent(){
		return parentDir;
		
	}
	
	public String parentName = String.valueOf(parentDir);
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	abstract boolean IsLeaf();

	public void getInfo()
	{
		System.out.println("\nName = "+getName()+"\nOwner = "+getOwner()+"\nSize = "+getSize()+"\nDate created = "+getCreated().toString()+"\nLast Modified = "+getLastModified().toString());

	}

	

}
