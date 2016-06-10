import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class FileIndexer extends FileQueue implements Runnable{

	//private FileQueue fileQueue/*= new FileQueue()*/;
	ReentrantLock aLock;
	private File file;
	//private int index;
	
	public FileIndexer(File file) {
		this.file = file;
		aLock = new ReentrantLock();
		//fileQueue= new FileQueue();
	}

	private volatile boolean flag = true;
    
	public void stopRunning(){
        flag = false;
    }
	
	public void run(){
		
		aLock.lock();
		try{
			
			while(flag){
					try {
						Thread.sleep(1000);
						System.out.println("\nIndexer waiting for file");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				
					indexFile( file);
					//System.out.println("\nIndexing file :");
			}
		}
		finally{
			aLock.unlock();
		}
	}

	private ArrayList indexFile(File file) {
			fileQueue.remove(file);
			//file = fileQueue.get();
			System.out.println("Indexed File "+file.getName());
			return fileQueue;
			
			
	}

}