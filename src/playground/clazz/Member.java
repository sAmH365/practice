package playground.clazz;

public class Member {

  private String name;
  private Integer age;
  private String mobileNumber;

  public Member() {}

  public Member(String name, Integer age, String mobileNumber) {
    this.name = name;
    this.age = age;
    this.mobileNumber = mobileNumber;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }
}
