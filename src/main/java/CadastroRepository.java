import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CadastroRepository {
    private Connection conexao;

    public CadastroRepository(){
        conexao = Conexao.getConexao();
    }

    public void incluir(Cadastro cadastro){
        try{
            String SqlInstruction =  "INSERT INTO public.tab_cadastro(nome, idade) VALUES(?, ?);";
            PreparedStatement pst = conexao.prepareStatement(SqlInstruction);
            pst.setString(1, cadastro.getNome());
            pst.setInt(2, cadastro.getIdade());
            pst.execute();

            System.out.println("Cadastro inserido com sucesso!");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void alterar(Cadastro cadastro){
        try{
            String SqlInstruction =  "UPDATE public.tab_cadastro SET nome=?, idade=? WHERE id=?;";
            PreparedStatement pst = conexao.prepareStatement(SqlInstruction);
            pst.setString(1, cadastro.getNome());
            pst.setInt(2, cadastro.getIdade());
            pst.setInt(3, cadastro.getId());
            pst.execute();

            System.out.println("Cadastro alterado com sucesso!");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void excluir(Integer id){
        try{
            String SqlInstruction =  "DELETE FROM public.tab_cadastro WHERE id=?;";
            PreparedStatement pst = conexao.prepareStatement(SqlInstruction);
            pst.setInt(1, id);
            pst.execute();

            System.out.println("Cadastro excluído com sucesso!");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public List<Cadastro> listar(){
        String SqlInstruction =  "SELECT id, nome, idade FROM public.tab_cadastro;";
        List<Cadastro> lista = new ArrayList<>();

        try {
            PreparedStatement statement = conexao.prepareStatement(SqlInstruction);
            //statement.setInt(1, 1);
            ResultSet result =  statement.executeQuery();
            while (result.next()){
                int id = result.getInt("id");
                String nome = result.getString("nome");
                int idade = result.getInt("idade");
                //System.out.println("Column 1: " + id);
                //System.out.println("Column 2: " + nome);
                //System.out.println("Column 3: " + idade);

                Cadastro cadastro = new Cadastro();
                cadastro.setId(id);
                cadastro.setNome(nome);
                cadastro.setIdade(idade);

                lista.add(cadastro);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return lista;
    }

    public Cadastro buscar(Integer id){
        Cadastro cadastro =  null;

        try {
            String SqlInstruction =  "SELECT id, nome, idade FROM public.tab_cadastro WHERE id=?;";
            PreparedStatement statement = conexao.prepareStatement(SqlInstruction);
            statement.setInt(1, id);
            ResultSet result =  statement.executeQuery();

            if (result.next()){
                String nome = result.getString("nome");
                int idade = result.getInt("idade");

                cadastro = new Cadastro();
                cadastro.setId(id);
                cadastro.setNome(nome);
                cadastro.setIdade(idade);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return cadastro;
    }
}