public interface IMyList<T> {
    void add(T element);
    void add(int index, T element);
    void clear();
    T pop();
    int size();
    T remove(int index);
}
