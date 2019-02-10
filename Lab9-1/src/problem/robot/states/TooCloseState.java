package problem.robot.states;

import java.util.function.Predicate;

import problem.robot.EnvtParam;
import problem.robot.IRobot;

public class TooCloseState extends AbstractRoboState {

	public TooCloseState(IRobot robot, EnvtParam param) {
		super(robot, param);
	}

	@Override
	public void populateInitialStates() {
		EnvtParam param = this.getParam();
		Predicate<Integer> steadyPred = (i) -> {return (param.getDelta() - param.getLow() <= i && i <= param.getHigh() - param.getDelta());};
		Predicate<Integer> tooClosePred = (i) -> {return (i > param.getHigh() - param.getDelta());};
		Predicate<Integer> tooFarPred = (i) -> {return (i < param.getDelta() - param.getLow());};
		this.addConnectedState(steadyPred, StableState.class);
		this.addConnectedState(tooClosePred, TooCloseState.class);
		this.addConnectedState(tooFarPred, TooFarState.class);

	}

	@Override
	public void controlRobot(int sensor) {
		this.getRobot().correctRight(sensor);

	}

}
