public class PizzaWithSausages extends PizzaDecorator{

    public PizzaWithSausages(Pizza pizza){
        super(pizza);
    }

    @Override
    public double getCost(){
        return super.getCost() + 1.5;
    }

    @Override
    public String getIngredients(){
        return super.getIngredients() + "with Sausages";
    }

    @Override
    public double getTime(){
        return super.getTime() + 0.2;
    }
}
