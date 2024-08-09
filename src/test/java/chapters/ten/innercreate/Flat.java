package chapters.ten.innercreate;

public class Flat {

    private int id;

    public Flat(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    class BathRoom {
        private boolean isUnited;

        public boolean isUnited() {
            return isUnited;
        }

        public void setUnited(boolean united) {
            isUnited = united;
        }
    }
}
