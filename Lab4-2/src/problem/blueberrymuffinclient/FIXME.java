package problem.blueberrymuffinclient;

import problem.blueberrymuffin.RealThread;
import problem.blueberrymuffin.VirtualThread;

public class FIXME {
	public static void main(String[] args){
		VirtualThread t1 = new VirtualThread(() -> {
			for(int i=0; i<100; i++){
				System.out.println("t1 "+i);
			}
		});
		VirtualThread t2 = new VirtualThread(() -> {
			for(int i=0; i<100; i++){
				System.out.println("t2 "+i);
			}
		});
		VirtualThread t3 = new VirtualThread(() -> {
			for(int i=0; i<100; i++){
				System.out.println("t3 "+i);
			}
		});
		VirtualThread t4 = new VirtualThread(() -> {
			for(int i=0; i<100; i++){
				System.out.println("t4 "+i);
			}
		});
		
		t1.start();
		System.err.println(RealThread.getTotalThreads());
		
		t2.start();
		System.err.println(RealThread.getTotalThreads());
		
		t3.start();
		System.err.println(RealThread.getTotalThreads());
		
		t4.start(); // BOOM: Muffin CPU blows up here
		System.err.println(RealThread.getTotalThreads());
	}
}
