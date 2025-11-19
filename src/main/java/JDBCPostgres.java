import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBCPostgres {
    public static void main(String[] args) {
        try{
            String url = "jdbc:postgresql://localhost:5432/rocket_db";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "030403Jg*");
            //props.setProperty("ssl", "true");
            Connection conn = DriverManager.getConnection(url, props);
            System.out.println("Conexão estabelecida");

            String SqlInstruction =  "INSERT INTO public.tab_cadastro(nome, idade) VALUES(?, ?);";
            String nome = "Estela Helena Dias Miranda";
            Integer idade = 20;

            PreparedStatement pst = conn.prepareStatement(SqlInstruction);
            pst.setString(1, nome);
            pst.setInt(2, idade);
            pst.execute();

            System.out.println("Cadastro inserido com sucesso!");
        }catch(Exception err){
            err.printStackTrace();
        }
    }
}