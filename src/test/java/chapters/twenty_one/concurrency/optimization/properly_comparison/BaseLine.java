package chapters.twenty_one.concurrency.optimization.properly_comparison;

class BaseLine extends AbstractAccumulator {

    {
        id = "BaseLine";
    }


    @Override
    public void accumulate() {
        value += preLoaded[index++];
        if (index >= SIZE)
            index = 0;
    }

    @Override
    public long read() {
        return value;
    }
}
