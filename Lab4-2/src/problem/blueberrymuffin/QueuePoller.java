package problem.blueberrymuffin;

public class QueuePoller implements Runnable {

	public QueuePoller() {
	}

	@Override
	public void run() {
		MuffinThreadExecuter exec = MuffinThreadExecuter.getInstance();

		try {
			Runnable runner = exec.getNextJob();
			runner.run();
		} catch (InterruptedException e) {
			run();
		}
	}

}
