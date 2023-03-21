public class MyCustomList<T> implements IMyList<T> {
    private T[] objArray;
    private final Class<T> dataType;
    //WE GOT TEK!
    @SuppressWarnings("unchecked")
    public MyCustomList(Class<T> dataType){
        this.dataType = dataType;
        this.objArray = (T[]) java.lang.reflect.Array.newInstance(dataType, 0);
    }
    public T get(int i) {
        if(objArray.length == 0)
          return null;
        return objArray[i];
    }

    @SuppressWarnings("unchecked")
    public void add(T element) {
        T[] tempArray = (T[]) java.lang.reflect.Array.newInstance(dataType, objArray.length + 1);
        System.arraycopy(objArray, 0, tempArray, 0, objArray.length);
        tempArray[objArray.length] = element;
        objArray = tempArray;
    }

    @SuppressWarnings("unchecked")
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

    @SuppressWarnings("unchecked")
    public void clear() {
        this.objArray = (T[]) java.lang.reflect.Array.newInstance(this.dataType, 0);
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if(objArray.length == 0)
          return null;
        T tempElem = objArray[objArray.length-1];
        T[] tempArray = (T[]) java.lang.reflect.Array.newInstance(this.dataType, objArray.length-1);
        System.arraycopy(objArray, 0, tempArray, 0, objArray.length-1);
        objArray = tempArray;
        return tempElem;
    }

    public int size() {
        return objArray.length;
    }

    @SuppressWarnings("unchecked")
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
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < objArray.length-1; i++) {
            sb.append(objArray[i]);
            sb.append(", ");
        }
        sb.append(objArray[objArray.length-1]);
        sb.append("]");
        return sb.toString();
    }
}