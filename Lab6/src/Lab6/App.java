package Lab6;

public class App {
    interface Data extends Comparable<Data> {
        public void print();

        public int getIdx();
    }

    public static void main(String[] args) throws Exception {
    	Drawer<? super Data> shelf = new Drawer<Data>();

        shelf.add(new Album("album 1", 5));
        shelf.add(new Album("album 2", 10));
        shelf.add(new Book("book 1", 4));
        shelf.add(new Book("book 2", 3));

        Data res = shelf.findMax();

        System.out.print("Bigest data is: ");
        res.print();
    }
}
