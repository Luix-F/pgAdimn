package app;

import java.util.List;
import java.util.Scanner;

import dao.DAO;
import dao.UsuarioDAO;
import model.Usuario;

public class Aplicacao {

	public static void main(String[] args) throws Exception {

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Scanner sc = new Scanner(System.in);
		int key = 9;

		System.out.println("\n1= Inserir usuário\n2= Excluir usuário\n3= Listar\n0= Sai do programa");
		while (key != 0) {
			key = sc.nextInt();

			List<Usuario> usuarios = usuarioDAO.getSexoMasculino();
			switch (key) {
				case 0:
					System.out.println("\nSaindo do programa === ");
					break;
				case 1:
					////////////
					System.out.println("\n\n==== Inserir usuário === ");
					System.out.println("Digite o codigo: ");
					int cd = sc.nextInt();
					System.out.println("Digite o login: ");
					String lo = sc.nextLine();
					System.out.println("Digite a senha: ");
					String se = sc.nextLine();
					System.out.println("Digite o sexo: ");
					String sx = sc.nextLine();
					char xs = sx.charAt(0);
					Usuario usuario = new Usuario(cd, lo, se, xs);
					if (usuarioDAO.insert(usuario) == true) {
						System.out.println("Inserção com sucesso -> " + usuario.toString());
					}
					////////
					break;
				case 2:
					//////////
					System.out.println("\n\n==== Excluir usuário (código ");
					System.out.println("Digite o codigo: ");
					int ecd = sc.nextInt();
					usuarioDAO.delete(ecd);
					//////
					break;
				case 3:
					System.out.println("\n\n==== Mostrar usuários ordenados por código === ");
					usuarios = usuarioDAO.getOrderByCodigo();
					for (Usuario u : usuarios) {
						System.out.println(u.toString());
					}
					break;

				default:
				System.out.println("\nInvalido");
					break;
			}
		}

		/*
		 * System.out.println("\n\n==== Testando autenticação ===");
		 * System.out.println("Usuário (" + usuario.getLogin() + "): " +
		 * usuarioDAO.autenticar("pablo", "pablo"));
		 */
		// System.out.println("\n\n==== Mostrar usuários do sexo masculino === ");

		// for (Usuario u: usuarios) {
		// System.out.println(u.toString());
		// }
		/*
		 * System.out.println("\n\n==== Atualizar senha (código (" + usuario.getCodigo()
		 * + ") === ");
		 * usuario.setSenha(DAO.toMD5("pablo"));
		 * usuarioDAO.update(usuario);
		 * 
		 * System.out.println("\n\n==== Testando autenticação ===");
		 * System.out.println("Usuário (" + usuario.getLogin() + "): " +
		 * usuarioDAO.autenticar("pablo", DAO.toMD5("pablo")));
		 * 
		 * System.out.println("\n\n==== Invadir usando SQL Injection ===");
		 * System.out.println("Usuário (" + usuario.getLogin() + "): " +
		 * usuarioDAO.autenticar("pablo", "x' OR 'x' LIKE 'x"));
		 */

		/*
		 * System.out.println("\n\n==== Mostrar usuários ordenados por login === ");
		 * usuarios = usuarioDAO.getOrderByLogin();
		 * for (Usuario u: usuarios) {
		 * System.out.println(u.toString());
		 * }
		 */
	}
}