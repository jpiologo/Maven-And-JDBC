import java.util.List;

public class SistemaCadastro {
    public static void main(String[] args) {
        Conexao.conectar();
        CadastroRepository repository = new CadastroRepository();
        //Cadastro cadastro = new Cadastro();

        //cadastro.setNome("Estela Miranda");
        //cadastro.setIdade(20);
        //cadastro.setId(1);

        //repository.incluir(cadastro);
        //repository.alterar(cadastro);
        //repository.excluir(1);

        //List<Cadastro> cadastros = repository.listar();
        //for(Cadastro c: cadastros){
        //    System.out.println(c.getId() + " " + c.getNome());
        //}

        Cadastro cadastro = repository.buscar(2);
        if(cadastro!=null){
            System.out.println(cadastro.getId() + " " + cadastro.getNome());
        }else{
            System.out.println("Não foi possível localizar um cadastro com ID informado.");
        }
    }
}