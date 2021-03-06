public class Worker {
    private final OnTaskDoneListener<String> callback;
    private final OnTaskErrorListener<String> errorCallback;

    public Worker(OnTaskDoneListener<String> callback, OnTaskErrorListener<String> errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 32) {
                errorCallback.onError("Task " + i + " isn't done");
            } else {
                callback.onDone("Task " + i + " is done");
            }
        }
    }
}