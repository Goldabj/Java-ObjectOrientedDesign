package problem.robot.states;

import java.util.function.Predicate;

import problem.robot.EnvtParam;
import problem.robot.IRobot;

public interface IRoboState {
	public void handleCondition(int sensorReading);
	public void addConnectedState(Predicate<Integer> pred, Class<? extends IRoboState> stateClass);
	public void removeConnectedState(Class<? extends IRoboState> stateClass);
	public IRobot getRobot();
	public void setParam(EnvtParam param);
	public EnvtParam getParam();
}
