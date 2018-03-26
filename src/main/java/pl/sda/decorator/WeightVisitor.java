package pl.sda.decorator;

import pl.sda.decorator.Entity.Items;
import pl.sda.decorator.Entity.Visitor;

public class WeightVisitor implements Visitor {

    private double totalWeight;
    @Override
    public void visit(Items items) {
        totalWeight =+ items.getWeight();
    }
}
