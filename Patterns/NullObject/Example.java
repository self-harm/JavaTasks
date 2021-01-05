 1/*
 2* Pattern Null object.
 3*/
 4
 5public class Example {
 6
 7    public static void main(String[] args) {
 8        AbstractEntity realEntity = new RealEntity();
 9        realEntity.doSomething(); // RealEntity::doSomething
10
11        AbstractEntity unknownEntity = new NullEntity();
12        unknownEntity.doSomething(); // no output
13    }
14}
15
16abstract class AbstractEntity {
17
18    public abstract void doSomething();
19}
20
21class RealEntity extends AbstractEntity {
22
23    @Override
24    public void doSomething() {
25        System.out.println("RealEntity::doSomething");
26    }
27}
28
29class NullEntity extends AbstractEntity {
30    
31    @Override
32    public void doSomething() {
33        
34    }
35}
