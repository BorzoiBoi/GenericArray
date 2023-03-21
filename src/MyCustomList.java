public class MyCustomList<T> implements IMyList<T> {
    private T[] objArray;
    public int length;
    private final Class<T> dataType;
    //WE GOT TEK!
    public MyCustomList(Class<T> dataType){
        this.dataType = dataType;
        this.objArray = (T[]) java.lang.reflect.Array.newInstance(dataType, 0);
        this.length = 0;
    }
    public T get(int i) {
        if(this.length == 0)
          return null;
        return objArray[i];
    }

    public void add(T element) {
        T[] tempArray = (T[]) java.lang.reflect.Array.newInstance(dataType, length + 1);
        for(int i = 0; i < length; i++)
        {
            tempArray[i] = objArray[i];
        }
        tempArray[length] = element;
        this.length++;
        objArray = tempArray;
    }

    public void add(int index, T element) {
        T[] tempArray = (T[]) java.lang.reflect.Array.newInstance(dataType, length + 1);
        for(int i = 0; i < length+1; i++)
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
        this.length++;
        objArray = tempArray;
    }

    public void clear() {
        this.objArray = (T[]) java.lang.reflect.Array.newInstance(this.dataType, 0);
        this.length = 0;
    }

    public T pop() {
        if(this.length == 0)
          return null;
        T tempElem = objArray[length-1];
        T[] tempArray = (T[]) java.lang.reflect.Array.newInstance(this.dataType, length-1);
        for(int i = 0; i < length-1; i++)
        {
            tempArray[i] = objArray[i];
        }
        objArray = tempArray;
        this.length--;
        return tempElem;
    }

    public int size() {
        return objArray.length;
    }

    public T remove(int index) {
        if(index < 0 || index >= length)
          return null;
        T tempElem = objArray[index];
        T[] tempArray = (T[]) java.lang.reflect.Array.newInstance(this.dataType, length-1);
        for(int i = 0; i < length-1; i++)
        {
            if(i < index) {
                tempArray[i] = objArray[i];
            }
            else {
                tempArray[i] = objArray[i+1];
            }
        }
        objArray = tempArray;
        this.length--;
        return tempElem;
    }

    public void arrWrite() {
        if(length == 0)
        {
            System.out.print("[]\n");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < length-1; i++) {
            System.out.print(objArray[i] + ", ");
        }
        System.out.print(objArray[length-1] + "]\n");
    }
}