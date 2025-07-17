package chapters.twenty_one.concurrency.modelling.car_builder;

class ExhaustRobot extends AbstractRobot {

    public ExhaustRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " installing Exhaust system");
        assembler.getCar().addExhaust();
    }
}
