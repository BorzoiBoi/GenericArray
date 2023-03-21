public class MyCustomList<T> implements IMyList<T> {
    private T[] objArray;
    private final Class<T> dataType;
    //WE GOT TEK!
    public MyCustomList(Class<T> dataType){
        this.dataType = dataType;
        this.objArray = (T[]) java.lang.reflect.Array.newInstance(dataType, 0);
    }
    public T get(int i) {
        if(objArray.length == 0)
          return null;
        return objArray[i];
    }

    public void add(T element) {
        T[] tempArray = (T[]) java.lang.reflect.Array.newInstance(dataType, objArray.length + 1);
        for(int i = 0; i < objArray.length; i++)
        {
            tempArray[i] = objArray[i];
        }
        tempArray[objArray.length] = element;
        objArray = tempArray;
    }

    public void add(int index, T element) {
        T[] tempArray = (T[]) java.lang.reflect.Array.newInstance(dataType, objArray.length + 1);
        for(int i = 0; i < objArray.length+1; i++)
        {
            if(i < index) {
              tempArray[i] = objArray[i];
            }
            else if(i == index) {
              tempArray[i] = element;
            }
            else {
              tempArray[i] = objArray[i-1];
            }
        }
        objArray = tempArray;
    }

    public void clear() {
        this.objArray = (T[]) java.lang.reflect.Array.newInstance(this.dataType, 0);
    }

    public T pop() {
        if(objArray.length == 0)
          return null;
        T tempElem = objArray[objArray.length-1];
        T[] tempArray = (T[]) java.lang.reflect.Array.newInstance(this.dataType, objArray.length-1);
        for(int i = 0; i < objArray.length-1; i++)
        {
            tempArray[i] = objArray[i];
        }
        objArray = tempArray;
        return tempElem;
    }

    public int size() {
        return objArray.length;
    }

    public T remove(int index) {
        if(index < 0 || index >= objArray.length)
          return null;
        T tempElem = objArray[index];
        T[] tempArray = (T[]) java.lang.reflect.Array.newInstance(this.dataType, objArray.length-1);
        for(int i = 0; i < objArray.length-1; i++)
        {
            if(i < index) {
                tempArray[i] = objArray[i];
            }
            else {
                tempArray[i] = objArray[i+1];
            }
        }
        objArray = tempArray;
        return tempElem;
    }

    public String toString() {
        if(objArray.length == 0)
        {
            return "[]";
        }
        String ret = "";
        ret += "[";
        for (int i = 0; i < objArray.length-1; i++) {
            ret += objArray[i] + ", ";
        }
        ret += objArray[objArray.length-1] + "]\n";
        return ret;
    }
}