package other.dbmigration;

public interface Migration {

    void perform();

    void undo();
}
