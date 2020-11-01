public class SimplePizza implements Pizza{  //realize simple pizza w/o any additives;

    @Override
    public double getCost(){
        return 6;
    }

    @Override
    public String getIngredients(){
        return "Pizza";
    }

    @Override
    public double getTime(){
        return 1;
    }
}
