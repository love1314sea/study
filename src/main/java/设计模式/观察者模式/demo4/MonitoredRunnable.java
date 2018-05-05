package 设计模式.观察者模式.demo4;

/**
 * @author wushang@tingyun.com
 * @date 2018/5/4
 */
public abstract class MonitoredRunnable implements Runnable { //具有 通知状态 功能的 执行单元
    protected Monitor monitor;

    public MonitoredRunnable(final Monitor monitor) {
        this.monitor = monitor;
    }

    public void notifyChange(RunnableEvent state) {
        monitor.onEvent(state);
    }

    public enum RunnableState {
        RUNNING, ERROR, DONE
    }

    public static class RunnableEvent {
        private RunnableState state;
        private Thread thread;
        private Throwable throwable;

        public RunnableEvent(RunnableState state, Thread thread, Throwable throwable) {
            this.state = state;
            this.thread = thread;
            this.throwable = throwable;
        }

        public RunnableState getState() {
            return state;
        }

        public Thread getThread() {
            return thread;
        }

        public Throwable getThrowable() {
            return throwable;
        }

        @Override
        public String toString() {
            return "RunnableEvent{" +
                    "state=" + state +
                    ", thread=" + thread.getName() +
                    ", throwable=" + throwable +
                    '}';
        }
    }

}
