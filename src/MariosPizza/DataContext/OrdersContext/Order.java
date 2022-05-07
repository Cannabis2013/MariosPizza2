package MariosPizza.DataContext.OrdersContext;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Order implements Comparable<Order>, Serializable {
    @Override
    public int compareTo(Order order) {
        var val = estimatedTimeOfFinish.compareTo(order.estimatedTimeOfFinish);
        if(val > 0)
            return 1;
        else if(val == 0)
            return order.orderID - orderID;
        else
            return -1;
    }

    private enum Status {
        Pending,
        InProgress,
        Done
    }

    private static int _instanceIndex = 1;

    public final int orderID;

    private LocalTime estimatedTimeOfFinish;
    public LocalTime getEstimated() {return estimatedTimeOfFinish;}

    private Status status;

    public boolean isPending() {
        return status == Status.Pending;
    }

    public boolean isInProgress() {
        return status == Status.InProgress;
    }

    public boolean isDone() {
        return status == Status.Done;
    }

    public final int menuIndexes;

    private final LocalTime created;
    private LocalTime _started;

    public LocalTime started() {return _started;}

    public LocalTime finished() {return _finished;}

    private LocalTime _finished;

    public Order(int pizzaIndex, int duration) {
        this.menuIndexes = pizzaIndex;
        created = LocalTime.now();
        status = Status.Pending;
        estimatedTimeOfFinish = created.plus(duration,ChronoUnit.MINUTES);
        orderID = _instanceIndex++;
    }

    public static void setInstanceIndex(int instanceIndex) {_instanceIndex = instanceIndex;}

    public void setInProgress(){
        _started = LocalTime.now();
        status = Status.InProgress;
    }

    public void setFinished(){
        _finished = LocalTime.now();
        status = Status.Done;
    }

    public boolean overdue(){
        var currentTime = LocalTime.now();
        if(currentTime.compareTo(estimatedTimeOfFinish) <= 0)
            return false;
        return true;
    }
}
