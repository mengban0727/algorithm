package thread;

/**
 * @author zhangjie
 */
public class TestUrl {

  public static void main(String[] args) {
    String[] split = "http://zhs.mof.gov.cn/zhengwuxinxi/zhengcefabu/201909/t20190912_3385739.html"
        .split("/");
    System.out.println(split[1]);
  }
}
