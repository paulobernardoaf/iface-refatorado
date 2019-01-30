import java.util.Scanner;

public class Conta {

    private Usuario user = new Usuario();
    private String login;
    private String senha;
    private int id;

    public Conta(int id) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o login: ");
        String login = scanner.nextLine();
        while(Sistema.indisponibilidadeLogin(login)) {
            System.out.println("Login ja esta em uso, escolha outro:");
            login = scanner.nextLine();
        }
        this.setLogin(login);
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();
        this.setSenha(senha);
        System.out.print("Digite o nome de usuário: ");
        String usuario = scanner.nextLine();
        while (Sistema.indisponibilidadeUsuario(usuario)) {
            System.out.println("Nome de usuario ja esta em uso, escolha outro:");
            usuario = scanner.nextLine();
        }
        this.getUser().setNome(usuario);
        this.setId(id);

    }

    public void detalhesDaConta() {
        System.out.println("Id: " + this.getId());
        System.out.println("Login: " + this.getLogin());
        System.out.println("Senha: " + this.getSenha());
        System.out.println("Detalhes do usuário:");
        this.user.detalhesUsuario();
        System.out.println();
    }

    public void editarConta(){

        Scanner scanner = new Scanner(System.in);

        while(true) {

            System.out.println("Escolha o que deseja alterar:\n" +
                    "(1) - Senha\n" +
                    "(2) - Login\n" +
                    "(3) - Nome de Usuário\n" +
                    "(Outro) - Voltar para sessão");

            int escolha = Utilidades.lerInteiro();

            if(escolha == 1) {
                System.out.print("Digite a nova senha: ");
                String senhaStr = scanner.nextLine();
                this.setSenha(senhaStr);
            } else if(escolha == 2) {
                System.out.print("Digite o novo login: ");
                String loginStr = scanner.nextLine();
                this.setLogin(loginStr);
            } else if(escolha == 3) {
                System.out.print("Digite o novo nome de usuário: ");
                String nomeStr = scanner.nextLine();
                this.getUser().setNome(nomeStr);
            } else {
                return;
            }

            System.out.println("Alterações realizadas.");

        }
    }

    public void adicionarAmigo() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome de usuário:");
        String nome = scanner.nextLine();
        Usuario amigo = Sistema.getUsuarioPeloNome(nome);
        if(amigo == null) {
            System.out.println("Usuário não encontrado.");
        } else {
            this.getUser().mandarSolicitacao(amigo);
            System.out.println("Solicitação de amizade enviada.");
        }

    }

    public void listarAmigos() {

        for (Usuario usuario : this.getUser().getSolicitacoes()) {
            System.out.println("\t" + usuario.getNome());
        }

    }

    public void aceitarSolicitacao() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome de usuário do amigo a ser aceito: ");
        String nome = scanner.nextLine();
        Usuario amigo = Sistema.getUsuarioPeloNome(nome);
        if(amigo == null) {
            System.out.println("Usuário não encontrado.");
        } else {
            this.getUser().aceitarSolicitção(amigo.getNome());
        }

    }

    public void visualizarChatComUsuario() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome de usuário a ser buscado: ");
        String nome = scanner.nextLine();
        Usuario usuario =  Sistema.getUsuarioPeloNome(nome);
        if(usuario != null) {
            this.getUser().visualizarChatUnico(usuario);
        } else {
            System.out.println("Usuário não existe.");
        }

    }

    public void entrarEmComunidade() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Comunidades existentes:");
        Sistema.listarTodasComunidades();
        System.out.print("Digite o nome da comunidade: ");
        String nome = scanner.nextLine();
        Comunidade comunidade = Sistema.checarComunidadeExistente(nome);
        if(comunidade != null) {
            this.getUser().entrarEmComunidade(comunidade);
        } else {
            System.out.println("Comunidade não existente.");
        }

    }

    public void administrarComunidade() {

        Scanner scanner = new Scanner(System.in);

        this.getUser().visualizarComunidadesAdmins();

        System.out.print("Digite o nome da sua comunidade que deseja gerenciar:");
        String nome = scanner.nextLine();
        Comunidade comunidade = Sistema.getComunidadePeloNome(nome);
        if(comunidade != null) {
            if(this.getUser().getAdminComunidades().contains(comunidade)) {
                this.getUser().administrarComunidade(comunidade);
            } else {
                System.out.println("Você não tem permissão para gerenciar essa comunidade.");
            }
        } else {
            System.out.println("Essa comunidade não existe.");
        }

    }

    public Usuario getUser() {
        return user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
