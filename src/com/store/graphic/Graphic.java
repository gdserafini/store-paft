package com.store.graphic;

import java.time.LocalDate;

public class Graphic {
	
	public static void printIntro() {
		System.out.println("\nBem-vindo a PAFT Store.\nPara começar faça login.");
	}
	
	public static void printEnd() {
		System.out.println("Finalizado.\n" + LocalDate.now());
	}
	
	public static void printMsgEnterCpf() {
		System.out.println("Digite seu cpf: ");
	}

	public static void printMsgInvalidFormat() {
		System.out.println("Formato inválido.");
	}
	
	public static void printMsgInvalidValue() {
		System.out.println("Valor inválido.");
	}
	
	public static void printMsgInvalidType() {
		System.out.println("Entrada de dados inválida.");
	}
	
	public static void printMsgNotFound() {
		System.out.println("Não encontrado.");
	}
	
	public static void printMsgEnterPassword() {
		System.out.println("Digite sua senha: ");
	}
	
	public static void printMsgIncorrectPassword() {
		System.out.println("Senha incorreta.");
	}
	
	public static void printMsgCreateAccount() {
		System.out.println("Para criar uma conta digite se nome: ");
	}
	
	public static void printMsgCreatePassword() {
		System.out.println("Defina uma senha: ");
	}
	
	public static void printMsgAccountCreated() {
		System.out.println("Conta criada com sucesso.");
	}
	
	public static void printMsgCreateError() {
		System.out.println("Erro ao criar.");
	}
	
	public static void printMsgMainMenu() {
		System.out.println("PAFT Store - Menu principal.");
	}
	
	public static void printMainMenuOptions(Integer number) {
		System.out.println("\nDigite 1 para ir as compras."
				+ "\n(auth)Digite 2 para relatório."
				+ "\nDigite 3 para mudar o usuário."
				+ "\nDigite 4 para saber mais sobre a loja."
				+ "\n(admin)Digite 5 para gerenciar o estoque."
				+ "\nDigite 6 para sair.");
	}
	
	public static void printMainMenuOptions() {
		System.out.println("\nDigite 1 para ir as compras."
				+ "\n(auth)Digite 2 para relatório."
				+ "\nDigite 3 para mudar o usuário."
				+ "\nDigite 4 para saber mais sobre a loja."
				+ "\n(admin)Digite 5 para gerenciar o estoque."
				+ "\nDigite 6 para sair.");
	}
	
	public static void printBuyMenuOptions() {
		System.out.println("\nDigite 1 para procurar um produto."
				+ "\nDigite 2 para listar todos os produtos."
				+ "\nDigite 3 para adicionar um produto ao carrinho."
				+ "\nDigite 4 para exibir o carrinho."
				+ "\nDigite 5 para sair.");
	}
	
	public static void printInventoryMenuOptions() {
		System.out.println("\nDigite 1 para alterar um produto."
				+ "\nDigite 2 para adicionar um novo produto."
				+ "\nDigite 3 para remover um produto."
				+ "\nDigite 4 para sair");
	}
	
	public static void printMsgAbout() {
		System.out.println("\nBem-vindo a PAFT Store"
				+ "\nSomos a maior loja do Brasil, sempre com os melhores preços."
				+ "\nv.2.0 by giordano.");
	}
	
	public static void printMsgBuyMenu() {
		System.out.println("PAFT Store - Menu de compras.");
	}
	
	public static void printObject(Object object) {
		System.out.println(object);
	}
	
	public static void printMsgProductName() {
		System.out.println("Digite o nome do produto: ");
	}
	
	public static void printMsgEnterAmount() {
		System.out.println("Digite a quantidade: ");
	}
	
	public static void printMsgCartMenu() {
		System.out.println("PAFT Store - Carrinho");
	}
	
	public static void printCartOptions() {
		System.out.println("\nDigite 1 para finalizar as compras."
				+ "\nDigite 2 para remover um produto."
				+ "\nDigite 3 para voltar as compras.");
	}
	
	public static void printMsgInventoryMenu() {
		System.out.println("PAFT Store - Menu estoque.");
	}
	
	public static void printMsgNotPossibleAdd() {
		System.out.println("Não é possível adicionar.");
	}
	
	public static void printMsgErrorDataBase() {
		System.out.println("Erro ao se conectar com o banco de dados.");
	}
	
	public static void printMsgUpdateData() {
		System.out.println("Dados atualizados.");
	}
	
	public static void printMsgAlreadyExists() {
		System.out.println("Já existe um registro com esta chave.");
	}
	
	public static void printMsgErrorUpdate() {
		System.out.println("Erro em atualizar os dados.");
	}
	
	public static void printMsgDeleted() {
		System.out.println("Deletado com sucesso.");
	}
	
	public static void printMsgDeleteError() {
		System.out.println("Erro ao deletar.");
	}
	
	public static void printMsgErrorGet() {
		System.out.println("Erro no get");
	}
	
	public static void printMsgInvalidAcess() {
		System.out.println("Acesso negado.");
	}
	
	public static void printMsgEmpty() {
		System.out.println("Vazio.");
	}
	
	public static void printMsgOptionsChange() {
		System.out.println("Digite 1 para alterar o preço, 2 para alterar a quantidade em estoque:");
	}
	
	public static void printMsgEnterNewPrice() {
		System.out.println("Digite o preço: ");
	}
	
	public static void printMsgCreated() {
		System.out.println("Registro criado com sucesso.");
	}
	
	public static void printMsgEnterNewAmount() {
		System.out.println("Digite a quantidade: ");
	}
	
}
