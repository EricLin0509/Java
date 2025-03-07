public class Fish implements Run, Hunt  {
    
    @Override
    public void hunt() {
        System.out.println("The fish is hunting...");
    }

    @Override
    public void run() {
        System.out.println("The fish is swimming away...");
    }

}
