package inner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjie
 */
public class AnonymousInnerClass {

  public Map<String, ObjectFactory<?>> tmpMap = new HashMap<>();

  public String method1(String name) {
    tmpMap.put(name, new ObjectFactory<String>() {
      @Override
      public String getObject() {
        return method2(name);
      }
    });
    return name;
  }

  public void method2(AnonymousInnerClass as) {
    tmpMap.put("as", new ObjectFactory<String>() {
      @Override
      public String getObject() {
        return method3(as);
      }
    });
  }

  public String method2(String name) {
    name = name +"123";
    System.out.println(name);
    return name;
  }

  public String method3(AnonymousInnerClass as){
    return null;
  }


  public static void main(String[] args) {
    AnonymousInnerClass anonymousInnerClass = new AnonymousInnerClass();
    String name = "test";
    anonymousInnerClass.method1(name);
    anonymousInnerClass.tmpMap.get(name).getObject();

    Map<String,Object> testMap = new HashMap<>(2);
    testMap.put("1","1");
  }


}
