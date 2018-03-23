package work.tools;

public class ImRUN {
    public static void main(String[] args) {
//        GenerateDB gdb = new GenerateDB();
//        gdb.createDB();
        UserDAO user = new UserDAO();
        user.insertUser("root2", "root", "root");
    }
}
