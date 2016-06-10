import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

public class FileCrawler extends Thread{

	private Directory root;
	//ArrayList<FSElement> f = new ArrayList<FSElement>();
	ReentrantLock aLock;
	private ArrayList<FSElement> children;
	private FileQueue fileQueue /*= new FileQueue()*/;

	
	public FileCrawler(Directory root, FileQueue fileQueue) {
		this.root = root;
		aLock = new ReentrantLock();
		this.fileQueue = fileQueue;
	}
	
	private volatile boolean flag = true;
    
	public void stopRunning(){
        flag = false;
    }
     

	public void run() {
		
			aLock.lock();
			try{
				while(flag){
					System.out.println("\n*************** Crawling\\Indexing ***********");
					crawl(root);
				}
			}finally{
				aLock.unlock();
			}
		
				
	}

	
	private void crawl(Directory root) {
		
		aLock.lock();
		try{
			children = root.getChildren();
			Iterator<FSElement> child =  children.iterator();
			while(child.hasNext())
			{	
				FSElement children1 = (FSElement) child.next();
				if (children1 instanceof File){
					
					File childFile = (File) children1;
					if(fileQueue.getSize() >= 3)
						fileQueue.put(childFile);
					else{
						new Thread(new FileIndexer(childFile)).start();
						System.out.println("\n File: \t"+childFile.getName());
					}
				}
			
				else{
					//setCurrent((Directory) children1);
					crawl((Directory) children1);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				
				}
				
			}
		}finally{
			aLock.unlock();
			
		}
		
		
	}

}
