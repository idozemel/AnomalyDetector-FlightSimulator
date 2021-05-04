package Commands;

public class Colman {

    String[] col ;
    int size;

    public String[] getCol() {
        return col;
    }

    public String[] gettcol(){
        return col;
    }

    public void setCol(String[] col) {
        this.col = col;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Colman (String[] c , int s) {
        size = s;
        for (int i = 0; i < s; i++)
        {
            col[i]=c[i];
        }
    }

}
