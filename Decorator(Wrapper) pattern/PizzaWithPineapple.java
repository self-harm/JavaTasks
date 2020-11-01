public class PizzaWithPineapple extends PizzaDecorator{

    public PizzaWithPineapple(Pizza pizza){
        super(pizza);
    }

    @Override
    public double getCost(){
        return super.getCost() + 3.0;
    }

    @Override
    public String getIngredients(){
        return super.getIngredients() + "with Pineapple";
    }

    @Override
    public double getTime(){
        return super.getTime() + 1.0;
    }
}
