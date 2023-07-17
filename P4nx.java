import java.util.Scanner;
import java.util.ArrayList;

public class P4nx{
	
	// Leitor de entrada padrao
	static Scanner teclado = new Scanner(System.in);
	
	
	// linha auxiliar
	public static void linha(){
		System.out.println("\n=======================================================");
	}
	
	
	// Menu de opcoes de ordenacao
	public static void menu(){
		linha();
		System.out.printf("\n\t\t\tMENU\n");
		linha();
		System.out.println("\nTabela com os metodos de ordenacao:\n\n" +
			"1. Alfabetica (A-Z)\n" +
			"2. Alfabetica (Z-A)\n" +
			"3. Menor Peso - crescente\n4. Maior Peso - decrescente\n" +
			"5. Menor Altura - crescente\n6. Maior Altura - decrescente\n" +
			"7. Menor IMC - crescente\n8. Maior IMC - decrescente\n" +
			"9. Homem -> Mulher\n10. Mulher -> Homem\n" +
			"11. Nascimento - crescente\n12. Nascimento - decrescente"); 
	}
	
	
	// Verificando a escolha do usuario
	public static int escolha(){
		linha();
		System.out.print("\n1- Listar Elementos\n2- Sair\n\nEscolha uma opcao: ");
		int opcao = teclado.nextInt();
		linha();
		
		return opcao;
	}
	
	
	// Le o modo de ordenacao
	public static int leCriterio(){
		System.out.print("\nEscolha um metodo de ordenacao: ");
		int c = teclado.nextInt();
		linha();
		return c;
	}
	
	
	// Criando os objetos Homem
	public static MinhaListaOrdenavel adicionaHomens(MinhaListaOrdenavel l){
		// Objetos criados
		Homem h1 = new Homem("Carlos", 3, 10, 2003, (float) 2, 74, 20),
		
		h2 = new Homem("Marcelo", 10, 02, 1987, (float) 1.78, 65, 36),
			
		h3 = new Homem("Arthur", 23, 9, 1989, (float) 1.67, 56, 34),
			
		h4 = new Homem("Pedro", 12, 11, 1993, (float) 1.70, 70, 30),
			
		h5 = new Homem("Luiz", 30, 11, 2000, (float) 1.75, 80, 23);
		
		// Adicionando os elementos criados ao array
		l.add(h1); l.add(h2); l.add(h3); l.add(h4); l.add(h5);
		
		// Retornando a lista com os novos objetos
		return l;
	}
	
	
	public static MinhaListaOrdenavel adicionaMulheres(MinhaListaOrdenavel l){
		// Criando os objetos Mulher
		Mulher m1 = new Mulher("Ana", 8, 5, 2009, (float) 1.76, 76, 14),
		
		m2 = new Mulher("Vitoria", 5, 11, 1993, (float) 1.68, 64, 24),
		
		m3 = new Mulher("Beatriz", 14, 11, 2007, (float) 1.64, 56, 16),
		
		m4 = new Mulher("Paula", 9, 2, 2007, (float) 1.60, 50, 16),
		
		m5 = new Mulher("Karla", 14, 8, 2001, (float) 1.61, 68, 22);
		
		// Adicionando os elementos criados ao array
		l.add(m1); l.add(m2); l.add(m3);
		l.add(m4); l.add(m5);
		
		// Retornando a lista com os novos objetos
		return l;
	}
	
	
	// Fim do programa
	public static void fim(){
		System.out.print("\nFim do programa\n");
		linha();
		System.exit(0);
	}
	
	
	public static void main(String[] args){
		// Adicionando Homens e Mulheres
		MinhaListaOrdenavel lista = new MinhaListaOrdenavel();
		lista = adicionaHomens(lista); lista = adicionaMulheres(lista);
		
		// Menu de ordenacao
		menu(); 
		int e = escolha();
		while (e == 1){
			// Verifica o criterio de ordenacao
			int criterio = leCriterio();
			ArrayList<PessoaIMC> listaOrdenada = lista.ordena(criterio); 

			// Criando a tabela ordenada
			Tabela t = new Tabela();
			t.setDados(listaOrdenada);
			t.criaJanela();
			
			// Verifica a escolha
			e = escolha();
		}
		
		// Fim do programa
		fim();
	}
}