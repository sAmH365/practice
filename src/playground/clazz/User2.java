package playground.clazz;

public class User2 extends Member{

  private String privateField1;
  private Integer privateField2;

  private User2() {}

  public String getUsername() {
    return super.getName();
  }

}
