public class Sessao {

    private Conta conta;

    public Sessao(Conta conta) {
        this.conta = conta;
    }

    public Usuario start() {
        System.out.println("Bem vindo " + this.conta.getUser().getNome());

        while(true) {

            System.out.println("Escolha sua operação:\n" +
                    "(0)  - Deletar sua conta\n" +
                    "(1)  - Editar perfil\n" +
                    "(2)  - Adicionar Amigo\n" +
                    "(3)  - Visualizar solicitações de amizades pendentes [" + this.conta.getUser().getSolicitacoes().size() + "]\n" +
                    "(4)  - Aceitar solicitação de amizade pendente\n" +
                    "(5)  - Chats\n" +
                    "(6)  - Visualizar chat com usuario especifico\n" +
                    "(7)  - Enviar mensagem para um usuário\n" +
                    "(8)  - Visualizar comunidades pertencentes\n" +
                    "(9)  - Criar nova comunidade\n" +
                    "(10) - Entrar em uma comunidade\n" +
                    "(11) - Visualizar amigos\n" +
                    "(12) - Visualizar detalhes da conta\n" +
                    "(13) - Administrar suas comunidades [" + this.conta.getUser().getAdminComunidades().size()  + "]\n" +
                    "(14) - Visualizar chat da comunidade\n" +
                    "(15) - Enviar mensagem para comunidade\n" +
                    "(Outro) - Sair da sessão");

            int escolha = Utilidades.lerInteiro();

            if(escolha == 0) {
                return this.getConta().getUser();
            } else if(escolha == 1) {
                this.getConta().editarConta();
            } else if(escolha == 2) {
               this.getConta().adicionarAmigo();
            } else if(escolha == 3) {
                this.getConta().listarAmigos();
            } else if(escolha == 4) {
                this.getConta().aceitarSolicitacao();
            } else if(escolha == 5) {
                this.getConta().getUser().visualizarChats();
            } else if(escolha == 6) {
                this.getConta().visualizarChatComUsuario();
            } else if(escolha == 7) {
                this.getConta().getUser().enviarMensagem();
            } else if(escolha == 8) {
                this.getConta().getUser().visualizarComunidadesPertencentes();
            } else if(escolha == 9) {
                this.getConta().getUser().criarComunidade();
            } else if(escolha == 10) {
                this.getConta().entrarEmComunidade();
            } else if(escolha == 11) {
                this.getConta().getUser().listarAmigos();
            } else if(escolha == 12) {
                this.getConta().detalhesDaConta();
            } else if(escolha == 13) {
                this.getConta().administrarComunidade();
            } else if(escolha == 14) {
                this.conta.getUser().visualizarChatDaComunidade();
            } else if(escolha == 15) {
                this.conta.getUser().enviarMensagemParaComunidade();
            }
            else {
                return null;
            }

        }

    }

    public Conta getConta() {
        return conta;
    }
}
