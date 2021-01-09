// Target
public interface Chief
{
  public Object makeBreakfast();
  public Object makeLunch();
  public Object makeDinner();
}

// Adaptee
public class Plumber
{
  public Object getScrewNut()
  { ... }
  public Object getPipe()
  { ... }
  public Object getGasket()
  { ... }
}

// Adapter
public class ChiefAdapter extends Plumber implements Chief
/*мы вкладываем в методы интерфейса методы класса(адаптера)*/
{
  public Object makeBreakfast()
  {
    return getGasket();
  }
  public Object makeLunch()
  {
    return getPipe();
  }
  public Object makeDinner()
  {
    return getScrewNut();
  }
}

// Client
public class Client
{
  public static void eat(Object dish)
  { ... }

  public static void main(String[] args)
  {
    Chief ch = new ChiefAdapter();
    Object dish = ch.makeBreakfast();
    eat(dish);
    dish = ch.makeLunch();
    eat(dish);
    dish = ch.makeDinner();
    eat(dish);
    callAmbulance();
  }
}
