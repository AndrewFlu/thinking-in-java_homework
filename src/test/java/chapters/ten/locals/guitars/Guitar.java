package chapters.ten.locals.guitars;

public class Guitar {
    private boolean hasInternalTuner;

    public Guitar(boolean hasInternalTuner) {
        this.hasInternalTuner = hasInternalTuner;
    }

    public void prepareToPlay() {
        internalTune(hasInternalTuner);
    }

    private void internalTune(boolean isElectricityTuner) {
        if (isElectricityTuner) {
            class ElectroTuner implements ITuner {
                @Override
                public void tune() {
                    System.out.println("Выполнена найстройка инструмента с помощью встроенного тюнера");
                }
            }

            ElectroTuner eTuner = new ElectroTuner();
            eTuner.tune();
        } else {
            class ManualTuner implements ITuner {
                @Override
                public void tune() {
                    System.out.println("Выполнена настройка инструмента в ручном режиме");
                }
            }

            ManualTuner mTuner = new ManualTuner();
            mTuner.tune();
        }
    }
}
