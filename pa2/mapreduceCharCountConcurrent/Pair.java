package mapreduce;

import java.io.Serializable;

public class Pair implements Serializable {
  public Object key;
  public Object value;
  public Pair(Object key, Object value) {
    this.key = key;
    this.value = value;
  }
  public void print() {
    System.out.print("("+this.key+", "+this.value+")");
  }
  public String getString() {
    String s = "(" + this.key + ", " + (String)this.value + ")";
    return s;
  }
}

