package chapters.twenty_one.concurrency.tasks.task_35;

// Объекты, только для чтения, не требуют синхронизации
class WebClient {
    private final int sessionTime;

    public WebClient(int sessionTime) {
        this.sessionTime = sessionTime;
    }

    public int getSessionTime() {
        return sessionTime;
    }

    @Override
    public String toString() {
        return "[" + sessionTime + "]";
    }
}
