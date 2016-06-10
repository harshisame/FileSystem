import java.util.Date;

public class FileSystem {
     
    private static FileSystem instance = null;
   
    private FileSystem(){};
    
    public static FileSystem getInstance(){
    	if(instance == null)
		{
			instance = new FileSystem();
		}
		return instance;
    }
     
    public static Date currentDate = new Date();
        
    static Directory root = new Directory(null, currentDate);
   
    static Directory system = new Directory(root, currentDate);
    
    static File a = new File(system, currentDate);
    static File b = new File(system, currentDate);
    static File c = new File(system, currentDate);
    
    static Directory home = new Directory(root, currentDate);
    static File d = new File(home, currentDate);
    
    static Directory pictures = new Directory(home, currentDate);
    static File e = new File(pictures, currentDate);
    static File f = new File(pictures, currentDate);
    
    static Link x = new Link(home, currentDate, system);
    static Link y = new Link(pictures, currentDate, e);
    
    
    public static void main(String args[]){
        
    	root.setName("Root");
        root.setOwner("Harshita");
        root.appendChild(system);
        root.appendChild(home);
        root.setLastModified(currentDate);
        
        system.setName("System");
        system.setOwner("Harshita");
        system.appendChild(a);
        system.appendChild(b);
        system.appendChild(c);
        system.setLastModified(currentDate);
        
        
        a.setName("a");
        a.setOwner("Harshita");
        a.setSize(8);
        a.setLastModified(currentDate);
        
        
        b.setName("b");
        b.setOwner("Harshita");
        b.setSize(10);
        b.setLastModified(currentDate);
        
        c.setName("c");
        c.setOwner("Harshita");
        c.setSize(5);
        c.setLastModified(currentDate);
        
        home.setName("Home");
        home.setOwner("Harshita");
        home.appendChild(d);
        home.appendChild(pictures);
        home.setLastModified(currentDate);
        
        d.setName("d");
        d.setOwner("Harshita");
        d.setSize(6);
        d.setLastModified(currentDate);
        
        pictures.setName("Pictures");
        pictures.setOwner("Harshita");
        pictures.appendChild(e);
        pictures.appendChild(f);
        pictures.setLastModified(currentDate);
        
        
        e.setName("e");
        e.setOwner("Harshita");
        e.setSize(20);
        e.setLastModified(currentDate);
        
        
        f.setName("f");
        f.setOwner("Harshita");
        f.setSize(15);
        f.setLastModified(currentDate);
        
        x.setName("x");
        y.setName("y");
        
        
        getInstance().showAllElements();
        
        FileQueue fileQueue = new FileQueue();
       
       
    	Thread t = new Thread(new FileCrawler(root, fileQueue));
          
          t.start();
          
          try
          {
              Thread.sleep(10000);
          } 
          catch (InterruptedException e) 
          {
              e.printStackTrace();
          }
           
           
          ((FileCrawler) t).stopRunning();
    }

	private void showAllElements() {
		
		root.getInfo();
		root.getChildren();
		
		system.getInfo();
		System.out.println("Parent Name: "+system.getParent().getName());
		system.getChildren();
		a.getInfo();
		System.out.println("Parent Name: "+a.getParent().getName());
		b.getInfo();
		System.out.println("Parent Name: "+b.getParent().getName());
		c.getInfo();
		System.out.println("Parent Name: "+c.getParent().getName());
		
		home.getInfo();
		System.out.println("Parent Name: "+home.getParent().getName());
		home.getChildren();
		d.getInfo(); 
		System.out.println("Parent Name: "+d.getParent().getName());
		
		pictures.getInfo();
		System.out.println("Parent Name: "+pictures.getParent().getName());
		pictures.getChildren();
		e.getInfo();
		System.out.println("Parent Name: "+e.getParent().getName());
		f.getInfo();
		System.out.println("Parent Name: "+f.getParent().getName());
		
		System.out.println("\n The size of the link for system is :"+x.getSize());
		
		System.out.println("\n The size of the link for e is :"+y.getSize());
		
	}
}

