package MariosPizza.MarioPizzaOrdering.LocalDataContext.OrdersContext;

import MariosPizza.MarioPizzaOrdering.DataContext.IPersistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeOrders implements IPersistence {
    private final String _FILE = "Orders.ser";

    @Override
    public void save(List<Order> orders) {
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(fileOut);
            out.writeObject(orders);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> load() {
        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream(_FILE);
        } catch (FileNotFoundException e) {
            return new ArrayList<Order>();
        }
        ObjectInputStream in = null;
        List<Order> orders = null;
        try {
            in = new ObjectInputStream(fileIn);
            orders = (List<Order>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
