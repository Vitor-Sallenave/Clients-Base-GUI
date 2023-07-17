public class Mulher extends PessoaIMC{
	private int idade;
	private static int contagemM = 0;
	
	// Construtor
	Mulher(String nome, int dia, int mes, int ano, float altura,
	float peso, int idade){
		super(nome, dia, mes, ano, altura, peso);
		this.idade = idade;
		contagemM++;
	}
	
	// Classificacao conforme IMC
	public String resultIMC(){
		float IMC = calculaIMC(peso, altura);
		if (IMC < 19){
			return "Abaixo do peso ideal";
		} else if (IMC <= 25.8){
			return "Peso ideal";
		} else{
			return "Acima do peso ideal";
		}
	}
	
	// Retorna os dados da mulher
	public String[] getDados(){
		String[] dadosIMC = super.getDados();
		String[] dados = new String[9];
	
		int i;
		for (i = 0; i < 4; i++){
			dados[i] = dadosIMC[i];
		}
		
		dados[i] = "Mulher";
		dados[++i] = Integer.toString(idade);
		dados[++i] = Float.toString(calculaIMC(super.peso, super.altura));
		dados[++i] = resultIMC();
		
		return dados;
	}
	
	// Formato de saida padrao
	public String toString(){
		String str = super.toString();
		str += ("Genero: Mulher\nIdade: " + idade + "\nIMC: " +
		calculaIMC(peso, altura) + " (" + resultIMC() + ")");
		return str;
	}
	
	// Contagem do numero de objetos criados
	static int numMulheres(){
		return contagemM;
	}
}
