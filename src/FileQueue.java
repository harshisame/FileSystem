import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class FileQueue{
	
	public ArrayList<String> fileQueue = new ArrayList<String>(3);
	ReentrantLock aLock;
	
	public void put(File file){
			
			//fileQueue.set(index+1, file);
			//if(fileQueue.size() < 3)
				fileQueue.add(file.getName());
			//else
				
				//new Thread(new FileIndexer(file)).start();
				//System.out.println("\n File: \t"+childFile.getName());
	}

	
	public ArrayList<String> get(){
		return fileQueue;
	}
	
	public int getSize(){
		return fileQueue.size();
	}
	
	public void index(int index, File file){
		fileQueue.remove(file);
		//System.out.println("Index of " +file+" : "+index );
	}
	
	public void remove(File file){
		fileQueue.remove(file);
	}
}
