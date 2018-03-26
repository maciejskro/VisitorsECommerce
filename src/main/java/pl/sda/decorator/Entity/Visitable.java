package pl.sda.decorator.Entity;

public interface Visitable {

    void accept(Visitor visitor);
}
