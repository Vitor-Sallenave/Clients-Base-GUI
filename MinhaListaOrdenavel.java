import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MinhaListaOrdenavel{
	// ArrayList que armazena homens e mulheres
	private ArrayList<PessoaIMC> array = new ArrayList<PessoaIMC>();
	
	// Adiciona elementos ao array
	public void add(PessoaIMC p){
		// Verificando se p e o homem ou mulher
		if (p instanceof Homem){
			array.add((Homem) p);
		} else{
			array.add((Mulher) p);
		}
	}
	
	// Acessa os elementos do array
	public PessoaIMC get(int i){
		return array.get(i);
	}
	
	// Retorna a quantidade de elementos do array
	public int tamanho(){
		return array.size();
	}
	
	// Comparators
	
	// Nome
	public Comparator<Object> nomeC = new Comparator<Object> () {
		public int compare (Object p1, Object p2){
			String nome1, nome2;
			nome1 = ((PessoaIMC) p1).getNome();
			nome2 = ((PessoaIMC) p2).getNome();
			return nome1.compareTo(nome2);
		}
	};
	
	// Genero
	public Comparator<Object> generoC = new Comparator<Object> () {
		public int compare (Object p1, Object p2){
			// p1 e p2 são objetos do mesmo tipo
			boolean iguais = (p1 instanceof Homem && p2 instanceof Homem) ||
			(p1 instanceof Mulher && p2 instanceof Mulher);
			
			// p1 e homem
			boolean p1hom = p1 instanceof Homem;
			
			// Verificando
			if (iguais){
				return 0;
			}else if (p1hom){
				return -1;
			} else{
				return 1;
			}
		}
	};
	
	// Peso
	public Comparator<Object> pesoC = new Comparator<Object> () {
		public int compare (Object p1, Object p2){
			float peso1, peso2;
			
			peso1 = ((PessoaIMC) p1).getPeso();
			peso2 = ((PessoaIMC) p2).getPeso();
			
			if (peso1 == peso2){
				return 0;
			} else if(peso1 < peso2){
				return -1;
			} else{
				return 1;
			}
		}
	};
	
	// Altura
	public Comparator<Object> alturaC = new Comparator<Object> () {
		public int compare (Object p1, Object p2){
			float altura1, altura2;
			
			altura1 = ((PessoaIMC) p1).getAltura();
			altura2 = ((PessoaIMC) p2).getAltura();
			
			if (altura1 == altura2){
				return 0;
			} else if(altura1 < altura2){
				return -1;
			} else{
				return 1;
			}
		}
	};
	
	// IMC
	public Comparator<Object> imcC = new Comparator<Object> () {
		public int compare (Object p1, Object p2){
			float imc1, imc2;
			
			imc1 = PessoaIMC.calculaIMC(((PessoaIMC) p1).getPeso(),
			((PessoaIMC) p1).getAltura());
			
			imc2 = PessoaIMC.calculaIMC(((PessoaIMC) p2).getPeso(),
			((PessoaIMC) p2).getAltura());
			
			if (imc1 == imc2){
				return 0;
			} else if(imc1 < imc2){
				return -1;
			} else{
				return 1;
			}
		}
	};
	
	// Data de nascimento
	public Comparator<Object> nascimentoC = new Comparator<Object> () {
		public int compare (Object p1, Object p2){
			// Ano, mês e dia 
			int ano1, mes1, dia1, ano2, mes2, dia2; 
			
			// p1
			ano1 = ((PessoaIMC) p1).getAno();
			mes1 = ((PessoaIMC) p1).getMes();
			dia1 = ((PessoaIMC) p1).getDia();

			// p2
			ano2 = ((PessoaIMC) p2).getAno();
			mes2 = ((PessoaIMC) p2).getMes();
			dia2 = ((PessoaIMC) p2).getDia();

			// Comparando as datas de nascimento
			if (ano1 < ano2){	
				return -1;
			} else if (ano1 > ano2){
				return 1;
			} else{
				if (mes1 < mes2){
					return -1;
				} else if (mes1 > mes2){
					return 1;
				} else{
					if (dia1 < dia2){
						return -1;
					} else if (dia1 > dia2){
						return 1;
					} else{
						return 0;
					}
				}
			}   
		}
	};
		
	// Ordenando o array
	public ArrayList<PessoaIMC> ordena(int opcao) {
		// Avalia as opcoes
		switch (opcao) {
			case 1:
				Collections.sort(this.array, nomeC); break;
			case 2:
				Collections.sort(this.array, nomeC.reversed()); break;
			case 3:
				Collections.sort(this.array, pesoC); break;
			case 4:
				Collections.sort(this.array, pesoC.reversed()); break;
			case 5:
				Collections.sort(this.array, alturaC); break;
			case 6:
				Collections.sort(this.array, alturaC.reversed()); break;
			case 7:
				Collections.sort(this.array, imcC); break;
			case 8:
				Collections.sort(this.array, imcC.reversed()); break;
			case 9:
				Collections.sort(this.array, generoC); break;
			case 10:
				Collections.sort(this.array, generoC.reversed()); break;
			case 11:
				Collections.sort(this.array, nascimentoC); break;
			case 12:
				Collections.sort(this.array, nascimentoC.reversed()); break;
		}
		
		// Retorna o array ordenado
		return array;
	}
}