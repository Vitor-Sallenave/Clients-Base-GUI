import java.util.Calendar;
import java.util.GregorianCalendar;

class Pessoa{
	
	// Campos
	private String nome;
	private GregorianCalendar dataNasc;
	private static int contagem = 0;
	
	// Construtor 1
	Pessoa(String nome, int dia, int mes, int ano){
		this.nome = nome;
		this.dataNasc = new GregorianCalendar(ano, mes, dia);
		contagem++;
	}
	
	// Formato de saida padrao
	public String toString(){
		String str = "INFOS\n=======================================================\n\nNome: "
		+ nome + "\n"
		+ "Data de Nascimento: " +
		dataNasc.get(Calendar.DATE) + "/" +
		dataNasc.get(Calendar.MONTH) + "/" +
		dataNasc.get(Calendar.YEAR) + "\n";
		
		return str;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public GregorianCalendar getDataNasc(){
		return this.dataNasc;
	}
	
	public int getDia(){
		return this.dataNasc.get(Calendar.DATE);
	}
	
	public int getMes(){
		return this.dataNasc.get(Calendar.MONTH);
	}
	
	public int getAno(){
		return this.dataNasc.get(Calendar.YEAR);
	}
	
	// Contagem do numero de objetos criados
	static int numPessoas(){
		return contagem;
	}
	
}