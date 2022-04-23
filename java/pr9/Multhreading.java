public class Main {
    public static void main(String[] args) {
        // test TickTock
        TickTock t = new TickTock();
        t.clock();
    }
}

class TickTock {
    String state;

    synchronized void tick(boolean running) {
        if (!running) {
            return;
        }
        System.out.println(state);
        state = state == "Tick" ? "Tock" : "Tick";
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // clock method that runs forever, printing ticks and tocks at each half-second
    public void clock() {
        state = "Tick";
        boolean running = true;
        this.tick(running);
    }
}   