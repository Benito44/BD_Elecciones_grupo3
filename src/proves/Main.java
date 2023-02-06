/*package proves;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        FileReaderClass reader = new FileReaderClass();
        List<String[]> data = reader.readFile("C:/M02/02201606_MESA/07021606.DAT");

        DatabaseInserter inserter = new DatabaseInserter();
        inserter.insertData(data);
    }

}
/*public class DatabaseInserter {
     public void insertData(List<String[]> data) {

                  for (String[] values : data) {
                    pstmt.setString(1, values[0]);
                    pstmt.setString(2, values[1]);
                    pstmt.setString(3, values[2]);
                    pstmt.executeUpdate();
                }
            }
            }
            */

/*
public class FileReaderClass {

  public static List<String[]> readFile(String fileName) {
    List<String[]> data = new ArrayList<>();
    try {
      BufferedReader br = new BufferedReader(new FileReader(fileName));
      String line;
 */
