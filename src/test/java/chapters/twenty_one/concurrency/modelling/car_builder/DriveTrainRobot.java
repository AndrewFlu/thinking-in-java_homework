package chapters.twenty_one.concurrency.modelling.car_builder;

class DriveTrainRobot extends AbstractRobot {

    public DriveTrainRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " installing Drivetrain");
        assembler.getCar().addDriveTrain();
    }
}
