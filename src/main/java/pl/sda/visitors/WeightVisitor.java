package pl.sda.visitors;

import pl.sda.visitors.Entity.Items;
import pl.sda.visitors.Entity.Visitor;

public class WeightVisitor implements Visitor {

    private double totalWeight;
    @Override
    public void visit(Items items) {
        totalWeight =+ items.getWeight();
    }

    public Double getTotalWheit() {
        return this.totalWeight;
    }
}
