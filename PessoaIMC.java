abstract class PessoaIMC extends Pessoa{
	protected float peso, altura; 
	
	// Construtor 1
	PessoaIMC(String nome, int dia, int mes, int ano,
	float altura, float peso){
		super(nome, dia, mes, ano);
		this.peso = peso;
		this.altura = altura;
	}
	
	// Getters
	public float getPeso(){
		return this.peso;
	}
	
	public float getAltura(){
		return this.altura;
	}
	
	// Calcula o IMC
	static float calculaIMC(float peso, float altura){
		return peso/(float) Math.pow(altura, 2);
	}
	
	// Retorna uma instancia da classe String
	abstract String resultIMC();
	
	// Dados para a tabela
	public String[] getDados(){
		String dia = Integer.toString(super.getDia());
		String mes = Integer.toString(super.getMes());
		String ano = Integer.toString(super.getAno());
		String dataNasc = dia + "/" + mes + "/" + ano;
		String peso = Float.toString(getPeso());
		String altura = Float.toString(getAltura());
		
		String[] dados = {super.getNome(), dataNasc, peso, altura};
		
		return dados;
	}
	
	// Formato de saida padrao
	public String toString(){
		String str = super.toString();
		str += ("Peso: " + peso + "\nAltura: " + altura + "\n");
		return str;
	}
}
