package problem.robot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import problem.robot.states.IRoboState;
import problem.robot.states.StableState;
import problem.robot.states.StartingState;
import problem.robot.states.TooCloseState;
import problem.robot.states.TooFarState;

public class RoombaRobot implements IRobot {
	Iterator<Integer> routeItr;
	private IRoboState currentState;
	private List<IRoboState> states;
	private EnvtParam currentParam;
	
	public RoombaRobot(Iterator<Integer> itr, EnvtParam param) {
		this.routeItr = itr;
		this.currentState = null;
		this.currentParam = param;
		this.states = new ArrayList<>();
		populateStates();
	}
	
	private void populateStates() {
		this.states.add(new StableState(this, this.currentParam));
		this.states.add(new TooFarState(this, this.currentParam));
		this.states.add(new TooCloseState(this, this.currentParam));
	}

	@Override
	public int readIR() {
		if(routeItr.hasNext())
			return routeItr.next();
		return -1;
	}

	@Override
	public void steady(int sensor) {
		System.out.format("Steady state correction [Sensor - %d]%n", sensor);
	}

	@Override
	public void correctLeft(int sensor) {
		System.out.format("Left correction [Sensor - %d]%n", sensor);
	}

	@Override
	public void correctRight(int sensor) {
		System.out.format("Right correction [Sensor - %d]%n", sensor);
	}

	@Override
	public void run() {
		this.currentState = new StableState(this, this.currentParam);
		// set the param for all states
		int sensor = readIR();
		while (sensor != -1) {
			this.currentState.handleCondition(sensor);
			sensor = readIR();
		}
	}

	@Override
	public void addState(IRoboState state) {
		this.states.add(state);
		
	}

	@Override
	public boolean removeState(IRoboState state) {
		return this.states.remove(state);
	}

	@Override
	public void setCurrentState(IRoboState state) {
		this.currentState = state;
	}

	@Override
	public IRoboState getCurrentState(IRoboState state) {
		return this.getCurrentState(state);
	}

	@Override
	public IRoboState getState(Class<? extends IRoboState> stateClass) {
		IRoboState state = null;
		for (int i = 0; i < this.states.size(); i++) {
			if (this.states.get(i).getClass().equals(stateClass)) {
				state = this.states.get(i);
				break;
			}
		}
		return state;
	}

	@Override
	public void setParam(EnvtParam param) {
		this.currentParam = param;
		for(int i = 0; i < this.states.size(); i++) {
			this.states.get(i).setParam(param);
		}
		
	}
}
