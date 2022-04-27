package mariosPizza.LocalDataContext.pizzaOrders;

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
        {
            if(_pizzaIndex < order._pizzaIndex)
                return 1;
            else
                return -1;
        }
        else
            return -1;
    }

    public enum Status {
        Pending,
        InProgress,
        Done
    }

    private static int _instanceIndex = 1;

    private int _orderID;

    public int getOrderID() {
        return _orderID;
    }

    private LocalTime estimatedTimeOfFinish;

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

    private final int _pizzaIndex;
    public int pizzaIndex() {return _pizzaIndex;}

    private final LocalTime created;
    private LocalTime started;
    private LocalTime finished;

    public Order(int pizzaIndex, int duration) {
        this._pizzaIndex = pizzaIndex;
        created = LocalTime.now();
        status = Status.Pending;
        estimatedTimeOfFinish = created.plus(duration,ChronoUnit.MINUTES);
        _orderID = _instanceIndex++;
    }

    public static void setInstanceIndex(int instanceIndex) {_instanceIndex = instanceIndex;}

    public LocalTime getCreated() {return created;}
    public LocalTime getStarted() {return started;}
    public LocalTime getFinished() {return finished;}

    public LocalTime getEstimated() {
        return estimatedTimeOfFinish;
    }

    public void setInProgress(){
        started = LocalTime.now();
        status = Status.InProgress;
    }

    public void setFinished(){
        finished = LocalTime.now();
        status = Status.Done;
    }

    public boolean overdue(){
        var currentTime = LocalTime.now();
        if(currentTime.compareTo(estimatedTimeOfFinish) <= 0)
            return false;
        return true;
    }
}
