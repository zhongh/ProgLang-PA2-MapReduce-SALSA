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

  public String toString() {
    return  "(" + this.key.toString() + "," + this.value.toString() + ")";
  }

  public void printDocFreqPair() {
    String word = (String) this.key;
    Pair docFreqPair = (Pair) this.value;
    System.out.print("(" + word + ", (" + docFreqPair.key + ", " + docFreqPair.value + ")");
  }

  public String getString() {
    String s = "(" + this.key + ", " + (String)this.value + ")";
    return s;
  }
}

