public class PizzaWithMushrooms extends PizzaDecorator{

    public PizzaWithMushrooms(Pizza pizza){
        super(pizza);
    }

    @Override
    public double getCost(){
        return super.getCost() + 2.0;
    }

    @Override
    public String getIngredients(){
        return super.getIngredients() + "with Mushrooms";
    }

    @Override
    public double getTime(){
        return super.getTime() + 0.1;
    }
}
