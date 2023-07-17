public class Homem extends PessoaIMC{
	private int idade;
	private static int contagemh = 0;
	
	// Construtor
	Homem(String nome, int dia, int mes, int ano, float altura,
	float peso, int idade){
		super(nome, dia, mes, ano, altura, peso);
		this.idade = idade;
		contagemh++;
	}
	
	// Resultado do IMC
	public String resultIMC(){
		float IMC = calculaIMC(peso, altura);
		if (IMC < 20.7){
			return "Abaixo do peso ideal";
		} else if (IMC <= 26.4){
			return "Peso ideal";
		} else{
			return "Acima do peso ideal";
		}
	}
	
	public int getIdade(){
		return this.idade;
	}
	
	// Retorna os dados do homem
	public String[] getDados(){
		String[] dadosIMC = super.getDados();
		String[] dados = new String[9];
	
		int i;
		for (i = 0; i < 4; i++){
			dados[i] = dadosIMC[i];
		}
		
		dados[i] = "Homem";
		dados[++i] = Integer.toString(idade);
		dados[++i] = Float.toString(calculaIMC(super.peso, super.altura));
		dados[++i] = resultIMC();
		
		return dados;
	}
	
	// Formato de saida padrao
	public String toString(){
		String str = super.toString();
		str += ("Genero: Homem\nIdade: " + idade + "\nIMC: " +
		calculaIMC(super.peso, super.altura) + " (" + resultIMC() + ")");
		
		return str;
	}
	
	// Contagem do numero de objetos criados
	static int numHomens(){
		return contagemh;
	}
} 
