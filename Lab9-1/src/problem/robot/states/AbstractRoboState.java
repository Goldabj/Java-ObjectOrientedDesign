package problem.robot.states;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;

import problem.robot.EnvtParam;
import problem.robot.IRobot;

public abstract class AbstractRoboState implements IRoboState {
	private IRobot robot;
	private Map<Predicate<Integer>, Class<? extends IRoboState>> connnectedStates;
	private EnvtParam param;

	public AbstractRoboState(IRobot robot, EnvtParam param) {
		this.robot = robot;
		this.connnectedStates = new HashMap<>();
		this.param = param;
		populateInitialStates();
	}

	@Override
	public void handleCondition(int sensorReading) {
		controlRobot(sensorReading);
		Class<? extends IRoboState> connectedState = null; 
		Iterator<Predicate<Integer>> iter = this.connnectedStates.keySet().iterator();
		while (iter.hasNext()) {
			Predicate<Integer> pred = iter.next();
			if (pred.test(sensorReading)) {
				connectedState = this.connnectedStates.get(pred);
				break;
			}
		}
		if (connectedState != null) {
			IRoboState nextState = this.robot.getState(connectedState);
			if (nextState != null) {
				this.robot.setCurrentState(nextState);
			}
		}
		

	}

	@Override
	public void addConnectedState(Predicate<Integer> pred, Class<? extends IRoboState> stateClass) {
		this.connnectedStates.put(pred, stateClass);

	}

	@Override
	public void removeConnectedState(Class<? extends IRoboState> stateClass) {
		this.connnectedStates.remove(stateClass);
	}
	
	@Override 
	public IRobot getRobot() {
		return this.robot;
	}
	
	@Override
	public void setParam(EnvtParam param) {
		this.param = param;
	}
	
	@Override 
	public EnvtParam getParam() {
		return this.param;
	}
	
	abstract public void populateInitialStates();
	
	abstract public void controlRobot(int sensor);

}
