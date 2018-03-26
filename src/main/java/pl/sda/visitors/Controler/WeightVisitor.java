package pl.sda.visitors.Controler;

import pl.sda.visitors.Entity.Items;
import pl.sda.visitors.Entity.Visitor;

public class WeightVisitor implements Visitor {

    private double totalWeight;
    @Override
    public void visit(Items items) {
        totalWeight = totalWeight + ((items == null)? 0.0 : items.getWeight())  ;
    }

    public Double getTotalWeight() {
        return this.totalWeight;
    }
}
