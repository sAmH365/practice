package playground.clazz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Clazz {

  public static void main(String[] args)
      throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    Class<? extends Member> memberClazz = User2.class;
//    Class<Member> memberClazz = Member.class;

//    Constructor<User2> user2Con = memberClazz.getDeclaredConstructor();
//    Member member = user2Con.newInstance();


    // 선언된 필드들
    Field[] declaredFields = memberClazz.getDeclaredFields();
    for (Field declaredField : declaredFields) {
      System.out.println("필드 : " + declaredField.getName());
    }
//    memberClazz.getDeclaredField("")

    // 선언된 메서드들
    Method[] declaredMethods = memberClazz.getDeclaredMethods();
    for (Method declaredMethod : declaredMethods) {
      System.out.println("메서드 : " + declaredMethod);
    }

    // 상위 메서드
    System.out.println("상위 클래스 : " + memberClazz.getSuperclass().getName());

    // 선언된 생성자
    Constructor<?>[] constructors = memberClazz.getConstructors();
    for (Constructor<?> constructor : constructors) {
      System.out.println("생성자 : " + constructor.getName());
    }


  }

}
