package pl.sda.visitors;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import pl.sda.visitors.Entity.Book;
import pl.sda.visitors.Entity.Items;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

;


public class WeightVisiotrTest {

    private Items items;
    private List<Items> listItems;
    private WeightVisitor visitorTest;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setupClasses() {
        visitorTest = new WeightVisitor();
        items = new Book();
        items.setName("dowolna ksiązka");
        items.setWeight(0.0);
        listItems = new ArrayList<>();
        Items items1 = new Book();
            items1.setName("ksiązka z wagą 1");
            items1.setWeight(1.0);
        Items items2 = new Book();
            items2.setName("ksiązka z wagą 2.33");
            items2.setWeight(2.33);
                listItems.add(items);
                listItems.add(items1);
                listItems.add(items2);
    }

    @Test
    public void shouldReturnZeroForZeroWeight() {

        WeightVisitor mocVisitorTest = mock(WeightVisitor.class);
        visitorTest.visit(items);
        mocVisitorTest.visit(items);

        verify(mocVisitorTest).visit(items);
        assertThat(visitorTest.getTotalWeight()).isEqualTo(0.0);
    }

    @Test
    public void shouldReturnZeroIfNullIsGiven() {

        visitorTest.visit(null);

        assertThat(visitorTest.getTotalWeight()).isEqualTo(0.0);
    }

    @Test
    public void shoudReturnOneIfOneKilosIsGiven() {

        visitorTest.visit(listItems.get(1));

        assertThat(visitorTest.getTotalWeight()).isEqualTo(1.0);
    }

    @Test
    public  void shouldSumOfGivenWeightObject() {

        for (Items i : listItems) {
            visitorTest.visit(i);
        }
        //visitorTest.getTotalWeight();

        assertThat(visitorTest.getTotalWeight()).isEqualTo(3.33);
    }

}
