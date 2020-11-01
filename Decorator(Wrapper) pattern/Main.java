public class Main {

    public static void main(String[] args) {

        Pizza simplePizza = new SimplePizza();
        System.out.printlf("Ingredients: %s, %nCost: %.2f, %nTime", simplePizza.getIngredients(), simplePizza.getCost(), simplePizza.getTime());

        Pizza pizzaWithSausages = new PizzaWithSausages(new SimplePizza());
        System.out.printlf("Ingredients: %s, %nCost: %.2f, %nTime", pizzaWithSausages.getIngredients(), pizzaWithSausages.getCost(), pizzaWithSausages.getTime());

        Pizza pizzaWithAllIngredients = new PizzaWithPineapple(new PizzaWithSausages(new PizzaWithMushrooms(new SimplePizza())));
        System.out.printlf("Ingredients: %s, %nCost: %.2f, %nTime", pizzaWithAllIngredients.getIngredients(), pizzaWithAllIngredients.getCost(), pizzaWithAllIngredients.getTime());
    }
}
