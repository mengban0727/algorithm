package stack;

/**
 * 使用前后栈实现浏览器的前进和后退
 *
 * @author zhangjie
 */
public class SampleBrower {

  private String currentPage;

  private LinkedListStack<String> backStack;

  private LinkedListStack<String> forwardStack;

  public void open(String url) {
    if (this.currentPage != null) {
      this.backStack.push(this.currentPage);
      this.forwardStack.clear();
    }
    this.currentPage = url;
  }

  public String goBack() {
    //TODO:判断backStack是否为空

    if (this.backStack.size == 0) {
      return null;
    }
    this.forwardStack.push(this.currentPage);
    String backUrl = this.backStack.pop();
    this.currentPage = backUrl;
    return backUrl;
  }

  public String goForward() {
    //TODO:判断forwardStack是否为空
    if (this.forwardStack.size == 0) {
      return null;
    }

    this.backStack.push(currentPage);
    String forwardUlr = this.forwardStack.pop();
    this.currentPage = forwardUlr;
    return forwardUlr;
  }

}
