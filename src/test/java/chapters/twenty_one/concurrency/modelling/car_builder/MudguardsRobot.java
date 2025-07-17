package chapters.twenty_one.concurrency.modelling.car_builder;

class MudguardsRobot extends AbstractRobot {

    public MudguardsRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " installing Mudguards");
        assembler.getCar().addMudguards();
    }
}
