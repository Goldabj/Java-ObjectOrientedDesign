package problem.blueberrymuffin;

public class VirtualThread {
	private MuffinThreadExecuter executor;
	private Runnable runnable;

	public VirtualThread(Runnable runner) {
		this.runnable = runner;
		executor = MuffinThreadExecuter.getInstance();
	}
	
	public void start() {
		executor.execute(this.runnable);
	}

}
