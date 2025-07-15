package chapters.twenty_one.concurrency.modelling.car_builder;

class EngineRobot extends AbstractRobot {

    public EngineRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " installing Engine");
        assembler.getCar().addEngine();
    }
}
