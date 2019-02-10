package problem.blueberrymuffin;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class MuffinThreadExecuter implements Executor {
	private static MuffinThreadExecuter instance;
	private BlockingQueue<Runnable> allJobs;
	private List<RealThread> workerThreads;
	
	private MuffinThreadExecuter() {
		this.allJobs = new LinkedBlockingQueue<>();
		this.workerThreads = new ArrayList<>();
	}
	
	public static MuffinThreadExecuter getInstance() {
		if (instance == null) {
			instance = new MuffinThreadExecuter();
		}
		return instance;
	}

	@Override
	public void execute(Runnable command) {
		allJobs.add(command);
		if(workerThreads.size() < 3) {
			RealThread thread = new RealThread(new QueuePoller());
			workerThreads.add(thread);
			thread.start();
		}
		
	}
	
	public synchronized Runnable getNextJob() throws InterruptedException {
		return allJobs.poll(1, TimeUnit.SECONDS);
	}
	
	
	
	
	
	

}
