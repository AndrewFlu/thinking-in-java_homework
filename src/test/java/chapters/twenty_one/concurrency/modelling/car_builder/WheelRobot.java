package chapters.twenty_one.concurrency.modelling.car_builder;

class WheelRobot extends AbstractRobot {

    public WheelRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " installing Wheels");
        assembler.getCar().addWheels();
    }
}
