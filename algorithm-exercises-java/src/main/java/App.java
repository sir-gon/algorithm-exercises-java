/**
* Main app entry point.
*/
public class App {
  public String getGreeting() {
    return "Hello World!";
  }

  @SuppressWarnings({"java:S106"})
  public static void main(String[] args) {
    System.out.println(new App().getGreeting());
  }
}
