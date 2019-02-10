package problem.robot;

import problem.robot.states.IRoboState;

public interface IRobot {
	public int readIR();
	public void steady(int sensor);
	public void correctLeft(int sensor);
	public void correctRight(int sensor);
	public void run();
	public void addState(IRoboState state);
	public boolean removeState(IRoboState state);
	public void setCurrentState(IRoboState state);
	public IRoboState getCurrentState(IRoboState state);
	public IRoboState getState(Class<? extends IRoboState> stateClass);
	public void setParam(EnvtParam param);
	
}
