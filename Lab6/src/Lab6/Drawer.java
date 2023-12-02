package Lab6;

import java.util.ArrayList;

import Lab6.App.Data;

public class Drawer<T extends Data> {
  private ArrayList<T> arr;

  public Drawer() {
    arr = new ArrayList<T>();
  }

  public T findMax() {
    if (arr.isEmpty()) {
      return null;
    }

    T max = arr.get(0);
    for (int i=1; i< arr.size(); i++){
    	if ( arr.get(i).compareTo(max) > 0 )
    	{
    		max = arr.get(i);
    	}
    }

    return max;
  }

  public void add(T data) {
    arr.add(data);
  }

  public void remove(int idx) {
    arr.remove(idx);
  }

  public void remove(T data) {
    arr.remove(data);
  }
}
